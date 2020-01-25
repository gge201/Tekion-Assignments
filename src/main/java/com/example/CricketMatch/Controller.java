package com.example.CricketMatch;
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
    public Match greeting(@RequestParam(value = "T1", defaultValue = "Mumbai") String T1,@RequestParam(value = "T2", defaultValue = "Chennai") String T2, @RequestParam(value = "overs", defaultValue = "20") String overs) {
        // Return String kk to look at the webpage and change function type to string
        Player[] Team1=new Player[11];
        Player[] Team2=new Player[11];
        int j;

        for(j=0;j<11;j++)
        {
            Team1[j]=new Player(T1+" Player-"+ j,T1);
            Team2[j]=new Player(T2+" Player-"+ j,T2);
        }

        Innings Te1=new Innings(Integer.parseInt(overs),0,Team1,Team2);
        Innings Te2= new Innings(Integer.parseInt(overs),Te1.getScore(),Team2,Team1);

        Match m=new Match(Te1,Te2,Team1,Team2);

        return m;
    }

}