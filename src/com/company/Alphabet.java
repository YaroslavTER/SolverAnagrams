package com.company;

import java.util.Vector;

/**
 * Created by pc on 6/28/2016.
 */
public class Alphabet {
    private Vector<Section> alphabet = new Vector<>();
    public Alphabet(){

    }

    public Section get_section(int index){
        return alphabet.elementAt(index);
    }

    public int length(){
        return alphabet.size();
    }

    public void add_section(char letter){
        alphabet.add(new Section(letter));
    }

    public void add_word(int index, String word){
        alphabet.elementAt(index).add_word(word);
    }

    public int get_index(char input_letter){
        int left = 0, right = alphabet.size() - 1, middle = (right-left)/2, rememb_index = -1;
        String letter = "" + input_letter;
        for(int index = 0; index < alphabet.size(); index++){
            String compare_letter = "" + alphabet.elementAt(index).get_letter();
            if(letter.compareTo(compare_letter) < 0) {
                left = middle;
                middle = (right-left)/2;
            } else if(letter.compareTo(compare_letter) > 0) {
                right = middle;
                middle = (right-left)/2;
            } else if(letter.compareTo(compare_letter) == 0)
                rememb_index = index;
        }
        return rememb_index;
    }

    public boolean is_it_from_alphabet(String word){
        boolean result = false;
        String check_word = "";
        int left = 0, right = alphabet.elementAt(get_index(word.charAt(0))).length() - 1, middle = (right-left)/2;
        for(int index = 0; index < alphabet.elementAt(get_index(word.charAt(0))).length(); index++) {
            check_word = alphabet.elementAt(get_index(word.charAt(0))).get_word(index);
            if(word.compareTo(check_word) < 0)
                left = middle;
            else if(word.compareTo(check_word) > 0)
                right = middle;
            else if(word.compareTo(check_word) == 0)
                result = true;
            middle = (right-left)/2;
        }
        return result;
    }
}
