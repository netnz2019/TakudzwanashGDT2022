/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tgumb
 */
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

public static void main(String[] args){
    int length;
    Scanner input = new Scanner (System.in) ;
    System.out.println( "How many players are playing today");
    length = input.nextInt();

    String[] names = new String[length];

    for (int counter = 0; counter < length; counter++) {
     System.out.println( "Enter Player name"+ (counter+1)) ;
     names [ counter] = input.next();
    }
     input.close() ;

     System.out.println("Your friends are");
    for(int counter = 0; counter < length; counter++){
    System.out.println(names[counter]);
    }
}

}

        
