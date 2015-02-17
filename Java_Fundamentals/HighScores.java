//ASSIGNMENT : Project 5
//DATE : 02/12/15
//FILE : HighScore.java
//DESC : Program that records high-score data for a fictitious game. The program will ask the user to enter five names, and five scores. It will store the data in memory, and print it back out sorted by score.

import java.util.ArrayList;
import java.util.Scanner;

public class HighScores{
    public static void main(String args[]){

//ArrayLists names and scores to hold input
        ArrayList<String> names = new ArrayList<String>(5);
        ArrayList<Integer> scores = new ArrayList<Integer>(5);

//Get user input
        initialize(names, scores);

//Sort result
        sort(names, scores);

//Print the result
        display(names, scores);
    }

    public static void initialize(ArrayList<String> names, ArrayList<Integer> scores){
        Scanner input = new Scanner(System.in);
        int size = 5;
        for(int i = 0; i != size; ++i){
            System.out.println("Enter the name for score #" + (i + 1) + " : ");
            names.add(input.next());
            System.out.println("Enter the score for score #" + (i + 1) + " : ");
            scores.add(input.nextInt());
        }
    }

    public static void sort(ArrayList<String> names, ArrayList<Integer> scores){
//Sort ArrayLists scores and names in descending order according to scores
        int largest = 0, pos = 0;
        for(int i = 0; i != (scores.size() - 1); ++i){

//Set largest to current element
            largest = scores.get(i);
            for(int m = i + 1; m != scores.size(); ++m){
                if(scores.get(m) > largest){
                    largest = scores.get(m);
                    pos = m;
                }
            }
//If current element isn't the largest swap it with the largest
            if(scores.get(i) < largest){
                int scores_tmp = scores.get(i);
                String names_tmp = names.get(i);
                scores.set(i, largest);
                names.set(i, names.get(pos));
                scores.set(pos, scores_tmp);
                names.set(pos, names_tmp);

            }
        }
    }

    public static void display(ArrayList<String> names, ArrayList<Integer> scores){
        System.out.println("\nTop Scorers : ");
        for(int i = 0; i != scores.size(); ++i){
            System.out.println(names.get(i) +" : " + scores.get(i));
        }
    }
}
