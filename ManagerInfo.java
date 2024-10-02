package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ManagerInfo extends JFrame {
    ManagerInfo() {
        // Main Gradient Panel
        JPanel panel = new GradientPanel();
        panel.setBounds(5, 5, 990, 590);
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10, 34, 980, 450);
        table.setForeground(Color.BLACK);
        table.setBackground(new Color(0, 0, 0, 0)); // Transparent background for the table
        table.setOpaque(false); // Set the table to be non-opaque
        panel.add(table);

        try {
            con c = new con();
            String q = "select * from Employee where job = 'Hotel Manager'";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton back = new JButton("BACK");
        back.setBounds(350, 500, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        // Adding Labels
        addLabel(panel, "Name", 41, 11);
        addLabel(panel, "Age", 159, 11);
        addLabel(panel, "Gender", 273, 11);
        addLabel(panel, "Job", 416, 11);
        addLabel(panel, "Salary", 536, 11);
        addLabel(panel, "Phone", 656, 11);
        addLabel(panel, "Gmail", 786, 11);
        addLabel(panel, "Aadhar", 896, 11);

        setUndecorated(true);
        setLayout(null);
        setLocation(430, 100);
        setSize(1000, 600);
        setVisible(true);
    }

    private void addLabel(JPanel panel, String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 70, 19);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label);
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
        new ManagerInfo();
    }
}
