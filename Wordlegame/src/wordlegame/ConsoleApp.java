
package wordlegame;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleApp {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";
    public static List<Character> greenLetters = new ArrayList<>();
    public static List<Character> yellowLetters = new ArrayList<>();
    public static List<Character> greyLetters = new ArrayList<>();
    public static void main(String[] args) {
            try{
                ArrayList<String> CommonWords = new ArrayList<>();  // Array list to store words.
                int i = 0;
                File myObj = new File("common1.txt");           //Read words from ccommon file
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



                for (int v=0;v<2;v++) {
                    System.out.println(" ");
                }
                System.out.println("____________________________________________________________________________________");
                System.out.println("G - Green, this means you have guessed the right letter in the right location");
                System.out.println("Y - Yellow, this means you have guessed the right letter but in the wrong location");
                System.out.println("R - Red, this means you have guessed the wrong letter");
                System.out.println("____________________________________________________________________________________");
                System.out.println("You have a total of 6 attempts to predict the word");
                //System.out.println(" ");
                System.out.println(CYAN_BOLD_BRIGHT +"Correct word is: "+actualWord+ ANSI_RESET);   // actual word uncomment the line if want to keep track.
                WordleModel model = new WordleModel(false,0,0,actualWord,"",Words,false,false);  //Initialize model.
                Scanner myInpObj = new Scanner(System.in);     // Another scanner object to scan input from user.
                for(int j=0;j<6;j++){                          //Loop will exceute 6 times.

                    int attemptCount = j+1;
                    System.out.println(" ");
                    System.out.println("Attempt: " + attemptCount);
                    System.out.println("Please Enter a 5 character word: ");


                    model.currWord = myInpObj.nextLine();      //Input from the user

                    if(model.currWord.length()>5 || model.currWord.length()<5){     //Check length of word typed.
                        j = j-1;
                        model.InvalidWordFlag=true;
                        model.ReadyTestWordFlag=false;
                        System.err.println("Please enter a word with 5 characters.");
                    }
                    else if(model.Words.contains(model.currWord)){         //Check if word is in the list or not.

                        model.ReadyTestWordFlag=true;
                        model.InvalidWordFlag=false;
                        String hint="";
                        for(int k=0;k<model.currWord.length();k++){        // loop to traverse over the word.
                            ArrayList<Indexes> indexes = new ArrayList<>();
                            if(model.currWord.toLowerCase().toCharArray()[k] == model.actualWord.toLowerCase().toCharArray()[k]){  //Verify if word is at the actual postion or not.
                                hint+="G ";
                                //indexes.add(new Indexes(i,new Color(121, 184, 81)));
                                greenLetters.add(model.currWord.toLowerCase().toCharArray()[k]);
                                //System.out.println(model.currWord.toLowerCase().toCharArray()[k]);
                                //System.out.println(greenLetters.size());
                            }
                            else if(model.actualWord.contains(Character.toString(model.currWord.toLowerCase().toCharArray()[k]))){
                                hint+="Y ";
                                //indexes.add(new Indexes(i,new Color(243, 194, 55)));
                                yellowLetters.add(model.currWord.toLowerCase().toCharArray()[k]);
                                //System.out.println(model.currWord.toLowerCase().toCharArray()[k]);
                                //System.out.println(yellowLetters.size());
                            }
                            else{
                                hint+="- ";
                                //indexes.add(new Indexes(i,new Color(164, 174, 196)));
                                greyLetters.add(model.currWord.toLowerCase().toCharArray()[k]);
                            }

                        }

                        model.displayAlphabet(greenLetters, yellowLetters, greyLetters);
                        System.out.println(" ");

                        if(model.currWord.equals(model.actualWord)){ //if word entered equals to actual word.
                            model.isGameOver=true;
                            System.out.println("You won.");
                            System.exit(0);
                        }
                        else
                            System.out.println(hint);
                    }
                    else{
                        j=j-1;
                        model.InvalidWordFlag=true;
                        model.ReadyTestWordFlag=false;
                        System.err.println("InValid Word.");
                    }


                }
                System.err.println("You Lost.");
            }
            catch(Exception ex){

            }
       }
}
