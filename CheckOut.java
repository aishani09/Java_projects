package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class CheckOut extends JFrame {
    CheckOut() {
        // Main Gradient Panel
        JPanel panel = new GradientPanel();
        panel.setBounds(5, 5, 790, 390);
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("Check-Out");
        label.setBounds(100, 20, 200, 30);
        label.setFont(new Font("Tahoma", Font.BOLD, 20));
        label.setForeground(Color.BLACK);
        panel.add(label);

        JLabel userID = new JLabel("Customer ID");
        userID.setBounds(30, 80, 100, 30);
        userID.setFont(new Font("Tahoma", Font.BOLD, 12));
        userID.setForeground(Color.BLACK);
        panel.add(userID);

        Choice customer = new Choice();
        customer.setBounds(200, 80, 150, 25);
        panel.add(customer);

        JLabel room = new JLabel("Room Number");
        room.setBounds(30, 130, 100, 30);
        room.setFont(new Font("Tahoma", Font.BOLD, 12));
        room.setForeground(Color.BLACK);
        panel.add(room);

        JLabel labelRoomNumber = new JLabel();
        labelRoomNumber.setBounds(200, 130, 100, 30);
        labelRoomNumber.setFont(new Font("Tahoma", Font.BOLD, 12));
        labelRoomNumber.setForeground(Color.BLACK);
        panel.add(labelRoomNumber);

        JLabel checkinTime = new JLabel("Check-In Time");
        checkinTime.setBounds(30, 180, 100, 30);
        checkinTime.setFont(new Font("Tahoma", Font.BOLD, 12));
        checkinTime.setForeground(Color.BLACK);
        panel.add(checkinTime);

        JLabel labelCheckinTime = new JLabel();
        labelCheckinTime.setBounds(200, 180, 200, 30);
        labelCheckinTime.setFont(new Font("Tahoma", Font.BOLD, 12));
        labelCheckinTime.setForeground(Color.BLACK);
        panel.add(labelCheckinTime);

        JLabel checkoutTime = new JLabel("Check-Out Time");
        checkoutTime.setBounds(30, 230, 100, 30);
        checkoutTime.setFont(new Font("Tahoma", Font.BOLD, 12));
        checkoutTime.setForeground(Color.BLACK);
        panel.add(checkoutTime);

        Date date = new Date();
        JLabel labelCheckoutTime = new JLabel("" + date);
        labelCheckoutTime.setBounds(200, 230, 200, 30);
        labelCheckoutTime.setFont(new Font("Tahoma", Font.BOLD, 12));
        labelCheckoutTime.setForeground(Color.BLACK);
        panel.add(labelCheckoutTime);

        try {
            con c = new con();
            ResultSet resultSet = c.statement.executeQuery("select * from customer");
            while (resultSet.next()) {
                customer.add(resultSet.getString("number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton checkout = new JButton("Check out");
        checkout.setBounds(30, 300, 120, 30);
        checkout.setForeground(Color.white);
        checkout.setBackground(Color.BLACK);
        panel.add(checkout);

        checkout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    con cv = new con();
                    cv.statement.executeUpdate("delete from customer where number = '" + customer.getSelectedItem() + "'");
                    cv.statement.executeUpdate("update room set availability='Available' where roomnumber = '" + labelRoomNumber.getText() + "'");
                    JOptionPane.showMessageDialog(null, "Done");
                    setVisible(false);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        JButton check = new JButton("Check");
        check.setBounds(300, 300, 120, 30);
        check.setForeground(Color.white);
        check.setBackground(Color.BLACK);
        panel.add(check);

        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                con c = new con();
                try {
                    ResultSet resultSet = c.statement.executeQuery("select * from customer where number = '" + customer.getSelectedItem() + "'");
                    while (resultSet.next()) {
                        labelRoomNumber.setText(resultSet.getString("room"));
                        labelCheckinTime.setText(resultSet.getString("checkin"));
                    }

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(170, 300, 120, 30);
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setLayout(null);
        setSize(800, 400);
        setLocation(500, 210);
        setVisible(true);
    }

    // GradientPanel class for background gradient
    class GradientPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            int width = getWidth();
            int height = getHeight();

            // Define the gradient colors
            Color color1 = new Color(0, 120, 166);  // Navy blue
            Color color2 = new Color(93, 224, 230); // Light blue

            // Create the gradient
            GradientPaint gp = new GradientPaint(0, 0, color1, 0, height, color2);

            // Apply the gradient to the background
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, width, height);
        }
    }

    public static void main(String[] args) {
        new CheckOut();
    }
}
