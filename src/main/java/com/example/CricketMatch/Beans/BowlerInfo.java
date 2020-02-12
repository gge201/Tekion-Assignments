package com.example.CricketMatch.Beans;

import java.text.DecimalFormat;
public class BowlerInfo {
    private static DecimalFormat df2 = new DecimalFormat("#.##");
    private String economy;
    private int overbowled;
    private int maiden;
    private int wickets;
    private int runsgiven;
    private int lb;
    public BowlerInfo(){
        this.economy="0.0";
        this.overbowled=0;
        this.maiden=0;
        this.wickets=0;
        this.runsgiven=0;
        this.lb=0;
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




    public void setEco(int runsgiven,int overbowl,int l)
    {
        if(overbowl==0 && l==0)
        {
            economy="0.0";
        }
        else{
            economy= df2.format(((float) 6 * runsgiven) / (6 * overbowl + l));
        }
    }
}
