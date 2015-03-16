//ASSIGNMENT : Project 6
//DATE : 02/19/15
//FILE : MyCircleTester.java
//DESC : Program to test MyCircle class

import java.util.Scanner;

public class MyCircleTester{
    public static void main(String args[]){
        MyCircle circ1, circ2, circ3, neg_circ;
        circ1 = new MyCircle();
        circ2 = new MyCircle();
        circ3 = new MyCircle();
        neg_circ = new MyCircle();

//Test basic MyCircle methods
//Set values and print for circ1
        circ1.setX(1);
        circ1.setY(1);
        circ1.setRadius(4.567);

        System.out.println("circ1.x = " + circ1.getX());
        System.out.println("circ1.y = " + circ1.getY());
        System.out.println("circ1.radius = " + circ1.getRadius());
        System.out.println("circ1 area = " + circ1.getArea());
        System.out.println();

//Set values and print for circ2
        circ2.setX(2);
        circ2.setY(2);
        circ2.setRadius(1);

        System.out.println("circ2.x = " + circ2.getX());
        System.out.println("circ2.y = " + circ2.getY());
        System.out.println("circ2.radius = " + circ2.getRadius());
        System.out.println("circ2 area = " + circ2.getArea());
        System.out.println();

//Set values and print for circ3
        circ3.setX(3);
        circ3.setY(3);
        circ3.setRadius(1);

        System.out.println("circ3.x = " + circ3.getX());
        System.out.println("circ3.y = " + circ3.getY());
        System.out.println("circ3.radius = " + circ3.getRadius());
        System.out.println("circ3 area = " + circ3.getArea());
        System.out.println();

//Set values and print for neg_circ
        neg_circ.setX(-3);
        neg_circ.setY(-3);
        neg_circ.setRadius(2);

        System.out.println("neg_circ.x = " + neg_circ.getX());
        System.out.println("neg_circ.y = " + neg_circ.getY());
        System.out.println("neg_circ.radius = " + neg_circ.getRadius());
        System.out.println("neg_circ area = " + neg_circ.getArea());
        System.out.println();

//Test overlap function
        System.out.println("Do circ1 and circ2 overlap? " + circ1.doesOverlap(circ2));
        System.out.println("Do circ1 and circ3 overlap? " + circ1.doesOverlap(circ3));
        System.out.println("Do circ2 and circ3 overlap? " + circ2.doesOverlap(circ3));
        System.out.println("Do neg_circ and circ3 overlap? " + neg_circ.doesOverlap(circ3));
    }
}
