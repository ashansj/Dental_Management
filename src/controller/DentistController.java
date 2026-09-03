package Controller;

import Model.DentistDAO;
import Model.Schedule;
import java.sql.SQLException;
import java.util.List;

public class DentistController {
    private DentistDAO dao;

    public DentistController() {
        this.dao = new DentistDAO();
    }

    public List<Schedule> loadDentistSchedules(String doctorName) {
        return dao.getSchedules(doctorName);
    }

    public String updateDentistStatus(String docName, String workDate, String status, String startTime, String endTime) {
        if (workDate.isEmpty()) {
            return "ERR_DATE";
        }
        
        try {
            boolean success = dao.insertSchedule(docName, workDate, status, startTime, endTime);
            if (success) {
                return "SUCCESS";
            }
        } catch (SQLException e) {
            return "DB_ERROR:" + e.getMessage();
        }
        return "FAILED";
    }
}