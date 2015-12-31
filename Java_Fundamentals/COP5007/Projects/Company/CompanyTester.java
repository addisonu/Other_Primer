//ASSIGNMENT : Project 3
//DATE : 10/11/15
//FILE : CompanyTester.java
//DESC : Tests the classes : Company, Employee, SalariedEmployee, HourlyEmployee, CommissionedEmployee

/**
 *Tests the classes : Company, Employee, SalariedEmployee, HourlyEmployee, CommissionedEmployee
 */
public class CompanyTester{
    public static void main(String args[]){
// Create employees
    Company company0 = new Company("company0");
    HourlyEmployee he0 = new HourlyEmployee(), he1 = new HourlyEmployee("John Doe", 13.50, 30);
    SalariedEmployee se0 = new SalariedEmployee(), se1 = new SalariedEmployee("Jane Doe", 639.12);
    CommissionedEmployee ce0 = new CommissionedEmployee(), ce1 = new CommissionedEmployee("Simyits Arron", 500.00, 200.00, .17);

// Add employees to company
    company0.addEmployee(he0);
    company0.addEmployee(he1);
    company0.addEmployee(se0);
    company0.addEmployee(se1);
    company0.addEmployee(ce0);
    company0.addEmployee(ce1);

// Print all company info
    System.out.println(company0.toString());
    }
}
