//ASSIGNMENT : Project 2
//DATE : 09/15/15
//FILE : Hotel.java
//DESC : Create objects of class Hotel type

import java.text.NumberFormat;

/**
 * This class creates a Hotel objec
 * @param theRooms array of length 10 holding all room objects
 * @param name String holding the hotel name
 * @param location String holding the hotel location
 * @param occupiedCnt int recording number of rooms occupied
 * @param numOfRooms int recording number of rooms in hotel
 */

public class Hotel {
// CONSTANTS //
    private static final int NOT_FOUND = -1;

// INSTANCE VARIABLE //
    private Room theRooms[];
    private String name;
    private String location;
    private int occupiedCnt;
    private int numOfRooms;

// METHODS //
    public Hotel(){
        theRooms = new Room[10];
        setName("");
        setLocation("");
        occupiedCnt = 0;
        numOfRooms = 0;
    }

    public Hotel(String name_arg, String location_arg){
        theRooms = new Room[10];
        setName(name_arg);
        setLocation(location_arg);
        occupiedCnt = 0;
        numOfRooms = 0;
    }

    public boolean isFull(){
        return occupiedCnt == numOfRooms;
    }

    public boolean isEmpty(){
        return occupiedCnt == 0;
    }

    public void addRoom(int roomNum_arg, String bedType_arg, char smoking_arg, double rate_arg){
        if(numOfRooms < 10 && numOfRooms >=0){
        theRooms[numOfRooms] = new Room(roomNum_arg, bedType_arg, smoking_arg, rate_arg);

        theRooms[numOfRooms].setOccupied(false);
        ++numOfRooms;
        }
    }

    public void addReservation(String occupant_arg, char smoking_arg, String bedType_arg){
            if(numOfRooms != 0 && !isFull()){
                for(int i = 0; i < numOfRooms; ++i){
                        if(!theRooms[i].isOccupied()){
                            if(theRooms[i].getSmoking() == smoking_arg && theRooms[i].getBedType() == bedType_arg){
                                theRooms[i].setOccupant(occupant_arg);
                                theRooms[i].setOccupied(true);
                                ++occupiedCnt;
                                System.out.println("The resevation was made.");
                                return;
                        }
                    }
                }
            }
            System.out.println("The resevation was not made.");
    }

    public void cancelReservation(String occupant_arg){
        int index = findReservation(occupant_arg);
        if(index != NOT_FOUND){
            theRooms[index].setOccupied(false);
            System.out.println("The reservation has been canceled");
            return;
        }
        System.out.println("Occupant name not found");
    }

    public void printReservationList(){
        for(int i = 0; i < numOfRooms; ++i){
            if(theRooms[i].isOccupied())
                System.out.println(theRooms[i].toString());
        }
    }

    public double getDailySales(){
        if(occupiedCnt > 0){
            double total = 0;
            for(int i = 0; i < numOfRooms; ++i){
                if(theRooms[i].isOccupied())
                    total += theRooms[i].getRoomRate();
            }
            return total;
        }
        return 0.0;
    }

    public double occupancyPercentage(){
        if(numOfRooms != 0)
            return occupiedCnt / (double)numOfRooms;
        return 0;
    }

    public String toString(){
            String hotel_info = "Hotel Name: " + name + '\n'
            + "Number of Rooms: " + numOfRooms + '\n'
            + "Number of Occupied Rooms: " + occupiedCnt + '\n'
            + "Room Details are: \n\n";
            for(int i = 0; i < numOfRooms; ++i){
                hotel_info +=theRooms[i].toString() + '\n';
            }
            return hotel_info;
    }

    public String getName(){
        return name;
    }

    public void setName(String name_arg){
        name = name_arg;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String location_arg){
        location = location_arg;
    }

// AUXILIARY FUNCTIONS //
    private int findReservation(String occupant_arg){
        for(int i = 0; i < numOfRooms; ++i){
            if(theRooms[i].getOccupant() == occupant_arg)
                return i;
        }
        return NOT_FOUND;
    }
}
