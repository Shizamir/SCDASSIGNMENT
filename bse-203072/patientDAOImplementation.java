/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author SoftwareEngineer
 */

package hospitalmanagement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import hospitalmanagement.patient;


public class patientDAOImplementation implements patientDAO {

    private Connection connection;

    public patientDAOImplementation() throws ClassNotFoundException, SQLException
    {
        String url="jdbc:mysql://localhost:3306/hospital management system";
        String username= "root";
        String password="";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(url,username, password);
    }
    public void createpatient(patient p) {
        try {
            // Prepare the SQL statement
            String query = "INSERT INTO 'ptient details' "+ "(P_id, P_name, P_father, P_mail,P_contact, P_address, P_age, P_bloodgroup, P_info )"+
                    " VALUES ('"+
                    p.getP_id()+"',"+
                    p.getP_name()+",'" + 
                    p.getP_Father()+"',"+ 
                    p.getP_email()+",'"+ 
                    p.getP_contact()+"',"+
                    p.getP_address()+",'"+
                    p.getP_age()+"',"+
                    p.getP_bloodgroup()+",'"+
                    p.getP_info()+"')";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Set the parameter values for the prepared statement
            preparedStatement.setInt(1, p.getP_id());
            preparedStatement.setString(2, p.getP_name());
            preparedStatement.setString(3, p.getP_Father());
            preparedStatement.setString(4, p.getP_email());
            preparedStatement.setInt(5, p.getP_contact());
            preparedStatement.setString(6, p.getP_address());
            preparedStatement.setInt(7, p.getP_age());
           // preparedStatement.setString(8, p.getP_bloodgroup().isSelected());

           preparedStatement.setString(9, p.getP_info());

            // Execute the SQL statement
            preparedStatement.executeUpdate(query);

            // Close the prepared statement
            preparedStatement.close();
            connection.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public patient getPatientById(int id) {
       patient patients= null;
        try {
            // Prepare the SQL statement
            String query = "SELECT * FROM 'patient detais' WHERE P_id = '"+
                    patients.getP_id()+"'";
            
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery(query);
            
            // Set the parameter value for the prepared statement
            preparedStatement.setInt(1, id);

            // Execute the SQL statement
            ResultSet resultSet = preparedStatement.executeQuery();

            // Process the result set
            if (resultSet.next()) {
                patients = new patient();
                patients.setP_id(resultSet.getInt("id"));
                patients.setP_name(resultSet.getString("name"));
                patients.setP_Father(resultSet.getString("father"));
            }

            // Close the result set and prepared statement
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }

    public List<patient> getAllpatient() {
        List<patient> patient = new ArrayList<>();
        try {
            // Prepare the SQL statement
            String query = "SELECT * FROM 'patient details'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Execute the SQL statement
            ResultSet resultSet = preparedStatement.executeQuery();

            // Process the result set
            while (resultSet.next()) {
                patient patients = new patient();
                patients.setP_id(resultSet.getInt("id"));
                patients.setP_name(resultSet.getString("name"));
                patients.setP_Father(resultSet.getString("father"));
                patient.add(patients);
            }

            // Close the result set and prepared statement
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patient;
    }


    public void updatepatient(patient p) {
        try {
            // Prepare the SQL statement
            String query = "UPDATE 'patient details'"+
                    "SET P_name =" + p.getP_name()+
                    " WHERE P_id = '"+ p.getP_id()+ "'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Set the parameter values for the prepared statement
            preparedStatement.setInt(1, p.getP_id());
            preparedStatement.setString(2, p.getP_name());
            preparedStatement.setString(3, p.getP_Father());

            // Execute the SQL statement
            preparedStatement.executeUpdate();

            // Close the prepared statement
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletepatient(int id) {
        try {
            // Prepare the SQL statement
            String query = "DELETE FROM 'patient details' WHERE P_id = " +id ;
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Set the parameter value for the prepared statement
            preparedStatement.setInt(1, id);

            // Execute the SQL statement
            preparedStatement.executeUpdate();

            // Close the prepared statement
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


