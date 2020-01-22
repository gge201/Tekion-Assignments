package com.example.CricketMatch;
import java.util.Random;

public class Team {
    int score;
    int wickets;
    int overs;
    String name;
    int div=0,mod=0;
    int ball=0;
    Random rand = new Random();
    int r=0;
    Team(String name,int overs,int prev) {
        int i = 0;
        this.name = name;
        this.overs = overs;
        div = overs;
        for (i = 0; i < (6 * this.overs); i++) {
            r = rand.nextInt(8);
            if (r == 7) {
                wickets++;
            } else {
                score = score + r;
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
    }
}