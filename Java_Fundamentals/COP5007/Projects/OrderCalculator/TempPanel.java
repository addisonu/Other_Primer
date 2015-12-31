/**
Provides all GUI elements and functionality for TempPanel
@version 1.0

Project #: 6
FILE NAME: TempPanel.java
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
Panel for temperature drink options
 */

public class TempPanel extends JPanel{

// INSTANCE VARIABLES //

    /**
    Main panel for a TempPanel object
    */
    public JPanel temp_panel = new JPanel();

// instance variables for temperature prices

    /**
    Price added for a cold drink
    */
    public static final double cold_price = 0.7;

    /**
    String name for a cold drink
    */
    public static String cold_str = "Cold";

    /**
    Price added for a hot drink
    */
    public static final double hot_price = 0.5;

    /**
    String name for a hot drink
    */
    public static String hot_str = "Hot";

// instance variables for method implementation

    /**
    Button group for temperature radio buttons
    */
    ButtonGroup temp_btn_group;

    /**
    Constructs an TempPanel with default values for instance fields
    */
    public TempPanel(){

// Create drink temperature choice panel
        super(new BorderLayout());
        add(temp_panel, BorderLayout.CENTER);
        temp_panel.setLayout(new GridLayout(2, 1));
        temp_panel.setBackground(Color.DARK_GRAY);
        TitledBorder temp_title = BorderFactory.createTitledBorder("Temp");
        temp_panel.setBorder(temp_title);

// Create and add drink temperature radio buttons
        JRadioButton hot_rb = new JRadioButton(hot_str);
        hot_rb.setActionCommand(hot_str);

        JRadioButton cold_rb = new JRadioButton(cold_str, true);
        cold_rb.setActionCommand(cold_str);

        temp_panel.add(cold_rb);
        temp_panel.add(hot_rb);

// Group radio buttons
        temp_btn_group = new ButtonGroup();
        temp_btn_group.add(cold_rb);
        temp_btn_group.add(hot_rb);
    }
}
