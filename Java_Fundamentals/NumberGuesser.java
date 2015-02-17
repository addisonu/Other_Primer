//ASSIGNMENT : Project 3
//DATE : 02/02/15
//FILE : NumberGuesser.java
//DESC : A program that can figure out a number chosen by a human user. The human user will think of a number between 1 and 100. The program will make guesses and the user will tell the program to guess higher or lower.

import java.util.*;

public class NumberGuesser{
    public static void main(String[] args){
        do{
            playOneGame();
        }while(shouldPlayAgain());
    }

    public static void playOneGame(){
        char response = 'u';
        int midpoint = -1, high = 100, low = 1;

//Prompt user to guess a number
        System.out.println("Guess a number between 1 and 100.");

//Continue guessing until guess is correct
        do{
            midpoint = getMidpoint(low, high);
            response = getUserResponseToGuess(midpoint);

//Update high or low
            if(response == 'h'){
                low = midpoint + 1;
            }
            else if(response == 'l'){
                high = midpoint - 1;
            }
        }while(response != 'c' && midpoint != low && midpoint != high);
    }

    public static boolean shouldPlayAgain(){

//Prompt user to continue or quit game and read input
        Scanner input = new Scanner(System.in);
        char choice = 'n';

        System.out.print("Great! Do you want to continue playing the game? (y/n) : ");
        choice = input.next().charAt(0);

//Return result
        if(choice == 'y'){
            return true;
        }
        else{
            return false;
        }
    }

    public static char getUserResponseToGuess(int guess){

//Prompt user and read response
        Scanner input = new Scanner(System.in);
        char choice = 'n';

        System.out.print("Is is it " + guess + "?" +
        "\t(h/l/c) : ");
        choice = input.next().charAt(0);

        return choice;
    }

    public static int getMidpoint(int low, int high){
        return (high + low)/2;
    }
}
