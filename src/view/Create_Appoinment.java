/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Model.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import controller.AppointmentController;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
    
public class Create_Appoinment extends javax.swing.JFrame {

    private int loggedInPatientId;
    private String loggedInPatientName;
    private boolean updatingComboBoxes = false;
    
    
    
    public Create_Appoinment() {
    initComponents();
    initializeAppointmentForm();
}

public Create_Appoinment(int patientId, String patientName) {
    initComponents();

    this.loggedInPatientId = patientId;
    this.loggedInPatientName = patientName;

  

    initializeAppointmentForm();
}

    private void initializeAppointmentForm() {

    SelectDentist.removeAllItems();
    SelectDentist.addItem("Select Dentist");
    SelectDentist.setEnabled(false);

    dentistTimetxt.removeAllItems();
    dentistTimetxt.addItem("Select Time");
    dentistTimetxt.setEnabled(false);

    
    AppoinmentDatetxt.addPropertyChangeListener(
            "date",
            evt -> loadDentistsByDate()
    );

    
    SelectDentist.addActionListener(
            evt -> loadAvailableTimes()
    );
}
    
    private void loadDentistsByDate() {

    if (updatingComboBoxes) {
            return;
        }

        updatingComboBoxes = true;

        try {
            SelectDentist.removeAllItems();
            SelectDentist.addItem("Select Dentist");
            SelectDentist.setEnabled(false);

            dentistTimetxt.removeAllItems();
            dentistTimetxt.addItem("Select Time");
            dentistTimetxt.setEnabled(false);

            if (AppoinmentDatetxt.getDate() == null) {
                return;
            }

            java.sql.Date selectedDate = new java.sql.Date(
                    AppoinmentDatetxt.getDate().getTime()
            );


            String sql =
                    "SELECT DISTINCT doctor_name "
                    + "FROM approved_dentist_schedule "
                    + "WHERE work_date = ? "
                    + "AND start_time IS NOT NULL "
                    + "AND end_time IS NOT NULL "
                    + "ORDER BY doctor_name";

            try (Connection con = DBconnect.getConnection();
                 PreparedStatement pst = con.prepareStatement(sql)) {

                pst.setDate(1, selectedDate);

                try (ResultSet rs = pst.executeQuery()) {

                    boolean dentistFound = false;

                    while (rs.next()) {
                        SelectDentist.addItem(
                                rs.getString("doctor_name")
                        );
                        dentistFound = true;
                    }

                    if (dentistFound) {
                        SelectDentist.setEnabled(true);
                    } else {
                        SelectDentist.removeAllItems();
                        SelectDentist.addItem("No dentists available");
                    }
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Dentists load failed.\n" + ex.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            updatingComboBoxes = false;
        }
    }
    
    private void loadAvailableTimes() {

    if (updatingComboBoxes) {
        return;
    }

    updatingComboBoxes = true;

    try {
        dentistTimetxt.removeAllItems();
        dentistTimetxt.addItem("Select Time");
        dentistTimetxt.setEnabled(false);

        if (AppoinmentDatetxt.getDate() == null) {
            return;
        }

        Object selectedItem = SelectDentist.getSelectedItem();

        if (selectedItem == null) {
            return;
        }

        String selectedDentist = selectedItem.toString();

        if (selectedDentist.equals("Select Dentist")
                || selectedDentist.equals("No dentists available")) {
            return;
        }

        java.sql.Date selectedDate = new java.sql.Date(
                AppoinmentDatetxt.getDate().getTime()
        );


        controller.AppointmentController appointmentController = new controller.AppointmentController();
        java.util.List<String> timeList = appointmentController.getAvailableTimes(selectedDate, selectedDentist);

        if (!timeList.isEmpty()) {
            for (String timeSlot : timeList) {
                dentistTimetxt.addItem(timeSlot);
            }
            dentistTimetxt.setEnabled(true);
        } else {
            dentistTimetxt.removeAllItems();
            dentistTimetxt.addItem("No time available");
        }

    } catch (Exception ex) {
        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Available time load failed.\n" + ex.getMessage(),
                "Database Error",
                javax.swing.JOptionPane.ERROR_MESSAGE
        );
    } finally {
        updatingComboBoxes = false;
    }
}
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dentistTimetxt = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        createappointmentBtn = new javax.swing.JButton();
        AppoinmentDatetxt = new com.toedter.calendar.JDateChooser();
        SelectDentist = new javax.swing.JComboBox<>();
        PName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        PAge = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        PNumber = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Create Appoinment");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Sunrise logo Light Small-01.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 128));

        jLabel2.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel2.setText("Dentist");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, -1, -1));

        jLabel5.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel5.setText("Treatment Type");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 390, -1, -1));

        jLabel3.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel3.setText("Patient Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        jLabel6.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel6.setText("Available Time");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 500, -1, -1));

        dentistTimetxt.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        dentistTimetxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Time" }));
        getContentPane().add(dentistTimetxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 550, 360, 40));

        jComboBox2.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dental Cleanings & Scaling", "Tooth Extractions", "Dental Fillings", "Root Canal Treatment" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 440, 360, 40));

        createappointmentBtn.setBackground(new java.awt.Color(0, 102, 102));
        createappointmentBtn.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        createappointmentBtn.setForeground(new java.awt.Color(255, 255, 255));
        createappointmentBtn.setText("Create Appoinment");
        createappointmentBtn.setToolTipText("");
        createappointmentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createappointmentBtnActionPerformed(evt);
            }
        });
        getContentPane().add(createappointmentBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 660, -1, 40));

        AppoinmentDatetxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(AppoinmentDatetxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 350, 40));

        SelectDentist.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", " ", " ", " ", " ", " ", " ", " " }));
        getContentPane().add(SelectDentist, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 550, 330, 40));
        getContentPane().add(PName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 320, 40));

        jLabel4.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel4.setText("Appoinment Date");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, -1));
        getContentPane().add(PAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 240, 350, 40));

        jLabel7.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel7.setText("Patient Age");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, -1, -1));
        getContentPane().add(PNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 320, 40));

        jLabel8.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel8.setText("Mobile No");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void createappointmentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createappointmentBtnActionPerformed
        
                
        String patientName = PName.getText().trim();
        String patientAgeStr = PAge.getText().trim();
        String mobileNumber = PNumber.getText().trim();
        java.util.Date date = AppoinmentDatetxt.getDate();
        
        if (patientName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter patient name.");
            PName.requestFocus();
            return;
        }

        if (patientAgeStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter patient age.");
            PAge.requestFocus();
            return;
        }

        int patientAge;
        try {
            patientAge = Integer.parseInt(patientAgeStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric age.");
            PAge.requestFocus();
            return;
        }

        if (mobileNumber.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter mobile number.");
            PNumber.requestFocus();
            return;
        }

        if (date == null) {
            JOptionPane.showMessageDialog(this, "Please select an appointment date.");
            return;
        }

        String dentist = String.valueOf(SelectDentist.getSelectedItem());
        String time = String.valueOf(dentistTimetxt.getSelectedItem());
        String treatment = String.valueOf(jComboBox2.getSelectedItem());

        if (dentist.equals("Select Dentist") || dentist.equals("No dentists available") || dentist.equals("null")) {
            JOptionPane.showMessageDialog(this, "Please select a dentist.");
            return;
        }

        if (time.equals("Select Time") || time.equals("No time available") || time.equals("null")) {
            JOptionPane.showMessageDialog(this, "Please select a time.");
            return;
        }

        
        String sql = "INSERT INTO appointments "
                + "(PName, PAge, PNumber, dentist_name, appointment_date, appointment_time, treatment_type) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBconnect.getConnection()) {
            if (con == null) {
                JOptionPane.showMessageDialog(this, "Database connection failed.");
                return;
            }

            try (PreparedStatement pst = con.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS)) {
    pst.setString(1, patientName);
    pst.setInt(2, patientAge);
    pst.setString(3, mobileNumber);
    pst.setString(4, dentist);
    pst.setDate(5, new java.sql.Date(date.getTime()));
    pst.setString(6, time);
    pst.setString(7, treatment);

    int result = pst.executeUpdate();
    if (result > 0) {
        
        int generatedAppointmentId = -1;
        try (ResultSet rsKeys = pst.getGeneratedKeys()) {
            if (rsKeys.next()) {
                generatedAppointmentId = rsKeys.getInt(1);
            }
        }

        JOptionPane.showMessageDialog(this, "Appointment created successfully!");
        
        
        generateAppointmentPDF(generatedAppointmentId, patientName, patientAge, mobileNumber, dentist, date, time, treatment);
    }

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    
        
    }//GEN-LAST:event_createappointmentBtnActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        String dentist = String.valueOf(SelectDentist.getSelectedItem());
        String time = String.valueOf(dentistTimetxt.getSelectedItem());
        String treatment = String.valueOf(jComboBox2.getSelectedItem());
    }//GEN-LAST:event_jComboBox2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Create_Appoinment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Create_Appoinment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Create_Appoinment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Create_Appoinment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Create_Appoinment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser AppoinmentDatetxt;
    private javax.swing.JTextField PAge;
    private javax.swing.JTextField PName;
    private javax.swing.JTextField PNumber;
    private javax.swing.JComboBox<String> SelectDentist;
    private javax.swing.JButton createappointmentBtn;
    private javax.swing.JComboBox<String> dentistTimetxt;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void generateAppointmentPDF(int appointmentId, String name, int age, String mobile, String dentist, java.util.Date date, String time, String treatment) {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String dateStr = sdf.format(date);

        String userHome = System.getProperty("user.home");
        File dir = new File(userHome + "/Desktop/Appointments");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String filePath = dir.getAbsolutePath() + "/Appointment_" + appointmentId + ".pdf";

        try {
            // OpenPDF Document initialization
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            // Clinic Header Fonts & Colors
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20, new Color(0, 102, 153));
            Paragraph title = new Paragraph("SUNRISE DENTAL CLINIC", titleFont);
            title.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(title);

            Font subtitleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, Color.DARK_GRAY);
            Paragraph subtitle = new Paragraph("Official Appointment Slip\n\n", subtitleFont);
            subtitle.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(subtitle);

            // Table with 2 columns
            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100);
            table.setWidths(new float[]{2f, 3f});

            addTableCell(table, "Appointment ID:", true);
            addTableCell(table, "APN-" + appointmentId, false);

            addTableCell(table, "Patient Name:", true);
            addTableCell(table, name, false);

            addTableCell(table, "Patient Age:", true);
            addTableCell(table, String.valueOf(age), false);

            addTableCell(table, "Mobile Number:", true);
            addTableCell(table, mobile, false);

            addTableCell(table, "Dentist Name:", true);
            addTableCell(table, dentist, false);

            addTableCell(table, "Appointment Date:", true);
            addTableCell(table, dateStr, false);

            addTableCell(table, "Appointment Time:", true);
            addTableCell(table, time, false);

            addTableCell(table, "Treatment Type:", true);
            addTableCell(table, treatment, false);

            addTableCell(table, "Status:", true);
            addTableCell(table, "Pending Confirmation", false);

            document.add(table);

            // Footer Note
            Font footerFont = FontFactory.getFont(FontFactory.HELVETICA, 10, Color.GRAY);
            Paragraph footer = new Paragraph("\nThank you for choosing Sunrise Dental! Please arrive 10 minutes prior to your time slot.", footerFont);
            footer.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(footer);

            document.close();

            JOptionPane.showMessageDialog(this, "Appointment PDF successfully downloaded to your Desktop under 'Appointments' folder!\nPath: " + filePath);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error generating PDF: " + e.getMessage(), "PDF Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void addTableCell(PdfPTable table, String text, boolean isHeader) {
        Font font = FontFactory.getFont(FontFactory.HELVETICA, 11, isHeader ? Font.BOLD : Font.NORMAL);
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setPadding(8);
        if (isHeader) {
            cell.setBackgroundColor(new Color(230, 230, 230));
        }
        table.addCell(cell);
    }
    
}
