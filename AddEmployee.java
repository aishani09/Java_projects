package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame implements ActionListener {
    JTextField nameText, ageText, salaryText, phoneText, adhaarText, emailText;
    JButton add, back;
    JRadioButton male, female;
    JComboBox comboBox;

    AddEmployee(){


        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,490);
        panel.setLayout(null);
        panel.setBackground(Color.PINK);
        add(panel);

        JLabel name = new JLabel("Name");
        name.setBounds(60,30,150,27);
        name.setFont(new Font("serif", Font.BOLD,17));
        name.setForeground(Color.BLACK);
        panel.add(name);


        nameText = new JTextField();
        nameText.setBounds(200,30,150,27);
        nameText.setBackground(Color.white);
        nameText.setFont(new Font("Tahoma", Font.BOLD, 14));
        nameText.setForeground(Color.black);
        panel.add(nameText);


        JLabel age = new JLabel("Age");
        age.setBounds(60,80,150,27);
        age.setFont(new Font("serif", Font.BOLD,17));
        age.setForeground(Color.BLACK);
        panel.add(age);


        ageText = new JTextField();
        ageText.setBounds(200,80,150,27);
        ageText.setBackground(Color.white);
        ageText.setFont(new Font("Tahoma", Font.BOLD, 14));
        ageText.setForeground(Color.black);
        panel.add(ageText);


        JLabel gender = new JLabel("Gender");
        gender.setBounds(60,120,150,27);
        gender.setFont(new Font("serif", Font.BOLD,17));
        gender.setForeground(Color.BLACK);
        panel.add(gender);


        male = new JRadioButton("Male");
        male.setBounds(200,120,67,27);
        male.setBackground(Color.white);
        male.setFont(new Font("Tahoma", Font.BOLD, 14));
        male.setForeground(Color.black);
        panel.add(male);

        female = new JRadioButton("Female");
        female.setBounds(280,120,80,27);
        female.setBackground(Color.white);
        female.setFont(new Font("Tahoma", Font.BOLD, 14));
        female.setForeground(Color.black);
        panel.add(female);


        JLabel job = new JLabel("Job");
        job.setBounds(60,170,150,27);
        job.setFont(new Font("serif", Font.BOLD, 17));
        job.setForeground(Color.BLACK);
        panel.add(job);


        comboBox = new JComboBox(new String[]{"Front Desk","Housekeeping", "Kitchen Staff", "Room Service", "Manager", "Accountant", "Chef"});
        comboBox.setBackground(Color.white);
        comboBox.setBounds(200,170,150,30);
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        comboBox.setForeground(Color.black);
        panel.add(comboBox);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(60,220,150,27);
        salary.setFont(new Font("serif", Font.BOLD,17));
        salary.setForeground(Color.BLACK);
        panel.add(salary);


        salaryText = new JTextField();
        salaryText.setBounds(200,220,150,27);
        salaryText.setBackground(Color.white);
        salaryText.setFont(new Font("Tahoma", Font.BOLD, 14));
        salaryText.setForeground(Color.black);
        panel.add(salaryText);


        JLabel phone = new JLabel("Phone");
        phone.setBounds(60,270,150,27);
        phone.setFont(new Font("serif", Font.BOLD,17));
        phone.setForeground(Color.BLACK);
        panel.add(phone);

        phoneText = new JTextField();
        phoneText.setBounds(200,270,150,27);
        phoneText.setBackground(Color.white);
        phoneText.setFont(new Font("Tahoma", Font.BOLD, 14));
        phoneText.setForeground(Color.black);
        panel.add(phoneText);


        JLabel adhaar = new JLabel("Adhaar");
        adhaar.setBounds(60,320,150,27);
        adhaar.setFont(new Font("serif", Font.BOLD,17));
        adhaar.setForeground(Color.BLACK);
        panel.add(adhaar);

        adhaarText = new JTextField();
        adhaarText.setBounds(200,320,150,27);
        adhaarText.setBackground(Color.white);
        adhaarText.setFont(new Font("Tahoma", Font.BOLD, 14));
        adhaarText.setForeground(Color.black);
        panel.add(adhaarText);


        JLabel email = new JLabel("Email Id");
        email.setBounds(60,370,150,27);
        email.setFont(new Font("serif", Font.BOLD,17));
        email.setForeground(Color.BLACK);
        panel.add(email);

        emailText = new JTextField();
        emailText.setBounds(200,370,150,27);
        emailText.setBackground(Color.white);
        emailText.setFont(new Font("Tahoma", Font.BOLD, 14));
        emailText.setForeground(Color.black);
        panel.add(emailText);


        JLabel AED = new JLabel("Add Employee Details");
        AED.setBounds(450,24,445,35);
        AED.setFont(new Font("Tahoma", Font.BOLD,31));
        AED.setForeground(Color.BLACK);
        panel.add(AED);

        add = new JButton("ADD");
        add.setBounds(200,420,100,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        panel.add(add);


        back = new JButton("BACK");
        back.setBounds(310,420,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);


        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/addemp.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,100,300,300);
        panel.add(label);



        setUndecorated(true);
        setLocation(60,160);
        setLayout(null);
        setSize(900,500);
        setVisible(true);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            String name = nameText.getText();
            String age = ageText.getText();
            String salary = salaryText.getText();
            String phone = phoneText.getText();
            String email = emailText.getText();
            String aadhar = adhaarText.getText();
            String job = (String) comboBox.getSelectedItem();
            String gender = null;
            if(male.isSelected()){
                gender="Male";
            }else if(female.isSelected()){
                gender="Female";
            }
            try{
                con c = new con();
                String q = "insert into employee values('"+name+"', '"+age+"', '"+gender+"', '"+job+"', '"+salary+"', '"+phone+"', '"+email+"', '"+aadhar+"')";
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Employee added");
                setVisible(false);
            }catch(Exception E){
                E.printStackTrace();
            }

        }else{
            setVisible(false);

        }
    }

    public static void main(String[] args) {
        new AddEmployee();

    }
}
