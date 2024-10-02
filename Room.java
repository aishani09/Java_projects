package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Room extends JFrame {
    JTable table;
    JButton back;

    Room() {
        // Create a custom JPanel with a gradient background
        GradientPanel gradientPanel = new GradientPanel();
        gradientPanel.setLayout(null);
        add(gradientPanel);

        // Setting the panel properties
        gradientPanel.setBounds(5, 5, 890, 590);

        // Image and labels
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/roomm.png"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(600, 200, 200, 200);
        gradientPanel.add(label);

        table = new JTable();
        table.setBounds(10, 40, 500, 400);
        table.setForeground(Color.BLACK);
        gradientPanel.add(table);

        try {
            con c = new con();
            String RoomInfo = "select * from room;";
            ResultSet resultSet = c.statement.executeQuery(RoomInfo);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        back = new JButton("BACK");
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.setBounds(200, 500, 120, 30);
        gradientPanel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JLabel room = new JLabel("Room No.");
        room.setBounds(12, 15, 80, 19);
        room.setForeground(Color.black);
        room.setFont(new Font("Tahoma", Font.BOLD, 14));
        gradientPanel.add(room);

        JLabel availability = new JLabel("Availability");
        availability.setBounds(119, 15, 80, 19);
        availability.setForeground(Color.black);
        availability.setFont(new Font("Tahoma", Font.BOLD, 14));
        gradientPanel.add(availability);

        JLabel clean = new JLabel("Clean Status");
        clean.setBounds(216, 15, 150, 19);
        clean.setForeground(Color.black);
        clean.setFont(new Font("Tahoma", Font.BOLD, 14));
        gradientPanel.add(clean);

        JLabel price = new JLabel("Price");
        price.setBounds(330, 15, 80, 19);
        price.setForeground(Color.black);
        price.setFont(new Font("Tahoma", Font.BOLD, 14));
        gradientPanel.add(price);

        JLabel bed = new JLabel("Bed Type");
        bed.setBounds(417, 15, 80, 19);
        bed.setForeground(Color.black);
        bed.setFont(new Font("Tahoma", Font.BOLD, 14));
        gradientPanel.add(bed);

        setUndecorated(true);
        setLayout(null);
        setLocation(500, 100);
        setSize(900, 600);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Room();
    }
}

// Custom JPanel class to implement gradient background
class GradientPanel5 extends JPanel {
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
