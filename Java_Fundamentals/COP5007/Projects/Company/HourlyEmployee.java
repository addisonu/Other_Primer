//ASSIGNMENT : Project 3
//DATE : 10/11/15
//FILE : HourlyEmployee.java
//DESC : Employee derived class that creates an hourly employee object

/**
 *Employee derived class that creates an hourly employee object
 */

public class HourlyEmployee extends Employee{

// INSTANCE VARIABLES //
    private double rate;
    private int hours;

// METHODS //
    public HourlyEmployee(){
        setRate(0);
        setHours(40);
    }

    public HourlyEmployee(String name_arg, double rate_arg, int hours_arg){
        super(name_arg);
        setRate(rate_arg);
        setHours(hours_arg);
    }

    public double getRate(){
        return rate;
    }

    public void setRate(double rate_arg){
        rate = rate_arg;
    }

    public int getHours(){
        return hours;
    }

    public void setHours(int hours_arg){
        hours = hours_arg;
    }

    public double computePay(){
        return getHours() * getRate();
    }

    public String toString(){
        return super.toString() + "\nweekly salary : " + computePay();
    }
}
