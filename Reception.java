package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame {

    public Reception() {
        // Main Gradient Panel
        JPanel mainPanel = new GradientPanel();
        mainPanel.setBounds(280, 5, 1238, 820);
        add(mainPanel);

        // Sidebar Gradient Panel
        JPanel sidebarPanel = new GradientPanel();
        sidebarPanel.setBounds(5, 5, 270, 820);
        add(sidebarPanel);

        // Adding Sidebar Logo
        addSidebarLogo(sidebarPanel);

        // Adding buttons to the sidebar panel
        addSidebarButtons(sidebarPanel);

        // Frame properties
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(1950, 1090);
        setVisible(true);
    }

    // Method to add the logo to the sidebar
    private void addSidebarLogo(JPanel panel) {
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/Borcelle (2).png"));
        Image i2 = i11.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon imageIcon11 = new ImageIcon(i2);
        JLabel label1 = new JLabel(imageIcon11);
        label1.setBounds(5, 530, 250, 250);
        panel.add(label1);
    }

    // Method to create sidebar buttons
    private void addSidebarButtons(JPanel panel) {
        String[] buttonLabels = {
                "New Customer Form", "Room", "Department", "All Employee",
                "Customer Info", "Manager Info", "Checkout", "Update Check-In Details",
                "Update Room Status", "Pickup Service", "Search Room", "Logout", "Back"
        };

        int[] yPositions = {
                30, 70, 110, 150, 190, 230, 270, 310, 350, 390, 430, 470, 470
        };

        ActionListener[] listeners = {
                e -> new NewCustomer(),
                e -> new Room(),
                e -> new Department(),
                e -> new Employee(),
                e -> new CustomerInfo(),
                e -> new ManagerInfo(),
                e -> new CheckOut(),
                e -> new UpdateCheck(),
                e -> new UpdateRoom(),
                e -> new PickUp(),
                e -> new SearchRoom(),
                e -> System.exit(500),
                e -> { setVisible(false); new Dashboard(); }
        };

        for (int i = 0; i < buttonLabels.length; i++) {
            JButton button = createButton(buttonLabels[i], 30, yPositions[i], listeners[i]);
            panel.add(button);
        }
    }

    // Method to create buttons
    private JButton createButton(String text, int x, int y, ActionListener listener) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 200, 30);
        button.setBackground(Color.LIGHT_GRAY);
        button.setForeground(Color.BLACK);
        button.addActionListener(listener);
        return button;
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
        new Reception();
    }
}
