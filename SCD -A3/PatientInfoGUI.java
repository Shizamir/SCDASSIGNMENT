package patientinfogui;

/**
 *
 * @author Dell 
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class PatientInfoGUI extends JFrame {
    private JLabel lblPatientId, lblPatientName, lblGender, lblBloodGroup, lblDisease, lblAdmitDate, lblRoomNo, lblDoctorId, lblDoctorName, lblDischargeDate;
    private JLabel lblRoomCharges, lblNoOfDays, lblTotalRoomCharges, lblServiceCharges, lblBillingDate, lblPaymentMode,lblpay, lblTotalCharges, lblBillNo;
    private JTextField txtPatientId, txtPatientName, txtGender, txtBloodGroup, txtDisease, txtAdmitDate, txtRoomNo, txtDoctorId, txtDoctorName, txtDischargeDate;
    private JTextField txtRoomCharges, txtNoOfDays, txtTotalRoomCharges, txtServiceCharges, txtBillingDate, txtTotalCharges, txtBillNo,txtpay;
    private JComboBox<String> cmbPaymentMode;
    private JButton btnSave, btnNew, btnDelete, btnUpdate;
    private JTable table;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;

    public PatientInfoGUI() {
        setTitle("Patient Information");
        setSize(400, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        lblPatientId = new JLabel("Patient ID:");
        lblPatientId.setBounds(10, 10, 80, 25);
        add(lblPatientId);

        txtPatientId = new JTextField();
        txtPatientId.setBounds(100, 10, 150, 25);
        txtPatientId.setEditable(false); 
        add(txtPatientId);

        lblPatientName = new JLabel("Patient Name:");
        lblPatientName.setBounds(10, 40, 80, 25);
        add(lblPatientName);

        txtPatientName = new JTextField();
        txtPatientName.setBounds(100, 40, 150, 25);
        txtPatientName.setEditable(false); 
        add(txtPatientName);

        lblGender = new JLabel("Gender:");
        lblGender.setBounds(10, 70, 80, 25);
        add(lblGender);

        txtGender = new JTextField();
        txtGender.setBounds(100, 70, 150, 25);
        txtGender.setEditable(false); 
        add(txtGender);
//____
         lblBloodGroup = new JLabel("Blood Group:");
        lblBloodGroup.setBounds(10, 100, 80, 25);
        add(lblBloodGroup);
        
        txtBloodGroup = new JTextField();
        txtBloodGroup.setBounds(100, 100, 150, 25);
        txtBloodGroup.setEditable(false);
        add(txtBloodGroup);
        
        lblDisease = new JLabel("Disease:");
        lblDisease.setBounds(10, 130, 80, 25);
        add(lblDisease);
        
        txtDisease = new JTextField();
        txtDisease.setBounds(100, 130, 150, 25);
        txtDisease.setEditable(false);
        add(txtDisease);
        
        lblAdmitDate = new JLabel("Admit Date:");
        lblAdmitDate.setBounds(10, 160, 80, 25);
        add(lblAdmitDate);
        
        txtAdmitDate = new JTextField();
        txtAdmitDate.setBounds(100, 160, 150, 25);
        txtAdmitDate.setEditable(false);
        add(txtAdmitDate);
        
        lblRoomNo = new JLabel("Room No:");
        lblRoomNo.setBounds(10, 190, 80, 25);
        add(lblRoomNo);
        
        txtRoomNo = new JTextField();
        txtRoomNo.setBounds(100, 190, 150, 25);
        txtRoomNo.setEditable(false);
        add(txtRoomNo);
        
        lblDoctorId = new JLabel("Doctor ID:");
        lblDoctorId.setBounds(10, 220, 80, 25);
        add(lblDoctorId);
        
        txtDoctorId = new JTextField();
        txtDoctorId.setBounds(100, 220, 150, 25);
        txtDoctorId.setEditable(false);
        add(txtDoctorId);
        
        lblDoctorName = new JLabel("Doctor Name:");
        lblDoctorName.setBounds(10, 250, 80, 25);
        add(lblDoctorName);
        
        txtDoctorName = new JTextField();
        txtDoctorName.setBounds(100, 250, 150, 25);
        txtDoctorName.setEditable(false);
        add(txtDoctorName);
        
        lblDischargeDate = new JLabel("Discharge Date:");
        lblDischargeDate.setBounds(10, 280, 150, 25);
        add(lblDischargeDate);
        
        txtDischargeDate = new JTextField();
        txtDischargeDate.setBounds(100, 280, 150, 25);
        txtDischargeDate.setEditable(false);
        add(txtDischargeDate);
        
        lblRoomCharges = new JLabel("Room Charges:");
        lblRoomCharges.setBounds(10, 310, 100, 25);
        add(lblRoomCharges);
        
        txtRoomCharges = new JTextField();
        txtRoomCharges.setBounds(120, 310, 150, 25);
        txtRoomCharges.setEditable(false);
        add(txtRoomCharges);
        
        lblNoOfDays = new JLabel("No. of Days:");
        lblNoOfDays.setBounds(10, 340, 100, 25);
        add(lblNoOfDays);
        
        txtNoOfDays = new JTextField();
        txtNoOfDays.setBounds(120, 340, 150, 25);
        txtNoOfDays.setEditable(false);
        add(txtNoOfDays);
        
        lblTotalRoomCharges = new JLabel("Total Room Charges:");
        lblTotalRoomCharges.setBounds(10, 370, 120, 25);
        add(lblTotalRoomCharges);
        
        txtTotalRoomCharges = new JTextField();
        txtTotalRoomCharges.setBounds(140, 370, 150, 25);
        txtTotalRoomCharges.setEditable(false);
        add(txtTotalRoomCharges);
        
        lblServiceCharges = new JLabel("Service Charges:");
        lblServiceCharges.setBounds(10, 400, 100, 25);
        add(lblServiceCharges);
        
        txtServiceCharges = new JTextField();
        txtServiceCharges.setBounds(120, 400, 150, 25);
        txtServiceCharges.setEditable(false);
        add(txtServiceCharges);
        
        lblBillingDate = new JLabel("Billing Date:");
        lblBillingDate.setBounds(10, 430, 100, 25);
        add(lblBillingDate);
        
        txtBillingDate = new JTextField();
        txtBillingDate.setBounds(120, 430, 150, 25);
        txtBillingDate.setEditable(true);
        add(txtBillingDate);
        
        lblPaymentMode = new JLabel("Payment Mode:");
        lblPaymentMode.setBounds(10, 460, 100, 25);
        add(lblPaymentMode);
        
        String[] paymentModes = {"Cash", "Credit Card", "Debit Card", "Net Banking"};
        cmbPaymentMode = new JComboBox<>(paymentModes);
        cmbPaymentMode.setBounds(120, 460, 150, 25);
        add(cmbPaymentMode);
        
        lblpay = new JLabel("Payment mode detail:");
        lblpay.setBounds(270, 460, 150, 25);
        add(lblpay);
        
        txtpay = new JTextField();
        txtpay.setBounds(390, 460, 150, 25);
        txtpay.setEditable(true);
        add(txtpay);
        
        lblTotalCharges = new JLabel("Total Charges:");
        lblTotalCharges.setBounds(10, 490, 100, 25);
        add(lblTotalCharges);
        
        txtTotalCharges = new JTextField();
        txtTotalCharges.setBounds(120, 490, 150, 25);
        txtTotalCharges.setEditable(false);
        add(txtTotalCharges);

        lblBillNo = new JLabel("Bill No:");
        lblBillNo.setBounds(10, 520, 80, 25);
        add(lblBillNo);

        txtBillNo = new JTextField();
        txtBillNo.setBounds(100, 520, 150, 25);
        txtBillNo.setEditable(false); 
        add(txtBillNo);

        btnSave = new JButton("Save");
        btnSave.setBounds(10, 560, 80, 25);
        add(btnSave);

        btnNew = new JButton("New");
        btnNew.setBounds(100, 560, 80, 25);
        add(btnNew);

        btnDelete = new JButton("Delete");
        btnDelete.setBounds(190, 560, 80, 25);
        btnDelete.setEnabled(false); // Disabled by default
        add(btnDelete);

        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(280, 560, 80, 25);
        btnUpdate.setEnabled(false); // Disabled by default
        add(btnUpdate);

        String[] columnNames = {"Patient ID", "Patient Name", "Service Charges"};
        Object[][] data = {
                {"P001", "John Doe", "100.00"}
        };

        tableModel = new DefaultTableModel(data, columnNames);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 600, 370, 150);
        add(scrollPane);
        

        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Save button action
                // Add your code here to handle saving the patient information
            }
        });

        btnNew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // New button action
                // Add your code here to handle clearing the input fields
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Delete button action
                // Add your code here to handle deleting the patient information
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Update button action
                // Add your code here to handle updating the patient information
            }
        });
    }

    public static void main(String[] args) {
        PatientInfoGUI frame = new PatientInfoGUI();
        frame.setVisible(true);
    }
}
