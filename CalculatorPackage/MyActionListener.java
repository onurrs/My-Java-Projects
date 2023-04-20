package CalculatorPackage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {

    private char op;
    private int num1, num2;
    private final JTextField textField;

    public MyActionListener(JTextField textField){
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        char ch = e.getActionCommand().charAt(0);

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
            case 'C':
                op = '\0';
                num1 = 0;
                num2 = 0;
                textField.setText("");
                break;
            case '=':
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
