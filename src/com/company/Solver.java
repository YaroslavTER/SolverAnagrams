package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by pc on 6/27/2016.
 */
public class Solver {
    private Alphabet alphabet = new Alphabet();
    public Solver() throws IOException {
        read_file("C:\\Users\\pc\\IdeaProjects\\SolverAnagrams\\src\\com\\company\\words.txt");
    }

    public  void read_file(String filename) throws IOException {
        FileReader reader = new FileReader(filename);
        BufferedReader buffer = new BufferedReader(reader);
        String line = buffer.readLine();
        char letter = ' ';
        while(line != null){
            if(line.length() > 0) {
                if (letter != line.charAt(0)) {
                    letter = line.charAt(0);
                    alphabet.add_section(letter);
                }
                if (letter == line.charAt(0))
                    alphabet.add_word(alphabet.get_index(letter), line);
            }
            line = buffer.readLine();

        }
    }

    private  void permutations(int number, String line){
        if(number == 1) {
            if(alphabet.is_it_from_alphabet(line))
                System.out.println(line);
        } else {
            for(int index = 0; index < number; index++){
                line = swap(line, index, number - 1);
                permutations(number - 1, line);
                line = swap(line, index, number - 1);
            }
        }
    }

    public  void solve() throws IOException {
        String  line;
        System.out.print("Write anagram: ");
        Scanner scanner = new Scanner(System.in);
        line = scanner.nextLine();
        System.out.println("Think...");
        permutations(line.length(), line);
    }

    private  String swap(String line, int first_index, int second_index){
        String new_line = "";
        for(int index = 0; index < line.length(); index++){
            if(index == first_index)
                new_line += line.charAt(second_index);
            else if(index == second_index)
                new_line += line.charAt(first_index);
            else
                new_line += line.charAt(index);
        }
        return new_line;
    }
}
