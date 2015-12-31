//ASSIGNMENT : Project 3
//DATE : 10/11/15
//FILE : Company.java
//DESC : Create a Company object which manages objects of type Employee

import java.util.ArrayList;

/**
 * Create a Company object which manages objects of type Employee
 */

public class Company{

// INSTANCE VARIABLES //
    private String name;
    private ArrayList<Employee> employees;

// METHODS //

    public Company(){
        setName("");
        employees = new ArrayList<Employee>();
    }

    public Company(String name_arg){
        setName("");
        employees = new ArrayList<Employee>();
    }

    public String getName(){
        return name;
    }

    public void setName(String name_arg){
        name = name_arg;
    }

    public void addEmployee(Employee employee_arg){
        employees.add(employee_arg);
    }

    public Employee getEmployee(int ID_arg){
        for(Employee emp : employees)
            if(emp.getID() == ID_arg)
                return emp;
        System.out.println("Employee was not found.");
        return null;
    }

    public int employeeCnt(){
        return Employee.getNextIDNum() - 1001;
    }

    public double totalPayroll(){
        double payroll = 0;
        for(Employee emp : employees)
            payroll += emp.computePay();
        return payroll;
    }

    public String toString(){
        String employee_info = "";
        for(Employee emp : employees){
            employee_info += emp.toString() + "\n\n";
        }
        return "Company name : " + getName() + '\n' + employee_info;
    }
}
