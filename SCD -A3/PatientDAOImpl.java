package patientadmitinfo1;

/**
 *
 * @author Dell
 */
import java.util.ArrayList;
import java.util.List;

public class PatientDAOImpl implements PatientDAO {
    private List<Patient> patients;

    public PatientDAOImpl() {
        patients = new ArrayList<>();
    }

    @Override
    public void savePatient(Patient patient) {
        patients.add(patient);
    }

    @Override
    public void updatePatient(Patient patient) {
        // Find the patient in the list by patientId and update the fields
        for (Patient p : patients) {
            if (p.getPatientId().equals(patient.getPatientId())) {
                // Update the fields of the existing patient object
                p.setPatientName(patient.getPatientName());
                p.setGender(patient.getGender());
                // Update other fields as well
                // ...
                break;
            }
        }
    }

    @Override
    public void deletePatient(String patientId) {
        // Find the patient in the list by patientId and remove it
        patients.removeIf(p -> p.getPatientId().equals(patientId));
    }

    @Override
    public List<Patient> getAllPatients() {
        return patients;
    }

    @Override
    public Patient getPatientById(String patientId) {
        // Find and return the patient in the list by patientId
        for (Patient p : patients) {
            if (p.getPatientId().equals(patientId)) {
                return p;
            }
        }
        return null; // Patient not found
    }
}
