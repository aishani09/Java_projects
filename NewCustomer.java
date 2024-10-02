package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class NewCustomer extends JFrame implements ActionListener {
    JComboBox comboBox;
    JTextField textFieldNumber, textName, textCountry, textDeposit;
    JRadioButton r1, r2;
    Choice c1;
    JLabel date;
    JButton add, back;

    NewCustomer() {
        // Create a custom JPanel with a gradient background
        GradientPanel gradientPanel = new GradientPanel();
        gradientPanel.setLayout(null);
        add(gradientPanel);

        // Setting the panel properties
        gradientPanel.setBounds(5, 5, 840, 540);

        // Image and labels
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/customer.png"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel imgLabel = new JLabel(imageIcon1);
        imgLabel.setBounds(550, 150, 200, 200);
        gradientPanel.add(imgLabel);

        JLabel labelName = new JLabel("NEW CUSTOMER FORM");
        labelName.setBounds(118, 11, 260, 53);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelName.setForeground(Color.BLACK);
        gradientPanel.add(labelName);

        JLabel labelID = new JLabel("ID:");
        labelID.setBounds(35, 76, 200, 14);
        labelID.setForeground(Color.BLACK);
        labelID.setFont(new Font("Tahoma", Font.BOLD, 14));
        gradientPanel.add(labelID);

        comboBox = new JComboBox(new String[] {"Passport", "Aadhar Card", "Voter ID", "Driving License"});
        comboBox.setBounds(271, 73, 150, 20);
        comboBox.setForeground(Color.BLACK);
        comboBox.setBackground(Color.white);
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        gradientPanel.add(comboBox);

        JLabel labelNumber = new JLabel("Number:");
        labelNumber.setBounds(35, 111, 200, 14);
        labelNumber.setForeground(Color.BLACK);
        labelNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
        gradientPanel.add(labelNumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271, 111, 150, 20);
        gradientPanel.add(textFieldNumber);

        JLabel labelname = new JLabel("Name:");
        labelname.setBounds(35, 151, 200, 14);
        labelname.setForeground(Color.BLACK);
        labelname.setFont(new Font("Tahoma", Font.BOLD, 14));
        gradientPanel.add(labelname);

        textName = new JTextField();
        textName.setBounds(271, 151, 150, 20);
        gradientPanel.add(textName);

        JLabel labelGender = new JLabel("Gender:");
        labelGender.setBounds(35, 191, 200, 14);
        labelGender.setForeground(Color.BLACK);
        labelGender.setFont(new Font("Tahoma", Font.BOLD, 14));
        gradientPanel.add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma", Font.BOLD, 14));
        r1.setForeground(Color.BLACK);
        r1.setBounds(271, 191, 80, 14);
        gradientPanel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma", Font.BOLD, 14));
        r2.setForeground(Color.BLACK);
        r2.setBounds(350, 191, 80, 14);
        gradientPanel.add(r2);

        JLabel labelCountry = new JLabel("Country:");
        labelCountry.setBounds(35, 231, 200, 20);
        labelCountry.setForeground(Color.BLACK);
        labelCountry.setFont(new Font("Tahoma", Font.BOLD, 14));
        gradientPanel.add(labelCountry);

        textCountry = new JTextField();
        textCountry.setBounds(271, 231, 150, 20);
        gradientPanel.add(textCountry);

        JLabel labelRoom = new JLabel("Allocated Room No.:");
        labelRoom.setBounds(35, 274, 200, 20);
        labelRoom.setForeground(Color.BLACK);
        labelRoom.setFont(new Font("Tahoma", Font.BOLD, 14));
        gradientPanel.add(labelRoom);

        c1 = new Choice();
        try {
            con c = new con();
            ResultSet resultSet = c.statement.executeQuery("select * from room");
            while (resultSet.next()) {
                c1.add(resultSet.getString("roomnumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        c1.setBounds(271, 274, 150, 20);
        c1.setFont(new Font("Tahoma", Font.BOLD, 14));
        c1.setForeground(Color.black);
        c1.setBackground(Color.white);
        gradientPanel.add(c1);

        JLabel labelCIS = new JLabel("Checked In:");
        labelCIS.setBounds(35, 316, 200, 20);
        labelCIS.setForeground(Color.BLACK);
        labelCIS.setFont(new Font("Tahoma", Font.BOLD, 14));
        gradientPanel.add(labelCIS);

        Date date1 = new Date();
        date = new JLabel("" + date1);
        date.setBounds(271, 316, 200, 20);
        date.setForeground(Color.BLACK);
        date.setFont(new Font("Tahoma", Font.BOLD, 14));
        gradientPanel.add(date);

        JLabel labelDeposit = new JLabel("Deposit:");
        labelDeposit.setBounds(35, 360, 200, 20);
        labelDeposit.setForeground(Color.BLACK);
        labelDeposit.setFont(new Font("Tahoma", Font.BOLD, 14));
        gradientPanel.add(labelDeposit);

        textDeposit = new JTextField();
        textDeposit.setBounds(271, 360, 200, 20);
        gradientPanel.add(textDeposit);

        add = new JButton("ADD");
        add.setBounds(100, 430, 120, 30);
        add.setForeground(Color.BLACK);
        add.setBackground(Color.white);
        add.addActionListener(this);
        gradientPanel.add(add);

        back = new JButton("BACK");
        back.setBounds(260, 430, 120, 30);
        back.setForeground(Color.BLACK);
        back.setBackground(Color.white);
        back.addActionListener(this);
        gradientPanel.add(back);

        setLayout(null);
        setLocation(500, 150);
        setSize(850, 550);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            con c = new con();
            String radioBTn = null;
            if (r1.isSelected()) {
                radioBTn = "Male";
            } else if (r2.isSelected()) {
                radioBTn = "Female";
            }

            String s1 = (String) comboBox.getSelectedItem();
            String s2 = textFieldNumber.getText();
            String s3 = textName.getText();
            String s4 = radioBTn;
            String s5 = textCountry.getText();
            String s6 = c1.getSelectedItem();
            String s7 = date.getText();
            String s8 = textDeposit.getText();
            try {
                String q = "insert into customer values ('" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "','" + s5 + "','" + s6 + "','" + s7 + "','" + s8 + "')";
                String q1 = "update room set availability = 'Occupied' where roomnumber = " + s6;
                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null, "Added Successfully");
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new NewCustomer();
    }
}

// Custom JPanel class to implement gradient background
class GradientPanel2 extends JPanel {
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
