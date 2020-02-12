package com.example.CricketMatch.Services;

import com.example.CricketMatch.Beans.Innings;
import com.example.CricketMatch.Beans.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
@Service
public class InningsService {
    @Autowired
    private Innings innings;
    @Autowired
    private PlayerService playerService=new PlayerService();

    public Innings getInnings() {
        return innings;
    }

    public InningsService(){
        innings=new Innings();
    }
    public void setInnings(Innings innings) {
        this.innings = innings;
    }

    int t;
    Random rand = new Random();
    private float r1=0;
    private float r2=0;
    private int r3=0;
    public void playInnings(int overs, int prevTarget, Player t1[], Player t2[])
    {
        innings.setTotalOver(overs);
        int i = 0;
        int count=0;
        for (i = 0; i < (6 * overs); i++) {
            r1=rand.nextFloat();
            r2=rand.nextFloat();
            r3 = rand.nextInt(7);
            if(innings.getStriker()<=10 && innings.getNonStriker()<=10) {
                setRuns(t1,t2);
                count = addRuns(t1,t2,count, i, prevTarget);
                if((i+1)%6==0) count = overFinish(t2,count,i);
                count = InningsFinish(prevTarget,count,i);
                if(count==37)
                {
                    break;
                }
            }
        }
        if(innings.getStriker()<=10 && t1[innings.getStriker()].getBatsmanInfo().getOut()=="")
        {
            innings.T1.put(t1[innings.getStriker()].getName(),t1[innings.getStriker()].getBatsmanInfo());
        }
        if(innings.getNonStriker()<=10) {
            innings.T1.put(t1[innings.getNonStriker()].getName(),t1[innings.getNonStriker()].getBatsmanInfo());
        }
        for(i=0; i<=Integer.min(Integer.max(innings.getStriker(), innings.getNonStriker()),10); i++)
        {
            playerService.updateStrikeRate(t1[i]);
        }
        for(i=6; i<(6+ (innings.getOver()>5 ? 5 : innings.getOver())); i++)
        {
            playerService.updateEconomy(t2[i]);
            innings.T2.put(t2[i].getName(),t2[i].getBowlerInfo());
        }
        return ;
    }
    private void setRuns(Player []t1,Player []t2)
    {
        if (t1[innings.getStriker()].getType() == "Batsman") {
            if (r1 <= t1[innings.getStriker()].getRating() * 0.1 && r2 <= t2[innings.getBowl()].getRating() * 0.03) {
                if (t1[innings.getStriker()].getRating() < t2[innings.getBowl()].getRating()) {
                    r3 = rand.nextInt(5);
                }
            } else if (r1 > t1[innings.getStriker()].getRating() * 0.1 && r2 > t2[innings.getBowl()].getRating() * 0.03) {
                if (t1[innings.getStriker()].getRating() > t2[innings.getBowl()].getRating()) {
                    r3 = rand.nextInt(3);
                } else {
                    r3 = 7;
                }
            } else if (r1 > t1[innings.getStriker()].getRating() * 0.1 && r2 <= t2[innings.getBowl()].getRating() * 0.03) {
                r3 = 7;
            }

        } else {
            if (r2 < t2[innings.getBowl()].getRating() * 0.045) {
                r3 = 7;
            }
        }
    }
    private void set(int count,int i)
    {
        innings.setOversFaced((i+1)/6);
        innings.setBallBowled((i + 1) % 6);
        if((i+1)%6!=0) innings.setOver(innings.getOver()+1);
    }
    private void swap()
    {
        t=innings.getStriker();
        innings.setStriker(innings.getNonStriker());
        innings.setNonStriker(t);
    }
    private int addRuns(Player[]t1,Player[]t2,int count,int i,int prev)
    {
        playerService.updateRuns(r3%7,t1[innings.getStriker()]);
        count = count + r3%7;
        playerService.updateRunsGiven(r3%7,t2[innings.getBowl()]);
        playerService.updateBallsDelivered(t2[innings.getBowl()]);
        playerService.updateBallsFaced(t1[innings.getStriker()]);

        if(r3==4)
        {
            playerService.updateFours(t1[innings.getStriker()]);
        }
        else if(r3==6)
        {
            playerService.updateSixes(t1[innings.getStriker()]);
        }
        else if(r3%2==1 && r3!=7)
        {
            swap();
        }

        if (r3 == 7) {
            t1[innings.getStriker()].getBatsmanInfo().setOut(t2[innings.getBowl()].getName());
            innings.T1.put(t1[innings.getStriker()].getName(),t1[innings.getStriker()].getBatsmanInfo());
//            bw.add(t2[bowl].getName());
//            run.add(score);
//            ov.add((i+1)/6+"."+(i+1)%6);
            innings.setWickets(innings.getWickets()+1);
            playerService.updateWicketsTaken(t2[innings.getBowl()]);

            innings.setStriker(Integer.max(innings.getStriker(), innings.getNonStriker())+1);
        }
        else {
            innings.setScore( innings.getScore() + r3);
        }

        return count;
    }
    private int overFinish(Player []t2,int count,int i){
        if(count==0)
        {
            playerService.updateMaidenOvers(t2[innings.getBowl()]);
        }
        t2[innings.getBowl()].getBowlerInfo().setLb(0);
        playerService.updateOversBowled(t2[innings.getBowl()]);
        innings.setOver(innings.getOver()+1);
        if(innings.getBowl()<10)
        {
            innings.setBowl(innings.getBowl()+1);
        }
        else if(innings.getBowl()==10){
            innings.setBowl(6);
        }
        swap();

        return 0;
    }
    private int  InningsFinish(int prev,int count,int i){
        if (prev == 0 && innings.getWickets() == 10) {
            set(count,i);
            return 37;
        }
        else if ( (innings.getWickets() == 10 || innings.getScore() > prev) && prev>0) {
            innings.setBallsLeft(6*innings.getTotalOver()-(i+1));
            set(count,i);
            return 37;
        }
        return count;
    }
}
