//ASSIGNMENT : Programming project 1
//DATE : 09/06/15
//FILE : GuessingGameTester.java
//DESC : Test program for GuessingGame class

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class GuessingGameTester {
    public static void main(String args[]){
        String input;
        Scanner kb_input = new Scanner(System.in);
        do{
// Greet user, prompt for var to start game
            System.out.println("Welcome to the Guessing Game\nEnter the maximum number");
            GuessingGame game = new GuessingGame(kb_input.nextInt());
            System.out.println("Enter the number of guesses allowed:");
            game.set_maxGuessesAllowed(kb_input.nextInt());
            game.newGame(game.get_maxGuessesAllowed());
            System.out.println("answer = " + game.get_answer());

// Continue getting guess until user guesses correctly or other conditions are met
            while(!game.isGameOver()){
                System.out.println("Enter your guess, remember it must be between 0 and " + game.get_max());
                System.out.println(game.guess(kb_input.nextInt()));
            }
            System.out.print("Play again? (y/n): ");
            input = kb_input.next();
        }while(input.charAt(0) != 'n');
    }
}
