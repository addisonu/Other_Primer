//ASSIGNMENT : Project 5
//DATE : 11/22/15
//FILE : CarbonFootprint.java
//DESC : Captures data about auto carbon footprint

/**
 * Interface that will be implemented by Building, Food, and Vehicle classes
 * Has a single member that calculates the carbon emissions for a given object of a particular category.
 */

public interface CarbonFootprint {
    public double getCarbonFootprint();
}
