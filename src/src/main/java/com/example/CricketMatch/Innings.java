package com.example.CricketMatch;

import java.util.ArrayList;
import java.util.Random;

public class Innings {
    private ArrayList<String> bw=new ArrayList<String>();
    private ArrayList<String> ov=new ArrayList<String>();
    private ArrayList<Integer> run=new ArrayList<Integer>();
    private int score;
    private int wickets;

    public int getScore() {
        return score;
    }

    public int getWickets() {
        return wickets;
    }

    public String getName() {
        return name;
    }


    int j;
    private String name;
    private int div=0,mod=0;
    private int ball=0;
    int st=0,ns=1;
    Random rand = new Random();
    float r1=0,r2=0;
    int r3=0;

    public ArrayList<String> getBw() {
        return bw;
    }

    public ArrayList<String> getOv() {
        return ov;
    }

    public ArrayList<Integer> getRun() {
        return run;
    }


    public int getDiv() {
        return div;
    }

    public int getMod() {
        return mod;
    }

    public int getBall() {
        return ball;
    }

    public int getSt() {
        return st;
    }

    public int getNs() {
        return ns;
    }
    Player[] T1=new Player[11];
    Player[] T2=new Player[11];

    public Player[] getT1() {
        return T1;
    }

    public Player[] getT2() {
        return T2;
    }

    Innings(int overs, int prev, Player Team1[], Player Team2[])
    {
        Team1[0].setRating(9);  Team1[0].setType("Batsman");
        Team1[1].setRating(8.5f);   Team1[1].setType("Batsman");
        Team1[2].setRating(9.5f);   Team1[2].setType("Batsman");
        Team1[3].setRating(8);  Team1[3].setType("Batsman");
        Team1[4].setRating(8);  Team1[4].setType("Batsman");
        Team1[5].setRating(7.5f);   Team1[5].setType("Batsman");
        Team1[6].setRating(8.5f);   Team1[6].setType("Bowler");
        Team1[7].setRating(8);  Team1[7].setType("Bowler");
        Team1[8].setRating(9);  Team1[8].setType("Bowler");
        Team1[9].setRating(7);  Team1[9].setType("Bowler");
        Team1[10].setRating(9); Team1[10].setType("Bowler");

        Team2[0].setRating(9.5f);  Team2[0].setType("Batsman");
        Team2[1].setRating(8.5f);   Team2[1].setType("Batsman");
        Team2[2].setRating(9f);   Team2[2].setType("Batsman");
        Team2[3].setRating(8.5f);  Team2[3].setType("Batsman");
        Team2[4].setRating(8.5f);  Team2[4].setType("Batsman");
        Team2[5].setRating(7.5f);   Team2[5].setType("Batsman");
        Team2[6].setRating(9);   Team2[6].setType("Bowler");
        Team2[7].setRating(8.5f);  Team2[7].setType("Bowler");
        Team2[8].setRating(9);  Team2[8].setType("Bowler");
        Team2[9].setRating(7.5f);  Team2[9].setType("Bowler");
        Team2[10].setRating(9); Team2[10].setType("Bowler");
        name=Team1[0].getTeam();
        int i = 0;
        int t=0;
        int over=0;

        div = overs;
        int count=0,curr=6;
        for (i = 0; i < (6 * overs); i++) {
            r1=rand.nextFloat();
            r2=rand.nextFloat();
            r3 = rand.nextInt(7);
            if(Team1[st].getType()=="Batsman"){
                if(r1<=Team1[st].getRating()*0.1 && r2<=Team2[curr].getRating()*0.03)
                {
                    if(Team1[st].getRating()<Team2[curr].getRating()) {
                        r3=rand.nextInt(5);
                    }
                }
                else if (r1>Team1[st].getRating()*0.1 && r2>Team2[curr].getRating()*0.03)
                {
                    if(Team1[st].getRating()>Team2[curr].getRating()) {
                        r3 = rand.nextInt(3);
                    }
                    else{
                        r3=7;
                    }
                }
                else if(r1>Team1[st].getRating()*0.1 && r2<=Team2[curr].getRating()*0.03){
                    r3=7;
                }

            }
            else{
                if(r2<Team2[curr].getRating()*0.045)
                {
                    r3 = 7;
                }
            }
            if(r3!=7) {

                Team1[st].setRuns(r3 + Team1[st].getRuns());
                count = count + r3;
                Team2[curr].setRunsgiven(Team2[curr].getRunsgiven() + r3 % 7);
            }
            Team2[curr].setLb(Team2[curr].getLb()+1);
            Team1[st].setBalls(Team1[st].getBalls()+1);
            if(r3==4)
            {
                Team1[st].setFours(Team1[st].getFours()+1);
            }
            if(r3==6)
            {
                Team1[st].setSixes(Team1[st].getSixes()+1);
            }
            if(r3%2==1 && r3!=7)
            {
                t=st;
                st=ns;
                ns=t;
            }

            if (r3 == 7) {
                Team1[st].setOut(Team2[curr].getName());
                bw.add(Team2[curr].getName());
                run.add(score);
                ov.add((i+1)/6+"."+(i+1)%6);
                wickets++;
                Team2[curr].setWickets(Team2[curr].getWickets()+1);
                st=Integer.max(st,ns)+1;
            }
            else {
                score = score + r3;
            }
            if((i+1)%6==0)
            {
                if(count==0)
                {
                    Team2[curr].setMaiden(Team2[curr].getMaiden()+1);
                }
                Team2[curr].setLb(0);
                Team2[curr].setOverbowled(Team2[curr].getOverbowled()+1);
                over++;
                if(curr<10)
                {
                    curr++;
                }
                else if(curr==10){
                    curr=6;
                }
                t=st;
                st=ns;
                ns=t;
                count=0;
            }
            if (prev == 0 && wickets == 10) {
                div = (i + 1) / 6;
                mod = (i + 1) % 6;
                break;
            }
            if ( (wickets == 10 || score > prev) && prev>0) {
                ball=6*overs-(i+1);
                div=(i+1)/6;
                mod=(i+1)%6;
                break;
            }
        }
        for(i=0;i<11;i++)
        {
            Team1[i].setSR(Team1[i].getRuns(),Team1[i].getBalls());
        }
        for(i=6;i<11;i++)
        {
            Team2[i].setEco(Team2[i].getRunsgiven(),Team2[i].getOverbowled(),Team2[i].getLb());
        }
        T1=Team1;
        T2=Team2;
    }
}
