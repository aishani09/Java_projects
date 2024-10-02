package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends JFrame implements ActionListener {
    JButton add_employee, add_room, add_drivers, logout, back;

    Admin() {
        // Set JFrame properties
        setLayout(new BorderLayout());
        setSize(1950, 1090);
        setLocationRelativeTo(null); // Center the window

        // Create a custom JPanel with a gradient background
        GradientPanel gradientPanel = new GradientPanel();
        gradientPanel.setLayout(null);
        add(gradientPanel, BorderLayout.CENTER);

        add_employee = new JButton("ADD EMPLOYEE");
        add_employee.setBounds(250, 230, 200, 30);
        add_employee.setBackground(Color.WHITE);
        add_employee.setForeground(Color.BLACK);
        add_employee.setFont(new Font("Tahoma", Font.BOLD, 15));
        add_employee.addActionListener(this);
        gradientPanel.add(add_employee);

        add_room = new JButton("ADD ROOM");
        add_room.setBounds(250, 380, 200, 30);
        add_room.setBackground(Color.WHITE);
        add_room.setForeground(Color.BLACK);
        add_room.setFont(new Font("Tahoma", Font.BOLD, 15));
        add_room.addActionListener(this);
        gradientPanel.add(add_room);

        add_drivers = new JButton("ADD DRIVER");
        add_drivers.setBounds(250, 530, 200, 30);
        add_drivers.setBackground(Color.WHITE);
        add_drivers.setForeground(Color.BLACK);
        add_drivers.setFont(new Font("Tahoma", Font.BOLD, 15));
        add_drivers.addActionListener(this);
        gradientPanel.add(add_drivers);

        logout = new JButton("Logout");
        logout.setBounds(10, 700, 95, 30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.setFont(new Font("Tahoma", Font.BOLD, 15));
        logout.addActionListener(this);
        gradientPanel.add(logout);

        back = new JButton("Back");
        back.setBounds(110, 700, 95, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        back.addActionListener(this);
        gradientPanel.add(back);

        // Adding icons
        ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("icon/employees.png"));
        Image l11 = l1.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
        JLabel label = new JLabel(new ImageIcon(l11));
        label.setBounds(70, 180, 120, 120);
        gradientPanel.add(label);

        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("icon/room.png"));
        Image image = imageIcon1.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
        JLabel label1 = new JLabel(new ImageIcon(image));
        label1.setBounds(70, 340, 120, 120);
        gradientPanel.add(label1);

        ImageIcon imageIcon2 = new ImageIcon(ClassLoader.getSystemResource("icon/driver.png"));
        Image image1 = imageIcon2.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
        JLabel label2 = new JLabel(new ImageIcon(image1));
        label2.setBounds(70, 500, 120, 120);
        gradientPanel.add(label2);

        ImageIcon imageIcon3 = new ImageIcon(ClassLoader.getSystemResource("icon/Borcelle (2).png"));
        Image image2 = imageIcon3.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        JLabel label3 = new JLabel(new ImageIcon(image2));
        label3.setBounds(1000, 200, 400, 400);
        gradientPanel.add(label3);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit on close
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add_employee) {
            new AddEmployee();
        } else if (e.getSource() == add_room) {
            new AddRoom();
            setUndecorated(true);
        } else if (e.getSource() == add_drivers) {
            new addDriver();
        } else if (e.getSource() == logout) {
            System.exit(102);
        } else if (e.getSource() == back) {
            new Dashboard();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Admin();
    }
}

// Custom JPanel class to implement gradient background
class GradientPanel1 extends JPanel {
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
