package org.example;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Game game=new Game("src\\main\\resources\\word.txt");
        Scanner sc=new Scanner(System.in);

        Set<String> usedLetters=new TreeSet<>();

        System.out.println("In game: "+ game.getAnountWords()+" words!");
        System.out.println("[N]ew game or [E]xit");

        while (true){

            String in =sc.nextLine();
            String randomWord= game.getRandomWord();
            if (in.equals("N") || in.equals("n")){
                System.out.println("Ok, Lets play");
                Prints state = Prints.ZERO;

                int count=0;
                while (count!=7){

                    System.out.println(state);
                    System.out.println("Current state of the word: " + game.getGuessedWord());
                    if(game.getGuessedWord().equals(randomWord)){
                        System.out.println("------------------------------");
                        System.out.println("Congratulations YOU ARE WIN!!!");
                        System.out.println("------------------------------");
                        System.out.println("[N]ew game or [E]xit");
                        usedLetters.clear();
                        break;
                    }
                    if(count==6){
                        System.out.println("----------------------------------------------------------");
                        System.out.println("You lost, it was: "+randomWord.toLowerCase()+ ", try again");
                        System.out.println("----------------------------------------------------------");
                        System.out.println("[N]ew game or [E]xit");
                        usedLetters.clear();
                        break;
                    }
                    System.out.println("Used letters: " + String.join(", ", usedLetters));
                    System.out.print("Enter letter: ");
                    char letter= sc.nextLine().charAt(0);

                    if(game.guesLetter(letter,randomWord)){
                        System.out.println("Letter " + letter + " is find!");

                    }
                    else {
                        if (usedLetters.contains(Character.toString(letter))){
                            continue;
                        }
                        count++;
                        state =game.getCountOfMistakes(count);

                    }
                    usedLetters.add(Character.toString(letter));

                }

            } else if (in.equals("E") || in.equals("e")) {
                System.out.println("Bye-Bye");
                break;
            }
            else {
                System.out.println("I am don't understand you, lease repeat");
                System.out.println("[N]ew game or [E]xit");

            }
        }
    }
}