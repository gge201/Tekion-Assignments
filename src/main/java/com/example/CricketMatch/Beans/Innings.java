package com.example.CricketMatch.Beans;

import java.util.*;
public class Innings {
    private List<String> bw=new ArrayList<String>();
    private List<String> ov=new ArrayList<String>();
    private List<Integer> run=new ArrayList<Integer>();

    private int score;

    public int getBallsLeft() {
        return ballsLeft;
    }

    private int wickets;
    int totalOver=0;
    int over=0;
    int j;
    private int oversFaced=0, ballBowled =0;
    private int ballsLeft=0;
    private int striker=0, nonStriker =1,t;
    Random rand = new Random();
    private float r1=0,r2=0;
    private int r3=0;
    private int bowl;
    private Map <String,Player.BatsmanInfo> T1=new HashMap<String,Player.BatsmanInfo>();
    private Map <String,Player.BowlerInfo> T2=new HashMap<String, Player.BowlerInfo>();
    public int getOversFaced() {
        return oversFaced;
    }

    public int getBallBowled() {
        return ballBowled;
    }


    public int getStriker() {
        return striker;
    }

    public int getNonStriker() {
        return nonStriker;
    }

    public int getScore() {
        return score;
    }

    public int getWickets() {
        return wickets;
    }

    public Map<String,Player.BatsmanInfo> getT1() {
        return T1;
    }
    public Map<String,Player.BowlerInfo> getT2() {
        return T2;
    }

    public void playInnings(int overs,int prevTarget,Player t1[],Player t2[])
    {
        totalOver=overs;
        int i = 0;
        int count=0;
        bowl=6;
        for (i = 0; i < (6 * overs); i++) {
            r1=rand.nextFloat();
            r2=rand.nextFloat();
            r3 = rand.nextInt(7);
            if(striker<=10 && nonStriker<=10) {
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
        if(striker<=10 && t1[striker].getBatsmanInfo().getOut()=="")
        {
            T1.put(t1[striker].getName(),t1[striker].getBatsmanInfo());
        }
        if(nonStriker<=10) {
            T1.put(t1[nonStriker].getName(),t1[nonStriker].getBatsmanInfo());
        }
        for(i=0; i<=Integer.min(Integer.max(striker, nonStriker),10); i++)
        {
            t1[i].updateStrikeRate();
        }
        for(i=6; i<(6+ (over>5 ? 5 : over)); i++)
        {
            t2[i].updateEconomy();
            T2.put(t2[i].getName(),t2[i].getBowlerInfo());
        }
        return ;
    }
    private void setRuns(Player []t1,Player []t2)
    {
            if (t1[striker].getType() == "Batsman") {
                if (r1 <= t1[striker].getRating() * 0.1 && r2 <= t2[bowl].getRating() * 0.03) {
                    if (t1[striker].getRating() < t2[bowl].getRating()) {
                        r3 = rand.nextInt(5);
                    }
                } else if (r1 > t1[striker].getRating() * 0.1 && r2 > t2[bowl].getRating() * 0.03) {
                    if (t1[striker].getRating() > t2[bowl].getRating()) {
                        r3 = rand.nextInt(3);
                    } else {
                        r3 = 7;
                    }
                } else if (r1 > t1[striker].getRating() * 0.1 && r2 <= t2[bowl].getRating() * 0.03) {
                    r3 = 7;
                }

            } else {
                if (r2 < t2[bowl].getRating() * 0.045) {
                    r3 = 7;
                }
            }
    }
    private void set(int count,int i)
    {
        oversFaced = (i + 1) / 6;
        ballBowled = (i + 1) % 6;
        if((i+1)%6!=0) over++;
    }
    private void swap()
    {
        t=striker;
        striker=nonStriker;
        nonStriker=t;
    }
    private int addRuns(Player[]t1,Player[]t2,int count,int i,int prev)
    {
        t1[striker].updateRuns(r3%7);
        count = count + r3%7;
        t2[bowl].updateRunsGiven(r3%7);
        t2[bowl].updateBallsDelivered();
        t1[striker].updateBallsFaced();

        if(r3==4)
        {
            t1[striker].updateFours();
        }
        else if(r3==6)
        {
            t1[striker].updateSixes();
        }
        else if(r3%2==1 && r3!=7)
        {
            swap();
        }

        if (r3 == 7) {
            t1[striker].getBatsmanInfo().setOut(t2[bowl].getName());
            T1.put(t1[striker].getName(),t1[striker].getBatsmanInfo());
            bw.add(t2[bowl].getName());
            run.add(score);
            ov.add((i+1)/6+"."+(i+1)%6);
            wickets++;
            t2[bowl].updateWicketsTaken();

            striker=Integer.max(striker, nonStriker)+1;
        }
        else {
            score = score + r3;
        }

        return count;
    }
    private int overFinish(Player []t2,int count,int i){
        if(count==0)
        {
            t2[bowl].updateMaidenOvers();
        }
        t2[bowl].getBowlerInfo().setLb(0);
        t2[bowl].updateOversBowled();
        over++;
        if(bowl<10)
        {
            bowl++;
        }
        else if(bowl==10){
            bowl=6;
        }
        swap();

        return 0;
    }
    private int  InningsFinish(int prev,int count,int i){
        if (prev == 0 && wickets == 10) {
            set(count,i);
            return 37;
        }
        else if ( (wickets == 10 || score > prev) && prev>0) {
            ballsLeft=6*totalOver-(i+1);
            set(count,i);
            return 37;
        }
        return count;
    }

}
