//ASSIGNMENT : Project 15
//DATE : 05/15/15
//FILE : Ship.java
//DESC : Class that creates and tracks Ship objects

import java.util.*;

public class Ship{

// DATA MEMBERS //
    ArrayList<Point> points;
    ArrayList<Point> hits;

// MEMBER FUNCTIONS //

// Create ship's points from arguments origin, length, and orientation
    public Ship(Point origin, boolean isVertical, int length){
        points = new ArrayList<Point>();
        hits = new ArrayList<Point>();

        Point tmp = new Point(origin.get_x(), origin.get_y());
        points.add(tmp);

        for(int i = 1; i < length; ++i){
            if(isVertical){
                tmp = new Point(origin.get_x(), origin.get_y() + i);
                points.add(tmp);
            }
            else{
                tmp = new Point(origin.get_x() + i, origin.get_y());
                tmp.set_x(origin.get_x() + i);
                points.add(tmp);
            }
        }
    }

// Returns true if a Ship covers a point on the board, false if it does not
    public boolean containsPoint(Point p){
        for(int i = 0; i < points.size(); ++i){
            if(p.equals(points.get(i)))
                return true;
        }
        return false;
    }

// Returns true if the receiving ship shares a point with the argument ship
    public boolean collidesWith(Ship s){
        for(int i = 0; i < points.size(); ++i)
            if(s.containsPoint(points.get(i)))
                return true;
        return false;
    }

// Adds a point to a ship's hits data member if it contains the point entered
    public boolean shotFiredAtPoint(Point p){
        if(containsPoint(p) && !isHitAtPoint(p)){
            hits.add(p);
            return true;
        }
        else
            return false;
    }

// Returns true if a ship's hits data member contains the point entered
    public boolean isHitAtPoint(Point p){
        for(int i = 0; i < hits.size(); ++i)
            if(p.equals(hits.get(i)))
                return true;
        return false;
    }

// Returns the number of points in the ship that have been hit
    public int hitCount(){
        return hits.size();
    }

// Returns true if a ship is sunk, false otherwise
    public boolean isSunk(){
        return points.size() == hits.size();
    }
}
