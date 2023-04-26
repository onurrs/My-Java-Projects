/*
 *   Author: Haci Onur Sogut
 *   Date: 27.04.2023
 *   Description: A simple calculator using Java Swing (Still updating the calculator)
 */

package MyCalculator;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Calculator {
    public static void main(String[] args) {
        createAndShowGUI();
    }

    public static void createAndShowGUI() {

        JFrame frame = new JFrame("One Little Calculator");
        frame.setPreferredSize(new Dimension(300,300));
        frame.setResizable(false);

        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(50,50));
        textField.setEditable(false);
        textField.setFocusable(false);
        textField.setFont(new Font("Arial", Font.BOLD, 18));
        textField.setBackground(Color.decode("#eec4c9")); //light pink
        textField.setForeground(Color.decode("#1560bd")); //light blue
        Border innerTextFieldBorder = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode("#1560bd")); //light blue
        Border outerTextFieldBorder = BorderFactory.createMatteBorder(5, 5, 5, 5, Color.decode("#b57edc")); //lavender color
        textField.setBorder(BorderFactory.createCompoundBorder(outerTextFieldBorder,innerTextFieldBorder));
        textField.setHorizontalAlignment(JTextField.RIGHT);

        MyActionListener actionListener = new MyActionListener(textField);

        frame.addKeyListener(actionListener);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,4));

        panel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        ((GridLayout) panel.getLayout()).setHgap(5);
        ((GridLayout) panel.getLayout()).setVgap(5);
        panel.setBackground(Color.decode("#b57edc")); //lavender color

        JButton n0 = new JButton("0");
        JButton n1 = new JButton("1");
        JButton n2 = new JButton("2");
        JButton n3 = new JButton("3");
        JButton n4 = new JButton("4");
        JButton n5 = new JButton("5");
        JButton n6 = new JButton("6");
        JButton n7 = new JButton("7");
        JButton n8 = new JButton("8");
        JButton n9 = new JButton("9");

        JButton ca = new JButton("*");
        JButton bo = new JButton("/");
        JButton to = new JButton("+");
        JButton ci = new JButton("-");
        JButton es = new JButton("=");
        JButton si = new JButton("C");

        JButton[] buttons = {n1,n2,n3,to,n4,n5,n6,ci,n7,n8,n9,ca,n0,es,si,bo};

        for (JButton button:buttons) {
            button.setFont(new Font("Arial",Font.BOLD,16));
            button.setFocusable(false);
            panel.add(button);
            button.addActionListener(actionListener);
            button.setBorder(BorderFactory.createLineBorder(Color.decode("#1560bd"),1,false));  //lavender color
            button.setForeground(Color.decode("#1560bd")); //light blue
            button.setBackground(Color.decode("#eec4c9")); //light pink
        }

        frame.getContentPane().add(textField, BorderLayout.NORTH);
        frame.getContentPane().add(panel);

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
