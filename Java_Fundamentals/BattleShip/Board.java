//ASSIGNMENT : Project 15
//DATE : 05/16/15
//FILE : Board.java
//DESC : Class that creates and tracks board objects

import java.util.*;

public class Board{

// Size of sea
    static final int SEA_MILES = 10;

// DATA MEMBERS //
    private ArrayList<ArrayList<Character>> sea;
    private Ship fleet[];
    private ArrayList<Point> shots;
    private Random rndpoint;

// MEMBER FUNCTIONS //

// Initialize game board
    public Board(){

// Create fleet
        fleet = new Ship[5];
        rndpoint = new Random(System.currentTimeMillis());
        int length = 0;
        boolean isVertical = false;
        Point origin = new Point(0, 0);
        boolean collides = false;
        Ship new_ship;

        for(int i = 0; i < fleet.length; ++i){
            do{
                length = rndpoint.nextInt(4) + 2;
                isVertical = rndpoint.nextBoolean();

                if(isVertical){
                    origin.set_x(rndpoint.nextInt(SEA_MILES));
                    origin.set_y(rndpoint.nextInt(SEA_MILES - length + 1));
                }
                else{
                    origin.set_x(rndpoint.nextInt(SEA_MILES - length + 1));
                    origin.set_y(rndpoint.nextInt(SEA_MILES));
                }
                new_ship = new Ship(origin, isVertical, length);
                for(int k = 0; k < i;++k){
                    if((collides = new_ship.collidesWith(fleet[k])))
                        break;
                }
            }while(collides);
            fleet[i] = new_ship;
        }
// Load shots
        shots = new ArrayList<Point>();

// Set each char in sea
        sea = new ArrayList<ArrayList<Character>>();
        for(int i = 0; i < SEA_MILES; ++i){
            sea.add(new ArrayList<Character>());
            for(int j = 0; j < SEA_MILES; ++j){
                sea.get(i).add('~');
            }
        }
    }

// Fire a shot at the argument point
    public void fireShot(Point p){
        if(!seaHitAtPoint(p)){
            shots.add(p);
            for(int i = 0; i < 5; ++i){
                if(fleet[i].shotFiredAtPoint(p)){
                    sea.get(p.get_y()).set(p.get_x(), 'X');
                    System.out.println("Hit!");
                    if(fleet[i].isSunk())
                        System.out.println("You capsized a ship of length " + fleet[i].points.size() + "!!!");
                    return;
                }
            }
            sea.get(p.get_y()).set(p.get_x(), '.');
            System.out.println("Miss :(");
        }
        else
            System.out.println("Shot has already been fired at this point");
    }

// Returns true if a board's shots data member contains the point entered
    public boolean seaHitAtPoint(Point p){
        for(int i = 0; i < shots.size(); ++i){
            if(p.equals(shots.get(i)))
                return true;
        }
        return false;
    }

// Print all points on the grid, showing misses, hits, and water
    public void display(){
        for(int i = sea.size() - 1; i >= 0; --i){
            System.out.print(i + " ");
            for(int j = 0; j < sea.get(0).size(); ++j)
                System.out.print(sea.get(i).get(j) + " ");
            System.out.println();
        }
        System.out.print(" ");
        for(int i = 0; i < sea.size(); ++i)
            System.out.print(" " + i);
        System.out.println();
    }

// Return true if all ships have been sunk, false otherwise
    public boolean gameOver(){
        return fleet[0].isSunk() && fleet[1].isSunk() && fleet[2].isSunk() && fleet[3].isSunk() && fleet[4].isSunk();
    }
}
