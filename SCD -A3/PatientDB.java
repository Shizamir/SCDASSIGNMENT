/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package patientdb;

/**
 *
 * @author Dell
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class PatientDB {
    private Connection connection;

    public PatientDB() {
        // Establish a database connection
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean savePatient(Patient Patient) {
        String query = "INSERT INTO Patients (Patient_id, name, father_name, email, contact_number, address, qualification, gender, date_of_joining) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, Patient.getPatientID());
            statement.setString(2, Patient.getName());
            statement.setString(3, Patient.getFatherName());
            statement.setString(4, Patient.getEmail());
            statement.setString(5, Patient.getContactNumber());
            statement.setString(6, Patient.getAddress());
            statement.setString(7, Patient.getQualification());
            statement.setString(8, Patient.getGender());
            statement.setString(9, Patient.getDateOfJoining());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletePatient(String PatientID) {
        String query = "DELETE FROM Patients WHERE Patient_id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, PatientID);

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updatePatient(Patient Patient) {
        String query = "UPDATE Patients SET name = ?, father_name = ?, email = ?, contact_number = ?, " +
                       "address = ?, qualification = ?, gender = ?, date_of_joining = ? WHERE Patient_id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, Patient.getName());
            statement.setString(2, Patient.getFatherName());
            statement.setString(3, Patient.getEmail());
            statement.setString(4, Patient.getContactNumber());
            statement.setString(5, Patient.getAddress());
            statement.setString(6, Patient.getQualification());
            statement.setString(7, Patient.getGender());
            statement.setString(8, Patient.getDateOfJoining());
            statement.setString(9, Patient.getPatientID());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Patient getPatientByID(String PatientID) {
        String query = "SELECT * FROM Patients WHERE Patient_id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, PatientID);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Patient Patient = new Patient();
                Patient.setPatientID(resultSet.getString("Patient_id"));
                Patient.setName(resultSet.getString("name"));
                Patient.setFatherName(resultSet.getString("father_name"));
                Patient.setEmail(resultSet.getString("email"));
                Patient.setContactNumber(resultSet.getString("contact_number"));
                Patient.setAddress(resultSet.getString("address"));
                Patient.setQualification(resultSet.getString("qualification"));
                Patient.setGender(resultSet.getString("gender"));
                Patient.setDateOfJoining(resultSet.getString("date_of_joining"));

                return Patient;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}