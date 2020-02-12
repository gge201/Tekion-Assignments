package com.example.CricketMatch.Beans;


public class Player {
    private BowlerInfo bowlerInfo;
    private BatsmanInfo batsmanInfo;


    Player(String name,String team){
        this.name=name;
        this.team=team;
    }

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
        batsmanInfo=new BatsmanInfo();
        if(type=="Bowler")
        {
            bowlerInfo=new BowlerInfo();
        }
    }

    public BowlerInfo getBowlerInfo() {
        return bowlerInfo;
    }

    public BatsmanInfo getBatsmanInfo() {
        return batsmanInfo;
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

    public void setBowlerInfo(BowlerInfo bowlerInfo) {
        this.bowlerInfo = bowlerInfo;
    }

    public void setBatsmanInfo(BatsmanInfo batsmanInfo) {
        this.batsmanInfo = batsmanInfo;
    }

    public void setTeam(String team) {
        this.team = team;
    }





}
