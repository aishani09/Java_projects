package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame implements ActionListener {
    JCheckBox checkBox;
    Choice choice;
    JTable table;
    JButton add, back;

    SearchRoom() {
        // Main Gradient Panel
        JPanel panel = new GradientPanel(); // Change here for gradient background
        panel.setBounds(5, 5, 690, 490);
        panel.setLayout(null);
        add(panel);

        JLabel searchForRoom = new JLabel("Search for Room");
        searchForRoom.setBounds(250, 11, 186, 31);
        searchForRoom.setForeground(Color.BLACK);
        searchForRoom.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(searchForRoom);

        JLabel rbt = new JLabel("Room Bed Type:");
        rbt.setBounds(50, 73, 120, 16);
        rbt.setForeground(Color.BLACK);
        rbt.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(rbt);

        JLabel rn = new JLabel("Room Number");
        rn.setBounds(23, 162, 150, 16);
        rn.setForeground(Color.BLACK);
        rn.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(rn);

        JLabel available = new JLabel("Availability");
        available.setBounds(175, 162, 150, 16);
        available.setForeground(Color.BLACK);
        available.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(available);

        JLabel SS = new JLabel("Cleaning Status");
        SS.setBounds(306, 162, 150, 16);
        SS.setForeground(Color.BLACK);
        SS.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(SS);

        JLabel price = new JLabel("Price");
        price.setBounds(458, 162, 150, 16);
        price.setForeground(Color.BLACK);
        price.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(price);

        JLabel BT = new JLabel("Bed Type");
        BT.setBounds(580, 162, 150, 16);
        BT.setForeground(Color.BLACK);
        BT.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(BT);

        checkBox = new JCheckBox("Only Display Available");
        checkBox.setBounds(400, 69, 205, 23);
        checkBox.setForeground(Color.black);
        checkBox.setBackground(new Color(0, 0, 0, 0)); // Set transparent background
        panel.add(checkBox);

        choice = new Choice();
        choice.add("Single Bed");
        choice.add("Double Bed");
        choice.setBounds(170, 70, 120, 20);
        panel.add(choice);

        table = new JTable();
        table.setBounds(0, 187, 700, 100);
        table.setBackground(new Color(0, 0, 0, 0)); // Set transparent background
        table.setForeground(Color.black);
        panel.add(table);

        try {
            con c = new con();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            e.printStackTrace();
        }

        add = new JButton("Search");
        add.setBounds(200, 400, 120, 30);
        add.setBackground(Color.BLACK); // Set transparent background
        add.setForeground(Color.white);
        add.addActionListener(this);
        panel.add(add);

        back = new JButton("Back");
        back.setBounds(380, 400, 120, 30);
        back.setBackground(Color.BLACK); // Set transparent background
        back.setForeground(Color.white);
        back.addActionListener(this);
        panel.add(back);

        setUndecorated(true);
        setLayout(null);
        setLocation(500, 200);
        setSize(700, 500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            String Q = "select * from Room where bed_type ='" + choice.getSelectedItem() + "'";
            String Q1 = "select * from Room where availability = 'Available' and bed_type ='" + choice.getSelectedItem() + "'";
            try {
                con c = new con();
                ResultSet resultSet = c.statement.executeQuery(Q);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
                if (checkBox.isSelected()) {
                    ResultSet resultSet1 = c.statement.executeQuery(Q1);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet1));
                }
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
        }
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
        new SearchRoom();
    }
}
