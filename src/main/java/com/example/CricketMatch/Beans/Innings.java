package com.example.CricketMatch.Beans;

import java.util.*;

public class Innings {
    private List<String> bw=new ArrayList<String>();
    private List<String> ov=new ArrayList<String>();
    private List<Integer> run=new ArrayList<Integer>();
    private int score;
    private int wickets;
    int j;
    private int oversFaced=0, ballBowled =0;
    private int ball=0;
    private int striker=0, nonStriker =1;
    Random rand = new Random();
    float r1=0,r2=0;
    int r3=0;

    public int getOversFaced() {
        return oversFaced;
    }

    public int getBallBowled() {
        return ballBowled;
    }

    public int getBall() {
        return ball;
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

    public List<Player> getT2() {
        return T2;
    }

    public List<Player> getT1() {
        return T1;
    }


    int bowl;
    private void setRuns()
    {
        if(t1[striker].getType()=="Batsman"){
            if(r1<=t1[striker].getRating()*0.1 && r2<=t2[bowl].getRating()*0.03)
            {
                if(t1[striker].getRating()<t2[bowl].getRating()) {
                    r3=rand.nextInt(5);
                }
            }
            else if (r1>t1[striker].getRating()*0.1 && r2>t2[bowl].getRating()*0.03)
            {
                if(t1[striker].getRating()>t2[bowl].getRating()) {
                    r3 = rand.nextInt(3);
                }
                else{
                    r3=7;
                }
            }
            else if(r1>t1[striker].getRating()*0.1 && r2<=t2[bowl].getRating()*0.03){
                r3=7;
            }

        }
        else{
            if(r2<t2[bowl].getRating()*0.045)
            {
                r3 = 7;
            }
        }
    }
    private int set(int count,int i,int over)
    {
        oversFaced = (i + 1) / 6;
        ballBowled = (i + 1) % 6;
        if(ballBowled==0)
        {
            overFinish(count,over,i);
        }
        return 37;
    }
    private int addRuns(int count,int i,int prev,int over)
    {
        if(r3!=7) {

            t1[striker].getBatsman().setRuns(r3 + t1[striker].getBatsman().getRuns());
            count = count + r3;
            System.out.println(bowl);
            t2[bowl].getBowler().setRunsgiven(t2[bowl].getBowler().getRunsgiven() + r3 % 7);
        }
        t2[bowl].getBowler().setLb(t2[bowl].getBowler().getLb()+1);
        t1[striker].getBatsman().setBalls(t1[striker].getBatsman().getBalls()+1);
        if(r3==4)
        {
            t1[striker].getBatsman().setFours(t1[striker].getBatsman().getFours()+1);
        }
        if(r3==6)
        {
            t1[striker].getBatsman().setSixes(t1[striker].getBatsman().getSixes()+1);
        }
        if(r3%2==1 && r3!=7)
        {
            int t;
            t=striker;
            striker= nonStriker;
            nonStriker =t;
        }

        if (r3 == 7) {
            t1[striker].getBatsman().setOut(t2[bowl].getName());
            T1.add(t1[striker]);
            bw.add(t2[bowl].getName());
            run.add(score);
            ov.add((i+1)/6+"."+(i+1)%6);
            wickets++;
            t2[bowl].getBowler().setWickets(t2[bowl].getBowler().getWickets()+1);
            striker=Integer.max(striker, nonStriker)+1;
        }

        else {
            score = score + r3;
        }
        if (prev == 0 && wickets == 10) {
            count=set(count,i,over);
        }
        if ( (wickets == 10 || score > prev) && prev>0) {
            ball=6*getOversFaced()-(i+1);
            count=set(count,i,over);
        }
        return count;
    }
    private int overFinish(int count,int over,int i){
        if(count==0)
        {
            t2[bowl].getBowler().setMaiden(t2[bowl].getBowler().getMaiden()+1);
        }
        t2[bowl].getBowler().setLb(0);
        t2[bowl].getBowler().setOverbowled(t2[bowl].getBowler().getOverbowled()+1);
        over++;
        if(bowl<10)
        {
            bowl++;
        }
        else if(bowl==10){
            bowl=6;
        }
        int t;
        t=striker;
        striker= nonStriker;
        nonStriker =t;

        return 0;
    }
    private List<Player> T1=new ArrayList<Player>();
    private List<Player> T2=new ArrayList<Player>();
    Player[] t1=new Player[11];
    Player[] t2=new Player[11];
    Innings(int overs, int prev, Player Team1[], Player Team2[])
    {
        t1=Team1;
        t2=Team2;
        //name=Team1[0].getTeam();
        int i = 0;
        int over=0;

        oversFaced = overs;
        int count=0;
        bowl=6;
        for (i = 0; i < (6 * overs); i++) {
            r1=rand.nextFloat();
            r2=rand.nextFloat();
            r3 = rand.nextInt(7);
            setRuns();
            count=addRuns(count,i,prev,over);
            if((i+1)%6==0) {
                count = overFinish(count, over, i);
            }
            if(count==37)
            {
                break;
            }
        }
        if(striker<=10 && t1[striker].getBatsman().getOut()=="")
        {
            T1.add(t1[striker]);
        }
        if(nonStriker<=10) {
            T1.add(t1[nonStriker]);
        }
        for(i=0; i<=Integer.min(Integer.max(striker, nonStriker),10); i++)
        {
            t1[i].getBatsman().setSR(t1[i].getBatsman().getRuns(),t1[i].getBatsman().getBalls());
        }
        if(overs>=5)
        {
            overs=5;
        }
        for(i=6; i<(6+ (overs%5==0 ? 5 : overs%5)); i++)
        {
            t2[i].getBowler().setEco(t2[i].getBowler().getRunsgiven(),t2[i].getBowler().getOverbowled(),t2[i].getBowler().getLb());
            T2.add(t2[i]);
        }

    }
}
