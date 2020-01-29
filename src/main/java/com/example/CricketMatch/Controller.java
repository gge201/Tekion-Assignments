package com.example.CricketMatch;
import com.example.CricketMatch.Match;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping("/")

    public String out()
    {

        return "<body>" +
                "<i><h3>"+
                "<form action=\"/Verdict\">\n" +
                "Overs: <input type=\"text\" Name=\"overs\"><br>\n" +
                "Team 1: <input type=\"text\" Name=\"T1\"><br>\n" +
                "Team 2: <input type=\"text\" Name=\"T2\"><br><br>\n" +
                "<input type=\"submit\" value=\"Submit\">\n" +
                "</form> " +"</h3></i></body>";
    }
    @GetMapping("/Verdict")
    public Match Greeting(@RequestParam(value = "T1", defaultValue = "Mumbai") String T1,@RequestParam(value = "T2", defaultValue = "Chennai") String T2, @RequestParam(value = "overs", defaultValue = "20") String overs) {
        // Return String kk to look at the webpage and change function type to string
        Match m=new Match(T1,T2,Integer.parseInt(overs));
        return m;
    }

}