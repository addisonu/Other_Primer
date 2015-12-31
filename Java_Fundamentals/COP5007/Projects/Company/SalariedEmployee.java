//ASSIGNMENT : Project 3
//DATE : 10/11/15
//FILE : SalariedEmployee.java
//DESC : creates object of type SalariedEmployee

/**
 *creates object of type SalariedEmployee
 */

public class SalariedEmployee extends Employee{

// INSTANCE VARIABLES //
    private double salary;

// METHODS //

    public SalariedEmployee(){
        setSalary(0);
    }

    public SalariedEmployee(String name_arg, double salary_arg){
        super(name_arg);
        setSalary(salary_arg);
    }

    public double getSalary(){
        return salary;
    }

    public void setSalary(double salary_arg){
        salary = salary_arg;
    }

    public double computePay(){
        return getSalary();
    }

    public String toString(){
        return super.toString() + "\nweekly salary : " + computePay();
    }
}
