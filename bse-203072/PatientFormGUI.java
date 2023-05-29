package hospitalmanagement;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PatientFormGUI extends JFrame {
    private JTextField PatientIdTextField, fullNameTextField, fatherNameTextField, emailTextField, contactNoTextField, addressTextField, ageTextField;
    private JComboBox<String> genderComboBox, bloodGroupComboBox;
    private JTextArea informationTextArea;
    private JButton saveButton, updateButton, deleteButton, newButton, getDataButton;
    private boolean isDataAvailable = false;

    patientDAOImplementation object;
    
    public PatientFormGUI() {
        initializeUI();
    }

    private void initializeUI() {
        // Set frame properties
        setTitle("Patient Form");
        setSize(700, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Create labels
        JLabel patientIdLabel = new JLabel("Patient ID:");
        JLabel fullNameLabel = new JLabel("Full Name:");
        JLabel fatherNameLabel = new JLabel("Father Name:");
        JLabel emailLabel = new JLabel("Email ID:");
        JLabel contactNoLabel = new JLabel("Contact No:");
        JLabel addressLabel = new JLabel("Address:");
        JLabel ageLabel = new JLabel("Age:");
        JLabel genderLabel = new JLabel("Gender:");
        JLabel bloodGroupLabel = new JLabel("Blood Group:");
        JLabel informationLabel = new JLabel("Information:");

        // Create text fields
        PatientIdTextField = new JTextField(15);
        fullNameTextField = new JTextField(15);
        fatherNameTextField = new JTextField(15);
        emailTextField = new JTextField(15);
        contactNoTextField = new JTextField(15);
        addressTextField = new JTextField(15);
        ageTextField = new JTextField(15);
        

        // create text area
        informationTextArea = new JTextArea(10, 30);
        JScrollPane informationScrollPane = new JScrollPane(informationTextArea);
        informationTextArea.setWrapStyleWord(false);
        informationTextArea.setLineWrap(true);
        
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
        add(patientIdLabel, gbc);
        gbc.gridx = 1;
        add(PatientIdTextField, gbc);
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
        add(ageLabel, gbc);
        gbc.gridx = 1;
        add(ageTextField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 7;
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
        
      add(informationLabel, gbc);
        gbc.gridx = 1;
        gbc.gridheight = 2; // Adjust the height of the text area
        add(informationScrollPane, gbc);

        gbc.gridy = 12; // Adjust the position of the button panel
        gbc.gridwidth = 2;
        add(buttonsPanel, gbc);
        
        
        updateButton.setEnabled(isDataAvailable);
        deleteButton.setEnabled(isDataAvailable);

        // Add event listeners
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                patient p = new patient();
              p.setP_id(Integer.parseInt(PatientIdTextField.getText()));
              p.setP_name(fullNameTextField.getText());
              p.setP_Father(fatherNameTextField.getText());
              p.setP_email(emailTextField.getText());
              p.setP_contact(Integer.parseInt(contactNoTextField.getText()));
              p.setP_address(addressTextField.getText());
              p.setP_age(Integer.parseInt(ageTextField.getText()));
              p.setP_info(informationTextArea.getText());
              //doc.setD_gender(genderComboBox.toString().G;
              object.createpatient(p);
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  patient p = new patient();
              p.setP_id(Integer.parseInt(PatientIdTextField.getText()));
              p.setP_name(fullNameTextField.getText());
              p.setP_Father(fatherNameTextField.getText());
              p.setP_email(emailTextField.getText());
              p.setP_contact(Integer.parseInt(contactNoTextField.getText()));
              p.setP_address(addressTextField.getText());
              p.setP_age(Integer.parseInt(ageTextField.getText()));
              p.setP_info(informationTextArea.getText());
              //doc.setD_gender(genderComboBox.toString().G;
              object.createpatient(p);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               int id = Integer.parseInt(PatientIdTextField.getText());
                object.deletepatient(id);
            }
        });

        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PatientIdTextField.setText(null);
                fullNameTextField.setText(null);
                fatherNameTextField .setText(null);
                emailTextField .setText(null);
                contactNoTextField.setText(null);
                addressTextField .setText(null);
                ageTextField .setText(null);
                informationTextArea.setText(null);
            }
        });

        getDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle get data button click event
                // Add your code here
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PatientFormGUI().setVisible(true);
            }
        });
    }
}




