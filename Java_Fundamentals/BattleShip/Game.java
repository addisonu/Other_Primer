//ASSIGNMENT : Project 15
//DATE : 05/18/15
//FILE : Game.java
//DESC : Plays Battleship game

import java.util.*;

public class Game{
    public static void main(String args[]) throws IllegalStateException {

// Initialize battleship
            Board game = new Board();
            Scanner input = new Scanner(System.in);
            int x = 0, y = 0;
        do{
            game.display();
            try{
                System.out.println("Enter the shot coordinates : ");
                x = input.nextInt();
                y = input.nextInt();

// Check coordinate is valid
                if((x < 0 || x >= game.SEA_MILES) || (y < 0 || y >= game.SEA_MILES))
                    throw new IllegalStateException("The coordinate you entered is beyond the battle region.");

                Point p = new Point(x, y);
                game.fireShot(p);
            }
            catch(IllegalStateException e){
                System.out.println(e.getMessage());
            }
        }while(!game.gameOver());
        System.out.println("You've vaporized the enemy fleet. Good game El Capitan.");
    }
}
