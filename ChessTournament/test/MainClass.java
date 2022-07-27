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
import java.io.*;
import java.util.*;

public class MainClass {

    public static void main(String[] args){
        int length;
        Scanner input = new Scanner (System.in);
        //sets the length of players to 8
        length = 8;
        //Array List of playernames
        ArrayList<Players> playername = new ArrayList<Players>(length);

        //checks the number of inputs
        for (int counter = 0; counter < length; counter++) {
         System.out.println( "Enter Player name"+ (counter+1));
         //asks for input and sets a value in the array list
         //playername.set(counter,input.next());
        }
         //stops inputs when max number of values is reached
         input.close();
         
         String filename = "players.txt";

        File file = new File(filename);
        //must manage exceptions - done in this example using try catch
        try{
        //instantiate a Scanner object to read from the file object
        Scanner fileScan = new Scanner(file);

        while(fileScan.hasNextLine()){
        // store the next line in the ArrayList
       // fileData.add(fileScan.nextLine());
        }
        }catch(FileNotFoundException e){
        System.out.println(" File not found ");
        System.exit(1); //exit if file not found
        }

        //for(String eachName:fileData){
        //System.out.println(eachName);
}
}
}
    //
    }
    //
}

        
