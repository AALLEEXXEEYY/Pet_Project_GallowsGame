package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Game {

    private List<String> words;
    private StringBuilder guessedWord;

    public Game(String filename) {
        words=new ArrayList<>();

        try(BufferedReader bufferedReader=new BufferedReader(new FileReader(filename))){

            String word;
            while ((word =bufferedReader.readLine())!=null){
                words.add(word.toLowerCase());
            }

        }
        catch (IOException e){
            System.out.println("Error reading file:"+ e.getMessage());

        }
    }

    public int getAnountWords(){
        return words.size();
    }

    public String getRandomWord(){
        Random random=new Random();
        String word =words.get(random.nextInt(words.size()));
        guessedWord = new StringBuilder(word.length());
        for (int i = 0; i < word.length(); i++) {
            guessedWord.append("*");
        }
        return word;
    }

    public String getGuessedWord() {
        return guessedWord.toString();
    }
    public boolean guesLetter(Character letter,String word){
        boolean found =false;
        int countOfwords=0;
        for(int i=0;i<word.length();i++){
            char lowercaseCh = Character.toLowerCase(letter);
            if(word.charAt(i)==lowercaseCh){
                guessedWord.setCharAt(i,lowercaseCh);
                countOfwords++;
            }
        }
        if(countOfwords>0){
            return true;
        }
        return found;
    }


    public Prints getCountOfMistakes(int count){
        Prints state = Prints.ZERO;

        if (count==1){
            System.out.println("-------------------");
            System.out.println("Five attempts left");
            System.out.println("-------------------");
            state=Prints.ONE;

        }
        if (count==2){
            System.out.println("-------------------");
            System.out.println("Four attempts left");
            System.out.println("-------------------");
            state=Prints.TWO;

        }
        if (count==3){
            System.out.println("-------------------");
            System.out.println("Three attempts left");
            System.out.println("-------------------");
            state=Prints.THREE;

        }
        if (count==4){
            System.out.println("-------------------");
            System.out.println("Two attempts left");
            System.out.println("-------------------");
            state=Prints.FOUR;

        }
        if (count==5){
            System.out.println("-------------------");
            System.out.println("One try left");
            System.out.println("-------------------");
            state=Prints.FIVE;

        }
        if (count==6){
            state=Prints.SIX;

        }

        return state;
    }

}
