/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tgumb
 */
import java.util.Scanner;
import java.io.*;

public class Players implements java.io.Serializable {

    //INTANCE VERIABLE
  private String contestant;
  private int position;
  private boolean winner;


 //Constructor that takes arguments
  public Players (String contestant, int position, boolean winner){
        this.contestant  = contestant;
        this.position = position;
        this.winner = winner;
      }
  
    //getter
      public boolean getwinner(){
        return this.winner;
      }

      public String getcontestant(){
        return this.contestant;
      }

      public int getposition(){
        return this.position;
      }


    //setter
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

        
