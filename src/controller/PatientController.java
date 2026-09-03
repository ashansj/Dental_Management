package Controller;

import Model.Patient;
import Model.PatientDAO;
import java.sql.SQLException;

public class PatientController {
    private PatientDAO patientDAO;

    public PatientController() {
        this.patientDAO = new PatientDAO();
    }

    public String registerPatient(String fullName, String email, String dob, String nic, String contactNo, String password, String confirmPws) {
        
        // Validation
        if (fullName.isEmpty() || email.isEmpty() || dob.isEmpty() || nic.isEmpty() || 
            contactNo.isEmpty() || password.isEmpty()) {
            return "EMPTY_FIELDS";
        }
        
        if (!password.equals(confirmPws)) {
            return "PASSWORD_MISMATCH";
        }

        try {
            Patient patient = new Patient(fullName, email, dob, nic, contactNo, password, confirmPws);
            boolean success = patientDAO.registerPatient(patient);
            
            if (success) {
                return "SUCCESS";
            }
        } catch (SQLException e) {
            return "DB_ERROR: " + e.getMessage();
        }
        
        return "FAILED";
    }
}