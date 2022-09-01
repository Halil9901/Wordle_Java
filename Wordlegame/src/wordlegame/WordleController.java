/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wordlegame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.function.Consumer;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author fahad.amin
 */
public class WordleController {
    private WordleModel model;
    private WordleView view;

    public WordleController(WordleModel model, WordleView view) {
        this.model = model;
        this.view = view;
        initView();
    }

    private void initView() {
    }
    public void initController() {
        //Add event listner to all the alphabets.
        view.getAlpha('a').addActionListener(e -> AlphabetClicked(e));
        view.getAlpha('b').addActionListener(e -> AlphabetClicked(e));
        view.getAlpha('c').addActionListener(e -> AlphabetClicked(e));
        view.getAlpha('d').addActionListener(e -> AlphabetClicked(e));
        view.getAlpha('e').addActionListener(e -> AlphabetClicked(e));
        view.getAlpha('f').addActionListener(e -> AlphabetClicked(e));
        view.getAlpha('g').addActionListener(e -> AlphabetClicked(e));
        view.getAlpha('h').addActionListener(e -> AlphabetClicked(e));
        view.getAlpha('i').addActionListener(e -> AlphabetClicked(e));
        view.getAlpha('j').addActionListener(e -> AlphabetClicked(e));
        view.getAlpha('k').addActionListener(e -> AlphabetClicked(e));
        view.getAlpha('l').addActionListener(e -> AlphabetClicked(e));
        view.getAlpha('m').addActionListener(e -> AlphabetClicked(e));
        view.getAlpha('n').addActionListener(e -> AlphabetClicked(e));
        view.getAlpha('o').addActionListener(e -> AlphabetClicked(e));
        view.getAlpha('p').addActionListener(e -> AlphabetClicked(e));
        view.getAlpha('q').addActionListener(e -> AlphabetClicked(e));
        view.getAlpha('r').addActionListener(e -> AlphabetClicked(e));
        view.getAlpha('s').addActionListener(e -> AlphabetClicked(e));
        view.getAlpha('t').addActionListener(e -> AlphabetClicked(e));
        view.getAlpha('u').addActionListener(e -> AlphabetClicked(e));
        view.getAlpha('v').addActionListener(e -> AlphabetClicked(e));
        view.getAlpha('w').addActionListener(e -> AlphabetClicked(e));
        view.getAlpha('x').addActionListener(e -> AlphabetClicked(e));
        view.getAlpha('y').addActionListener(e -> AlphabetClicked(e));
        view.getAlpha('z').addActionListener(e -> AlphabetClicked(e));
        
        //Add evenet listener to Enter and clear key.
        view.getEnter().addActionListener(e -> EnterClicked(e));
        view.getClear().addActionListener(e -> ClearClicked(e));
        //Populate view.
        view.show();
    }
    //Function to handle if alphabet is pressed and update the board accordingly.
    private void AlphabetClicked(ActionEvent e) {
        if(model.currCol<5){
            view.getLabel(model.currRow, model.currCol).setText(e.getActionCommand());
            model.currWord+=e.getActionCommand();
            model.currCol++;
        }
    }
    
    private void EnterClicked(ActionEvent e) {  //Enter button presses key handler.
        if(model.currWord.length()<5){          //Check the length of the word.
            model.InvalidWordFlag = true;
            model.ReadyTestWordFlag=false;
        }
        else if(model.Words.contains(model.currWord.toLowerCase())){ //Check if word is in the list or not.
            model.ReadyTestWordFlag=true;
            model.InvalidWordFlag=false;
        }
        else{
            model.InvalidWordFlag = true;
            model.ReadyTestWordFlag=false;
        }
        CheckBoard();
    }

    private void ClearClicked(ActionEvent e) { //Clear button clicked event will clear the indexes of curr row one by one.
        if(model.currCol>0){
            model.currCol--;
            view.getLabel(model.currRow, model.currCol).setText("");
            model.currWord = model.currWord.substring(0, model.currCol);
        }
    }
    private void CheckBoard(){
        if(model.InvalidWordFlag && model.currWord.length()<5){
            JOptionPane.showMessageDialog(null, "InComplete Word"); 
        }
        else if(model.ReadyTestWordFlag){
            ArrayList<Indexes> indexes = new ArrayList<>();          //List to store the value of each index with theie color.
            for(int i=0;i<model.currWord.length();i++){              //Traverse over the word to compare with actual word.
                if(model.currWord.toLowerCase().toCharArray()[i] == model.actualWord.toLowerCase().toCharArray()[i]){ //if character map on the same index with actual word
                    indexes.add(new Indexes(i,new Color(121, 184, 81))); //add index and color (Green) in the list 
                }
                else if(model.actualWord.toLowerCase().contains(Character.toString(model.currWord.toLowerCase().toCharArray()[i]))){ //if character is in the actual word but not at same index.
                    indexes.add(new Indexes(i,new Color(243, 194, 55))); //add index and color (yellow) in the list 
                }
                else{
                    indexes.add(new Indexes(i,new Color(164, 174, 196))); //add index and color (grey) in the list 
                }
            }
            for (int i = 0; i < indexes.size(); i++) { //loop to change ForeGround and BackGround Colors of board and key board.
                view.getLabel(model.currRow,indexes.get(i).index).setBackground(indexes.get(i).color);
                view.getLabel(model.currRow,indexes.get(i).index).setForeground(Color.WHITE);
                view.getAlpha(view.getLabel(model.currRow,indexes.get(i).index).getText().toCharArray()[0]).setBackground(indexes.get(i).color);
                view.getAlpha(view.getLabel(model.currRow,indexes.get(i).index).getText().toCharArray()[0]).setForeground(Color.WHITE);
            }
            model.currRow++;   //increament row every word.
            model.currCol=0;
            model.currWord="";  //restore currWord to empty.
            if(model.currRow==6){
                model.isGameOver=true;
                JOptionPane.showMessageDialog(null, "Game Over! Actual Word is: "+model.actualWord);
                System.exit(0);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Invalid Word");
        }
    }
    
}
