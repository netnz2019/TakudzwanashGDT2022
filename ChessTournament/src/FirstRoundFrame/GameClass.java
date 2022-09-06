package FirstRoundFrame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tkgumbo
 */
public class GameClass {
    
    public static void main(String[]args){
    // there must be a file of this name saved in the same directory as the class

    String filename = "players.ser";
    //make a File object
    File file = new File(filename);
    //must manage exceptions - done in this example using try catch

    try{
    //instantiate a Scanner object to read from the file object
    Scanner fileScan = new Scanner(file);
    //while there is another line yet to be read
    while(fileScan.hasNextLine()){
    // display the next line

    System.out.println(fileScan.nextLine());
    }
    }

    catch(FileNotFoundException e){
    System.out.println(" File not found ");
    System.exit(1); //exit from program if file not found
}
}
}

