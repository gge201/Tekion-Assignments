package com.example.CricketMatch.Repository;

import com.example.CricketMatch.Beans.Match;

import java.util.ArrayList;
import java.util.List;

public class MatchRepository {
    private List<Match> matchList=new ArrayList<Match>();
    public Match getMatch(int matchIndex) throws IndexOutOfBoundsException {
        if(matchIndex>=matchList.size())
        {
            throw new IndexOutOfBoundsException();
        }
        return matchList.get(matchIndex);
    }
    public void addMatch(Match m){
        matchList.add(m);
    }
}
