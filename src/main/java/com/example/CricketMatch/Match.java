package com.example.CricketMatch;
import java.util.*;

public class Match {
    int[] score1=new int[2];
    Innings I1,I2;
    int[] wickets=new int[2];
    int overs=50;
    String team1,team2;
    int div1,div2,mod1,mod2;
    String out;
    int remain=0;
    int tt=1;
    String vv="runs";

    public int[] getScore1() {
        return score1;
    }

    public int[] getWickets() {
        return wickets;
    }

    public int getOvers() {
        return overs;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public int getDiv1() {
        return div1;
    }

    public int getDiv2() {
        return div2;
    }

    public int getMod1() {
        return mod1;
    }

    public int getMod2() {
        return mod2;
    }

    public String getOut() {
        return out;
    }

    public int getRemain() {
        return remain;
    }

    public int getTt() {
        return tt;
    }

    public String getVv() {
        return vv;
    }

    public Innings getI1() {
        return I1;
    }

    public Innings getI2() {
        return I2;
    }

    Match(Innings T1, Innings T2){
        I1=T1;
        I2=T2;
        score1[0]=T1.getScore();
        overs=T1.getOvers();
        score1[1]=T2.getScore();
        team1=T1.getName();
        team2=T2.getName();
        wickets[0]=T1.getWickets();
        wickets[1]=T2.getWickets();
        div1=T1.getDiv();
        div2=T2.getDiv();
        mod1=T1.getMod();
        mod2=T2.getMod();
        remain=score1[0]-score1[1];
        if(score1[0]==score1[1])
        {
            out = "Verdict --  Match Tied";
            tt=0;
        }
        if(score1[1]>score1[0])
        {
            tt=2;
            remain=10-wickets[1];
            vv="wickets";
        }
        if(tt==1) {
            out = "Verdict --  " + team1 + " won by " + remain + " " + vv + " ( " + T2.getBall() + " balls left )";
        }
        else if(tt==2){
            out = "Verdict --  " + team2 + " won by " + remain + " " + vv + " ( " + T2.getBall() + " balls left )";
        }
    }

}