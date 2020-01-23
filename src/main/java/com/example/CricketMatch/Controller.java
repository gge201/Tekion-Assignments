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

        Match m=new Match(Te1,Te2);
        String jj[]=new String[5];
        jj[0]=jj[1]=jj[2]=jj[3]=jj[4]="";
        int i;
        jj[1]=jj[1]+"<table border="+".1px solid black;"+" width="+"40%;"+">" +
                "<caption><h2><u><b><i>Innings - 1(Batting) &emsp;"+Te1.getName()+"</u></i></b</h2></caption>"+
                "  <tr>" +
                "    <th>Name</th>" +"&emsp; &emsp;"+
                "    <th>b</th>" +
                "    <th>R</th>" +
                "    <th>B</th>" +
                "    <th>4s</th>" +
                "    <th>6s</th>" +
                "    <th>SR</th>" +
                "  </tr>";
        String ss="";
        for( i=0;i<=Integer.max(Te1.getSt()<=10?Te1.getSt():10,Te1.getNs()<=10?Te1.getNs():10);i++)
        {

            if(Te1.getSt()==i || Te1.getNs()==i) {
                ss="bgcolor=\"#F0FFFF\"";
            }
            jj[1] = jj[1] + "<tr "+ss+">\n" +
                    "    <td><i>" + Team1[i].getName() + "</i></td>" +
                    "    <td><i>" + Team1[i].getOut() + "</i></td>" +
                    "    <td><i>" + Team1[i].getRuns() + "</td>" +
                    "    <td><i>" + Team1[i].getBalls() + "</td>" +
                    "    <td><i>" + Team1[i].getFours() + "</td>" +
                    "    <td><i>" + Team1[i].getSixes() + "</td>" +
                    "    <td><i>" + Team1[i].getSr() + "</td>" +
                    "  </tr>" + " ";
            ss="";
        }

        jj[1]=jj[1]+"</table><br><u><b><i>"+Te1.getName()+"&ensp;"+m.score1[0]+"/"+m.wickets[0] + " (" + m.getDiv1() + "." + m.getMod1() + ") </u></b>" +"</i>";



        jj[2]=jj[2]+"<table border="+".1px solid black;"+" width="+"32%;"+"\n" +
                "<center><caption><h2><u><b><i>Innings - 1(Bowling) &emsp;"+Te2.getName()+"</u></i></b></h2></caption></center>"+
                "  <tr>\n" +
                "    <th>Name</th>\n" +"&emsp; &emsp;"+
                "    <th>O</th>\n" +
                "    <th>M</th>\n" +
                "    <th>R</th>\n" +
                "    <th>W</th>\n" +
                "    <th>E</th>\n" +
                "  </tr>";
        for( i=6;i<11;i++)
        {
            if((Team2[i].getOverbowled() > 0) || (Team2[i].getLb()>0)) {
                jj[2] = jj[2] + "<tr>\n" +
                        "    <td><i>" + Team2[i].getName() + "</i></td>\n" +
                        "    <td><i>" + Team2[i].getOverbowled() + "." + Team2[i].getLb() + "</td>\n" +
                        "    <td><i>" + Team2[i].getMaiden() + "</td>\n" +
                        "    <td><i>" + Team2[i].getRunsgiven() + "</td>\n" +
                        "    <td><i>" + Team2[i].getWickets() + "</td>\n" +
                        "    <td><i>" + Team2[i].getEconomy() + "</td>\n" +
                        "  </tr>" + " ";
            }
        }
        jj[2]=jj[2]+"</table><br> <u><b><i>FOW</i></b></u><br>";
        for(i=0;i<Te1.getBw().size();i++)
        {
            jj[2]=jj[2]+"<i>"+Te1.getRun().get(i)+"/"+(i+1)+" ("+Te1.getBw().get(i)+" - "+Te1.getOv().get(i)+" ) </i><br>";
        }
        jj[2]=jj[2]+"<br>";
        jj[2]=jj[2]+"<u><b> &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</b></u>";
        jj[3]=jj[3]+"<table border="+".1px solid black;"+" width="+"40%;"+">\n" +
                "<caption align="+"center"+"><h2><u><b><i>Innings - 2(Batting) &emsp;"+Te2.getName()+"</u></i></b></h2></caption></center>"+
                "  <tr>\n" +
                "    <th>Name</th>\n" +"&emsp; &emsp;"+
                "    <th>b</th>"+
                "    <th>R</th>\n" +
                "    <th>B</th>\n" +
                "    <th>4s</th>\n" +
                "    <th>6s</th>\n" +
                "    <th>SR</th>" +
                "  </tr>";
        for( i=0;i<=Integer.max(Te2.getSt()<=10?Te2.getSt():10,Te2.getNs()<=10?Te2.getNs():10);i++)
        {
            if(Te2.getSt()==i || Te2.getNs()==i) {
                ss="bgcolor=\"#F0FFFF\"";
            }
            jj[3] = jj[3] + "<tr "+ss+">\n" +
                    "    <td><i>" + Team2[i].getName() + "</i></td>" +
                    "    <td><i>" + Team2[i].getOut() + "</i></td>" +
                    "    <td><i>" + Team2[i].getRuns() + "</td>" +
                    "    <td><i>" + Team2[i].getBalls() + "</td>" +
                    "    <td><i>" + Team2[i].getFours() + "</td>" +
                    "    <td><i>" + Team2[i].getSixes() + "</td>" +
                    "    <td><i>" + Team2[i].getSr() + "</td>" +
                    "  </tr>" + " ";
            ss="";
        }


        jj[3]=jj[3]+"</table><br><u><b><i>"+Te2.getName()+"&ensp;"+m.score1[1]+"/"+m.wickets[1] + " (" + m.getDiv2() + "." + m.getMod2() + ") " +"</i></b></u>";
        jj[4]=jj[4]+"<table border="+".1px solid black;"+" width="+"32%;"+">\n" +
                "<caption><h2><u><b><i>Innings - 2(Bowling) &emsp;"+Te1.getName()+"</u></i></b></h2></caption>"+
                "  <tr>\n" +
                "    <th>Name</th>\n" +"&emsp; &emsp;"+
                "    <th>O</th>\n" +
                "    <th>M</th>\n" +
                "    <th>R</th>\n" +
                "    <th>W</th>\n" +
                "    <th>E</th>\n" +
                "  </tr>";

        for( i=6;i<11;i++)
        {
            if((Team1[i].getOverbowled() > 0) || (Team1[i].getLb()>0)) {
                jj[4] = jj[4] + "<tr>\n" +
                        "    <td><i>" + Team1[i].getName() + "</i></td>\n" +
                        "    <td><i>" + Team1[i].getOverbowled() + "." + Team1[i].getLb() + "</td>\n" +
                        "    <td><i>" + Team1[i].getMaiden() + "</td>\n" +
                        "    <td><i>" + Team1[i].getRunsgiven() + "</td>\n" +
                        "    <td><i>" + Team1[i].getWickets() + "</td>\n" +
                        "    <td><i>" + Team1[i].getEconomy()+ "</td>\n" +
                        "  </tr>" + " ";
            }
        }
        jj[4]=jj[4]+"</table><br> <u><b><i>FOW</i></b></u><br>";
        for(i=0;i<Te2.getBw().size();i++)
        {
            jj[4]=jj[4]+"<i>"+Te2.getRun().get(i)+"/"+(i+1)+" ("+Te2.getBw().get(i)+" - "+Te2.getOv().get(i)+" ) </i><br>";
        }
        jj[4]=jj[4]+"<br>";
        jj[4]=jj[4]+" <u><b> &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</b></u>";
        jj[0]=jj[0]+"<u><b><i>"+m.out+"</u></b></i>";
        String kk="<center>"+jj[1]+"<br>"+jj[2]+"<br>"+jj[3]+"<br>"+jj[4]+"<br>"+"<h2><b><i>"+jj[0]+"</i></b></h2></center>";

        return m;
    }

}