//ASSIGNMENT : Project 4
//DATE : 02/05/15
//FILE : PokerHands.java
//DESC : Reads five cards from the user, then analyzes the cards and prints out the category of hand that they represent.

import java.util.Scanner;

public class PokerHands{
    public static void main(String[] args){

//Create variables to hold user input
    int hand[] = new int[5];

    do{

//Prompt user for input and read
        getHand(hand);
        sort(hand);

//Call functions to determine hand type
        if(containsFourOfaKind(hand))
            System.out.println("Four of a kind!");

        else if(containsFullHouse(hand))
            System.out.println("Full House!");

        else if(containsStraight(hand))
            System.out.println("Straight!");

        else if(containsThreeOfaKind(hand))
            System.out.println("Three of a kind!");

        else if(containsTwoPair(hand))
            System.out.println("Two Pair!");

        else if(containsPair(hand))
            System.out.println("Pair!");

        else
            System.out.println("High Card!");

    }while(shouldPlayAgain());
}
    public static boolean containsPair(int hand[]){

//Numbers of matching cards to search for
        int target_cnt = 2;
        return count(hand, target_cnt);
    }

    public static boolean containsTwoPair(int hand[]){

//Numbers of matching cards to search for
        int target_cnt = 2;

//If at least one pair exists, search for second pair
        if(count(hand, target_cnt)){
            int pair_cnt = 0, i = 0;

            while(i != (hand.length - 1)){
                if(hand[i] == hand[i + 1]){
                    ++pair_cnt;
                    if(i != (hand.length - 2))
                        i += 2;
                    else
                        ++i;
                }
                else
                    ++i;
            }
            if(pair_cnt == 2)
                return true;
        }
        return false;
    }

    public static boolean containsThreeOfaKind(int hand[]){

//Numbers of matching cards to search for
        int target_cnt = 3;
        return count(hand, target_cnt);
    }

    public static boolean containsStraight(int hand[]){

        for(int i = 0; i != hand.length - 1; ++i){
            if(hand[i] != (hand[i + 1] - 1))
                return false;
        }
        return true;
    }

    public static boolean containsFullHouse(int hand[]){

//Numbers of matching cards to search for
        int target_cnt1 = 2, target_cnt2 = 3;
        return count(hand, target_cnt1) && count(hand, target_cnt2);
    }

    public static boolean containsFourOfaKind(int hand[]){

//Numbers of matching cards to search for
        int target_cnt = 4;
        return count(hand, target_cnt);
    }

    public static void sort(int hand[]){

        int smallest = 10, temp = 0, pos = 0;
        for(int i = 0, m; i != hand.length - 1; ++i){
            for(m = i; m != hand.length; ++m){
                if(hand[m] < smallest){
                    smallest = hand[m];
                    pos = m;
                }
            }
            if(smallest < hand[i]){
                temp = hand[i];
                hand[i] = smallest;
                hand[pos] = temp;
            }
            smallest = 10;
        }
    }

    public static boolean count(int hand[], int target_cnt){

//Create variables to track matches : val, matches array, match position
        int cnt = 1, val = hand[0], match_cnt = 0, matches[] = new int[5];

//Iterate through elements
        for(int i = 1; i != hand.length; ++i){
            if(val == hand[i])
                ++cnt;
            else{
                if(cnt > 1){
                    matches[match_cnt] = cnt;
                    ++match_cnt;
                    cnt = 1;
                }
                val = hand[i];
            }
        }
        if(cnt > 1){
            matches[match_cnt] = cnt;
            ++match_cnt;
            cnt = 1;
        }

        if(match_cnt > 0){
            for(int j = 0; j != matches.length; ++j){
                if(matches[j] == target_cnt)
                    return true;
            }
        }
        return false;
    }

    public static boolean shouldPlayAgain(){

        System.out.print("Continue? (y/n) : ");

        Scanner input = new Scanner(System.in);
        char choice = input.next().charAt(0);

        if(choice == 'y')
            return true;
        else
            return false;
    }

    public static void getHand(int hand[]){

        System.out.println("\nPlease enter " + hand.length + " integers between 2 - 9 inclusive for your hand.");

        Scanner input = new Scanner(System.in);

        for(int i = 0; i != hand.length; ++i){
            System.out.print("Card " + (i + 1) +": ");
            hand[i] = input.nextInt();
        }
    }
}
