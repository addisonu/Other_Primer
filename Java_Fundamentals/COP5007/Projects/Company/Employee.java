//ASSIGNMENT : Project 3
//DATE : 10/11/15
//FILE : Employee.java
//DESC : Employee abstract base class

/**
 *Employee abstract base class
 */

public abstract class Employee{

// INSTANCE VARIABLES //
    private String name;
    private int ID;
    private static int nextIDNum = 1000;

// METHODS //
    public Employee(){
        setName("");
        setID(nextIDNum++);
    }

    public Employee(String name_arg){
        setName(name_arg);
        setID(nextIDNum++);
    }

    public String getName(){
        return name;
    }

    public void setName(String name_arg){
        name = name_arg;
    }

    public int getID(){
        return ID;
    }

    public void setID(int ID_arg){
        ID = ID_arg;
    }

    public static int getNextIDNum(){
        return nextIDNum;
    }
    public abstract double computePay();

    public String toString(){
        return "name : " + getName()
            + "\nID : " + getID();
    }
}
