package controller;

import Model.AdminDentistDAO;
import Model.Dentist;
import java.sql.SQLException;
import java.util.List;

public class AdminDentistController {
    private AdminDentistDAO dao;

    public AdminDentistController() {
        this.dao = new AdminDentistDAO();
    }

    public List<Dentist> loadDentists() {
        try {
            return dao.getAllDentistDetails();
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Dentist> searchDentists(String keyword) {
        try {
            return dao.searchDentists(keyword);
        } catch (SQLException e) {
            return null;
        }
    }

    public String createAccount(String name, String contact, String address, String email, String pwd, String repwd) {
        if (name.isEmpty() || contact.isEmpty() || address.isEmpty() || email.isEmpty() || pwd.isEmpty()) {
            return "EMPTY_FIELDS";
        }
        if (!pwd.equals(repwd)) {
            return "PASSWORD_MISMATCH";
        }
        try {
            Dentist d = new Dentist(name, contact, address, email, pwd);
            boolean success = dao.createDentist(d);
            return success ? "SUCCESS" : "FAILED";
        } catch (SQLException e) {
            return "DB_ERROR: " + e.getMessage();
        }
    }

    public String updateAccount(String name, String contact, String address, String email, String pwd, String repwd) {
        if (name.isEmpty() || contact.isEmpty() || address.isEmpty() || email.isEmpty()) {
            return "EMPTY_FIELDS";
        }
        boolean updatePwd = false;
        if (!pwd.isEmpty()) {
            if (!pwd.equals(repwd)) {
                return "PASSWORD_MISMATCH";
            }
            updatePwd = true;
        }
        try {
            Dentist d = new Dentist(name, contact, address, email, pwd);
            boolean success = dao.updateDentist(d, updatePwd);
            return success ? "SUCCESS" : "UPDATE_FAILED";
        } catch (SQLException e) {
            return "DB_ERROR: " + e.getMessage();
        }
    }

    public List<Dentist> loadSchedules() {
        try {
            return dao.getDentistSchedules();
        } catch (SQLException e) {
            return null;
        }
    }

    public boolean approveSchedule(String date, String name, String start, String end) {
        try {
            return dao.approveSchedule(date, name, start, end);
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean removeSchedule(String name, String date) {
        try {
            return dao.removeSchedule(name, date);
        } catch (SQLException e) {
            return false;
        }
    }
}