package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheck extends JFrame {
    UpdateCheck() {
        // Main Gradient Panel
        JPanel panel = new GradientPanel();
        panel.setBounds(5, 5, 940, 490);
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500, 60, 300, 300);
        panel.add(label);

        JLabel label1 = new JLabel("Check-In Details");
        label1.setBounds(124, 11, 222, 25);
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setForeground(Color.BLACK);
        panel.add(label1);

        JLabel label2 = new JLabel("ID : ");
        label2.setBounds(25, 88, 46, 14);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        label2.setForeground(Color.BLACK);
        panel.add(label2);

        Choice c = new Choice();
        c.setBounds(248, 85, 140, 20);
        panel.add(c);

        try {
            con C = new con();
            ResultSet resultSet = C.statement.executeQuery("select * from customer");
            while (resultSet.next()) {
                c.add(resultSet.getString("number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number : ");
        label3.setBounds(25, 130, 150, 14);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        label3.setForeground(Color.BLACK);
        panel.add(label3);

        JTextField textField3 = new JTextField();
        textField3.setBounds(250, 130, 140, 20);
        panel.add(textField3);

        JLabel label4 = new JLabel("Name : ");
        label4.setBounds(25, 175, 100, 14);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        label4.setForeground(Color.BLACK);
        panel.add(label4);

        JTextField textField4 = new JTextField();
        textField4.setBounds(250, 175, 140, 20);
        panel.add(textField4);

        JLabel label5 = new JLabel("Checked In : ");
        label5.setBounds(25, 215, 100, 14);
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        label5.setForeground(Color.BLACK);
        panel.add(label5);

        JTextField textField5 = new JTextField();
        textField5.setBounds(250, 215, 140, 20);
        panel.add(textField5);

        JLabel label6 = new JLabel("Amount Paid (Rs) : ");
        label6.setBounds(25, 260, 150, 14);
        label6.setFont(new Font("Tahoma", Font.BOLD, 14));
        label6.setForeground(Color.BLACK);
        panel.add(label6);

        JTextField textField6 = new JTextField();
        textField6.setBounds(250, 260, 140, 20);
        panel.add(textField6);

        JLabel label7 = new JLabel("Pending Amount : ");
        label7.setBounds(25, 300, 150, 14);
        label7.setFont(new Font("Tahoma", Font.BOLD, 14));
        label7.setForeground(Color.BLACK);
        panel.add(label7);

        JTextField textField7 = new JTextField();
        textField7.setBounds(250, 300, 140, 20);
        panel.add(textField7);

        JButton update = new JButton("Update");
        update.setBounds(60, 380, 90, 23);
        update.setBackground(Color.black);
        update.setForeground(Color.WHITE);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    con C = new con();
                    String q = c.getSelectedItem();
                    String room = textField3.getText();
                    String name = textField4.getText();
                    String check = textField5.getText();
                    String amount = textField6.getText();
                    C.statement.executeUpdate("update customer set room = '" + room + "', name = '" + name + "', checkin = '" + check + "', deposit = '" + amount + "' where number = '" + q + "'");
                    JOptionPane.showMessageDialog(null, "Updated Successfully");
                    setVisible(false);

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(170, 380, 90, 23);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        panel.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add functionality to go back to the previous screen
            }
        });

        JButton check = new JButton("Check");
        check.setBounds(280, 380, 90, 23);
        check.setBackground(Color.black);
        check.setForeground(Color.WHITE);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = c.getSelectedItem();
                String q = "select * from customer where number = '" + id + "'";
                try {
                    con c = new con();
                    ResultSet resultSet = c.statement.executeQuery(q);

                    while (resultSet.next()) {
                        textField3.setText(resultSet.getString("room"));
                        textField4.setText(resultSet.getString("name"));
                        textField5.setText(resultSet.getString("checkin"));
                        textField6.setText(resultSet.getString("deposit"));
                    }

                    ResultSet resultSet1 = c.statement.executeQuery("select * from room where roomnumber = '" + textField3.getText() + "'");
                    while (resultSet1.next()) {
                        String price = resultSet1.getString("price");
                        int amountPaid = Integer.parseInt(price) - Integer.parseInt(textField6.getText());
                        textField7.setText("" + amountPaid);
                    }

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        setLayout(null);
        setSize(950, 500);
        setLocation(400, 200);
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
        new UpdateCheck();
    }
}
