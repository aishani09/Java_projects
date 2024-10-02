package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee extends JFrame {
    Employee() {
        // Create a custom JPanel with a gradient background
        GradientPanel gradientPanel = new GradientPanel();
        gradientPanel.setBounds(5, 5, 990, 590);
        gradientPanel.setLayout(null);
        add(gradientPanel);

        // Create the JTable and make it transparent
        JTable table = new JTable();
        table.setBounds(10, 34, 980, 450);
        table.setForeground(Color.BLACK);
        table.setBackground(new Color(0, 0, 0, 0)); // Set to transparent
        table.setFillsViewportHeight(true); // Allow the table to fill the viewport

        // Add the table to a JScrollPane for better visibility and scrolling
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 34, 980, 450);
        scrollPane.setOpaque(false); // Make the scroll pane transparent
        scrollPane.getViewport().setOpaque(false); // Make the viewport transparent
        gradientPanel.add(scrollPane);

        try {
            con c = new con();
            String employeeSQL = "select * from Employee";
            ResultSet resultSet = c.statement.executeQuery(employeeSQL);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton back = new JButton("BACK");
        back.setBounds(350, 500, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        gradientPanel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JLabel name = new JLabel("Name");
        name.setBounds(41, 11, 70, 19);
        name.setForeground(Color.BLACK);
        name.setFont(new Font("Tahoma", Font.BOLD, 14));
        gradientPanel.add(name);

        JLabel age = new JLabel("Age");
        age.setBounds(159, 11, 70, 19);
        age.setForeground(Color.BLACK);
        age.setFont(new Font("Tahoma", Font.BOLD, 14));
        gradientPanel.add(age);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(273, 11, 70, 19);
        gender.setForeground(Color.BLACK);
        gender.setFont(new Font("Tahoma", Font.BOLD, 14));
        gradientPanel.add(gender);

        JLabel job = new JLabel("Job");
        job.setBounds(416, 11, 70, 19);
        job.setForeground(Color.BLACK);
        job.setFont(new Font("Tahoma", Font.BOLD, 14));
        gradientPanel.add(job);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(536, 11, 70, 19);
        salary.setForeground(Color.BLACK);
        salary.setFont(new Font("Tahoma", Font.BOLD, 14));
        gradientPanel.add(salary);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(656, 11, 70, 19);
        phone.setForeground(Color.BLACK);
        phone.setFont(new Font("Tahoma", Font.BOLD, 14));
        gradientPanel.add(phone);

        JLabel gmail = new JLabel("Gmail");
        gmail.setBounds(786, 11, 70, 19);
        gmail.setForeground(Color.BLACK);
        gmail.setFont(new Font("Tahoma", Font.BOLD, 14));
        gradientPanel.add(gmail);

        JLabel aadhar = new JLabel("Aadhar");
        aadhar.setBounds(896, 11, 70, 19);
        aadhar.setForeground(Color.BLACK);
        aadhar.setFont(new Font("Tahoma", Font.BOLD, 14));
        gradientPanel.add(aadhar);

        setUndecorated(true);
        setLayout(null);
        setLocation(430, 100);
        setSize(1000, 600);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Employee();
    }
}

// Custom JPanel class to implement gradient background
class GradientPanel extends JPanel {
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
