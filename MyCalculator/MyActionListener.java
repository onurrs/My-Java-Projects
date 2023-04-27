/*
 *   Author: Haci Onur Sogut
 *   Date: 27.04.2023
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

    public MyActionListener(JTextField textField){
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ch = e.getActionCommand().charAt(0);
        buttonOrKeyPressed(ch);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        ch = e.getKeyChar();
        buttonOrKeyPressed(ch);
    }

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    private void buttonOrKeyPressed(char ch) {
        switch (ch){
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                if (op == '\0'){
                    num1 = num1*10 + Integer.parseInt(String.valueOf(ch));
                    textField.setText(num1 + "");
                }else {
                    num2 = num2*10 + Integer.parseInt(String.valueOf(ch));
                    textField.setText(num1 + " " + op + " " + num2);
                }
                break;
            case '+':
                op = '+';
                if (num2 != 0)
                    textField.setText(num1 + " " + op + " " + num2);
                else
                    textField.setText(num1 + " " + op);
                break;
            case '-':
                op = '-';
                if (num2 != 0)
                    textField.setText(num1 + " " + op + " " + num2);
                else
                    textField.setText(num1 + " " + op);
                break;
            case '/':
                op = '/';
                if (num2 != 0)
                    textField.setText(num1 + " " + op + " " + num2);
                else
                    textField.setText(num1 + " " + op);
                break;
            case '*':
                op = '*';
                if (num2 != 0)
                    textField.setText(num1 + " " + op + " " + num2);
                else
                    textField.setText(num1 + " " + op);
                break;
            case 8: //backspace
                op = '\0';
                num1 = 0;
                num2 = 0;
                textField.setText("");
                break;
            case '=':
            case 10: //enter
                switch (op){
                    case '+':
                        textField.setText(String.valueOf(num1+num2));
                        num1 = num1+num2;
                        num2 = 0;
                        op = '\0';
                        break;
                    case '-':
                        textField.setText(String.valueOf(num1-num2));
                        num1 = num1-num2;
                        num2 = 0;
                        op = '\0';
                        break;
                    case '*':
                        textField.setText(String.valueOf(num1*num2));
                        num1 = num1*num2;
                        num2 = 0;
                        op = '\0';
                        break;
                    case '/':
                        try {
                            textField.setText(String.valueOf((double) num1/num2));
                            num1 = num1/num2;
                            num2 = 0;
                            op = '\0';
                            break;
                        }catch (Exception exception){
                            textField.setText("Division by Zero!");
                            num1 = 0;
                            num2 = 0;
                            op = '\0';
                            break;
                        }
                }
        }
    }
}
