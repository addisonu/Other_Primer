//ASSIGNMENT : Project 7
//DATE : 02/26/15
//FILE : GuessingProgram.java
//DESC : Use NumberGuesser class to implement number guessing game

import java.util.Scanner;
import java.io.*;

public class GuessingProgram{
    public static void main(String args[])
    {
//Play game until user quits
        char choice = 'n';
        do{

//Get upper and lower bounds from user
            Scanner input = new Scanner(System.in);
            int rng_low = -1, rng_high = -1;

            System.out.println("Think of a number between 1 and 100");
            rng_high = 100;
            rng_low = 1;

            NumberGuesser game = new NumberGuesser(rng_low, rng_high);

//Continue guessing while user response isn't 'c'
                while(choice != 'c'){
                    System.out.print("Is the number " + game.getCurrentGuess() + "? (h/l/c) : ");
                    choice = input.next().charAt(0);
                    if(choice == 'h')
                        game.higher();
                    else if(choice == 'l')
                        game.lower();
                    else if(choice == 'c'){
                        System.out.println("You picked " + game.getCurrentGuess() + "? Great choice.");
                        game.reset();
                    }
                }
//Ask if user would like to continue game
                System.out.print("Do you want to play again? (y/n) : ");
                choice = input.next().charAt(0);
        }while(choice == 'y');
    }
}
