/*
 *   Author: Haci Onur Sogut
 *   Date: 27.04.2023
 *   Description: Action Listener for the JMenu of the Calculator
 */


package MyCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JMenuActionListener implements ActionListener {

    JFrame frame;

    public JMenuActionListener(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "Resizable" -> frame.setResizable(!frame.isResizable());
            case "Exit" -> System.exit(0);
        }
    }
}
