package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login2 extends JFrame implements ActionListener {
    JTextField textField1;
    JPasswordField passwordField1;

    JButton b1, b2;

    Login2() {
        // Set JFrame properties
        setLayout(new BorderLayout());
        setLocation(400, 270);
        setSize(600, 300);

        // Create a custom JPanel with a gradient background
        GradientPanel gradientPanel = new GradientPanel();
        gradientPanel.setLayout(null);
        add(gradientPanel, BorderLayout.CENTER);

        JLabel label1 = new JLabel("Username");
        label1.setBounds(40, 20, 100, 30);
        label1.setFont(new Font("Tahoma", Font.BOLD, 16));
        label1.setForeground(Color.WHITE);
        gradientPanel.add(label1);

        JLabel label2 = new JLabel("Password");
        label2.setBounds(40, 70, 100, 30);
        label2.setFont(new Font("Tahoma", Font.BOLD, 16));
        label2.setForeground(Color.WHITE);
        gradientPanel.add(label2);

        textField1 = new JTextField();
        textField1.setBounds(150, 20, 150, 30);
        textField1.setForeground(Color.BLACK);
        textField1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField1.setBackground(Color.WHITE);
        gradientPanel.add(textField1);

        passwordField1 = new JPasswordField();
        passwordField1.setBounds(150, 70, 150, 30);
        passwordField1.setForeground(Color.BLACK);
        passwordField1.setBackground(Color.WHITE);
        gradientPanel.add(passwordField1);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Borcelle (2).png"));
        JLabel label = new JLabel(imageIcon);
        label.setBounds(350, 10, 200, 250);
        gradientPanel.add(label);

        b1 = new JButton("Login");
        b1.setBounds(40, 140, 120, 30);
        b1.setFont(new Font("serif", Font.BOLD, 15));
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        gradientPanel.add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(200, 140, 120, 30);
        b2.setFont(new Font("serif", Font.BOLD, 15));
        b2.setBackground(Color.WHITE);
        b2.setForeground(Color.BLACK);
        b2.addActionListener(this);
        gradientPanel.add(b2);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                con c = new con();
                String user = textField1.getText();
                String pass = passwordField1.getText();
                String q = "select * from login2 where user_name = '" + user + "' and password = '" + pass + "'";
                ResultSet resultSet = c.statement.executeQuery(q);
                if (resultSet.next()) {
                    new Admin();
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid");
                }
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            new Dashboard();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login2();
    }
}

// Custom JPanel class to implement gradient background
class GradientPanel3 extends JPanel {
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
