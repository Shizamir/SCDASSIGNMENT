package hospitalmanagement;

/**
 *
 * @author SoftwareEngineer
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import hospitalmanagement.Services;


public class Serviceinformation_Implementation implements ServicesDAO
{

    private Connection connection;

    public Serviceinformation_Implementation() throws ClassNotFoundException, SQLException
    {
        String url="jdbc:mysql://localhost:3306/hospital management system";
        String username= "root";
        String password="";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(url,username, password);
    }
    public void createservice(Services service) {
        try {
            // Prepare the SQL statement
            String query = "INSERT INTO services "+ "(service_name,service_date,Patient_id,patient_name,service_charges )"+
                    " VALUES ('"+
                    service.getSName()+"',"+
                    service.getDate()+",'" + 
                    service.getP_id()+"',"+ 
                    service.getP_name()+",'"+ 
                    service.getCharges()+"')";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Set the parameter values for the prepared statement
            preparedStatement.setString(1, service.getSName());
            preparedStatement.setString(2, service.getDate());
            preparedStatement.setInt(3, service.getP_id());
            preparedStatement.setString(4, service.getP_name());
            preparedStatement.setInt(5, service.getCharges());

            // Execute the SQL statement
            preparedStatement.executeUpdate(query);

            // Close the prepared statement
            preparedStatement.close();
            connection.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

  
    public Services getserviceById(int id) {
        Services service = null;
        try {
            // Prepare the SQL statement
            String query = "SELECT * FROM services WHERE P_id = '"+
                    service.getP_id()+"'";
            
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery(query);
            
            // Set the parameter value for the prepared statement
            preparedStatement.setInt(1, id);

            // Execute the SQL statement
            ResultSet resultSet = preparedStatement.executeQuery();

            // Process the result set
            if (resultSet.next()) {
                service = new Services();
                service.setP_id(resultSet.getInt("id"));
                service.setP_name(resultSet.getString("name"));
                service.setSName(resultSet.getString("Service"));
            }

            // Close the result set and prepared statement
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return service;
    }

    public List<Services> getAllservices() {
        List<Services>service = new ArrayList<>();
        try {
            // Prepare the SQL statement
            String query = "SELECT * FROM services";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Execute the SQL statement
            ResultSet resultSet = preparedStatement.executeQuery();

            // Process the result set
            while (resultSet.next()) {
                Services services = new Services();
                services.setP_id(resultSet.getInt("id"));
                services.setP_name(resultSet.getString("name"));
                services.setDate(resultSet.getString("date"));
                services.add(service);
            }

            // Close the result set and prepared statement
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return service;
    }

    public void updateservice(Services service) {
        try {
            // Prepare the SQL statement
            String query = "UPDATE services"+
                    "SET P_name =" + service.getP_name()+
                    " WHERE id = '"+ service.getP_id()+ "'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Set the parameter values for the prepared statement
            preparedStatement.setInt(1, service.getP_id());
            preparedStatement.setString(2, service.getP_name());
            preparedStatement.setString(3, service.getDate());

            // Execute the SQL statement
            preparedStatement.executeUpdate();

            // Close the prepared statement
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

  
    public void deleteservice(int id) 
    {
         try {
            // Prepare the SQL statement
            String query = "DELETE FROM services WHERE P_id = " +id ;
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
