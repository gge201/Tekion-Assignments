package com.example.CricketMatch.Beans;

public class Team {
    Player P[]=new Player[11];
    private int overs;
    private String teamName;

    public int getOvers() {
        return overs;
    }

    public void setOvers(int overs) {
        this.overs = overs;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    Team(String name, int overs) {
        teamName=name;
        this.overs=overs;
        for(int i=0;i<11;i++)
        {
            P[i]=new Player(this.getTeamName()+" Player "+i,this.getTeamName());
        }

    }
}