/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tgumb
 * 
 * The Players class, is here to make a player object from each player which is entered
 * from the MainGame class, this players class saves data like the contestant which is the players name, 
 * it saves, position which is the players placement e.g 1st,2nd,3rd or 8th. and winner which can either be set as 
 * true or false, So if position is 1st then winner boolean will be set to true. Each player object is saved in the contestant
 * array list found in MainGame class.
 * 
 * 
 */

public class Players implements java.io.Serializable {

  //INSTANCE VARIABLE
  private String contestant;
  private int position;
  private boolean winner;


 //Constructor that takes arguments
  public Players (String contestant, int position, boolean winner){
        this.contestant  = contestant;
        this.position = position;
        this.winner = winner;
      }
  
    //getter methods
      public boolean getwinner(){
        return this.winner;
      }

      public String getcontestant(){
        return this.contestant;
      }

      public int getposition(){
        return this.position;
      }


    //setter methods
      public void setcontestant( String contestant){
      this.contestant = contestant;
      }

      public void setplayername2( boolean winner){
      this.winner = winner;
      }

      public void setposition(int position){
      this.position = position;
      }

}

        
