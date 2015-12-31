/**
Provides all GUI elements and functionality for ToppingPanel
@version 1.0

Project #: 6
FILE NAME: ToppingPanel.java
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
Panel for topping drink options
 */

public class ToppingPanel extends JPanel {

// INSTANCE VARIABLES //

    /**
    Main panel for a ToppingPanel object
    */
    public JPanel topping_panel = new JPanel();

// instance variables for topping prices

    /**
    Price for adding a bubble topping
    */
    public static final double bubble_price = 0.5;

    /**
    Price for adding a honey bubble topping
    */
    public static final double honey_bubble_price = 0.75;

    /**
    Price for adding a rainbow jelly topping
    */
    public static final double rainbow_jelly_price = 0.5;

    /**
    Price for adding a aloe vera topping
    */
    public static final double aloe_vera_price = 0.5;

    /**
    Price for adding a pudding topping
    */
    public static final double pudding_price = 0.9;

    /**
    Price for adding a adzuki topping
    */
    public static final double adzuki_price = 0.75;

    /**
    Price for adding a red bean topping
    */
    public static final double red_bean_price = 0.3;

    /**
    Price for adding a black bean topping
    */
    public static final double black_bean_price = 0.2;

// Checkboxes for drink topping

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

// METHODS //

    /**
    Constructs an ToppingPanel with default values for instance fields
    */
    public ToppingPanel(){

// Create drink topping choice panel
        super(new BorderLayout());
        add(topping_panel, BorderLayout.CENTER);
        topping_panel.setLayout(new GridLayout(8, 1));
        topping_panel.setBackground(Color.MAGENTA);
        TitledBorder topping_title = BorderFactory.createTitledBorder("Topping");
        topping_panel.setBorder(topping_title);

// Create and add topping checkboxes
        bubble_chbx  = new JCheckBox(bubble_str);
        bubble_chbx.setActionCommand(bubble_str);

        honey_bubble_chbx  = new JCheckBox(honey_bubble_str);
        honey_bubble_chbx.setActionCommand(honey_bubble_str);

        rainbow_jelly_chbx  = new JCheckBox(rainbow_jelly_str);
        rainbow_jelly_chbx.setActionCommand(rainbow_jelly_str);

        aloe_vera_chbx  = new JCheckBox(aloe_vera_str);
        aloe_vera_chbx.setActionCommand(aloe_vera_str);

        pudding_chbx  = new JCheckBox(pudding_str);
        pudding_chbx.setActionCommand(pudding_str);

        adzuki_chbx  = new JCheckBox(adzuki_str);
        adzuki_chbx.setActionCommand(adzuki_str);

        red_bean_chbx  = new JCheckBox(red_bean_str);
        red_bean_chbx.setActionCommand(red_bean_str);

        black_bean_chbx  = new JCheckBox(black_bean_str);
        black_bean_chbx.setActionCommand(black_bean_str);

        topping_panel.add(bubble_chbx);
        topping_panel.add(honey_bubble_chbx);
        topping_panel.add(rainbow_jelly_chbx);
        topping_panel.add(aloe_vera_chbx);
        topping_panel.add(pudding_chbx);
        topping_panel.add(adzuki_chbx);
        topping_panel.add(red_bean_chbx);
        topping_panel.add(black_bean_chbx);
    }
}
