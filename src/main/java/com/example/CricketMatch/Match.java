package com.example.CricketMatch;

public class Match {

    private int[] score1=new int[2];
    private String kk;
    public String getKk() {
        return kk;
    }


    private Innings i1,i2;
    private int[] wickets=new int[2];
    private int overs=50;
    private String team1,team2;
    private int div1,div2,mod1,mod2;
    private String out;
    private int remain=0;
    private int tt=1;
    private String vv="runs";

    public int[] getScore1() {
        return score1;
    }

    public int[] getWickets() {
        return wickets;
    }

    public int getOvers() {
        return overs;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public int getDiv1() {
        return div1;
    }

    public int getDiv2() {
        return div2;
    }

    public int getMod1() {
        return mod1;
    }

    public int getMod2() {
        return mod2;
    }

    public String getOut() {
        return out;
    }

    public int getRemain() {
        return remain;
    }

    public int getTt() {
        return tt;
    }

    public String getVv() {
        return vv;
    }

    public Innings getI1() {
        return i1;
    }

    public Innings getI2() {
        return i2;
    }

    public Match(String Team1, String Team2, int overs){
        Team team1=new Team(Team1,overs);
        Team team2=new Team(Team2,overs);
        for(int i=0;i<11;i++)
        {
            team1.P[i]=new Player(team1.getTeamName()+" Player "+i,team1.getTeamName());
            team2.P[i]=new Player(team2.getTeamName()+" Player "+i,team2.getTeamName());
        }

        Innings I1=new Innings(overs,0,team1.P,team2.P);
        Innings I2= new Innings(overs,I1.getScore(),team2.P,team1.P);

        i1=I1;
        i2=I2;
        score1[0]=I1.getScore();
        this.overs=I1.getOvers();
        score1[1]=I2.getScore();
        wickets[0]=I1.getWickets();
        wickets[1]=I2.getWickets();
        div1=I1.getDiv();
        div2=I2.getDiv();
        mod1=I1.getMod();
        mod2=I2.getMod();
        remain=score1[0]-score1[1];
        String jj[]=new String[5];
        jj[0]=jj[1]=jj[2]=jj[3]=jj[4]="";
        int i;
        jj[1]=jj[1]+"<table border="+".1px solid black;"+" width="+"40%;"+">" +
                "<caption><h2><u><b><i>Innings - 1(Batting) &emsp;"+I1.getName()+"</u></i></b</h2></caption>"+
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
        for( i=0;i<=Integer.max(I1.getSt()<=10?I1.getSt():10,I1.getNs()<=10?I1.getNs():10);i++)
        {

            if(I1.getSt()==i || I1.getNs()==i) {
                ss="bgcolor=\"#F0FFFF\"";
            }
            jj[1] = jj[1] + "<tr "+ss+">\n" +
                    "    <td><i>" + team1.P[i].getName() + "</i></td>" +
                    "    <td><i>" + team1.P[i].getOut() + "</i></td>" +
                    "    <td><i>" + team1.P[i].getRuns() + "</td>" +
                    "    <td><i>" + team1.P[i].getBalls() + "</td>" +
                    "    <td><i>" + team1.P[i].getFours() + "</td>" +
                    "    <td><i>" + team1.P[i].getSixes() + "</td>" +
                    "    <td><i>" + team1.P[i].getSr() + "</td>" +
                    "  </tr>" + " ";
            ss="";
        }

        jj[1]=jj[1]+"</table><br><u><b><i>"+I1.getName()+"&ensp;"+ I1.getScore()+"/"+I1.getWickets() + " (" + I1.getDiv() + "." + I1.getMod() + ") </u></b>" +"</i>";



        jj[2]=jj[2]+"<table border="+".1px solid black;"+" width="+"32%;"+"\n" +
                "<center><caption><h2><u><b><i>Innings - 1(Bowling) &emsp;"+I2.getName()+"</u></i></b></h2></caption></center>"+
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
            if((team2.P[i].getOverbowled() > 0) || (team2.P[i].getLb()>0)) {
                jj[2] = jj[2] + "<tr>\n" +
                        "    <td><i>" + team2.P[i].getName() + "</i></td>\n" +
                        "    <td><i>" + team2.P[i].getOverbowled() + "." + team2.P[i].getLb() + "</td>\n" +
                        "    <td><i>" + team2.P[i].getMaiden() + "</td>\n" +
                        "    <td><i>" + team2.P[i].getRunsgiven() + "</td>\n" +
                        "    <td><i>" + team2.P[i].getWickets() + "</td>\n" +
                        "    <td><i>" + team2.P[i].getEconomy() + "</td>\n" +
                        "  </tr>" + " ";
            }
        }
        jj[2]=jj[2]+"</table><br> <u><b><i>FOW</i></b></u><br>";
        for(i=0;i<I1.getBw().size();i++)
        {
            jj[2]=jj[2]+"<i>"+I1.getRun().get(i)+"/"+(i+1)+" ("+I1.getBw().get(i)+" - "+I1.getOv().get(i)+" ) </i><br>";
        }
        jj[2]=jj[2]+"<br>";
        jj[2]=jj[2]+"<u><b> &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</b></u>";
        jj[3]=jj[3]+"<table border="+".1px solid black;"+" width="+"40%;"+">\n" +
                "<caption align="+"center"+"><h2><u><b><i>Innings - 2(Batting) &emsp;"+I2.getName()+"</u></i></b></h2></caption></center>"+
                "  <tr>\n" +
                "    <th>Name</th>\n" +"&emsp; &emsp;"+
                "    <th>b</th>"+
                "    <th>R</th>\n" +
                "    <th>B</th>\n" +
                "    <th>4s</th>\n" +
                "    <th>6s</th>\n" +
                "    <th>SR</th>" +
                "  </tr>";
        for( i=0;i<=Integer.max(I2.getSt()<=10?I2.getSt():10,I2.getNs()<=10?I2.getNs():10);i++)
        {
            if(I2.getSt()==i || I2.getNs()==i) {
                ss="bgcolor=\"#F0FFFF\"";
            }
            jj[3] = jj[3] + "<tr "+ss+">\n" +
                    "    <td><i>" + team2.P[i].getName() + "</i></td>" +
                    "    <td><i>" + team2.P[i].getOut() + "</i></td>" +
                    "    <td><i>" + team2.P[i].getRuns() + "</td>" +
                    "    <td><i>" + team2.P[i].getBalls() + "</td>" +
                    "    <td><i>" + team2.P[i].getFours() + "</td>" +
                    "    <td><i>" + team2.P[i].getSixes() + "</td>" +
                    "    <td><i>" + team2.P[i].getSr() + "</td>" +
                    "  </tr>" + " ";
            ss="";
        }


        jj[3]=jj[3]+"</table><br><u><b><i>"+I2.getName()+"&ensp;"+I2.getScore()+"/"+I2.getWickets() + " (" + I2.getDiv() + "." + I2.getMod() + ") " +"</i></b></u>";
        jj[4]=jj[4]+"<table border="+".1px solid black;"+" width="+"32%;"+">\n" +
                "<caption><h2><u><b><i>Innings - 2(Bowling) &emsp;"+I1.getName()+"</u></i></b></h2></caption>"+
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
            if((team1.P[i].getOverbowled() > 0) || (team1.P[i].getLb()>0)) {
                jj[4] = jj[4] + "<tr>\n" +
                        "    <td><i>" + team1.P[i].getName() + "</i></td>\n" +
                        "    <td><i>" + team1.P[i].getOverbowled() + "." + team1.P[i].getLb() + "</td>\n" +
                        "    <td><i>" + team1.P[i].getMaiden() + "</td>\n" +
                        "    <td><i>" + team1.P[i].getRunsgiven() + "</td>\n" +
                        "    <td><i>" + team1.P[i].getWickets() + "</td>\n" +
                        "    <td><i>" + team1.P[i].getEconomy()+ "</td>\n" +
                        "  </tr>" + " ";
            }
        }
        jj[4]=jj[4]+"</table><br> <u><b><i>FOW</i></b></u><br>";
        for(i=0;i<I2.getBw().size();i++)
        {
            jj[4]=jj[4]+"<i>"+I2.getRun().get(i)+"/"+(i+1)+" ("+I2.getBw().get(i)+" - "+I2.getOv().get(i)+" ) </i><br>";
        }

        if(score1[0]==score1[1])
        {
            out = "Verdict --  Match Tied";
            tt=0;
        }
        if(score1[1]>score1[0])
        {
            tt=2;
            remain=10-wickets[1];
            vv="wickets";
        }
        if(tt==1) {
            out = "Verdict --  " + team1.getTeamName() + " won by " + remain + " " + vv + " ( " + I2.getBall() + " balls left )";
        }
        else if(tt==2){
            out = "Verdict --  " + team2.getTeamName() + " won by " + remain + " " + vv + " ( " + I2.getBall() + " balls left )";
        }
        jj[4]=jj[4]+"<br>";
        jj[4]=jj[4]+" <u><b> &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</b></u>";
        jj[0]=jj[0]+"<u><b><i>"+out+"</u></b></i>";
        kk="<center>"+jj[1]+"<br>"+jj[2]+"<br>"+jj[3]+"<br>"+jj[4]+"<br>"+"<h2><b><i>"+jj[0]+"</i></b></h2></center>";


    }

}