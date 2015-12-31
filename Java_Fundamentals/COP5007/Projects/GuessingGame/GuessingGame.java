//ASSIGNMENT : Programming project 1
//DATE : 09/06/15
//FILE : GuessingGame.java
//DESC : Class for a program that plays a number guessing game

import java.io.*;
import java.util.Random;

public class GuessingGame {

// CONSTRUCTORS //
    public GuessingGame() {
        set_max(0);
        generator = new Random();
    }

    public GuessingGame(int max_arg) {
        set_max(max_arg);
        generator = new Random();
    }

// METHODS //
    public void set_answer(){
        answer = generator.nextInt(max + 1);
    }

    public int get_answer(){
        return answer;
    }

    public void set_gameOver(boolean gameOver_arg){
        gameOver = gameOver_arg;
    }

    public boolean get_gameOver(){
        return gameOver;
    }

    public void set_differential(int differential_arg){
        differential = differential_arg;
    }

    public int get_differential(){
        return differential;
    }

    public void set_max(int max_arg){
        max = max_arg;
    }

    public int get_max(){
        return max;
    }

    public void set_maxGuessesAllowed(int maxGuessesAllowed_arg){
        maxGuessesAllowed = maxGuessesAllowed_arg;
    }

    public int get_maxGuessesAllowed(){
        return maxGuessesAllowed;
    }

    public void set_numGuessesTaken(int numGuessesTaken_arg){
        numGuessesTaken = numGuessesTaken_arg;
    }

    public int get_numGuessesTaken(){
        return numGuessesTaken;
    }

    public void newGame(int max_guesses) {
        set_maxGuessesAllowed(max_guesses);
        set_answer();
        set_gameOver(false);
        set_differential(max);
        set_numGuessesTaken(0);
    }

    public String guess(int guess_arg) {
        String result = "";
        if(numGuessesTaken >= maxGuessesAllowed){
            set_gameOver(true);
            return "Too many guesses.";
        }
        else{
            set_numGuessesTaken(++numGuessesTaken);
            if(guess_arg >= 0 && guess_arg <= max){
                if(answer == guess_arg){
                    set_gameOver(true);
                    return "Congratulations";
                }
                else if(answer > guess_arg){
                    result = "To Low\n" + ((answer - guess_arg) < differential ? "Getting warmer" : "Getting colder");
                }
                else if(answer < guess_arg){
                    result = "Too High\n" + ((guess_arg - answer) < differential ? "Getting warmer" : "Getting colder");
                }
            }
            else {
                return "Guess out of range, the guess must be between 0 and 50.";
            }
        }
                set_differential(Math.abs(guess_arg - answer));
                return result;
    }

    public boolean isGameOver() {
        return gameOver;
    }

// INSTANCE VARIABLES //
    private int answer;
    private Random generator;
    boolean gameOver;
    int differential;
    int max;
    int maxGuessesAllowed;
    int numGuessesTaken;
}
