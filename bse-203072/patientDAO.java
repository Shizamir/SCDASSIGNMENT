/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hospitalmanagement;
import java.util.List;

public interface patientDAO {
    void createpatient(patient p);
    patient getPatientById(int p_id);
    List<patient> getAllpatient();
    void updatepatient(patient p);
    void deletepatient(int p_id);
}
