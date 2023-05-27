package patientadmitinfo1;

import java.util.List;

/**
 *
 * @author Dell
 */
public interface PatientDAO {
    void savePatient(Patient patient);
    void updatePatient(Patient patient);
    void deletePatient(String patientId);
    List<Patient> getAllPatients();
    Patient getPatientById(String patientId);
}
