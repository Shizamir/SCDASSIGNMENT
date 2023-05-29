package hospitalmanagement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ServiceInformationGUI extends JFrame {
    private JTextField serviceNameField;
    private JTextField serviceDateField;
    private JTextField patientIdField;
    private JTextField patientNameField;
    private JTextField serviceChargesField;
    private JButton newButton;
    private JButton saveButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JButton getDataButton;
    private JTable dataTable;
    private DefaultTableModel tableModel;

    Serviceinformation_Implementation object;
    
    public ServiceInformationGUI() throws ClassNotFoundException, SQLException {
        object=new Serviceinformation_Implementation();
        setTitle("Service Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(800, 400));

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 10, 5, 10);

        JLabel serviceNameLabel = new JLabel("Service Name:");
        serviceNameField = new JTextField(20);

        JLabel serviceDateLabel = new JLabel("Service Date:");
        serviceDateField = new JTextField(20);

        JLabel patientIdLabel = new JLabel("Patient ID:");
        patientIdField = new JTextField(20);

        JLabel patientNameLabel = new JLabel("Patient Name:");
        patientNameField = new JTextField(20);

        JLabel serviceChargesLabel = new JLabel("Service Charges:");
        serviceChargesField = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(serviceNameLabel, gbc);
        gbc.gridy = 1;
        inputPanel.add(serviceDateLabel, gbc);
        gbc.gridy = 2;
        inputPanel.add(patientIdLabel, gbc);
        gbc.gridy = 3;
        inputPanel.add(patientNameLabel, gbc);
        gbc.gridy = 4;
        inputPanel.add(serviceChargesLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        inputPanel.add(serviceNameField, gbc);
        gbc.gridy = 1;
        inputPanel.add(serviceDateField, gbc);
        gbc.gridy = 2;
        inputPanel.add(patientIdField, gbc);
        gbc.gridy = 3;
        inputPanel.add(patientNameField, gbc);
        gbc.gridy = 4;
        inputPanel.add(serviceChargesField, gbc);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        newButton = new JButton("New");
        saveButton = new JButton("Save");
        deleteButton = new JButton("Delete");
        updateButton = new JButton("Update");
        getDataButton = new JButton("Get Data");

        buttonPanel.add(newButton);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(saveButton);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(deleteButton);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(updateButton);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(getDataButton);

        tableModel = new DefaultTableModel(new Object[]{"Patient ID", "Patient Name"}, 0);
        dataTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(dataTable);
        dataTable.setPreferredScrollableViewportSize(new Dimension(400, 150));

        add(inputPanel, BorderLayout.WEST);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.EAST);

        pack();
        setLocationRelativeTo(null);

        // Add event listeners
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serviceNameField.setText("");
                serviceDateField.setText("");
                patientIdField.setText("");
                patientNameField.setText("");
                serviceChargesField.setText("");
                JOptionPane.showMessageDialog(null, "New button clicked.");
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 Services ser = new Services();
              ser.setSName(serviceNameField.getText());
              ser.setP_name(serviceDateField.getText());
              ser.setP_id(Integer.parseInt(patientIdField.getText()));
              ser.setP_name(patientNameField.getText());
              ser.setCharges(Integer.parseInt(serviceChargesField.getText()));
             
              //doc.setD_gender(genderComboBox.toString().G;
              object.createservice(ser);
                JOptionPane.showMessageDialog(null, "Save button clicked.");
               
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                JOptionPane.showMessageDialog(null, "Delete button clicked.");
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle Update button click event
                // Implement logic here
                JOptionPane.showMessageDialog(null, "Update button clicked.");
            }
        });

        getDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle Get Data button click event
                // Implement logic here
                JOptionPane.showMessageDialog(null, "Get Data button clicked.");
            }
        });

        // Disable Delete and Update buttons initially
        deleteButton.setEnabled(false);
        updateButton.setEnabled(false);
    }

    public static void main(String[] args) 
    {
            SwingUtilities.invokeLater(new Runnable() throws ClassNotFoundException {
       
            public void run() {
                new ServiceInformationGUI().setVisible(true);
            }
        });
    }
}
