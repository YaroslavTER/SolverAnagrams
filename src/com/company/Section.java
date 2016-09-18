package com.company;

import java.util.Vector;

/**
 * Created by pc on 6/28/2016.
 */
public class Section {
    private char letter;
    private Vector<String> words = new Vector<>();
    public Section(char letter){
        this.letter = letter;
    }

    public char get_letter(){
        return letter;
    }

    public void add_word(String word){
        words.add(word);
    }

    public int length(){
        return words.size();
    }

    public String get_word(int index){
        return words.elementAt(index);
    }
}
