/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wordlegame;

import java.awt.List;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class WordleApp {
    public static void main(String[] args) {
        try{
            ArrayList<String> CommonWords = new ArrayList<>();  // Array list to store words.
            int i = 0;
            File myObj = new File("common1.txt");           //Read words from test file
            Scanner myReader = new Scanner(myObj);        // Scanner object to scan the input file.
            while (myReader.hasNextLine()) {              // While loop till the end of text file.
              String data = myReader.nextLine();          // Read each line from text file one by one.
              CommonWords.add(data.toLowerCase().trim());       // Add words one-by-one in the array list.
            }
            myReader.close();
            
            ArrayList<String> Words = new ArrayList<>();
            myObj = new File("words1.txt");           //Read words from test file
            myReader = new Scanner(myObj);        // Scanner object to scan the input file.
            while (myReader.hasNextLine()) {              // While loop till the end of text file.
              String data = myReader.nextLine();          // Read each line from text file one by one.
              Words.add(data.toLowerCase().trim());       // Add words one-by-one in the array list.
            }
            myReader.close();
            
            Random rand = new Random();                   //Create instance of random to get random number form the list.    
            int upperbound = CommonWords.size()-1;              // set the upperlimit for the random number to be generated.
            int int_random = rand.nextInt(upperbound);    // Generate random number.
            String actualWord =CommonWords.get(int_random);     // Get word form the list.
            System.out.println("Your have total 6 attempts to predict the word"); 
                System.err.println(actualWord);   // actual word uncomment the line if want to keep track.

            WordleModel m = new WordleModel(false,0,0,actualWord,"",Words,false,false);  //Initialize model.
            WordleView v = new WordleView(); //Create instance of View.
            WordleController c = new WordleController(m, v); //Create instance of controller.
            c.initController(); //Initialize controller.
            System.out.println(actualWord);
            System.out.println();
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        // Assemble all the pieces of the MVC
        
       }
    
}
