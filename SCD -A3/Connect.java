package connect;

/**
 *
 * @author Dell
 */
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.*;

public class Connect {

    /**
     * @param args the command line arguments
     */
     Connection con=null;
   
        public static Connection ConnectDB(){
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL","root","1234");
           return con;
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }      
    }
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
