//ASSIGNMENT : Project 5
//DATE : 11/22/15
//FILE : Buiding.java
//DESC : Captures information about the carbon footprint for buildings

import java.io.Serializable;

/**
 * Calculates the carbon dioxide emissions from a Building object
 */

public class Building implements CarbonFootprint, Serializable {

/**
 * Default constructor for Building class
 */
    public Building(){
        set_bill(0);
    }

/**
 * Parameterized constructor for Building class
 */
    public Building(double bill_arg){
        set_bill(bill_arg);
    }

 /**
 * Returns formatted string
 */
     public String toString(){
         return "bill : " + get_bill() + ", ef : " + get_elec_ef() + ", price : " + get_kwh_price() + ", months : " + get_months();
     }

/**
 * Will calculate the carbon emissions for a Building object
 */
    public double getCarbonFootprint(){
        return (get_bill() / get_kwh_price()) * get_elec_ef() * get_months();
    }

/**
 * Setter and getter methods for each instance variable
 */

    public double get_bill() { return bill; }

    public void set_bill(double bill_arg) { bill = bill_arg; }

    public double get_elec_ef() { return elec_ef; }

    public double get_kwh_price() { return kwh_price; }

    public int get_months() { return months; }

// INSTANCE VARIABLES //
/**
 * @param category will specify the type of object emissions are being calculated for
 * @param bill the average amount of the electric bill for a Building object
 * @param elec_ef the electricity emissions factor is the amount of co2 emmissions per unity of electricity
 * @param kwh_price the price per kwh of electricity, is given
 * @param month the number of months in a year
 */
    private double bill;
    private final double elec_ef = 1.648219;
    private final double kwh_price = 0.25;
    private final int months = 12;
}
