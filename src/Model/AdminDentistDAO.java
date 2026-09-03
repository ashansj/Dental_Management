package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDentistDAO {

    public List<Dentist> getAllDentistDetails() throws SQLException {
        List<Dentist> list = new ArrayList<>();
        String sql = "SELECT name, contact_no, address, email FROM dentist_details";
        try (Connection conn = DBconnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                list.add(new Dentist(rs.getString("name"), rs.getString("contact_no"), rs.getString("address"), rs.getString("email"), ""));
            }
        }
        return list;
    }

    public List<Dentist> searchDentists(String keyword) throws SQLException {
        List<Dentist> list = new ArrayList<>();
        String sql = "SELECT name, contact_no, address, email FROM dentist_details WHERE name LIKE ? OR contact_no LIKE ? OR address LIKE ? OR email LIKE ?";
        try (Connection conn = DBconnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            String pattern = "%" + keyword + "%";
            pstmt.setString(1, pattern);
            pstmt.setString(2, pattern);
            pstmt.setString(3, pattern);
            pstmt.setString(4, pattern);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    list.add(new Dentist(rs.getString("name"), rs.getString("contact_no"), rs.getString("address"), rs.getString("email"), ""));
                }
            }
        }
        return list;
    }

    public boolean createDentist(Dentist d) throws SQLException {
        String sql = "INSERT INTO dentist_details (name, contact_no, address, email, password) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBconnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, d.getName());
            pstmt.setString(2, d.getContactNo());
            pstmt.setString(3, d.getAddress());
            pstmt.setString(4, d.getEmail());
            pstmt.setString(5, d.getPassword());
            return pstmt.executeUpdate() > 0;
        }
    }

    public boolean updateDentist(Dentist d, boolean updatePwd) throws SQLException {
        String sql = updatePwd ? 
            "UPDATE dentist_details SET name=?, contact_no=?, address=?, password=? WHERE email=?" :
            "UPDATE dentist_details SET name=?, contact_no=?, address=? WHERE email=?";
        
        try (Connection conn = DBconnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, d.getName());
            pstmt.setString(2, d.getContactNo());
            pstmt.setString(3, d.getAddress());
            if (updatePwd) {
                pstmt.setString(4, d.getPassword());
                pstmt.setString(5, d.getEmail());
            } else {
                pstmt.setString(4, d.getEmail());
            }
            return pstmt.executeUpdate() > 0;
        }
    }

    public List<Dentist> getDentistSchedules() throws SQLException {
        List<Dentist> list = new ArrayList<>();
        String sql = "SELECT * FROM dentist";
        try (Connection con = DBconnect.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Dentist(rs.getString("work_date"), rs.getString("doctor_name"), rs.getString("start_time"), rs.getString("end_time")));
            }
        }
        return list;
    }

    public boolean approveSchedule(String workDate, String doctorName, String startTime, String endTime) throws SQLException {
        String insertSql = "INSERT INTO approved_dentist_schedule (work_date, doctor_name, start_time, end_time) VALUES (?, ?, ?, ?)";
        String deleteSql = "DELETE FROM dentist WHERE doctor_name=? AND work_date=? AND start_time=?";
        
        try (Connection con = DBconnect.getConnection()) {
            con.setAutoCommit(false);
            try (PreparedStatement pst1 = con.prepareStatement(insertSql);
                 PreparedStatement pst2 = con.prepareStatement(deleteSql)) {
                
                pst1.setString(1, workDate);
                pst1.setString(2, doctorName);
                pst1.setString(3, startTime);
                pst1.setString(4, endTime);
                pst1.executeUpdate();

                pst2.setString(1, doctorName);
                pst2.setString(2, workDate);
                pst2.setString(3, startTime);
                pst2.executeUpdate();

                con.commit();
                return true;
            } catch (SQLException e) {
                con.rollback();
                throw e;
            }
        }
    }

    public boolean removeSchedule(String doctorName, String workDate) throws SQLException {
        String sql = "DELETE FROM dentist WHERE doctor_name=? AND work_date=?";
        try (Connection con = DBconnect.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, doctorName);
            pst.setString(2, workDate);
            return pst.executeUpdate() > 0;
        }
    }
}