package controller;

import Model.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentController {

    public List<String> getAvailableTimes(java.sql.Date selectedDate, String selectedDentist) {
        List<String> timeList = new ArrayList<>();
        
        String sql = "SELECT start_time, end_time "
                   + "FROM approved_dentist_schedule "
                   + "WHERE work_date = ? "
                   + "AND doctor_name = ? "
                   + "ORDER BY start_time";

        try (Connection con = DBconnect.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setDate(1, selectedDate);
            pst.setString(2, selectedDentist);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    String startTime = rs.getString("start_time");
                    String endTime = rs.getString("end_time");
                    timeList.add(startTime + " - " + endTime);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return timeList;
    }
}