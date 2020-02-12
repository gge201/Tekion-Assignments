package com.example.CricketMatch.Services;

import com.example.CricketMatch.Beans.Player;

public class PlayerService {
    public PlayerService(){

    }

    public void updateRuns(int runs,Player p) {
        p.getBatsmanInfo().setRuns(p.getBatsmanInfo().getRuns()+runs);
    }

    public void updateRunsGiven(int runs,Player p) {
        p.getBowlerInfo().setRunsgiven(p.getBowlerInfo().getRunsgiven()+runs);
    }

    public void updateFours(Player p) {
        p.getBatsmanInfo().setFours(p.getBatsmanInfo().getFours()+1);
    }

    public void updateSixes(Player p) {
        p.getBatsmanInfo().setSixes(p.getBatsmanInfo().getSixes()+1);
    }

    public void updateBallsDelivered(Player p) {
        p.getBowlerInfo().setLb(p.getBowlerInfo().getLb()+1);
    }

    public void updateBallsFaced(Player p) {
        p.getBatsmanInfo().setBalls(p.getBatsmanInfo().getBalls()+1);
    }

    public void updateWicketsTaken(Player p) {
        p.getBowlerInfo().setWickets(p.getBowlerInfo().getWickets()+1);
    }

    public void updateMaidenOvers(Player p) {
        p.getBowlerInfo().setMaiden(p.getBowlerInfo().getMaiden()+1);
    }

    public void updateOversBowled(Player p) {
        p.getBowlerInfo().setOverbowled(p.getBowlerInfo().getOverbowled()+1);
    }

    public void updateStrikeRate(Player p) {
        p.getBatsmanInfo().setSR(p.getBatsmanInfo().getRuns(),p.getBatsmanInfo().getBalls());
    }

    public void updateEconomy(Player p) {
        p.getBowlerInfo().setEco(p.getBowlerInfo().getRunsgiven(),p.getBowlerInfo().getOverbowled(),p.getBowlerInfo().getLb());
    }
}
