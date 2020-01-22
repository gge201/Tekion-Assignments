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

    public int getOvers() {
        return overs;
    }

    public int getJ() {
        return j;
    }

    public String getName() {
        return name;
    }

    private int overs;
    int j;
    private String name;
    Player[] T1=new Player[11];
    Player[] T2=new Player[5];
    private int div=0,mod=0;
    private int ball=0;
    int st=0,ns=1;
    Random rand = new Random();
    int r=0;

    public ArrayList<String> getBw() {
        return bw;
    }

    public ArrayList<String> getOv() {
        return ov;
    }

    public ArrayList<Integer> getRun() {
        return run;
    }

    public Player[] getT1() {
        return T1;
    }

    public Player[] getT2() {
        return T2;
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



    Innings(int overs, int prev, Player Team1[], Player Team2[]) {
        for(j=0;j<11;j++)
        {
            T1[j]=Team1[j];
        }
        for(j=0;j<5;j++)
        {
            T2[j]=Team2[j+6];
        }
        name=T1[0].getTeam();
        int i = 0;
        int t=0;
        int over=0;
        this.overs = overs;
        div = overs;
        int count=0,curr=0;
        for (i = 0; i < (6 * this.overs); i++) {
            r = rand.nextInt(8);
            T1[st].setRuns(r%7+T1[st].getRuns());
            count=count+r;
            T2[curr].setRunsgiven(T2[curr].getRunsgiven()+r%7);
            T2[curr].setLb(T2[curr].getLb()+1);
            T1[st].setBalls(T1[st].getBalls()+1);
            if(r==4)
            {
                T1[st].setFours(T1[st].getFours()+1);
            }
            if(r==6)
            {
                T1[st].setSixes(T1[st].getSixes()+1);
            }
            if(r%2==1 && r!=7)
            {
                t=st;
                st=ns;
                ns=t;
            }

            if (r == 7) {
                T1[st].setOut(T2[curr].getName());
                bw.add(T2[curr].getName());
                run.add(score);
                ov.add((i+1)/6+"."+(i+1)%6);
                wickets++;
                T2[curr].setWickets(T2[curr].getWickets()+1);
                st=Integer.max(st,ns)+1;
            }
            else {
                score = score + r;
            }
            if((i+1)%6==0)
            {
                if(count==0)
                {
                    T2[curr].setMaiden(T2[curr].getMaiden()+1);
                }
                T2[curr].setLb(0);
                T2[curr].setOverbowled(T2[curr].getOverbowled()+1);
                over++;
                curr=over%5;
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
                ball=6*this.overs-(i+1);
                div=(i+1)/6;
                mod=(i+1)%6;
                break;
            }
        }
        for(i=0;i<11;i++)
        {
            T1[i].setSR(T1[i].getRuns(),T1[i].getBalls());
        }
        for(i=0;i<5;i++)
        {
            T2[i].setEco(T2[i].getRunsgiven(),T2[i].getOverbowled(),T2[i].getLb());
        }
    }
}
