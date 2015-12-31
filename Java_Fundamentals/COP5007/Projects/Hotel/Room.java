//ASSIGNMENT : Project 2
//DATE : 09/15/15
//FILE : Room.java
//DESC : Class that creates room objects

/**
 * This class creates objects of romm type
 * @param roomNum int holding number of a room
 * @param bedType String holding size of bed
 * @param rate double holding room price
 * @param occupantName String holding name of person staying in room
 * @param smoking char holding smoking priviledges for room
 * @param occupied boolean holding occupied status of room
 */

public class Room {

// INSTANCE VARIABLES //

    private int roomNum;
    private String bedType;
    private double rate;
    private String occupantName;
    private char smoking;
    private boolean occupied;

// PUBLIC METHODS //

    public Room(){ }

    public Room(int roomNum_arg, String bedType_arg, char smoking_arg, double rate_arg){
        setRoomNum(roomNum_arg);
        setBedType(bedType_arg);
        setSmoking(smoking_arg);
        setRate(rate_arg);
   }

    public String getBedType(){
        return bedType;
    }

    public char getSmoking(){
        return smoking;
    }

    public int getRoomNum(){
        return roomNum;
    }

    public double getRoomRate(){
        return rate;
    }

    public String getOccupant(){
        return occupantName;
    }

    public void setOccupied(boolean occupied_arg){
        occupied = occupied_arg;
    }

    public void setOccupant(String occupant_arg){
        occupantName = occupant_arg;
    }

    public void setRoomNum(int roomNum_arg){
        roomNum = roomNum_arg;
    }

    public void setBedType(String bedType_arg){
        bedType = bedType_arg;
    }

    public void setRate(double rate_arg){
        rate = rate_arg;
    }

    public void setSmoking(char smoking_arg){
        smoking = smoking_arg;
    }

    public boolean isOccupied(){
        return occupied;
    }

    public String toString(){
        String result = "Room Number: " + getRoomNum() + '\n'
                + "Occupant name: " + getOccupant() + '\n'
                + "Smoking room: " + getSmoking() + '\n'
                + "Bed Type: " + getBedType() + '\n'
                + "Rate: " + getRoomRate() + '\n';
        return result;
    }

// AUXILIARY FUNCTIONS //
}
