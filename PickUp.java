package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PickUp extends JFrame {
    PickUp() {
        // Main Gradient Panel
        JPanel panel = new GradientPanel(); // Change here for gradient background
        panel.setBounds(5, 5, 790, 590);
        panel.setLayout(null);
        add(panel);

        JLabel pus = new JLabel("Pick-Up Service");
        pus.setBounds(90, 11, 160, 25);
        pus.setForeground(Color.black);
        pus.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(pus);

        JLabel toc = new JLabel("Type of Cars");
        toc.setBounds(32, 97, 90, 14);
        toc.setForeground(Color.black);
        toc.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(toc);

        Choice c = new Choice();
        c.setBounds(123, 94, 150, 25);
        panel.add(c);

        try {
            con C = new con();
            ResultSet resultSet = C.statement.executeQuery("select * from driver");
            while (resultSet.next()) {
                c.add(resultSet.getString("carname"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        JTable table = new JTable();
        table.setBounds(10, 233, 800, 250);
        table.setBackground(new Color(0, 0, 0, 0)); // Set table background to transparent
        table.setForeground(Color.black);
        panel.add(table);

        try {
            con C = new con();
            String q = "select * from driver";
            ResultSet resultSet = C.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel name = new JLabel("Name");
        name.setBounds(24, 208, 46, 14);
        name.setForeground(Color.black);
        panel.add(name);

        JLabel age = new JLabel("Age");
        age.setBounds(165, 208, 46, 14);
        age.setForeground(Color.black);
        panel.add(age);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(265, 208, 46, 14);
        gender.setForeground(Color.black);
        panel.add(gender);

        JLabel company = new JLabel("Company");
        company.setBounds(365, 208, 100, 14);
        company.setForeground(Color.black);
        panel.add(company);

        JLabel carname = new JLabel("Car Name");
        carname.setBounds(485, 208, 100, 14);
        carname.setForeground(Color.black);
        panel.add(carname);

        JLabel available = new JLabel("Availability");
        available.setBounds(600, 208, 100, 14);
        available.setForeground(Color.black);
        panel.add(available);

        JLabel location = new JLabel("Location");
        location.setBounds(700, 208, 100, 14);
        location.setForeground(Color.black);
        panel.add(location);

        JButton display = new JButton("Display");
        display.setBounds(200, 500, 120, 30);
        display.setBackground(Color.black);
        display.setForeground(Color.WHITE);
        panel.add(display);
        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "select * from driver where carname = '" + c.getSelectedItem() + "'";
                try {
                    con c = new con();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(420, 500, 120, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setLayout(null);
        setSize(800, 600);
        setLocation(500, 100);
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
        new PickUp();
    }
}
