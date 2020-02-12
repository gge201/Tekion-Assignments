package com.example.CricketMatch.Services;

import com.example.CricketMatch.Beans.Match;
import com.example.CricketMatch.Beans.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
@Service
public class MatchService {
    @Autowired
    private Match match;

    public MatchService(String Team1, String Team2, int overs)
    {
        match=new Match(Team1,Team2,overs);
        doMatch();
    }
    public Match getMatch() {
        return match;
    }

    int r=0;
    Random rand=new Random();
    public void doToss()
    {
        r=rand.nextInt(2);
        if(r==0)
        {
            match.setToss(match.getTeam1().getTeamName());
            r=rand.nextInt(2);
            match.setTossDecision("Bat");
            if(r==1) {
                match.setTossDecision("Ball");
                Team t = match.getTeam1();
                match.setTeam1(match.getTeam2());
                match.setTeam2(t);
            }
        }
        if(r==1)
        {
            match.setToss(match.getTeam2().getTeamName());
            r=rand.nextInt(2);
            match.setTossDecision("Ball");
            if(r==0){
                match.setTossDecision("Bat");
                Team t = match.getTeam1();
                match.setTeam1(match.getTeam2());
                match.setTeam2( t);
            }
        }
    }
    public void doMatch() {
        doToss();
        match.getI1().playInnings(match.getTotalOvers(), 0, match.getTeam1().getP(), match.getTeam2().getP());
        match.getI2().playInnings(match.getTotalOvers(), match.getI1().getInnings().getScore(), match.getTeam2().getP(), match.getTeam1().getP());


        match.setDecider( match.getI1().getInnings().getScore() - match.getI2().getInnings().getScore());
        if (match.getI1().getInnings().getScore() == match.getI2().getInnings().getScore()) {
            match.setResult("Verdict --  Match Tied");
            match.setWinIndicator( 0);
        }
        if (match.getI2().getInnings().getScore() > match.getI1().getInnings().getScore()) {
            match.setWinIndicator(2);
            match.setDecider(10 - match.getI2().getInnings().getWickets());
            match.setWinBy( "wickets");
        }
        if (match.getWinIndicator() == 1) {
            match.setResult( "Verdict --  " + match.getTeam1().getTeamName() + " won by " + match.getDecider() + " " + match.getWinBy() + " ( " + match.getI2().getInnings().getBallsLeft() + " balls left )");
        } else if (match.getWinIndicator() == 2) {
            match.setResult( "Verdict --  " + match.getTeam2().getTeamName() + " won by " + match.getDecider() + " " + match.getWinBy() + " ( " + match.getI2().getInnings().getBallsLeft() + " balls left )");
        }
    }
}
