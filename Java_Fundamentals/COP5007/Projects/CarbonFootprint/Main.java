//ASSIGNMENT : Main.java
//DATE : 11/22/15
//FILE : Main.java
//DESC : Runs application

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Tests Building, Auto, and Food classes
 */

public class Main{
    public static void main(String args[]){

        ArrayList<String> names = new ArrayList<String>();
        ArrayList<CarbonFootprint> Carbon_list = new ArrayList<CarbonFootprint>();

        try{
            Scanner file = new Scanner(new File("Project5_objects.txt"));
            while(file.hasNext()){
                String stringRead = file.nextLine();
                StringTokenizer st = new StringTokenizer (stringRead, ",");
                String category = st.nextToken();
                try{
                    if(category.equalsIgnoreCase("food")){
                        String name = st.nextToken();
                        String food_type_arg = st.nextToken();
                        double amount_arg = Double.parseDouble(st.nextToken());

                        names.add(name);
                        Carbon_list.add(new Food(food_type_arg, amount_arg));
                    }
                    else if(category.equalsIgnoreCase("auto")){
                        String name = st.nextToken();
                        double miles_arg = Double.parseDouble(st.nextToken());
                        double mpg = Double.parseDouble(st.nextToken());

                        names.add(name);
                        Carbon_list.add(new Auto(miles_arg, mpg));
                    }
                    else if(category.equalsIgnoreCase("building")){
                        String name = st.nextToken();
                        double bill_arg = Double.parseDouble(st.nextToken());

                        names.add(name);
                        Carbon_list.add(new Building(bill_arg));
                    }
                    else{
                        System.err.println("Invalid category");
                        continue;
                    }
                }
                catch(NumberFormatException nfe){
                    System.err.println( "Error in Carbon_list record: " + stringRead + "; record ignored");
                }
            }
        }
        catch(FileNotFoundException fnfe){
            System.err.println("Unable to find Project5_objects.txt");
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }

        for (int i = 0; i != Carbon_list.size(); ++i){
            System.out.format("%s%.2f%s%n%n", names.get(i) + " has a carbon footprint of ", Carbon_list.get(i).getCarbonFootprint(), " lbs co2 emissions per year.");
        }
    }
}
