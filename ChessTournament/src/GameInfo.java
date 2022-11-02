/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tgumb
 * 
 * The Game info class, is here to make an object of each tournament that happens it does this by saving data like,
 * player name as seen below, it also saves the winner of the current tournament, the second place person,
 * and the date of the tournament. each tournament saved as an object in the game info array list found in MainGame class.
 * The Game info class, is also used to run the each tournament because the tournament runs off the player name variables
 * shown below. 
 * 
 */
public class GameInfo implements java.io.Serializable {
//INSTANCE VARIABLE
  private String playername;
  private String playername2;
  private String playername3;
  private String playername4;
  private String playername5;
  private String playername6;
  private String playername7;
  private String playername8;
  private String Winner_1;
  private String seconds;
  private int Date;


 //Constructor that takes arguments
  public GameInfo (String playername,String playername2,String playername3,String playername4,String playername5,String playername6,String playername7,String playername8,String Winner_1, int Date, String seconds){
    this.playername = playername;
    this.playername2 = playername2;
    this.playername3 = playername3;
    this.playername4 = playername4;
    this.playername5 = playername5;
    this.playername6 = playername6;
    this.playername7 = playername7;
    this.playername8 = playername8;
    this.Winner_1 = Winner_1;
    this.seconds = seconds;
    this.Date = Date;
  }
//getter methods 
  public String getPlayername(){
    return this.playername;
  }
  
  public String getPlayername2(){
    return this.playername2;
  }
  
  public String getPlayername3(){
    return this.playername3;
  }
  
  public String getPlayername4(){
    return this.playername4;
  }
  
  public String getPlayername5(){
    return this.playername5;
  }
  
  public String getPlayername6(){
    return this.playername6;
  }
  
  public String getPlayername7(){
    return this.playername7;
  }
  
  public String getPlayername8(){
    return this.playername8;
  }
  
  public String getWinner_1(){
    return this.Winner_1;
  }
  
  public int getDate(){
    return this.Date;
  }
  
  public String getseconds(){
    return this.seconds;
  }
  
  
  
  
//setter methods
  public void setplayername( String playername){
  this.playername = playername;
  }
  
  public void setplayername2( String playername2){
  this.playername2 = playername2;
  }
  
  public void setplayername3( String playername3){
  this.playername3 = playername3;
  }
  
  public void setplayername4( String playername4){
  this.playername4 = playername4;
  }
  
  public void setplayername5( String playername5){
  this.playername5 = playername5;
  }
  
  public void setplayername6( String playername6){
  this.playername6 = playername6;
  }
  
  public void setplayername7( String playername7){
  this.playername7 = playername7;
  }
  
  public void setplayername8( String playername8){
  this.playername8 = playername8;
  }
  
  
  public void setWinner_1(String Winner_1){
  this.Winner_1 = Winner_1;
  }
  
  public void setDate(int Date){
  this.Date = Date;
  }
  
  public void setseconds(String seconds){
  this.seconds = seconds;
  }

}

