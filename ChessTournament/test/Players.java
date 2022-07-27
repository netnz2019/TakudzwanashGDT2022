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
  private int movestillwin;
  private int duration;

 //Constructor that takes arguments
  public Players (String playername,int movestillwin,int duration){
    this.playername = playername;
    this.movestillwin = movestillwin;
    this.duration = duration;
  }
//getter
  public String getPlayername(){
    return this.playername;
  }
  
  public int getmovestillwin(){
    return this.movestillwin;
  }
  
  public int getduration(){
    return this.duration;
  }
//setter
  public void setplayername(String playername){
  this.playername = playername;
  }
  
  public void setmovestillwin(int movestillwin){
  this.movestillwin = movestillwin;
  }
  
  public void setduration(int duration){
  this.duration = duration;
  }
  
}

