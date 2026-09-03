package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DentistDAO {

    public List<Schedule> getSchedules(String doctorName) {
        List<Schedule> schedules = new ArrayList<>();
        
        // approved_dentist_schedule හි දත්ත වලට 'Approved' ලෙසත්, dentist දත්ත වලට එහි status (උදා: Pending) ලෙසත් ලබා ගනී.
        String query = "SELECT work_date, start_time, end_time, 'Approved' AS work_status FROM approved_dentist_schedule WHERE doctor_name = ? " +
                       "UNION ALL " +
                       "SELECT work_date, start_time, end_time, work_status FROM dentist WHERE doctor_name = ?";
        
        try (Connection con = DBconnect.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
             
            pst.setString(1, doctorName);
            pst.setString(2, doctorName);
            
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    String date = rs.getString("work_date");
                    String startTime = rs.getString("start_time");
                    String endTime = rs.getString("end_time");
                    String status = rs.getString("work_status");
                    
                    if (status == null || status.isEmpty()) {
                        status = "Pending"; 
                    }
                    
                    schedules.add(new Schedule(date, startTime, endTime, status));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return schedules;
    }

    public boolean insertSchedule(String docName, String workDate, String status, String startTime, String endTime) throws SQLException {
        String sql = "INSERT INTO dentist (doctor_name, work_date, work_status, start_time, end_time) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection con = DBconnect.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
             
            pst.setString(1, docName);
            pst.setString(2, workDate);
            pst.setString(3, status);
            pst.setString(4, startTime);
            pst.setString(5, endTime);
            
            return pst.executeUpdate() > 0;
        }
    }
}