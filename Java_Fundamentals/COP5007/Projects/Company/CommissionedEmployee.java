//ASSIGNMENT : Project 3
//DATE : 10/11/15
//FILE : CommissionedEmployee.java
//DESC : Creates an object of type CommissionedEmployee

/**
 *Creates an object of type CommissionedEmployee
 */

public class CommissionedEmployee extends SalariedEmployee{

// INSTANCE VARIABLES //
    private double weeklySales;
    private double commissionRate;

// METHODS //
    public CommissionedEmployee(){
        setWeeklySales(0);
        setCommissionRate(0);
    }

    public CommissionedEmployee(String name_arg, double salary_arg, double weeklySales_arg, double commissionRate_arg){
        super(name_arg, salary_arg);
        setWeeklySales(weeklySales_arg);
        setCommissionRate(commissionRate_arg);
    }

    public double getWeeklySales(){
        return weeklySales;
    }

    public void setWeeklySales(double weeklySales_arg){
        weeklySales = weeklySales_arg;
    }

    public double getCommissionRate(){
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate_arg){
        commissionRate = commissionRate_arg;
    }

    public double computePay(){
        double commission = getWeeklySales() * getCommissionRate();
        return super.getSalary() + commission;
    }

    public String toString(){
        double commission = getWeeklySales() * getCommissionRate();
        return super.toString() + "\ncommission : " + commission;
    }
}
