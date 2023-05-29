/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hospitalmanagement;
import java.util.List;


/**
 *
 * @author SoftwareEngineer
 */
   

public interface ServicesDAO {
    void createservices(Services service);
    Services getserviceById(int id);
    List<Services> getAllservices();
    void updateservice(Services service);
    void deleteservice(int id);
}
