package roombookinggui;

/**
 *
 * @author Dell
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class RoomBookingGUI extends JFrame {
    private JLabel roomNoLabel;
    private JTextField roomNoField;
    private JLabel roomChargesLabel;
    private JTextField roomChargesField;
    private JLabel roomTypeLabel;
    private JComboBox<String> roomTypeComboBox;
    private JButton newButton;
    private JButton saveButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton getDataButton;
    private JTable roomTable;
    private DefaultTableModel tableModel;

    private List<String> roomDataList;

    public RoomBookingGUI() {
        // Set up the JFrame
        setTitle("Room Booking");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 150);
        setLayout(new FlowLayout());
// Create table columns
        String[] columnNames = {"Room No", "Room Type", "Room Charges", "Room Status"};

        // Initialize table model
        tableModel = new DefaultTableModel(columnNames, 0);

        // Initialize room table
        roomTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(roomTable);

        // Add table to the JFrame
        add(scrollPane, BorderLayout.CENTER);
       
        // Initialize components
        roomNoLabel = new JLabel("Room No:\n");
        roomNoField = new JTextField(10);
        roomChargesLabel = new JLabel("Room Charges:\n");
        roomChargesField = new JTextField(10);
        roomTypeLabel = new JLabel("Room Type:\n");
        roomTypeComboBox = new JComboBox<>(new String[]{"Single", "Double", "Suite"});
        newButton = new JButton("New\n");
        saveButton = new JButton("Save\n");
        updateButton = new JButton("Update\n");
        deleteButton = new JButton("Delete\n");
        getDataButton = new JButton("Get Data\n");
// Initialize table with 3 rows
        addInitialRows();
          updateButton.setEnabled(false);
        deleteButton.setEnabled(false);

        // Add ActionListener to the new button
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
                updateButton.setEnabled(false);
                deleteButton.setEnabled(false);
            }
        });

        // Add components to the JFrame
        add(roomNoLabel);
        add(roomNoField);
        add(roomChargesLabel);
        add(roomChargesField);
        add(roomTypeLabel);
        add(roomTypeComboBox);
        add(newButton);
        add(saveButton);
        add(updateButton);
        add(deleteButton);
        add(getDataButton);

        // Initialize the room data list
        roomDataList = new ArrayList<>();

        // Add ActionListener to the new button
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        // Add ActionListener to the save button
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String roomNo = roomNoField.getText();
                String roomCharges = roomChargesField.getText();
                String roomType = (String) roomTypeComboBox.getSelectedItem();

                // Save the room booking data
                String roomData = "Room No: " + roomNo + ", Room Charges: " + roomCharges + ", Room Type: " + roomType;
                roomDataList.add(roomData);

                // Display a message dialog
                JOptionPane.showMessageDialog(RoomBookingGUI.this,
                        "Room booking data saved successfully!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);

                clearFields();
            }
        });

        // Add ActionListener to the update button
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = JOptionPane.showOptionDialog(RoomBookingGUI.this,
                        "Select a room booking data to update:",
                        "Update",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        roomDataList.toArray(),
                        null);

                if (selectedIndex >= 0) {
                    String roomData = roomDataList.get(selectedIndex);
                    String[] parts = roomData.split(", ");
                    String roomNo = parts[0].substring(parts[0].indexOf(":") + 2);
                    String roomCharges = parts[1].substring(parts[1].indexOf(":") + 2);
                    String roomType = parts[2].substring(parts[2].indexOf(":") + 2);

                    roomNoField.setText(roomNo);
                    roomChargesField.setText(roomCharges);
                    roomTypeComboBox.setSelectedItem(roomType);

                    roomDataList.remove(selectedIndex);

                    JOptionPane.showMessageDialog(RoomBookingGUI.this,
                            "Room booking data updated successfully!",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // Add ActionListener to the delete button
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = JOptionPane.showOptionDialog(RoomBookingGUI.this,
                        "Select a room booking data to delete:",
                        "Delete",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        roomDataList.toArray(),
                        null);

                if (selectedIndex >= 0) {
                    roomDataList.remove(selectedIndex);
                    JOptionPane.showMessageDialog(RoomBookingGUI.this,
                            "Room booking data deleted successfully!",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // Add ActionListener to the getData button
        getDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (roomDataList.isEmpty()) {
                    JOptionPane.showMessageDialog(RoomBookingGUI.this,
                            "No room booking data available!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    StringBuilder data = new StringBuilder("Room Booking Data:\n\n");
                    for (String roomData : roomDataList) {
                        data.append(roomData).append("\n");
                    }

                    JOptionPane.showMessageDialog(RoomBookingGUI.this,
                            data.toString(),
                            "Room Booking Data",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    private void clearFields() {
        roomNoField.setText("");
        roomChargesField.setText("");
        roomTypeComboBox.setSelectedIndex(0);
    }

     private void processRoomBooking() {
        // ...

        if (roomDataList.isEmpty()) {
            updateButton.setEnabled(false);
            deleteButton.setEnabled(false);
        } else {
            updateButton.setEnabled(true);
            deleteButton.setEnabled(true);
        }
     }
      private void addInitialRows() {
        String[][] data = {
                {"1", "General", "5000", "Vacant"},
                {"2", "General", "2500", "Vacant"},
                {"3", "Deluxe", "1000", "Booked"}
        };

        for (String[] rowData : data) {
            tableModel.addRow(rowData);
        }
    
    }
     
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                RoomBookingGUI roomBookingGUI = new RoomBookingGUI();
                roomBookingGUI.setVisible(true);
            }
        });
    }
}

