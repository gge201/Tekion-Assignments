package com.example.CricketMatch.Beans;
import java.util.Random;
public class Match {

    
    private String kk;
    private Innings I1,I2;
    private String toss;
    private String tossDecision;
    private Team team1,team2;
    int r=0;
    Random rand=new Random();
    private String team1Name,team2Name;
    private int totalOvers;
    private String Result;
    private int decider=0;
    private int winIndicator =1;
    private String winBy ="runs";


    public String getTeam1Name() {
        return team1Name;
    }

    public String getTeam2Name() {
        return team2Name;
    }

    /*public String getKk() {
            return kk;
        }*/
    public String getResult() {
        return Result;
    }

    public Innings getI1() {
        return I1;
    }

    public Innings getI2() {
        return I2;
    }

    public String getToss() {
        return toss;
    }

    public String getTossDecision() {
        return tossDecision;
    }

    private void doToss()
    {
        r=rand.nextInt(2);
        if(r==0)
        {
            toss=team1.getTeamName();
            r=rand.nextInt(2);
            tossDecision="Bat";
            if(r==1) {
                tossDecision="Ball";
                Team t = team1;
                team1 = team2;
                team2 = t;
            }
        }
        if(r==1)
        {
            toss=team2.getTeamName();
            r=rand.nextInt(2);
            tossDecision="Ball";
            if(r==0){
                tossDecision="Bat";
                Team t = team1;
                team1 = team2;
                team2 = t;
            }
        }
    }
    public Match(String Team1, String Team2, int overs){
        team1Name=Team1;
        team2Name=Team2;
        this.totalOvers=overs;
        team1=new Team(Team1);
        team2=new Team(Team2);
        team1.P[0].setRating(9);  team1.P[0].setType("Batsman");
        team1.P[1].setRating(8.5f);   team1.P[1].setType("Batsman");
        team1.P[2].setRating(9.5f);   team1.P[2].setType("Batsman");
        team1.P[3].setRating(8);  team1.P[3].setType("Batsman");
        team1.P[4].setRating(8);  team1.P[4].setType("Batsman");
        team1.P[5].setRating(7.5f);   team1.P[5].setType("Batsman");
        team1.P[6].setRating(8.5f);   team1.P[6].setType("Bowler");
        team1.P[7].setRating(8);  team1.P[7].setType("Bowler");
        team1.P[8].setRating(9);  team1.P[8].setType("Bowler");
        team1.P[9].setRating(7);  team1.P[9].setType("Bowler");
        team1.P[10].setRating(9); team1.P[10].setType("Bowler");

        team2.P[0].setRating(9.5f);  team2.P[0].setType("Batsman");
        team2.P[1].setRating(8.5f);   team2.P[1].setType("Batsman");
        team2.P[2].setRating(9f);   team2.P[2].setType("Batsman");
        team2.P[3].setRating(8.5f);  team2.P[3].setType("Batsman");
        team2.P[4].setRating(8.5f);  team2.P[4].setType("Batsman");
        team2.P[5].setRating(7.5f);   team2.P[5].setType("Batsman");
        team2.P[6].setRating(9);   team2.P[6].setType("Bowler");
        team2.P[7].setRating(8.5f);  team2.P[7].setType("Bowler");
        team2.P[8].setRating(9);  team2.P[8].setType("Bowler");
        team2.P[9].setRating(7.5f);  team2.P[9].setType("Bowler");
        team2.P[10].setRating(9); team2.P[10].setType("Bowler");
        doToss();
      I1=new Innings();
        I1.playInnings(totalOvers,0,team1.P,team2.P);
      I2= new Innings();
        I2.playInnings(totalOvers,I1.getScore(),team2.P,team1.P);


        decider=I1.getScore()-I2.getScore();
        String jj[]=new String[5];
        jj[0]=jj[1]=jj[2]=jj[3]=jj[4]="";
        int i;
        jj[1]=jj[1]+"<table border="+".1px solid black;"+" width="+"40%;"+">" +
                "<caption><h2><u><b><i>Innings - 1(Batting) &emsp;"+team1.getTeamName()+"</u></i></b</h2></caption>"+
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
        for(i=0; i<=Integer.max(I1.getStriker()<=10?I1.getStriker():10,I1.getNonStriker()<=10?I1.getNonStriker():10); i++)
        {

            if(I1.getStriker()==i || I1.getNonStriker()==i) {
                ss="bgcolor=\"#F0FFFF\"";
            }
            jj[1] = jj[1] + "<tr "+ss+">\n" +
                    "    <td><i>" + team1.P[i].getName() + "</i></td>" +
                    "    <td><i>" + team1.P[i].getBatsmanInfo().getOut() + "</i></td>" +
                    "    <td><i>" + team1.P[i].getBatsmanInfo().getRuns() + "</td>" +
                    "    <td><i>" + team1.P[i].getBatsmanInfo().getBalls() + "</td>" +
                    "    <td><i>" + team1.P[i].getBatsmanInfo().getFours() + "</td>" +
                    "    <td><i>" + team1.P[i].getBatsmanInfo().getSixes() + "</td>" +
                    "    <td><i>" + team1.P[i].getBatsmanInfo().getSr() + "</td>" +
                    "  </tr>" + " ";
            ss="";
        }

        jj[1]=jj[1]+"</table><br><u><b><i>"+team1.getTeamName()+"&ensp;"+ I1.getScore()+"/"+I1.getWickets() + " (" + I1.getOversFaced() + "." + I1.getBallBowled() + ") </u></b>" +"</i>";



        jj[2]=jj[2]+"<table border="+".1px solid black;"+" width="+"32%;"+"\n" +
                "<center><caption><h2><u><b><i>Innings - 1(Bowling) &emsp;"+team2.getTeamName()+"</u></i></b></h2></caption></center>"+
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
            if((team2.P[i].getBowlerInfo().getOverbowled() > 0) || (team2.P[i].getBowlerInfo().getLb()>0)) {
                jj[2] = jj[2] + "<tr>\n" +
                        "    <td><i>" + team2.P[i].getName() + "</i></td>\n" +
                        "    <td><i>" + team2.P[i].getBowlerInfo().getOverbowled() + "." + team2.P[i].getBowlerInfo().getLb() + "</td>\n" +
                        "    <td><i>" + team2.P[i].getBowlerInfo().getMaiden() + "</td>\n" +
                        "    <td><i>" + team2.P[i].getBowlerInfo().getRunsgiven() + "</td>\n" +
                        "    <td><i>" + team2.P[i].getBowlerInfo().getWickets() + "</td>\n" +
                        "    <td><i>" + team2.P[i].getBowlerInfo().getEconomy() + "</td>\n" +
                        "  </tr>" + " ";
            }
        }
        jj[2]=jj[2]+"</table><br> ";//<u><b><i>FOW</i></b></u><br>";
       /*for(i=0;i<I1.getBw().size();i++)
        {
            jj[2]=jj[2]+"<i>"+I1.getRun().get(i)+"/"+(i+1)+" ("+I1.getBw().get(i)+" - "+I1.getOv().get(i)+" ) </i><br>";
        }*/
        jj[2]=jj[2]+"<br>";
        jj[2]=jj[2]+"<u><b> &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</b></u>";
        jj[3]=jj[3]+"<table border="+".1px solid black;"+" width="+"40%;"+">\n" +
                "<caption align="+"center"+"><h2><u><b><i>Innings - 2(Batting) &emsp;"+team2.getTeamName()+"</u></i></b></h2></caption></center>"+
                "  <tr>\n" +
                "    <th>Name</th>\n" +"&emsp; &emsp;"+
                "    <th>b</th>"+
                "    <th>R</th>\n" +
                "    <th>B</th>\n" +
                "    <th>4s</th>\n" +
                "    <th>6s</th>\n" +
                "    <th>SR</th>" +
                "  </tr>";
        for(i=0; i<=Integer.max(I2.getStriker()<=10?I2.getStriker():10,I2.getNonStriker()<=10?I2.getNonStriker():10); i++)
        {
            if(I2.getStriker()==i || I2.getNonStriker()==i) {
                ss="bgcolor=\"#F0FFFF\"";
            }
            jj[3] = jj[3] + "<tr "+ss+">\n" +
                    "    <td><i>" + team2.P[i].getName() + "</i></td>" +
                    "    <td><i>" + team2.P[i].getBatsmanInfo().getOut() + "</i></td>" +
                    "    <td><i>" + team2.P[i].getBatsmanInfo().getRuns() + "</td>" +
                    "    <td><i>" + team2.P[i].getBatsmanInfo().getBalls() + "</td>" +
                    "    <td><i>" + team2.P[i].getBatsmanInfo().getFours() + "</td>" +
                    "    <td><i>" + team2.P[i].getBatsmanInfo().getSixes() + "</td>" +
                    "    <td><i>" + team2.P[i].getBatsmanInfo().getSr() + "</td>" +
                    "  </tr>" + " ";
            ss="";
        }


        jj[3]=jj[3]+"</table><br><u><b><i>"+team2.getTeamName()+"&ensp;"+I2.getScore()+"/"+I2.getWickets() + " (" + I2.getOversFaced() + "." + I2.getBallBowled() + ") " +"</i></b></u>";
        jj[4]=jj[4]+"<table border="+".1px solid black;"+" width="+"32%;"+">\n" +
                "<caption><h2><u><b><i>Innings - 2(Bowling) &emsp;"+team1.getTeamName()+"</u></i></b></h2></caption>"+
                "  <tr>\n" +
                "    <th>Name</th>\n" +"&emsp; &emsp;"+
                "    <th>O</th>\n" +
                "    <th>M</th>\n" +
                "    <th>R</th>\n" +
                "    <th>W</th>\n" +
                "    <th>E</th>\n" +
                "  </tr>";

        for( i=6;i<11;i++) {
            if ((team1.P[i].getBowlerInfo().getOverbowled() > 0) || (team1.P[i].getBowlerInfo().getLb() > 0)) {
                jj[4] = jj[4] + "<tr>\n" +
                        "    <td><i>" + team1.P[i].getName() + "</i></td>\n" +
                        "    <td><i>" + team1.P[i].getBowlerInfo().getOverbowled() + "." + team1.P[i].getBowlerInfo().getLb() + "</td>\n" +
                        "    <td><i>" + team1.P[i].getBowlerInfo().getMaiden() + "</td>\n" +
                        "    <td><i>" + team1.P[i].getBowlerInfo().getRunsgiven() + "</td>\n" +
                        "    <td><i>" + team1.P[i].getBowlerInfo().getWickets() + "</td>\n" +
                        "    <td><i>" + team1.P[i].getBowlerInfo().getEconomy() + "</td>\n" +
                        "  </tr>" + " ";
            }
        }
        jj[4]=jj[4]+"</table><br> ";//<u><b><i>FOW</i></b></u><br>";
     /*   for(i=0;i<I2.getBw().size();i++)
        {
            jj[4]=jj[4]+"<i>"+I2.getRun().get(i)+"/"+(i+1)+" ("+I2.getBw().get(i)+" - "+I2.getOv().get(i)+" ) </i><br>";
        }*/

        if(I1.getScore()==I2.getScore())
        {
            Result = "Verdict --  Match Tied";
            winIndicator =0;
        }
        if(I2.getScore()>I1.getScore())
        {
            winIndicator =2;
            decider=10-I2.getWickets();
            winBy="wickets";
        }
        if(winIndicator ==1) {
            Result = "Verdict --  " + team1.getTeamName() + " won by " + decider + " " + winBy + " ( " + I2.getBallsLeft() + " balls left )";
        }
        else if(winIndicator ==2){
            Result = "Verdict --  " + team2.getTeamName() + " won by " + decider + " " + winBy + " ( " + I2.getBallsLeft() + " balls left )";
        }
        jj[4]=jj[4]+"<br>";
        jj[4]=jj[4]+" <u><b> &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</b></u>";
        jj[0]=jj[0]+"<u><b><i>"+Result+"</u></b></i>";
        kk="<center>"+jj[1]+"<br>"+jj[2]+"<br>"+jj[3]+"<br>"+jj[4]+"<br>"+"<h2><b><i>"+jj[0]+"</i></b></h2></center>";
    }
}