package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {

    public List<String> getAvailableDentistsByDate(java.sql.Date date) throws SQLException {
        List<String> dentists = new ArrayList<>();
        String sql = "SELECT DISTINCT doctor_name FROM approved_dentist_schedule WHERE work_date = ? AND start_time IS NOT NULL AND end_time IS NOT NULL ORDER BY doctor_name";
        
        try (Connection con = DBconnect.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setDate(1, date);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    dentists.add(rs.getString("doctor_name"));
                }
            }
        }
        return dentists;
    }
    
    public List<String> getAvailableTimes(java.sql.Date date, String dentistName) throws SQLException {
    List<String> times = new ArrayList<>();
    
    
    String sql = "SELECT start_time, end_time FROM approved_dentist_schedule WHERE work_date = ? AND doctor_name = ?";
    
    try (Connection con = DBconnect.getConnection();
         PreparedStatement pst = con.prepareStatement(sql)) {
         
        pst.setDate(1, date);
        pst.setString(2, dentistName);
        
        try (ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                                String timeSlot = rs.getString("start_time") + " - " + rs.getString("end_time");
                times.add(timeSlot);
            }
        }
    }
    return times;
}

    public int saveAppointment(Appointment app) throws SQLException {
        String sql = "INSERT INTO appointments (PName, PAge, PNumber, dentist_name, appointment_date, appointment_time, treatment_type) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection con = DBconnect.getConnection();
             PreparedStatement pst = con.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS)) {
            
            pst.setString(1, app.getPatientName());
            pst.setInt(2, app.getAge());
            pst.setString(3, app.getMobileNumber());
            pst.setString(4, app.getDentist());
            pst.setDate(5, new java.sql.Date(app.getAppointmentDate().getTime()));
            pst.setString(6, app.getTime());
            pst.setString(7, app.getTreatmentType());

            int result = pst.executeUpdate();
            if (result > 0) {
                try (ResultSet rsKeys = pst.getGeneratedKeys()) {
                    if (rsKeys.next()) {
                        return rsKeys.getInt(1); // Return generated Appointment ID
                    }
                }
            }
        }
        return -1; // Failed
    }
}