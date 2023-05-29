package hospitalmanagement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import hospitalmanagement.Doctor;


public class DoctorDAOImplementation implements DoctorDAO {

    private Connection connection;

    public DoctorDAOImplementation() throws ClassNotFoundException, SQLException
    {
        String url="jdbc:mysql://localhost:3306/hospital management system";
        String username= "root";
        String password="";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(url,username, password);
    }
    public void createDoctor(Doctor doctor) {
        try {
            // Prepare the SQL statement
            String query = "INSERT INTO doctortable "+ "(D_id, D_name, D_father, D_mail,D_contact, D_address, D_qualification, D_gender, D_bloodgroup, D_joining )"+
                    " VALUES ('"+
                    doctor.getD_id()+"',"+
                    doctor.getD_name()+",'" + 
                    doctor.getD_father()+"',"+ 
                    doctor.getD_email()+",'"+ 
                    doctor.getD_contact()+"',"+
                    doctor.getD_address()+",'"+
                    doctor.getD_qualification()+"',"+
                    doctor.getD_bloodgroup()+",'"+
                    doctor.getD_joining()+"')";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Set the parameter values for the prepared statement
            preparedStatement.setInt(1, doctor.getD_id());
            preparedStatement.setString(2, doctor.getD_name());
            
            ResultSet rs= preparedStatement.executeQuery();

            // Execute the SQL statement
            preparedStatement.executeUpdate(query);

            // Close the prepared statement
            preparedStatement.close();
            connection.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Doctor getDoctorById(int id) {
        Doctor doctor = null;
        try {
            // Prepare the SQL statement
            String query = "SELECT * FROM doctortable WHERE D_id = '"+
                    doctor.getD_id()+"'";
            
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery(query);
            
            // Set the parameter value for the prepared statement
            preparedStatement.setInt(1, id);

            // Execute the SQL statement
            ResultSet resultSet = preparedStatement.executeQuery();

            // Process the result set
            if (resultSet.next()) {
                doctor = new Doctor();
                doctor.setD_id(resultSet.getInt("id"));
                doctor.setD_name(resultSet.getString("name"));
                doctor.setD_father(resultSet.getString("father"));
            }

            // Close the result set and prepared statement
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctor;
    }

    public List<Doctor> getAllDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        try {
            // Prepare the SQL statement
            String query = "SELECT * FROM doctortable";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Execute the SQL statement
            ResultSet resultSet = preparedStatement.executeQuery();

            // Process the result set
            while (resultSet.next()) {
                Doctor doctor = new Doctor();
                doctor.setD_id(resultSet.getInt("id"));
                doctor.setD_name(resultSet.getString("name"));
                doctor.setD_father(resultSet.getString("father"));
                doctors.add(doctor);
            }

            // Close the result set and prepared statement
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctors;
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        try {
            // Prepare the SQL statement
            String query = "UPDATE doctortable"+
                    "SET D_name =" + doctor.getD_name()+
                    " WHERE id = '"+ doctor.getD_id()+ "'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Set the parameter values for the prepared statement
            preparedStatement.setInt(1, doctor.getD_id());
            preparedStatement.setString(2, doctor.getD_name());
            preparedStatement.setString(3, doctor.getD_father());

            // Execute the SQL statement
            preparedStatement.executeUpdate();

            // Close the prepared statement
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDoctor(int id) {
        try {
            // Prepare the SQL statement
            String query = "DELETE FROM doctortable WHERE D_id = " +id ;
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
