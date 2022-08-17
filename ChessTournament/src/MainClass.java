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

public class MainClass {

    public static void main(String[] args){
         
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
}
}

        
