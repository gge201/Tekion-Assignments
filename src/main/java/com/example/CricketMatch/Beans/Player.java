package com.example.CricketMatch.Beans;

import java.text.DecimalFormat;

public class Player {
    private Bowler bowler;
    private Batsman batsman;

    public Bowler getBowler() {
        return bowler;
    }

    public Batsman getBatsman() {
        return batsman;
    }

    class Batsman{
        private int runs;
        private int fours;
        private int sixes;
        private int balls;
        private String sr;
        private String out="";

        private Batsman()
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
    class Bowler{
        private String economy;
        private int overbowled;
        private int maiden;
        private int wickets;
        private int runsgiven;
        private int lb;
        private Bowler(){
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


    Player(String name,String team){
        this.name=name;
        this.team=team;
    }


    private static DecimalFormat df2 = new DecimalFormat("#.##");

    private String name,team;
    private String type;
    private float rating;

    public String getType() {
        return type;
    }

    public float getRating() {
        return rating;
    }

    public void setType(String type) {
        this.type = type;
        batsman=new Batsman();
        if(type=="Bowler")
        {
            bowler=new Bowler();
        }
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }






    public void setName(String name) {
        this.name = name;
    }

    public void setTeam(String team) {
        this.team = team;
    }





}
