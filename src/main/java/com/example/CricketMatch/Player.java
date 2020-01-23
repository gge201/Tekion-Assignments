package com.example.CricketMatch;

import java.text.DecimalFormat;

public class Player {

    private static DecimalFormat df2 = new DecimalFormat("#.##");

    private String name,team;

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public String getOut() {
        return out;
    }

    public int getRuns() {
        return runs;
    }

    public int getFours() {
        return fours;
    }

    public int getSixes() {
        return sixes;
    }

    public int getBalls() {
        return balls;
    }

    public String getSr() {
        return sr;
    }

    public String getEconomy() {
        return economy;
    }

    public int getOverbowled() {
        return overbowled;
    }

    public int getMaiden() {
        return maiden;
    }

    public int getWickets() {
        return wickets;
    }

    public int getRunsgiven() {
        return runsgiven;
    }

    public int getLb() {
        return lb;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setOut(String out) {
        this.out = out;
    }

    private String out="";

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public void setFours(int fours) {
        this.fours = fours;
    }

    public void setSixes(int sixes) {
        this.sixes = sixes;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public void setSr(String sr) {
        this.sr = sr;
    }

    public void setEconomy(String economy) {
        this.economy = economy;
    }

    public void setOverbowled(int overbowled) {
        this.overbowled = overbowled;
    }

    public void setMaiden(int maiden) {
        this.maiden = maiden;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public void setRunsgiven(int runsgiven) {
        this.runsgiven = runsgiven;
    }

    public void setLb(int lb) {
        this.lb = lb;
    }

    private int runs=0;
    private int fours=0;
    private int sixes=0;
    private int balls=0;
    private String sr="0.0";
    private String economy="0.0";
    private int overbowled=0;
    private int maiden=0;
    private int wickets=0;
    private int runsgiven=0;
    private int lb=0;
    Player(String name,String team){
        this.name=name;
        this.team=team;
    }

    public void setSR(int run,int ball)
    {
        if(ball==0)
        {
            sr="0.0";
        }
        else{
            sr=df2.format(((double)100*run)/ball);
        }
    }
    public void setEco(int runsgive,int overbowl,int l)
    {
        if(overbowl==0 && l==0)
        {
            economy="0.0";
        }
        else{
            economy= df2.format(((double) 6 * runsgive) / (6 * overbowl + l));
        }
    }
}
