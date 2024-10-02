package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addDriver extends JFrame implements ActionListener {
    JTextField nameText, ageText, carCText, carNText, locText;
    JComboBox comboBox, comboBox1;
    JButton add, back;

    addDriver(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,490);
        panel.setBackground(Color.PINK);
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("Add Drivers");
        label.setBounds(194,10,200,22);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Tahoma", Font.BOLD, 22));
        panel.add(label);

        JLabel name = new JLabel("Name");
        name.setBounds(64,70,102,22);
        name.setFont(new Font("Tahoma", Font.BOLD, 16));
        name.setForeground(Color.BLACK);
        panel.add(name);

        nameText = new JTextField();
        nameText.setBounds(174, 70, 156, 20);
        nameText.setForeground(Color.black);
        nameText.setFont(new Font("Tahoma", Font.BOLD, 16));
        nameText.setBackground(Color.white);
        panel.add(nameText);


        JLabel age = new JLabel("Age");
        age.setBounds(64,110,102,22);
        age.setFont(new Font("Tahoma", Font.BOLD, 16));
        age.setForeground(Color.BLACK);
        panel.add(age);

        ageText = new JTextField();
        ageText.setBounds(174, 110, 156, 20);
        ageText.setForeground(Color.black);
        ageText.setFont(new Font("Tahoma", Font.BOLD, 16));
        ageText.setBackground(Color.white);
        panel.add(ageText);


        JLabel gender = new JLabel("Gender");
        gender.setBounds(64,150,102,22);
        gender.setFont(new Font("Tahoma", Font.BOLD, 16));
        gender.setForeground(Color.BLACK);
        panel.add(gender);

        comboBox = new JComboBox(new String[]{"Male", "Female"});
        comboBox.setBounds(176,150,154,20);
        comboBox.setForeground(Color.black);
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 16));
        comboBox.setBackground(Color.white);
        panel.add(comboBox);


        JLabel carC = new JLabel("Company");
        carC.setBounds(64,190,102,22);
        carC.setFont(new Font("Tahoma", Font.BOLD, 16));
        carC.setForeground(Color.BLACK);
        panel.add(carC);

        carCText = new JTextField();
        carCText.setBounds(174, 190, 156, 20);
        carCText.setForeground(Color.black);
        carCText.setFont(new Font("Tahoma", Font.BOLD, 16));
        carCText.setBackground(Color.white);
        panel.add(carCText);


        JLabel carN = new JLabel("Car Name");
        carN .setBounds(64,230,102,22);
        carN .setFont(new Font("Tahoma", Font.BOLD, 16));
        carN .setForeground(Color.BLACK);
        panel.add(carN );

        carNText = new JTextField();
        carNText.setBounds(174, 230, 156, 20);
        carNText.setForeground(Color.black);
        carNText.setFont(new Font("Tahoma", Font.BOLD, 16));
        carNText.setBackground(Color.white);
        panel.add(carNText);


        JLabel available = new JLabel("Available");
        available.setBounds(64,270,102,22);
        available.setFont(new Font("Tahoma", Font.BOLD, 16));
        available.setForeground(Color.BLACK);
        panel.add(available);

        comboBox1 = new JComboBox(new String[]{"Yes", "No"});
        comboBox1.setBounds(176,270,154,20);
        comboBox1.setForeground(Color.black);
        comboBox1.setFont(new Font("Tahoma", Font.BOLD, 16));
        comboBox1.setBackground(Color.white);
        panel.add(comboBox1);


        JLabel loc = new JLabel("Location");
        loc.setBounds(64,310,102,22);
        loc.setFont(new Font("Tahoma", Font.BOLD, 16));
        loc.setForeground(Color.BLACK);
        panel.add(loc);

        locText = new JTextField();
        locText.setBounds(174, 310, 156, 20);
        locText.setForeground(Color.black);
        locText.setFont(new Font("Tahoma", Font.BOLD, 16));
        locText.setBackground(Color.white);
        panel.add(locText);

        add = new JButton("ADD");
        add.setBounds(64,380,111,33);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        panel.add(add);

        back = new JButton("BACK");
        back.setBounds(198,380,111,33);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);


        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/license.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label1 = new JLabel(imageIcon1);
        label1.setBounds(500,60,300,300);
        panel.add(label1);


        setUndecorated(true);
        setLocation(20,200);
        setLayout(null);
        setSize(900,500);
        setVisible(true);




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add){
            String name = nameText.getText();
            String age = ageText.getText();
            String gender = (String) comboBox.getSelectedItem();
            String company = carCText.getText();
            String carname = carNText.getText();
            String available = (String) comboBox1.getSelectedItem();
            String location = locText.getText();
            try{
                con c= new con();
                String q = "insert into driver values('"+name+"', '"+age+"', '"+gender+"', '"+company+"', '"+carname+"', '"+available+"', '"+location+"');";
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Driver added");
                setVisible(false);

            }catch(Exception E){
                E.printStackTrace();
            }

        }else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new addDriver();
    }
}
