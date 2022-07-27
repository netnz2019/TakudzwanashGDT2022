/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tgumb
 */
public class Players {
//INTANCE VERIABLE
  private String playername;
  private String movestillwin;
  private String duration;

 //Constructor that takes arguments
  public Players (String playername,String movestillwin,String duration){
    this.playername = playername;
    this.movestillwin = movestillwin;
    this.duration = duration;
  }
//getter
  public String getPlayername(){
    return this.playername;
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
  
  public void setmovestillwin(String movestillwin){
  this.movestillwin = movestillwin;
  }
  
  public void setduration(String duration){
  this.duration = duration;
  }
  
}

