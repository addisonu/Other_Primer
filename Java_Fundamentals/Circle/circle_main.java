//ASSIGNMENT : Project 8
//DATE : 03/04/14
//FILE : circle_main.java
//DESC : Refinement of Circle class using more advanced techniques

public class circle_main{
    public static void main(String args[]){
        Point p = new Point();

//Test each of four constructors and toString

        Circle circ0 = new Circle();
        System.out.println("circ0 : " + circ0.toString());

        p.setX(4);
        p.setY(3);
        Circle circ1 = new Circle(p, 6);
        System.out.println("circ1 : " + circ1.toString());

        Circle circ2 = new Circle(5, -5, 5);
        System.out.println("circ2 : " + circ2.toString());

        Circle circ3 = new Circle(-4, -2, 4);
        System.out.println("circ3 : " + circ3.toString());

        Circle circ4 = new Circle(circ1);
        System.out.println("circ4 : " + circ4.toString() + '\n');

//Test doesOverlap
        System.out.println("Do circ0 and circ1 overlap : " + circ0.doesOverlap(circ1));
        System.out.println("Do circ1 and circ2 overlap : " + circ1.doesOverlap(circ2));
        System.out.println("Do circ2 and circ3 overlap : " + circ2.doesOverlap(circ3));
        System.out.println("Do circ3 and circ4 overlap : " + circ3.doesOverlap(circ4));
        System.out.println("Do circ4 and circ0 overlap : " + circ4.doesOverlap(circ0)+ '\n');

//Test equals
        System.out.println("Are circ0 and circ1 equal : " + circ0.equals(circ1));
        System.out.println("Are circ1 and circ2 equal : " + circ1.equals(circ2));
        System.out.println("Are circ2 and circ3 equal : " + circ2.equals(circ3));
        System.out.println("Are circ3 and circ4 equal : " + circ3.equals(circ4));
        System.out.println("Are circ4 and circ1 equal : " + circ4.equals(circ1));
    }
}
class Circle{

// MEMBER FUNCTIONS //
    public Circle(){
        origin = new Point(0, 0);
        radius = 1;
    }

    public Circle(Point o, double r){
        origin = o;
        radius = r;
    }

    public Circle(double xValue, double yValue, double r){
        this(new Point(xValue, yValue), r);
    }

    public Circle(Circle c){
        origin = c.origin;
        radius = c.radius;
    }

    public Point getOrigin(){
        return origin;
    }

    public void setOrigin(Point p){
        origin = p;
    }

    public void setX(double value){
        origin.setX(value);
    }

    public double getX(){
        return origin.getX();
    }

    public void setY(double value){
        origin.setY(value);
    }

    public double getY(){
        return origin.getY();
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

    public String toString(){
        return "x = " + getX() + ", y = " + getY() + ", radius = " + radius;
    }

    public boolean equals(Circle c){
        return radius == c.radius && origin.equals(c.origin);
    }

    public boolean doesOverlap(Circle c){
        if (equals(c))
            return true;

        else{
//Get distance between center of both circles
        double dist = Math.pow((getX() - c.getX()), 2) + Math.pow((getY() - c.getY()), 2);
        dist = Math.sqrt(dist);

//Get the sum of the circle radii
        double rad_sum = radius + c.radius;
        return dist <= rad_sum;
        }
    }

// DATA MEMBERS //
    Point origin;
    double radius;
}
