//ASSIGNMENT : Project 15
//DATE : 05/15/15
//FILE : Point.java
//DESC : Class that create objects representing an ordered pair

import java.util.*;

public class Point{

// DATA MEMBERS //
    private int x;
    private int y;

// MEMBER FUNCTIONS //
    public Point(int valx, int valy){
        x = valx;
        y = valy;
    }

    public void set_x(int val){
        x = val;
    }

    public int get_x(){
        return x;
    }

    public void set_y(int val){
        y = val;
    }

    public int get_y(){
        return y;
    }

    public boolean equals(Point p){
        return x == p.x && y == p.y;
    }
}
