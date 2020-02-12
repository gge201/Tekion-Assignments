package com.example.CricketMatch.Beans;
import java.text.DecimalFormat;
public class BatsmanInfo {

    private static DecimalFormat df2 = new DecimalFormat("#.##");
    private int runs;
    private int fours;
    private int sixes;
    private int balls;
    private String sr;
    private String out="";

    public BatsmanInfo()
    {
        this.runs=0;
        this.fours=0;
        this.sixes=0;
        this.balls=0;
        this.sr="0.0";
    }
    public int getRuns() {
        return runs;
    }
    public void setOut(String out) {
        this.out = out;
    }


    public String getOut() {
        return out;
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

    public void setSR(int run,int ball)
    {
        if(ball==0)
        {
            sr="0.0";
        }
        else{
            sr=df2.format(((float)100*run)/ball);
        }
    }
}
