package com.example.CricketMatch;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @RequestMapping("/")
    public String out()
    {
        return "<i><h4>"+
                "<form action=\"/Verdict\">\n" +
                "Overs: <input type=\"text\" name=\"overs\"><br>\n" +
                "Team 1: <input type=\"text\" name=\"T1\"><br>\n" +
                "Team 2: <input type=\"text\" name=\"T2\"><br><br>\n" +
                "<input type=\"submit\" value=\"Submit\">\n" +
                "</form> " +"</h4></i>";
    }
    @GetMapping("/Verdict")
    public Match greeting(@RequestParam(value = "T1", defaultValue = "Mumbai") String T1,@RequestParam(value = "T2", defaultValue = "Chennai") String T2, @RequestParam(value = "overs", defaultValue = "20") String overs) {
        Team Team1=new Team(T1,Integer.parseInt(overs),0);
        Team Team2=new Team(T2,Integer.parseInt(overs),Team1.score);
        Match m=new Match(Team1,Team2);
        String jj=m.out;
        return m;
    }

}
