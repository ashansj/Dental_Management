package controller;

import Model.Appointment;
import Model.AppointmentDAO;
import Util.PDFGenerator;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppointmentController {
    
    private AppointmentDAO appointmentDAO;

    public AppointmentController() {
        this.appointmentDAO = new AppointmentDAO();
    }

    public List<String> getDentistsByDate(Date date) throws SQLException {
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        return appointmentDAO.getAvailableDentistsByDate(sqlDate);
    }


    public List<String> getAvailableTimes(java.sql.Date date, String dentistName) {
    try {
        return appointmentDAO.getAvailableTimes(date, dentistName);
    } catch (SQLException e) {
        System.out.println("Error fetching times: " + e.getMessage());
        return new ArrayList<>(); 
    }
}

    public String createAppointment(String name, String ageStr, String mobile, String dentist, Date date, String time, String treatment) {
        
        // Validations
        if (name.isEmpty()) return "ERR_NAME";
        if (ageStr.isEmpty()) return "ERR_AGE_EMPTY";
        
        int age;
        try {
            age = Integer.parseInt(ageStr);
        } catch (NumberFormatException e) {
            return "ERR_AGE_FORMAT";
        }
        
        if (mobile.isEmpty()) return "ERR_MOBILE";
        if (date == null) return "ERR_DATE";
        if (dentist.equals("Select Dentist") || dentist.equals("No dentists available") || dentist.equals("null")) return "ERR_DENTIST";
        if (time.equals("Select Time") || time.equals("No time available") || time.equals("null")) return "ERR_TIME";

        // Create Model object
        Appointment app = new Appointment(name, age, mobile, dentist, date, time, treatment);

        try {
            int appId = appointmentDAO.saveAppointment(app);
            if (appId > 0) {
                try {
                    String pdfPath = PDFGenerator.generateAppointmentPDF(appId, name, age, mobile, dentist, date, time, treatment);
                    return "SUCCESS:" + pdfPath;
                } catch (Exception ex) {
                    return "SUCCESS_NO_PDF:" + ex.getMessage();
                }
            }
        } catch (SQLException e) {
            return "DB_ERROR:" + e.getMessage();
        }
        return "FAILED";
    }
}