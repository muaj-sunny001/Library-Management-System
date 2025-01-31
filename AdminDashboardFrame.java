package frames;

import panels.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminDashboardFrame extends JFrame {

    private JPanel contentPanel;
    private JPanel logoPanel, navigationPanel;
    private JButton logoutButton;
    private JButton manageBookButton, manageMemberButton, manageStaffsButton;

    public AdminDashboardFrame() {

        setTitle("Admin Dashboard");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        logoPanel = new JPanel();
        logoPanel.setBounds(0, 0, 1000, 60);
        logoPanel.setLayout(null);
        logoPanel.setBackground(new Color(0, 51, 102));

        JLabel libraryName = new JLabel("Students Library");
        libraryName.setFont(new Font("Arial", Font.BOLD, 24));
        libraryName.setForeground(Color.WHITE);
        libraryName.setBounds(20, 10, 300, 40);
        logoPanel.add(libraryName);

        logoutButton = new JButton("Logout");
        logoutButton.setBounds(860, 10, 100, 40);
        logoutButton.setFont(new Font("Arial", Font.BOLD, 16));
        logoutButton.setBackground(new Color(30, 144, 255));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setFocusPainted(false);
        logoutButton.setBorderPainted(false);
        logoutButton.setOpaque(true);
        logoPanel.add(logoutButton);

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginFrame();
            }
        });

        navigationPanel = new JPanel();
        navigationPanel.setBounds(0, 60, 1000, 50);
        navigationPanel.setLayout(new GridLayout(1, 3, 10, 0));
        navigationPanel.setBackground(new Color(100, 149, 237));

        manageBookButton = createNavigationButton("Books Collection");
        manageStaffsButton = createNavigationButton("Manage Staffs");
        manageMemberButton = createNavigationButton("Manage Members");

        navigationPanel.add(manageBookButton);
        navigationPanel.add(manageStaffsButton);
        navigationPanel.add(manageMemberButton);

        contentPanel = new JPanel(new CardLayout());
        contentPanel.setBounds(0, 110, 1000, 590);
        contentPanel.setBackground(new Color(255, 255, 255));

        contentPanel.add(new ManageBookPanelAdmin(), "Books Collection");
        contentPanel.add(new ManageStaffPanelAdmin(), "Manage Staffs");
        contentPanel.add(new ManageMemberPanelAdmin(), "Manage Members");
        

        manageBookButton.addActionListener(e -> switchPanel("Books Collection"));
        manageStaffsButton.addActionListener(e -> switchPanel("Manage Staffs"));
        manageMemberButton.addActionListener(e -> switchPanel("Manage Members"));
        

        add(logoPanel);
        add(navigationPanel);
        add(contentPanel);

        switchPanel("Books Collection");
        setVisible(true);
    }

    private JButton createNavigationButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setBackground(new Color(65, 105, 225));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
        return button;
    }

    private void switchPanel(String section) {
        CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
        cardLayout.show(contentPanel, section);

        resetButtonColors();

        switch (section) {
            case "Books Collection":
                manageBookButton.setBackground(new Color(30, 144, 255));
                break;

            case "Manage Staffs":
                manageStaffsButton.setBackground(new Color(30, 144, 255));
                break;
            case "Manage Members":
                manageMemberButton.setBackground(new Color(30, 144, 255));
                break;

        }
    }

    private void resetButtonColors() {
        manageBookButton.setBackground(new Color(65, 105, 225));
        manageStaffsButton.setBackground(new Color(65, 105, 225));
        manageMemberButton.setBackground(new Color(65, 105, 225));
        
    }

}
