/**
Provides all GUI elements and functionality for FlavorPanel
@version 1.0

Project #: 6
FILE NAME: FlavorPanel.java
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
Panel for flavor drink options
*/

public class FlavorPanel extends JPanel {

    /**
    Main panel for a FlavorPanel object
    */
    public JPanel flavor_panel = new JPanel();

// instance variables for flavor prices

    /**
    Price for grapefruit green tea flavor
    */
    public static final double grapefruit_green_price = 5.75;

    /**
    String name for grapefruit green tea flavor
    */
    public static String grapefruit_green_str = "Grapefruit Green Tea";

   /**
    Price for rooibos milk tea flavor
    */
    public static final double rooibos_milk_price = 5.10;

    /**
    String name for rooibos milk tea flavor
    */
    public static String rooibos_milk_str = "Rooibos Milk Tea";

   /**
    Price for black milk tea flavor
    */
    public static final double black_milk_price = 3.75;

    /**
    String name for black milk tea flavor
    */
    public static String black_milk_str = "Black Milk Tea";

    /**
    Price for royal milk tea flavor
    */
    public static final double royal_milk_price = 4.75;

    /**
    String name for royal milk tea flavor
    */
    public static String royal_milk_str = "Royal Milk Tea";

    /**
    Price for honey jasmine green tea
    */
    public static final double honey_jasmine_green_price = 5.25;

    /**
    String name for honey jasmine green tea flavor
    */
    public static String honey_jasmine_green_str = "Honey Jasmine Green Tea";

    /**
    Price for pina colada smoothie
    */
    public static final double pina_colada_price = 4.80;

    /**
    String name for pina colada smoothie flavor
    */
    public static String pina_colada_str = "Pina Colada Smoothie";

    /**
    Price for lavender black tea flavor
    */
    public static final double lavender_black_price = 4.35;

    /**
    String name for lavender black tea flavor
    */
    public static String lavender_black_str = "Lavender Black Tea";

    /**
    Checkbox for bubble topping
    */
    public JCheckBox bubble_chbx;

    /**
    String for bubble topping
    */
    public static final String bubble_str = "Bubble";

    /**
    Checkbox for honey bubble topping
    */
    public JCheckBox honey_bubble_chbx;

    /**
    String for honey bubble topping
    */
    public static final String honey_bubble_str = "Honey Bubble";

    /**
    Checkbox for rainbow jelly topping
    */
    public JCheckBox rainbow_jelly_chbx;

    /**
    String for rainbow jelly topping
    */
    public static final String rainbow_jelly_str = "Rainbow Jelly";

    /**
    Checkbox for aloe vera topping
    */
    public JCheckBox aloe_vera_chbx;

    /**
    String for aloe vera topping
    */
    public static final String aloe_vera_str = "Aloe Vera";

    /**
    Checkbox for pudding topping
    */
    public JCheckBox pudding_chbx;

    /**
    String for pudding topping
    */
    public static final String pudding_str = "Pudding";

    /**
    Checkbox for adzuki topping
    */
    public JCheckBox adzuki_chbx;

    /**
    String for adzuki topping
    */
    public static final String adzuki_str = "Adzuki";

    /**
    Checkbox for red bean topping
    */
    public JCheckBox red_bean_chbx;

    /**
    String for red bean topping
    */
    public static final String red_bean_str = "Red Bean";

    /**
    Checkbox for black bean topping
    */
    public JCheckBox black_bean_chbx;

    /**
    String for black bean topping
    */
    public static final String black_bean_str = "Black Bean";

    /**
    Button group for flavor radio buttons
    */
    ButtonGroup flavor_btn_group;

// METHODS //

    /**
    Constructs an FlavorPanel with default values for instance fields
    */
    public FlavorPanel(){

// Create drink flavor panel
        super(new BorderLayout());
        add(flavor_panel, BorderLayout.CENTER);
        flavor_panel.setLayout(new GridLayout(7, 1));
        flavor_panel.setBackground(Color.GREEN);
        TitledBorder flavor_title = BorderFactory.createTitledBorder("Flavor");
        flavor_panel.setBorder(flavor_title);

// Create and add drink flavor radio buttons
        JRadioButton grapefruit_green_rb = new JRadioButton(grapefruit_green_str, true);
        grapefruit_green_rb.setActionCommand(grapefruit_green_str);

        JRadioButton rooibos_milk_rb = new JRadioButton(rooibos_milk_str);
        rooibos_milk_rb.setActionCommand(rooibos_milk_str);

        JRadioButton black_milk_rb = new JRadioButton(black_milk_str);
        black_milk_rb.setActionCommand(black_milk_str);

        JRadioButton royal_milk_rb = new JRadioButton(royal_milk_str);
        royal_milk_rb.setActionCommand(royal_milk_str);

        JRadioButton honey_jasmine_green_rb = new JRadioButton(honey_jasmine_green_str);
        honey_jasmine_green_rb.setActionCommand(honey_jasmine_green_str);

        JRadioButton pina_colada_rb = new JRadioButton(pina_colada_str);
        pina_colada_rb.setActionCommand(pina_colada_str);

        JRadioButton lavender_black_rb = new JRadioButton(lavender_black_str);
        lavender_black_rb.setActionCommand(lavender_black_str);

        flavor_panel.add(grapefruit_green_rb);
        flavor_panel.add(rooibos_milk_rb);
        flavor_panel.add(black_milk_rb);
        flavor_panel.add(royal_milk_rb);
        flavor_panel.add(honey_jasmine_green_rb);
        flavor_panel.add(pina_colada_rb);
        flavor_panel.add(lavender_black_rb);

// Group radio buttons
        flavor_btn_group = new ButtonGroup();
        flavor_btn_group.add(grapefruit_green_rb);
        flavor_btn_group.add(rooibos_milk_rb);
        flavor_btn_group.add(black_milk_rb);
        flavor_btn_group.add(royal_milk_rb);
        flavor_btn_group.add(honey_jasmine_green_rb);
        flavor_btn_group.add(pina_colada_rb);
        flavor_btn_group.add(lavender_black_rb);
    }
}
