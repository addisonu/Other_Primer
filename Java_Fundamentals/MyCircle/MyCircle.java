//ASSIGNMENT : Project 6
//DATE : 02/19/15
//FILE : MyCircle.java
//DESC : Class to create, manipulate, and return dimensions of circle objects

public class MyCircle{

    public void setX(double value){
        x = value;
    }

    public double getX(){
        return x;
    }

    public void setY(double value){
        y = value;
    }

    public double getY(){
        return y;
    }

    public void setRadius(double value){
        radius = value;
    }

    public double getRadius(){
        return radius;
    }

    public double getArea(){
        return Math.PI * Math.pow(radius, 2);
    }

    public boolean doesOverlap(MyCircle otherCircle){

//Get distance between center of both circles
        double dist = Math.pow((x - otherCircle.x), 2) + Math.pow((y - otherCircle.y), 2);
        dist = Math.sqrt(dist);

//Get the sum of the circle radii
        double rad_sum = radius + otherCircle.radius;

        return dist <= rad_sum;
    }
//DATA MEMBERS
    private double x;
    private double y;
    private double radius;
}
