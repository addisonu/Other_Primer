//ASSIGNMENT : Project 12
//DATE : 04/12/15
//FILE : RandomNumberGuesser.java
//DESC : Subclass of the NumberGuesser class that should return a randomly generated number in the range of possible values

import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class RandomNumberGuesser extends NumberGuesser{
    public static void main(String args[]){

// Play game until user quits
        char choice = 'n';
        do{

// Get upper and lower bounds from user
            Scanner input = new Scanner(System.in);

            System.out.println("Think of a number between 1 and 100");
            int rng_high = 100;
            int rng_low = 1;

            RandomNumberGuesser game = new RandomNumberGuesser(rng_low, rng_high);

// Continue guessing while user response isn't 'c'
                while(choice != 'c'){
                    if(game.getHigh() > game.getLow() || (game.getHigh() == game.getLow() && game.getUpdate())){
                        System.out.print("Is the number " + game.getCurrentGuess() + "? (h/l/c) : ");
                        choice = input.next().charAt(0);
                    }
                    else
                        choice = 'c';

// Prompt user for hint and print outome or continue guessing
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
                System.out.println();
        }while(choice == 'y');
    }

// DATA MEMBERS //
    private Random rndpoint;
    private int lastGuess;
    private boolean update;

    public RandomNumberGuesser(int lowerBound, int upperBound)
    {
        super(lowerBound, upperBound);
        rndpoint = new Random(System.currentTimeMillis());;
        update = true;
    }

    public void higher()
    {
        if(getLow() < getHigh()){
            setLow(lastGuess + 1);
            update = true;
        }
    }

    public void lower()
    {
        if(getLow() < getHigh()){
            setHigh(lastGuess - 1);
            update = true;
        }
    }

    public int getCurrentGuess()
    {
        if(update && (getHigh() - getLow()) > 0){
            lastGuess = rndpoint.nextInt(getHigh() - getLow()) + getLow();
            update = false;
            return lastGuess;
        }
        else if(getHigh() == getLow()){
            update = false;
            return getHigh();
        }

        else
            return lastGuess;
    }

    public boolean getUpdate()
    {
        return update;
    }
}
