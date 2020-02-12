package com.example.CricketMatch.Beans;

import java.util.*;
public class Innings {

    private int score;
    private int wickets;
    private int totalOver;
    private int ballsLeft;
    private int over;
    private int j;
    private int bowl;
    private int striker, nonStriker;
    private int oversFaced, ballBowled;
    public Innings(){
        score=0;
        wickets=0;
        totalOver=0;
        over=0;
        oversFaced=0;
        ballBowled=0;
        ballsLeft=0;
        striker=0;
        nonStriker=1;
        bowl=6;
    }
    public int getBallsLeft() {
        return ballsLeft;
    }



    public void setScore(int score) {
        this.score = score;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public void setTotalOver(int totalOver) {
        this.totalOver = totalOver;
    }

    public void setOver(int over) {
        this.over = over;
    }

    public void setOversFaced(int oversFaced) {
        this.oversFaced = oversFaced;
    }

    public void setBallBowled(int ballBowled) {
        this.ballBowled = ballBowled;
    }

    public void setBallsLeft(int ballsLeft) {
        this.ballsLeft = ballsLeft;
    }

    public void setStriker(int striker) {
        this.striker = striker;
    }

    public void setNonStriker(int nonStriker) {
        this.nonStriker = nonStriker;
    }



    public int getTotalOver() {
        return totalOver;
    }

    public int getOver() {
        return over;
    }



//    public void setT1(Map<String, Player.BatsmanInfo> t1) {
//        T1 = t1;
//    }
//
//    public void setT2(Map<String, Player.BowlerInfo> t2) {
//        T2 = t2;
//    }

    public int getBowl() {
        return bowl;
    }

    public void setBowl(int bowl) {
        this.bowl = bowl;
    }


    public Map <String,BatsmanInfo> T1=new HashMap<String,BatsmanInfo>();
    public Map <String,BowlerInfo> T2=new HashMap<String, BowlerInfo>();
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

//    public Map<String,BatsmanInfo> getT1() {
//        return T1;
//    }
//    public Map<String,BowlerInfo> getT2() {
//        return T2;
//    }
}
