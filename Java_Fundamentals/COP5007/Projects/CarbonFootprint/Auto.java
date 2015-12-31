//ASSIGNMENT : Project 5
//DATE : 11/22/15
//FILE : Auto.java
//DESC : Captures data about auto carbon footprint

import java.io.Serializable;

/**
 * Class that calculates the co2 emissions for a Vehicle
 **/

public class Auto implements CarbonFootprint, Serializable {

/**
 * Default constructor for a Auto object
 */
    public Auto() {
        set_miles(0);
        set_fuel_efficiency(0);
    }

/**
 * Parameterized constructor for an Auto object
 */
    public Auto(double miles_arg, double fuel_efficiency_arg){
        set_miles(miles_arg);
        set_fuel_efficiency(fuel_efficiency_arg);
    }

/**
* Returns formatted string
*/
    public String toString(){
        return "miles : " + get_miles() + ", mpg  : " + get_fuel_efficiency() + ", co2_ef : " + get_co2_ef() + ", weeks : " + get_weeks() + ", greenhouse gases : " + get_gh_gases();
    }

/**
 * Calculates the co2 emissions for a Vehicle
 */
    public double getCarbonFootprint(){
        return (get_miles() * get_weeks()) / get_fuel_efficiency() * get_co2_ef() * get_gh_gases();
    }

/**
 * Setter and getter methods for each instance variable
 */

    public double get_miles() { return miles; }

    public void set_miles(double miles_arg) {
        miles = miles_arg;
    }

    public double get_fuel_efficiency() {
        return fuel_efficiency;
    }

    public void set_fuel_efficiency(double fuel_efficiency_arg) {
        fuel_efficiency = fuel_efficiency_arg;
    }

    public double get_co2_ef() {
        return co2_ef;
    }

    public int get_weeks() {
        return weeks;
    }

    public double get_gh_gases() {
        return gh_gases;
    }

// INSTANCE VARIABLES //
/**
 * @param miles the number of miles driven per week
 * @param fuel_efficiency the mpg for a vehicle
 * @param co2_ef the carbon dioxiode emissions for a vehicle
 * @param weeks the number of weeks in a year
 * @param gh_gases other greenhouse gases emitted from a vechicle's usage
 */
    private double miles;
    private double fuel_efficiency;
    private final double co2_ef = 19.4;
    private final int weeks = 52;
    private double gh_gases = (double)100 / 95;
}

