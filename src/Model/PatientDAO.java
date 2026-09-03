package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PatientDAO {

    public boolean registerPatient(Patient patient) throws SQLException {
        String sql = "INSERT INTO patient_login (full_name, email, dob, nic, contact_no, password, address) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection con = DBconnect.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            
            pst.setString(1, patient.getFullName());
            pst.setString(2, patient.getEmail());
            pst.setString(3, patient.getDob());
            pst.setString(4, patient.getNic());
            pst.setString(5, patient.getContactNo());
            pst.setString(6, patient.getPassword());
            pst.setString(7, patient.getAddress());

            int rowsInserted = pst.executeUpdate();
            return rowsInserted > 0;
        }
    }
}