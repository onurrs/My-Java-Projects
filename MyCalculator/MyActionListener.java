/*
 *   Author: Haci Onur Sogut
 *   Date: 27.04.2023 (Update: 08.05.2023)
 *   Description: Action and Key Listener for the calculator
 */

package MyCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyActionListener implements ActionListener, KeyListener {

    private char op, ch;
    private int num1, num2;
    private final JTextField textField;
    private int prevNum;
    private int prevCh;
    private boolean enterWasPressed = false;

    public MyActionListener(JTextField textField) {
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {        //for pressing a button on the calculator (frame)
        ch = e.getActionCommand().charAt(0);
        buttonOrKeyPressed(ch);
    }

    @Override
    public void keyTyped(KeyEvent e) {      //for pressing a key on the keyboard
        ch = e.getKeyChar();
        buttonOrKeyPressed(ch);
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    private void buttonOrKeyPressed(char ch) {
        switch (ch) {
            case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> {      //a number was pressed
                if (enterWasPressed && op == '\0') {        //if enter was the previous button and operator is not set: enters a new number
                    enterWasPressed = false;
                    num1 = Integer.parseInt(String.valueOf(ch));
                    prevCh = '\0';
                    prevNum = 0;
                    textField.setText(num1 + "");
                    break;
                }
                if (op == '\0') {       //first number is being created
                    num1 = num1 * 10 + Integer.parseInt(String.valueOf(ch));
                    textField.setText(num1 + "");
                } else {
                    num2 = num2 * 10 + Integer.parseInt(String.valueOf(ch));        //second number is being created because user has an operator
                    textField.setText(num1 + " " + op + " " + num2);
                }
            }
            case '+' -> {
                anotherCalculation(op);   //user clicked another operator to keep calculating instead pressing '=' (enter)
                op = '+';
                textField.setText(num1 + " " + op);
            }
            case '-' -> {
                anotherCalculation(op);
                op = '-';
                textField.setText(num1 + " " + op);
            }
            case '/' -> {
                anotherCalculation(op);
                op = '/';
                textField.setText((num1 + " " + op));
            }
            case '*' -> {
                anotherCalculation(op);
                op = '*';
                textField.setText(num1 + " " + op);
            }
            case 8, 'C', 127 -> { //user pressed: backspace C delete
                enterWasPressed = false;
                op = '\0';
                num1 = 0;
                num2 = 0;
                prevNum = 0;
                prevCh = '\0';
                textField.setText("");
            }
            case '=', 10 -> { //enter
                enterWasPressed = true;
                if (op != '\0') {   //if user has an operator in the textfield
                    if (num2 == 0 && op != '/') {  //if user has a second number use it or else use first number itself like second in the calculation (except division)
                        num2 = num1;
                    }
                    prevNum = num2;

                    prevCh = op;
                    switch (op) {
                        case '+':
                            textField.setText(String.valueOf(num1 + num2));
                            num1 = num1 + num2;
                            break;
                        case '-':
                            textField.setText(String.valueOf(num1 - num2));
                            num1 = num1 - num2;
                            break;
                        case '*':
                            textField.setText(String.valueOf(num1 * num2));
                            num1 = num1 * num2;
                            break;
                        case '/':
                            try {
                                textField.setText(String.valueOf(num1 / num2));
                                num1 = num1 / num2;
                                op = '\0';
                                break;
                            } catch (Exception exception) {
                                textField.setText("Division by Zero!");
                                num1 = 0;
                                break;
                            }
                    }
                    num2 = 0;   //reset number 2 and operator after calculation
                    op = '\0';
                } else {    //if user did not enter second number, and has an operator and operand in memory, make repetitive calculation
                    switch (prevCh) {
                        case '+' -> {
                            textField.setText(String.valueOf(num1 + prevNum));
                            num1 = num1 + prevNum;
                        }
                        case '-' -> {
                            textField.setText(String.valueOf(num1 - prevNum));
                            num1 = num1 - prevNum;
                        }
                        case '*' -> {
                            textField.setText(String.valueOf(num1 * prevNum));
                            num1 = num1 * prevNum;
                        }
                        case '/' -> {
                            textField.setText(String.valueOf(num1 / prevNum));
                            num1 = num1 / prevNum;
                        }
                    }
                }
            }
        }
    }

    private void anotherCalculation(char op) {      ////user clicked another operator to keep calculating instead pressing '=' (enter)
        enterWasPressed = false;
        if (num2 != 0) {        //default num2 is 0, so ++++ and ---- is okay but **** and //// is semantic error
            switch (op) {
                case '+' -> num1 += num2;
                case '-' -> num1 -= num2;
                case '*' -> num1 *= num2;
                case '/' -> num1 /= num2;
            }
        }
        num2 = 0;
    }
}
