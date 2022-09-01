
package wordlegame;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class WordleModel {
    public boolean isGameOver;
    public String[][] Board;
    public int currRow;
    public int currCol;
    public String actualWord;
    public String currWord;
    public ArrayList<String> Words;
    public boolean InvalidWordFlag;
    public boolean ReadyTestWordFlag;
    public boolean CorrectWordFlag;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_GREY_BACKGROUND = "\u001B[100m";



    public WordleModel(boolean isGameOver, int currRow, int currCol, String actualWord, String currWord, ArrayList<String> Words, boolean InvalidWordFlag, boolean WrongWordFlag) {
        this.isGameOver = isGameOver;
        this.currRow = currRow;
        this.currCol = currCol;
        this.actualWord = actualWord;
        this.currWord = currWord;
        this.Words = Words;
        this.InvalidWordFlag = InvalidWordFlag;
        this.ReadyTestWordFlag = WrongWordFlag;
    }


    public boolean isIsGameOver() {
        return isGameOver;
    }

    public void setIsGameOver(boolean isGameOver) {
        this.isGameOver = isGameOver;
    }

    public String[][] getBoard() {
        return Board;
    }

    public void setBoard(String[][] Board) {
        this.Board = Board;
    }

    public int getCurrRow() {
        return currRow;
    }

    public void setCurrRow(int currRow) {
        this.currRow = currRow;
    }

    public int getCurrCol() {
        return currCol;
    }

    public void setCurrCol(int currCol) {
        this.currCol = currCol;
    }

    public String getActualWord() {
        return actualWord;
    }

    public void setActualWord(String actualWord) {
        this.actualWord = actualWord;
    }

    public String getCurrWord() {
        return currWord;
    }

    public void setCurrWord(String currWord) {
        this.currWord = currWord;
    }

    public ArrayList<String> getWords() {
        return Words;
    }

    public void setWords(ArrayList<String> Words) {
        this.Words = Words;
    }

    public boolean isInvalidWordFlag() {
        return InvalidWordFlag;
    }

    public void setInvalidWordFlag(boolean InvalidWordFlag) {
        this.InvalidWordFlag = InvalidWordFlag;
    }

    public boolean isWrongWordFlag() {
        return ReadyTestWordFlag;
    }

    public void setWrongWordFlag(boolean WrongWordFlag) {
        this.ReadyTestWordFlag = WrongWordFlag;
    }


    // print the alphabet with the associated colour for each letter
    public void displayAlphabet(List<Character> greenLetters, List<Character> yellowLetters, List<Character> greyLetters) {
        char letter;
        for (letter = 'a'; letter <= 'z'; ++letter) {
            if (greenLetters.contains(letter)) {
                System.out.print(ANSI_GREEN_BACKGROUND + letter + ANSI_RESET + " ");
            } else if (yellowLetters.contains(letter)) {
                System.out.print(ANSI_YELLOW_BACKGROUND + letter + ANSI_RESET + " ");
            } else if (greyLetters.contains(letter)) {
                System.out.print(ANSI_GREY_BACKGROUND + letter + ANSI_RESET + " ");
            } else {
                System.out.print(letter + " ");
            }
        }

    }



}
