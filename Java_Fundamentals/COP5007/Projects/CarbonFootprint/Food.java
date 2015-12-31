//ASSIGNMENT : Project 5
//DATE : 11/22/15
//FILE : Food.java
//DESC : Captures information about the carbon footprint for food

import java.io.Serializable;

/**
 * Calculates the carbon dioxide emissions for a Food object
 */

public class Food implements CarbonFootprint, Serializable {

/**
 * Default constructor for a Food object
 */
    public Food(){
        set_food_type("");
        set_amount(0);
    }

/**
 * Parameterized constructor for a Food object
 */
    public Food(String food_type_arg, double amount_arg){
        set_food_type(food_type_arg);
        set_amount(amount_arg);
    }
/**
 * Returns formatted string
 */
    public String toString(){
        return "food_type : " + get_food_type() + ", amount : " + get_amount() + ", ef : " + get_ef() + ", months : " + get_months();
    }

/**
 * Returns the emission factor of a given food_type
 */
    public double get_ef(){
        if(get_food_type().equalsIgnoreCase("meat"))
            return get_meat_ef();
        else if(get_food_type().equalsIgnoreCase( "bread"))
            return get_bread_ef();
        else if(get_food_type().equalsIgnoreCase("dairy"))
            return get_dairy_ef();
        else if(get_food_type().equalsIgnoreCase("produce"))
            return get_produce_ef();
        else if(get_food_type().equalsIgnoreCase("fastfood"))
            return get_fastfood_ef();
        else if(get_food_type().equalsIgnoreCase("other"))
            return get_other_ef();
        else{
            System.err.println("Invalid food_type");
            return 0;
        }
    }

/**
 * Calculates the carbon dioxide emissions for a Food object
 */
    public double getCarbonFootprint(){
        return (get_amount() * get_ef() * get_months() * get_gram_to_pound());
    }

/**
 * Setter and getter methods for all instance variables
 */

    public String get_food_type(){
        return food_type;
    }

    public void set_food_type(String food_type_arg){
        food_type = food_type_arg;
    }

    public double get_amount(){
        return amount;
    }

    public void set_amount(double amount_arg){
        amount = amount_arg;
    }

    public double get_meat_ef(){
        return meat_ef;
    }

    public double get_bread_ef(){
        return bread_ef;
    }

    public double get_dairy_ef(){
        return dairy_ef;
    }

    public double get_produce_ef(){
        return produce_ef;
    }

    public double get_fastfood_ef(){
        return fastfood_ef;
    }

    public double get_other_ef(){
        return other_ef;
    }

    public double get_gram_to_pound(){
        return gram_to_pound;
    }

    public int get_months(){
        return months;
    }

// INSTANCE VARIABLES //
/**
 * @param food_type the type of food to calcluate emissions for can be : meat, bread, dairy, produce, fastfood, other
 * @param amount the amount of money used to purchase the food
 * @param *_ef all instance variables ending with _ef are the emissions factor for a given food_type
 * @param gram_to_pound factor to convert grams to pounds
 * @param months number of months in a year
 */
    private String food_type;
    private double amount;
    private final double meat_ef = 1452;
    private final double bread_ef = 741;
    private final double dairy_ef = 1911;
    private final double produce_ef = 1176;
    private final double fastfood_ef = 368;
    private final double other_ef = 467;
    private final double gram_to_pound = 0.0022;
    private final int months = 12;
}
