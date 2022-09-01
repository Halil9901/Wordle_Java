package test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import wordlegame.WordleModel;

import java.util.List;

import static org.junit.Assert.*;

public class ModelTest {
    private static WordleModel model;
    private static String actualWord;




    @Test
    public void RandomActualWordTest() {
        String word = model.getActualWord();

        //This test check if the word returned is a random word from the common.txt

        //Check to confirm that the word is not null i.e the method returns something.
        System.out.println(word);
        assertNotNull(word);
    }

    @Test
    public void IsGameOverTest(){
        Boolean IsgameOver = model.isGameOver;
        //this test checks if the game is over when playing. if test fails then there is something crutially wrong in
        // the program.

        assertFalse(IsgameOver == false);
    }

    @Test
    public void DisplayAlphabetTest() {


    }






}
