/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hospitalmanagement;
import java.util.List;

public interface DoctorDAO {
    void createDoctor(Doctor doctor);
    Doctor getDoctorById(int d_id);
    List<Doctor> getAllDoctors();
    void updateDoctor(Doctor doctor);
    void deleteDoctor(int d_id);
}
