package com.example.CricketMatch.Beans;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Team {
    @JsonIgnore
    public Player[] getP() {
        return P;
    }

    Player P[]=new Player[11];
    private String teamName;
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    Team(String name) {
        teamName=name;
        for(int i=0;i<11;i++)
        {
            P[i]=new Player(this.getTeamName()+" Player "+i,this.getTeamName());
        }

    }
}