package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CustomerInfo extends JFrame {

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

    CustomerInfo() {
        // Use the custom gradient panel for the background
        GradientPanel panel = new GradientPanel();
        panel.setBounds(5, 5, 890, 590);
        panel.setLayout(null);
        add(panel);

        // Create the JTable
        JTable table = new JTable();
        table.setBounds(10, 40, 900, 450);
        table.setBackground(new Color(255, 255, 255, 200)); // Semi-transparent background for the table
        table.setForeground(Color.black);
        table.setShowGrid(false); // Optional: Remove grid lines for a cleaner look
        table.setFillsViewportHeight(true); // Ensures table fills its viewport height
        panel.add(table);

        try {
            con c = new con();
            String q = "select * from Customer";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create column labels
        JLabel id = new JLabel("ID");
        id.setBounds(31, 11, 100, 14);
        id.setForeground(Color.black);
        id.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(id);

        JLabel number = new JLabel("Number");
        number.setBounds(150, 11, 100, 14);
        number.setForeground(Color.black);
        number.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(number);

        JLabel name = new JLabel("Name");
        name.setBounds(270, 11, 100, 14);
        name.setForeground(Color.black);
        name.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(name);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(360, 11, 100, 14);
        gender.setForeground(Color.black);
        gender.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(gender);

        JLabel country = new JLabel("Country");
        country.setBounds(480, 11, 100, 25);
        country.setForeground(Color.black);
        country.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(country);

        JLabel room = new JLabel("Room");
        room.setBounds(600, 11, 100, 14);
        room.setForeground(Color.black);
        room.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(room);

        JLabel time = new JLabel("CI Time");
        time.setBounds(680, 11, 100, 14);
        time.setForeground(Color.black);
        time.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(time);

        JLabel deposit = new JLabel("Deposit");
        deposit.setBounds(800, 11, 100, 25);
        deposit.setForeground(Color.black);
        deposit.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(deposit);

        JButton back = new JButton("Back");
        back.setBounds(420, 510, 120, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setLayout(null);
        setSize(900, 600);
        setLocation(500, 100);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CustomerInfo();
    }
}
