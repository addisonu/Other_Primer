//ASSIGNMENT : Project 2
//DATE : 01/25/15
//DESC : Allows user to play black jack game against dealer until they quit
//FILE : BlackJack.java

import java.util.*;

public class BlackjackGame{
    public static void main(String argv[]){

        Random deal;
        int cardd1 = 0, dtotal = 0, card1 = 0, card2 = 0, total = 0;
        char choice = 'n';
        Scanner input = new Scanner(System.in);

//User can play until they quit
do {

//Deal to dealer, user, and print two cards
        deal = new Random();
        cardd1 = deal.nextInt(11);
        dtotal += cardd1;
        System.out.println("The dealer starts with a " + cardd1);
        card1 = deal.nextInt(11);
        card2 = deal.nextInt(11);
        total += card1 + card2;
        System.out.println("First cards : " + card1 + ", " + card2);

//Print card total
        System.out.println("Total : " + total);

//User can be dealt cards until they stop or bust
        do {

//Ask user if they want another card
        System.out.print("Hit? (y/n) : ");
        choice = input.next().charAt(0);

//If yes, deal, print card, print total
        if(choice == 'y'){
            card1 = deal.nextInt(11);
            total += card1;
            System.out.println("Card : " + card1);
            System.out.println("Total : " + total);

//If card total > 21, print bust, and exit loop
            if(total > 21){
                System.out.println("Bust. Dealer wins...");
                choice = 'n';
            }
            else if(total == 21){
                System.out.println("You win!!");
                choice = 'n';
            }
        }
//If no, exit loop
            else{
                choice = 'n';
            }
        }while(choice == 'y');
        System.out.println("Dealer has a " + cardd1 + "...");

//Dealer must draw cards until their total >= 17
        while(dtotal < 17 && total < 21){
            System.out.print("c to continue : ");
            choice = input.next().charAt(0);
            cardd1 = deal.nextInt(11);
            dtotal += cardd1;
            System.out.println("Dealer gets a " + cardd1);
            System.out.println("Dealer Total : " + dtotal);
            if(dtotal == 21)
                System.out.println("Dealer Wins!!");
            else if(dtotal > 21)
                System.out.println("Dealer Busts!! You win :)");
        }

//Outcome
//Closest player to 21 wins
    if(total < 21 && dtotal < 21){
        if(total > dtotal)
            System.out.println("You win!!");
        else if(total == dtotal)
            System.out.println("Push.");
        else
            System.out.println("You lose!! Dealer wins :D");
    }
//Reset total
        total = dtotal = 0;

//Prompt user to continue/quit game
        System.out.print("Do you want to continue the game? (y/n) : ");
        choice = input.next().charAt(0);
    System.out.println();
    }while(choice == 'y');
}
}
