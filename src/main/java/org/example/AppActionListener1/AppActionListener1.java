package org.example.AppActionListener1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppActionListener1 implements ActionListener {
    JFrame frame = new JFrame("message");
    JLabel label = new JLabel("Cancel Button Clicked");

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equalsIgnoreCase("cancel")) {

            System.out.println("cancel buttion clicked");


            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            double width = screenSize.getWidth();
            double height = screenSize.getHeight();
            this.frame.setBounds((int) (width / 2), (int) height / 2, 200, 100);
            this.label.setBounds(20, 20, 100, 20);
            this.frame.add(this.label);
            this.frame.setVisible(true);
            new JDialog(frame, "Cancel clicked", true);


        }
    }
}
