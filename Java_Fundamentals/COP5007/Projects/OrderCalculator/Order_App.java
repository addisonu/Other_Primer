/**
Order calculator to calculate the price of a drink
@version 1.0

Project #: 6
FILE NAME: OrderApp.java
DATE: 11/27/15
*/

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

/**
  GUI for Order Calculator application
 */
public class Order_App extends JFrame {

// INSTANCE VARIABLES //

// instance variables for GUI drink option panels
    /**
    Panel for drink temperatures
    */
    private TempPanel temp_panel = new TempPanel();

    /**
    Panel for drink toppings
    */
    private ToppingPanel topping_panel = new ToppingPanel();

    /**
    Panel for drink flavor
    */
    private FlavorPanel flavor_panel = new FlavorPanel();

// instance variables for GUI dimension
    /**
    The width of the window
    */
    public static final int WIDTH = 650;

    /**
    The height of the window
    */
    public static final int HEIGHT = 400;

    // instance variables for method implementation

    /**
    Tax charged on all orders
    */
    private static final double tax_rate = 0.08875;

    /**
    Price for a hot or cold drink
    */
    private double temp_price = 0;

    /**
    Price for a combination of toppings
    */
    private double topping_price = 0;

    /**
    Price for drink flavor
    */
    private double flavor_price = 0;

    /**
    Label holding subtotal
    */
    JLabel subtotal_value_label;

    /**
    Label holding tax
    */
    JLabel tax_value_label;

    /**
    Label holding total
    */
    JLabel total_value_label;

// METHODS //

    /**
    Constructs an Order_App with default values for instance fields
    */
    public  Order_App(){
        super("Order Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLayout(new BorderLayout());

// Add greeting at top center of window
        JPanel greeting_panel = new JPanel();
        greeting_panel.setLayout(new FlowLayout());
        add(greeting_panel, BorderLayout.NORTH);
        JLabel greeting = new JLabel("Welcome to Yummy Bubbles");
        greeting_panel.setBackground(Color.BLACK);
        greeting.setForeground(Color.GREEN);
        greeting_panel.add(greeting);

// Create main panel with drink options
        JPanel drink_choice = new JPanel();
        drink_choice.setLayout(new GridLayout(1, 3));
        add(drink_choice, BorderLayout.CENTER);

// Add panels to drink_choice panel
        drink_choice.add(temp_panel);
        drink_choice.add(topping_panel);
        drink_choice.add(flavor_panel);

// Create order_total_panel
        JPanel order_total_panel = new JPanel();
        order_total_panel.setLayout(new GridLayout(4, 1));
        order_total_panel.setBackground(Color.BLACK);
        add(order_total_panel, BorderLayout.SOUTH);

// Create submit_panel
        JPanel submit_panel = new JPanel();
        submit_panel.setLayout(new FlowLayout());
        submit_panel.setBackground(Color.BLACK);
        order_total_panel.add(submit_panel);

// Create and add calculate and exit buttons
        JButton calculate_btn = new JButton("Calculate");
        calculate_btn.addActionListener(new CalculateListener());
        JButton exit_btn = new JButton("Exit");
        exit_btn.addActionListener(new ExitListener());

        submit_panel.add(calculate_btn);
        submit_panel.add(exit_btn);

// Create sub_total_panel
        JPanel subtotal_panel = new JPanel();
        subtotal_panel.setLayout(new FlowLayout());
        subtotal_panel.setBackground(Color.BLACK);
        order_total_panel.add(subtotal_panel);

// Create and add subtotal labels
        JLabel subtotal_label = new JLabel("Subtotal : ");
        subtotal_label.setForeground(Color.GREEN);

        subtotal_value_label = new JLabel("0");
        subtotal_value_label.setForeground(Color.GREEN);

        subtotal_panel.add(subtotal_label);
        subtotal_panel.add(subtotal_value_label);

// Create tax_panel
        JPanel tax_panel = new JPanel();
        tax_panel.setLayout(new FlowLayout());
        tax_panel.setBackground(Color.BLACK);
        order_total_panel.add(tax_panel);

// Create and add tax labels
        JLabel tax_label = new JLabel("Tax : ");
        tax_label.setForeground(Color.GREEN);

        tax_value_label = new JLabel("0");
        tax_value_label.setForeground(Color.GREEN);

        tax_panel.add(tax_label);
        tax_panel.add(tax_value_label);

// Create total_panel
        JPanel total_panel = new JPanel();
        total_panel.setLayout(new FlowLayout());
        total_panel.setBackground(Color.BLACK);
        order_total_panel.add(total_panel);

// Create and add total labels
        JLabel total_label = new JLabel("Total : ");
        total_label.setForeground(Color.GREEN);

        total_value_label = new JLabel("0");
        total_value_label.setForeground(Color.GREEN);

        total_panel.add(total_label);
        total_panel.add(total_value_label);
    }

    /**
    Returns formatted string of selected drink option names and prices
    */
    public String toString(){
         return "temp selecton at price : " + get_temp_price()
            + "\ntopping selection at price : " + get_topping_price()
            + "\nflavor selection at price : " + get_flavor_price();
    }

    /**
    Calculates the subtotal of a drink
    */
    public double calculate_subtotal(){
        return get_temp_price() + get_topping_price() + get_flavor_price();
    }

    /**
    Calculates the tax of a drink
    */
    public double calculate_tax(){
        return tax_rate * (get_temp_price() + get_topping_price() + get_flavor_price());
    }

    /**
    Calculates the total of a drink
    */
    public double calculate_total(){
        return calculate_subtotal() + calculate_tax();
    }

    /**
    Updates the labels for subtotal, tax, and total
    @param subtotal_arg the value of subtotal_value_label
    @param tax_arg the value of tax_value_label
    @param total_arg the value of total_value_label
    */
    public void update_value_label(String subtotal_arg, String tax_arg, String total_arg){
        get_subtotal_value_label().setText(subtotal_arg);
        get_tax_value_label().setText(tax_arg);
        get_total_value_label().setText(total_arg);
    }

// GETTER AND SETTER METHODS //

    /**
    Returns the instance variable temp_price
    */
    public double get_temp_price(){
        return temp_price;
    }

    /**
    Sets the instance variable temp_price
    @param price_arg the price of drink temperature drink
    */
    public void set_temp_price(double price_arg){
        temp_price = price_arg;
    }

    /**
    Returns the instance variable topping_price
    */
    public double get_topping_price(){
        return topping_price;
    }

    /**
    Sets the instance variable topping_price
    @param price_arg the price of drink toppings
    */
    public void set_topping_price(double price_arg){
        topping_price = price_arg;
    }

    /**
    Returns the instance variable flavor_price
    */
    public double get_flavor_price(){
        return flavor_price;
    }

    /**
    Sets the instance variable flavor_price
    @param price_arg the price of drink flavor
    */
    public void set_flavor_price(double price_arg){
        flavor_price = price_arg;
    }

    /**
    Returns the instance variable subtotal_label
    */
    public JLabel get_subtotal_value_label(){
        return subtotal_value_label;
    }

    /**
    Returns the instance variable tax_label
    */
    public JLabel get_tax_value_label(){
        return tax_value_label;
    }

    /**
    Returns the instance variable total_label
    */
    public JLabel get_total_value_label(){
        return total_value_label;
    }

// Get selected temp price
    /**
    Returns the price of selected temp
    @param temp price of selected drink temperature
    */
    public double get_selected_temp_price(String temp){
        if(temp == temp_panel.cold_str){
            return temp_panel.cold_price;
        }
        else if(temp == temp_panel.hot_str){
            return temp_panel.hot_price;
        }
        return 0;
    }

// Get selected flavor price
    /**
    Return the price of selected flavor
    @param flavor price of selected drink flavor
    */
    public double get_selected_flavor_price(String flavor){
        if(flavor == flavor_panel.grapefruit_green_str)
            return flavor_panel.grapefruit_green_price;
        else if(flavor == flavor_panel.rooibos_milk_str)
            return flavor_panel.rooibos_milk_price;
        else if(flavor == flavor_panel.black_milk_str)
            return flavor_panel.black_milk_price;
        else if(flavor == flavor_panel.royal_milk_str)
            return flavor_panel.royal_milk_price;
        else if(flavor == flavor_panel.honey_jasmine_green_str)
            return flavor_panel.honey_jasmine_green_price;
        else if(flavor == flavor_panel.pina_colada_str)
            return flavor_panel.pina_colada_price;
        else if(flavor == flavor_panel.lavender_black_str)
            return flavor_panel.lavender_black_price;
        return 0;
    }

// Get selected topping price
    /**
    Returns the sum price of all selected toppings
    */
    public double get_selected_topping_price(){
        set_topping_price(0);
        if(topping_panel.bubble_chbx.isSelected())
            set_topping_price(get_topping_price() + topping_panel.bubble_price);
        if(topping_panel.honey_bubble_chbx.isSelected())
            set_topping_price(get_topping_price() + topping_panel.honey_bubble_price);
        if(topping_panel.rainbow_jelly_chbx.isSelected())
            set_topping_price(get_topping_price() + topping_panel.rainbow_jelly_price);
        if(topping_panel.aloe_vera_chbx.isSelected())
            set_topping_price(get_topping_price() + topping_panel.aloe_vera_price);
        if(topping_panel.pudding_chbx.isSelected())
            set_topping_price(get_topping_price() + topping_panel.pudding_price);
        if(topping_panel.adzuki_chbx.isSelected())
            set_topping_price(get_topping_price() + topping_panel.adzuki_price);
        if(topping_panel.red_bean_chbx.isSelected())
            set_topping_price(get_topping_price() + topping_panel.red_bean_price);
        if(topping_panel.black_bean_chbx.isSelected())
            set_topping_price(get_topping_price() + topping_panel.black_bean_price);
        return get_topping_price();
    }

// Private listener classes

// Listener class for calculate button
    /**
    Listener class for calculate_btn
    */
    private class CalculateListener implements ActionListener {

        /**
        Performs action for CalculateListener class
        @param e the name of the ActionEvent object
        */
        public void actionPerformed(ActionEvent e){
            double temp = get_selected_temp_price(temp_panel.temp_btn_group.getSelection().getActionCommand());
            set_temp_price(temp);

            double flavor = get_selected_flavor_price(flavor_panel.flavor_btn_group.getSelection().getActionCommand());
            set_flavor_price(flavor);

            double topping = get_selected_topping_price();
            set_topping_price(topping);

// Format number to display two decimal places

            DecimalFormat df = new DecimalFormat("$0.00");

            String subtotal = df.format(calculate_subtotal());
            String tax = df.format(calculate_tax());
            String total = df.format(calculate_total());

            update_value_label(subtotal, tax, total);
        }
    }

// Listener class for exit button
    /**
    Listener class for exit_btn
    */
    private class ExitListener implements ActionListener {

        /**
        Performs action for ExitListener class
        @param e the name of the ActionEvent object
        */
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
}
