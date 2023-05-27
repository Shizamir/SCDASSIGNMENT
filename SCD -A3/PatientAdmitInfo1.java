package patientadmitinfo1;

/**
 *
 * @author Dell
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PatientAdmitInfo1 extends JFrame {
    private JTextField txtPatientId;
    private JTextField txtPatientName;
    private JTextField txtGender;
    private JTextField txtBloodGroup;
    private JTextField txtDisease;
    private JTextField txtAdmitDate;
    private JTextField txtDoctorId;
    private JTextField txtDoctorName;
    private JComboBox<String> cmbRoomNo;
    private JTextArea txtRemarks;
    private JButton btnNew;
    private JButton btnSave;
    private JButton btnDelete;
    private JButton btnUpdate;
    private JButton btnGetData;
    private JTable doctorTable;
    private JTable patientTable;

    public PatientAdmitInfo1() {
        // Set up the JFrame
        setTitle("Patient Admit Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        btnNew = new JButton("New");
        btnSave = new JButton("Save");
        btnDelete = new JButton("Delete");
        btnUpdate = new JButton("Update");
        btnGetData = new JButton("Get Data");
        buttonPanel.add(btnNew);
        buttonPanel.add(btnSave);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnGetData);

        // Create a panel for the doctor table
        JPanel doctorTablePanel = new JPanel(new BorderLayout());
        String[] doctorColumnNames = {"Doctor ID", "Doctor Name"};
        String[][] doctorData = {{"1", "John Doe"}, {"2", "Jane Smith"}};
        DefaultTableModel doctorTableModel = new DefaultTableModel(doctorData, doctorColumnNames);
        doctorTable = new JTable(doctorTableModel);
        JScrollPane doctorTableScrollPane = new JScrollPane(doctorTable);
        doctorTableScrollPane.setPreferredSize(new Dimension(400, 120));
        doctorTablePanel.add(doctorTableScrollPane, BorderLayout.CENTER);

        // Create a panel for the patient table
        JPanel patientTablePanel = new JPanel(new BorderLayout());
        String[] patientColumnNames = {"Patient ID", "Patient Name", "Gender", "Blood Group"};
        String[][] patientData = {{"1", "John Smith", "Male", "O+"}};
        DefaultTableModel patientTableModel = new DefaultTableModel(patientData, patientColumnNames);
        patientTable = new JTable(patientTableModel);
        JScrollPane patientTableScrollPane = new JScrollPane(patientTable);
        patientTableScrollPane.setPreferredSize(new Dimension(400, 120));
        patientTablePanel.add(patientTableScrollPane, BorderLayout.CENTER);

        // Create a panel for text fields, text area, and drop-down
        JPanel inputPanel = new JPanel(new GridLayout(9, 2, 10, 10));
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        JLabel lblPatientId = new JLabel("Patient ID:");
        txtPatientId = new JTextField();
        JLabel lblPatientName = new JLabel("Patient Name:");
        txtPatientName = new JTextField();
        JLabel lblGender = new JLabel("Gender:");
        txtGender = new JTextField();
        JLabel lblBloodGroup = new JLabel("Blood Group:");
        txtBloodGroup = new JTextField();
        JLabel lblDisease = new JLabel("Disease:");
        txtDisease = new JTextField();
        JLabel lblAdmitDate = new JLabel("Admit Date:");
        txtAdmitDate = new JTextField();
        JLabel lblDoctorId = new JLabel("Doctor ID:");
        txtDoctorId = new JTextField();
        JLabel lblDoctorName = new JLabel("Doctor Name:");
        txtDoctorName = new JTextField();
        JLabel lblRoomNo = new JLabel("Room No:");
        String[] roomNumbers = {"101", "102", "103", "104"}; // Example room numbers
        cmbRoomNo = new JComboBox<>(roomNumbers);
        JLabel lblRemarks = new JLabel("Remarks:");
        txtRemarks = new JTextArea(3, 10);
        JScrollPane scrollPane = new JScrollPane(txtRemarks);

        inputPanel.add(lblPatientId);
        inputPanel.add(txtPatientId);
        inputPanel.add(lblPatientName);
        inputPanel.add(txtPatientName);
        inputPanel.add(lblGender);
        inputPanel.add(txtGender);
        inputPanel.add(lblBloodGroup);
        inputPanel.add(txtBloodGroup);
        inputPanel.add(lblDisease);
        inputPanel.add(txtDisease);
        inputPanel.add(lblAdmitDate);
        inputPanel.add(txtAdmitDate);
        inputPanel.add(lblDoctorId);
        inputPanel.add(txtDoctorId);
        inputPanel.add(lblDoctorName);
        inputPanel.add(txtDoctorName);
        inputPanel.add(lblRoomNo);
        inputPanel.add(cmbRoomNo);
        inputPanel.add(lblRemarks);
        inputPanel.add(scrollPane);

        // Add panels to the JFrame
        add(buttonPanel, BorderLayout.NORTH);
        add(doctorTablePanel, BorderLayout.CENTER);
        add(patientTablePanel, BorderLayout.SOUTH);
        add(inputPanel, BorderLayout.WEST);

        // Add action listeners to the buttons
        btnNew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle New button click event
                // Perform necessary actions when the New button is clicked
            }
        });

        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle Save button click event
                // Perform necessary actions when the Save button is clicked
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle Delete button click event
                // Perform necessary actions when the Delete button is clicked
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle Update button click event
                // Perform necessary actions when the Update button is clicked
            }
        });

        btnGetData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle Get Data button click event
                // Perform necessary actions when the Get Data button is clicked
            }
        });

        // Set the size and make the JFrame visible
        pack();
        setLocationRelativeTo(null); // Center the JFrame on the screen
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PatientAdmitInfo1());
    }
}
