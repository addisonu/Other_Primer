//ASSIGNMENT : Project 2
//DATE : 09/17/15
//FILE : HotelTester.java
//DESC : Program to test functionality of Room and Hotel classes

import java.text.NumberFormat;

/**
 *This class tests the classes Room and Hotel
 */
public class HotelTester {
    public static void main(String[] args){

// Create two new Hotels, each using a different constructor
        Hotel Ritz = new Hotel();
        Hotel Mandarin = new Hotel("Mandarin Oriental", "New York");


// Use Hotel accessor and mutator methods and confirm new values
        Ritz.setName("Ritz-Carlton");
        Ritz.setLocation("New York");

// Add rooms to Ritz-Carlton
        Ritz.addRoom(777, "Twin", 'n', 1234.56);
        Ritz.addRoom(232, "Queen", 's', 545.54);
        Ritz.addRoom(433, "King", 'n', 654.43);
        System.out.print(Ritz.toString());

// Add rooms to Mandarin Oriental
        Mandarin.addRoom(545, "Twin", 's', 5435);
        Mandarin.addRoom(65, "King", 'n', 543.12);
        System.out.print(Mandarin.toString());

// Add reservations to both Hotels
        Ritz.addReservation("John Doe", 's', "Queen");
        Ritz.addReservation("Bob Williams", 's', "Twin");
        Mandarin.addReservation("Suzy Q", 's', "Queen");

// Test empty and full methods
        System.out.println("Mandarin Oriental is empty? " + Mandarin.isEmpty());
        System.out.println("Mandarin Oriental is full? " + Mandarin.isFull());

// Print reservations
        System.out.println("\nCurrent reservations for " + Ritz.getName() + ":");
        Ritz.printReservationList();
        Mandarin.printReservationList();

// Print daily sales
        System.out.println("Daily sales for " + Ritz.getName() + ": " + Ritz.getDailySales());

// Print percentage occupancy for both hotels
        NumberFormat pct = NumberFormat.getPercentInstance();
        System.out.println(Ritz.getName() + " occupancy percentage: " + pct.format(Ritz.occupancyPercentage()));
        System.out.println(Mandarin.getName() + " occupancy percentage: " + pct.format(Mandarin.occupancyPercentage()));

// Cancel reservations
        Ritz.cancelReservation("John Doe");
        System.out.println("\nCurrent reservations for " + Ritz.getName() + ":");
        Ritz.printReservationList();
    }
}
