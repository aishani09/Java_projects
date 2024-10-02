package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {
    Department() {
        // Create a custom JPanel with a gradient background
        GradientPanel gradientPanel = new GradientPanel();
        gradientPanel.setBounds(5, 5, 690, 490);
        gradientPanel.setLayout(null);
        add(gradientPanel);

        // Create the JTable and make it transparent
        JTable table = new JTable();
        table.setBounds(0, 40, 700, 350);
        table.setBackground(new Color(0, 0, 0, 0)); // Set to transparent
        table.setForeground(Color.black);
        table.setFillsViewportHeight(true); // Allow the table to fill the viewport

        // Add the table to a JScrollPane for better visibility and scrolling
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 40, 700, 350);
        scrollPane.setOpaque(false); // Make the scroll pane transparent
        scrollPane.getViewport().setOpaque(false); // Make the viewport transparent
        gradientPanel.add(scrollPane);

        try {
            con c = new con();
            String departmentInfo = "select * from department";
            ResultSet resultSet = c.statement.executeQuery(departmentInfo);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton back = new JButton("BACK");
        back.setBounds(280, 410, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        gradientPanel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JLabel label1 = new JLabel("Department");
        label1.setBounds(145, 11, 105, 20);
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        gradientPanel.add(label1);

        JLabel label2 = new JLabel("Budget");
        label2.setBounds(431, 11, 105, 20);
        label2.setForeground(Color.BLACK);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        gradientPanel.add(label2);

        setUndecorated(true);
        setLayout(null);
        setLocation(550, 150);
        setSize(700, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Department();
    }
}

// Custom JPanel class to implement gradient background
class GradientPanel4 extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();

        // Define a gradient from top to bottom
        Color color1 = new Color(0, 120, 166);  // Navy blue
        Color color2 = new Color(93, 224, 230); // Light blue
        GradientPaint gp = new GradientPaint(0, 0, color1, 0, height, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);
    }
}
