/*
*   Author: Haci Onur Sogut
*   Date: 25.04.2023
*   Description: A simple calculator using Java Swing
*/

package MyCalculator;

import javax.swing.*;
import java.awt.*;

public class Calculator {
    public static void main(String[] args) {
        createAndShowGUI();
    }

    public static void createAndShowGUI() {

        JFrame frame = new JFrame("One Little Calculator");
        frame.setPreferredSize(new Dimension(300,300));

        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(50,50));
        textField.setEditable(false);
        textField.setFocusable(false);

        MyActionListener actionListener = new MyActionListener(textField);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,4));

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
        for (JButton i:buttons) {
            i.setFocusable(false);
            panel.add(i);
            i.addActionListener(actionListener);
        }

        frame.getContentPane().add(textField, BorderLayout.NORTH);
        frame.getContentPane().add(panel);

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
