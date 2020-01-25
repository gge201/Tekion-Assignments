package com.example.CricketMatch;
import java.util.*;

public class Match {
    private int[] score1=new int[2];
    private String kk;
    /*public String getKk() {
        return kk;
    }*/


    private Innings I1,I2;
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
        return I1;
    }

    public Innings getI2() {
        return I2;
    }

    Match(Innings Te1, Innings Te2,Player[] Team1,Player[] Team2){
        I1=Te1;
        I2=Te2;
        score1[0]=Te1.getScore();
        overs=Te1.getOvers();
        score1[1]=Te2.getScore();
        team1=Te1.getName();
        team2=Te2.getName();
        wickets[0]=Te1.getWickets();
        wickets[1]=Te2.getWickets();
        div1=Te1.getDiv();
        div2=Te2.getDiv();
        mod1=Te1.getMod();
        mod2=Te2.getMod();
        remain=score1[0]-score1[1];
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

        jj[1]=jj[1]+"</table><br><u><b><i>"+Te1.getName()+"&ensp;"+ Te1.getScore()+"/"+Te1.getWickets() + " (" + Te1.getDiv() + "." + Te1.getMod() + ") </u></b>" +"</i>";



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


        jj[3]=jj[3]+"</table><br><u><b><i>"+Te2.getName()+"&ensp;"+Te2.getScore()+"/"+Te2.getWickets() + " (" + Te2.getDiv() + "." + Te2.getMod() + ") " +"</i></b></u>";
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
            out = "Verdict --  " + team1 + " won by " + remain + " " + vv + " ( " + Te2.getBall() + " balls left )";
        }
        else if(tt==2){
            out = "Verdict --  " + team2 + " won by " + remain + " " + vv + " ( " + Te2.getBall() + " balls left )";
        }
        jj[4]=jj[4]+"<br>";
        jj[4]=jj[4]+" <u><b> &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</b></u>";
        jj[0]=jj[0]+"<u><b><i>"+out+"</u></b></i>";
        kk="<center>"+jj[1]+"<br>"+jj[2]+"<br>"+jj[3]+"<br>"+jj[4]+"<br>"+"<h2><b><i>"+jj[0]+"</i></b></h2></center>";


    }

}