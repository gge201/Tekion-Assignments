package com.example.CricketMatch;
import java.util.*;

public class Match {
    int[] score1=new int[2];
    int[] wickets=new int[2];
    int overs=50;
    String team1,team2;
    int div1,div2,mod1,mod2;
    String out;
    int remain=0;
    int tt=1;
    String vv="runs";
    Match(Team T1,Team T2){
        score1[0]=T1.score;
        overs=T1.overs;
        score1[1]=T2.score;
        team1=T1.name;
        team2=T2.name;
        wickets[0]=T1.wickets;
        wickets[1]=T2.wickets;
        div1=T1.div;
        div2=T2.div;
        mod1=T1.mod;
        mod2=T2.mod;
        remain=score1[0]-score1[1];
        if(score1[0]==score1[1])
        {
            out = team1 + "  " + score1[0] + "/" + wickets[0] + " (" + div1 + "." + mod1 + ") " + "<br>" + team2 + "  " + score1[1] + "/" + wickets[1] + " (" + div2 + "." + mod2 + ") " + "<br>" +
                    "Verdict --  Match Tied";
        }
        if(score1[1]>score1[0])
        {
            tt=2;
            remain=10-wickets[1];
            vv="wickets";
        }
        if(tt==1) {
            out = team1 + "  " + score1[0] + "/" + wickets[0] + " (" + div1 + "." + mod1 + ") " + "<br>" + team2 + "  " + score1[1] + "/" + wickets[1] + " (" + div2 + "." + mod2 + ") " + "<br>" +
                    "Verdict --  " + team1 + " won by " + remain + " " + vv + " ( " + T2.ball + " balls left )";
        }
        else{
            out = team1 + "  " + score1[0] + "/" + wickets[0] + " (" + div1 + "." + mod1 + ") " + "<br>" + team2 + "  " + score1[1] + "/" + wickets[1] + " (" + div2 + "." + mod2 + ") " + "<br>" +
                    "Verdict --  " + team2 + " won by " + remain + " " + vv + " ( " + T2.ball + " balls left )";
        }
    }

}
