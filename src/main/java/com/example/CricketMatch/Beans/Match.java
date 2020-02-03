package com.example.CricketMatch.Beans;

public class Match {

    
   private String kk;
   /*public String getKk() {
        return kk;
   }*/
    private Innings I1,I2;
    private String team1,team2;
    private String Result;
    private int remain=0;
    private int tt=1;
    private String vv="runs";

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public String getResult() {
        return Result;
    }

    public Innings getI1() {
        return I1;
    }

    public Innings getI2() {
        return I2;
    }

    public Match(String Team1, String Team2, int overs){
        team1=Team1;
        team2=Team2;
        Team team1=new Team(Team1,overs);
        Team team2=new Team(Team2,overs);
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

        I1=new Innings(overs,0,team1.P,team2.P);

        I2= new Innings(overs,I1.getScore(), team1.P , team2.P);


        remain=I1.getScore()-I2.getScore();
        String jj[]=new String[5];
        jj[0]=jj[1]=jj[2]=jj[3]=jj[4]="";
        int i;
        jj[1]=jj[1]+"<table border="+".1px solid black;"+" width="+"40%;"+">" +
                "<caption><h2><u><b><i>Innings - 1(Batting) &emsp;"+Team1+"</u></i></b</h2></caption>"+
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
                    "    <td><i>" + team1.P[i].getBatsman().getOut() + "</i></td>" +
                    "    <td><i>" + team1.P[i].getBatsman().getRuns() + "</td>" +
                    "    <td><i>" + team1.P[i].getBatsman().getBalls() + "</td>" +
                    "    <td><i>" + team1.P[i].getBatsman().getFours() + "</td>" +
                    "    <td><i>" + team1.P[i].getBatsman().getSixes() + "</td>" +
                    "    <td><i>" + team1.P[i].getBatsman().getSr() + "</td>" +
                    "  </tr>" + " ";
            ss="";
        }

        jj[1]=jj[1]+"</table><br><u><b><i>"+Team1+"&ensp;"+ I1.getScore()+"/"+I1.getWickets() + " (" + I1.getOversFaced() + "." + I1.getBallBowled() + ") </u></b>" +"</i>";



        jj[2]=jj[2]+"<table border="+".1px solid black;"+" width="+"32%;"+"\n" +
                "<center><caption><h2><u><b><i>Innings - 1(Bowling) &emsp;"+Team2+"</u></i></b></h2></caption></center>"+
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
            if((team2.P[i].getBowler().getOverbowled() > 0) || (team2.P[i].getBowler().getLb()>0)) {
                jj[2] = jj[2] + "<tr>\n" +
                        "    <td><i>" + team2.P[i].getName() + "</i></td>\n" +
                        "    <td><i>" + team2.P[i].getBowler().getOverbowled() + "." + team2.P[i].getBowler().getLb() + "</td>\n" +
                        "    <td><i>" + team2.P[i].getBowler().getMaiden() + "</td>\n" +
                        "    <td><i>" + team2.P[i].getBowler().getRunsgiven() + "</td>\n" +
                        "    <td><i>" + team2.P[i].getBowler().getWickets() + "</td>\n" +
                        "    <td><i>" + team2.P[i].getBowler().getEconomy() + "</td>\n" +
                        "  </tr>" + " ";
            }
        }
        jj[2]=jj[2]+"</table><br> <u><b><i>FOW</i></b></u><br>";
       /* for(i=0;i<I1.getBw().size();i++)
        {
            jj[2]=jj[2]+"<i>"+I1.getRun().get(i)+"/"+(i+1)+" ("+I1.getBw().get(i)+" - "+I1.getOv().get(i)+" ) </i><br>";
        }*/
        jj[2]=jj[2]+"<br>";
        jj[2]=jj[2]+"<u><b> &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</b></u>";
        jj[3]=jj[3]+"<table border="+".1px solid black;"+" width="+"40%;"+">\n" +
                "<caption align="+"center"+"><h2><u><b><i>Innings - 2(Batting) &emsp;"+Team2+"</u></i></b></h2></caption></center>"+
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
                    "    <td><i>" + team2.P[i].getBatsman().getOut() + "</i></td>" +
                    "    <td><i>" + team2.P[i].getBatsman().getRuns() + "</td>" +
                    "    <td><i>" + team2.P[i].getBatsman().getBalls() + "</td>" +
                    "    <td><i>" + team2.P[i].getBatsman().getFours() + "</td>" +
                    "    <td><i>" + team2.P[i].getBatsman().getSixes() + "</td>" +
                    "    <td><i>" + team2.P[i].getBatsman().getSr() + "</td>" +
                    "  </tr>" + " ";
            ss="";
        }


        jj[3]=jj[3]+"</table><br><u><b><i>"+Team2+"&ensp;"+I2.getScore()+"/"+I2.getWickets() + " (" + I2.getOversFaced() + "." + I2.getBallBowled() + ") " +"</i></b></u>";
        jj[4]=jj[4]+"<table border="+".1px solid black;"+" width="+"32%;"+">\n" +
                "<caption><h2><u><b><i>Innings - 2(Bowling) &emsp;"+Team2+"</u></i></b></h2></caption>"+
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
            if((team1.P[i].getBowler().getOverbowled() > 0) || (team1.P[i].getBowler().getLb()>0)) {
                jj[4] = jj[4] + "<tr>\n" +
                        "    <td><i>" + team1.P[i].getName() + "</i></td>\n" +
                        "    <td><i>" + team1.P[i].getBowler().getOverbowled() + "." + team1.P[i].getBowler().getLb() + "</td>\n" +
                        "    <td><i>" + team1.P[i].getBowler().getMaiden() + "</td>\n" +
                        "    <td><i>" + team1.P[i].getBowler().getRunsgiven() + "</td>\n" +
                        "    <td><i>" + team1.P[i].getBowler().getWickets() + "</td>\n" +
                        "    <td><i>" + team1.P[i].getBowler().getEconomy()+ "</td>\n" +
                        "  </tr>" + " ";
            }
        }
        jj[4]=jj[4]+"</table><br> <u><b><i>FOW</i></b></u><br>";
     /*   for(i=0;i<I2.getBw().size();i++)
        {
            jj[4]=jj[4]+"<i>"+I2.getRun().get(i)+"/"+(i+1)+" ("+I2.getBw().get(i)+" - "+I2.getOv().get(i)+" ) </i><br>";
        }*/

        if(I1.getScore()==I2.getScore())
        {
            Result = "Verdict --  Match Tied";
            tt=0;
        }
        if(I2.getScore()>I1.getScore())
        {
            tt=2;
            remain=10-I2.getWickets();
            vv="wickets";
        }
        if(tt==1) {
            Result = "Verdict --  " + team1.getTeamName() + " won by " + remain + " " + vv + " ( " + I2.getBall() + " balls left )";
        }
        else if(tt==2){
            Result = "Verdict --  " + team2.getTeamName() + " won by " + remain + " " + vv + " ( " + I2.getBall() + " balls left )";
        }
        jj[4]=jj[4]+"<br>";
        jj[4]=jj[4]+" <u><b> &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</b></u>";
        jj[0]=jj[0]+"<u><b><i>"+Result+"</u></b></i>";
        kk="<center>"+jj[1]+"<br>"+jj[2]+"<br>"+jj[3]+"<br>"+jj[4]+"<br>"+"<h2><b><i>"+jj[0]+"</i></b></h2></center>";


    }

}