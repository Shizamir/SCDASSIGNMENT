package hospitalmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DoctorFormGUI extends JFrame {
    private JTextField doctorIdTextField, fullNameTextField, fatherNameTextField, emailTextField, contactNoTextField, addressTextField, qualificationTextField, dateOfJoiningTextField;
    private JComboBox<String> genderComboBox, bloodGroupComboBox;
    private JButton saveButton, updateButton, deleteButton, newButton, getDataButton;
    private boolean isDataAvailable = false;

    DoctorDAOImplementation object;
    public DoctorFormGUI() throws ClassNotFoundException, SQLException {
        initializeUI();
        object = new DoctorDAOImplementation();
        
    }

    private void initializeUI() {
        // Set frame properties
        setTitle("Doctor Form");
        setSize(700, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Create labels
        JLabel doctorIdLabel = new JLabel("Doctor ID:");
        JLabel fullNameLabel = new JLabel("Full Name:");
        JLabel fatherNameLabel = new JLabel("Father Name:");
        JLabel emailLabel = new JLabel("Email ID:");
        JLabel contactNoLabel = new JLabel("Contact No:");
        JLabel addressLabel = new JLabel("Address:");
        JLabel qualificationLabel = new JLabel("Qualification:");
        JLabel dateOfJoiningLabel = new JLabel("Date of Joining:");
        JLabel genderLabel = new JLabel("Gender:");
        JLabel bloodGroupLabel = new JLabel("Blood Group:");

        // Create text fields
        doctorIdTextField = new JTextField(15);
        fullNameTextField = new JTextField(15);
        fatherNameTextField = new JTextField(15);
        emailTextField = new JTextField(15);
        contactNoTextField = new JTextField(15);
        addressTextField = new JTextField(15);
        qualificationTextField = new JTextField(15);
        dateOfJoiningTextField = new JTextField(15);

        // Create combo boxes
        genderComboBox = new JComboBox<>(new String[]{"Male", "Female"});
        bloodGroupComboBox = new JComboBox<>(new String[]{"A", "B", "AB", "O"});

        // Create buttons panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());

        // Create buttons
        saveButton = new JButton("Save");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        newButton = new JButton("New");
        getDataButton = new JButton("Get Data");

        // Add buttons to the panel
        buttonsPanel.add(saveButton);
        buttonsPanel.add(updateButton);
        buttonsPanel.add(deleteButton);
        buttonsPanel.add(newButton);
        buttonsPanel.add(getDataButton);

        // Add components to the frame
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(doctorIdLabel, gbc);
        gbc.gridx = 1;
        add(doctorIdTextField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(fullNameLabel, gbc);
        gbc.gridx = 1;
        add(fullNameTextField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(fatherNameLabel, gbc);
        gbc.gridx = 1;
        add(fatherNameTextField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(emailLabel, gbc);
        gbc.gridx = 1;
        add(emailTextField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(contactNoLabel, gbc);
        gbc.gridx = 1;
        add(contactNoTextField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(addressLabel, gbc);
        gbc.gridx = 1;
        add(addressTextField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(qualificationLabel, gbc);
        gbc.gridx = 1;
        add(qualificationTextField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 7;
        add(dateOfJoiningLabel, gbc);
        gbc.gridx = 1;
        add(dateOfJoiningTextField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 8;
        add(genderLabel, gbc);
        gbc.gridx = 1;
        add(genderComboBox, gbc);
        gbc.gridx = 0;
        gbc.gridy = 9;
        add(bloodGroupLabel, gbc);
        gbc.gridx = 1;
        add(bloodGroupComboBox, gbc);
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 2;
        add(buttonsPanel, gbc);
        
        
        updateButton.setEnabled(isDataAvailable);
        deleteButton.setEnabled(isDataAvailable);

        // Add event listeners
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              Doctor doc = new Doctor();
              doc.setD_id(Integer.parseInt(doctorIdTextField.getText()));
              doc.setD_name(fullNameTextField.getText());
              doc.setD_father(fatherNameTextField.getText());
              doc.setD_email(emailTextField.getText());
              doc.setD_contact(Integer.parseInt(contactNoTextField.getText()));
              doc.setD_address(addressTextField.getText());
              doc.setD_qualification(qualificationTextField.getText());
              doc.setD_joining(dateOfJoiningTextField.getText());
              //doc.setD_gender(genderComboBox.toString().G;
              object.createDoctor(doc);
              
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Doctor doc = new Doctor();
               doc.setD_id(Integer.parseInt(doctorIdTextField.getText()));
              doc.setD_name(fullNameTextField.getText());
              doc.setD_father(fatherNameTextField.getText());
              doc.setD_email(emailTextField.getText());
              doc.setD_contact(Integer.parseInt(contactNoTextField.getText()));
              doc.setD_address(addressTextField.getText());
              doc.setD_qualification(qualificationTextField.getText());
              doc.setD_joining(dateOfJoiningTextField.getText());
              //doc.setD_gender(genderComboBox.toString().G;
              object.updateDoctor(doc);
               
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(doctorIdTextField.getText());
                object.deleteDoctor(id);

            }
        });

        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            doctorIdTextField.setText(null);
        fullNameTextField.setText(null);
        fatherNameTextField .setText(null);
        emailTextField .setText(null);
        contactNoTextField.setText(null);
        addressTextField .setText(null);
        qualificationTextField .setText(null);
        dateOfJoiningTextField.setText(null);
            }
        });

        getDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setSize(500,400);
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
                
                JTable table = new JTable(0,10);
                frame.add(table);
                
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    new DoctorFormGUI().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DoctorFormGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(DoctorFormGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
