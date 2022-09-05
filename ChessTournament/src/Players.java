/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tgumb
 */
public class Players implements java.io.Serializable {
//INTANCE VERIABLE
  private String playername;
  private String playername2;
  private String playername3;
  private String playername4;
  private String playername5;
  private String playername6;
  private String playername7;
  private String playername8;
  private String movestillwin;
  private String duration;

 //Constructor that takes arguments
  public Players (String playername,String playername2,String playername3,String playername4,String playername5,String playername6,String playername7,String playername8,String movestillwin,String duration){
    this.playername = playername;
    this.playername2 = playername2;
    this.playername3 = playername3;
    this.playername4 = playername4;
    this.playername5 = playername5;
    this.playername6 = playername6;
    this.playername7 = playername7;
    this.playername8 = playername8;
    this.movestillwin = movestillwin;
    this.duration = duration;
  }
//getter
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
  
  public String getmovestillwin(){
    return this.movestillwin;
  }
  
  public String getduration(){
    return this.duration;
  }
//setter
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
  
  public void setmovestillwin(String movestillwin){
  this.movestillwin = movestillwin;
  }
  
  public void setduration(String duration){
  this.duration = duration;
  }
}

