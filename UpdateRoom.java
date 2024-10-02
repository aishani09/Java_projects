package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateRoom extends JFrame {
    UpdateRoom() {
        // Main Gradient Panel
        JPanel panel = new GradientPanel(); // Change here for gradient background
        panel.setBounds(5, 5, 940, 490);
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/update.png"));
        Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500, 60, 300, 300);
        panel.add(label);

        JLabel label1 = new JLabel("Update Room Status");
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
        label3.setBounds(25, 130, 150, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        label3.setForeground(Color.BLACK);
        panel.add(label3);

        JTextField textField3 = new JTextField();
        textField3.setBounds(250, 130, 140, 20);
        panel.add(textField3);

        JLabel label4 = new JLabel("Availability : ");
        label4.setBounds(25, 175, 100, 20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        label4.setForeground(Color.BLACK);
        panel.add(label4);

        JTextField textField4 = new JTextField();
        textField4.setBounds(250, 175, 140, 20);
        panel.add(textField4);

        JLabel label5 = new JLabel("Cleaning Status : ");
        label5.setBounds(25, 215, 160, 20);
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        label5.setForeground(Color.BLACK);
        panel.add(label5);

        JTextField textField5 = new JTextField();
        textField5.setBounds(250, 215, 140, 20);
        panel.add(textField5);

        JButton update = new JButton("Update");
        update.setBounds(120, 310, 90, 23);
        update.setBackground(Color.black);
        update.setForeground(Color.WHITE);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    con C = new con();
                    String status = textField5.getText();
                    C.statement.executeUpdate("update room set cleaning_status = '" + status + "' where roomnumber = '" + textField3.getText() + "'");

                    JOptionPane.showMessageDialog(null, "Updated Successfully");
                    setVisible(false);

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(180, 355, 90, 23);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        panel.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JButton check = new JButton("Check");
        check.setBounds(60, 355, 90, 23);
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
                    }

                    ResultSet resultSet1 = c.statement.executeQuery("select * from room where roomnumber = '" + textField3.getText() + "'");
                    while (resultSet1.next()) {
                        textField4.setText(resultSet1.getString("availability"));
                        textField5.setText(resultSet1.getString("cleaning_status"));
                    }

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        setLayout(null);
        setSize(950, 450);
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
        new UpdateRoom();
    }
}
