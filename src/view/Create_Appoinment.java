package view;

import controller.AppointmentController;
import javax.swing.JOptionPane;
import java.util.List;

public class Create_Appoinment extends javax.swing.JFrame {

    private int loggedInPatientId;
    private String loggedInPatientName;
    private boolean updatingComboBoxes = false;
    private AppointmentController controller;

    public Create_Appoinment() {
        initComponents();
        controller = new AppointmentController();
        initializeAppointmentForm();
    }

    public Create_Appoinment(int patientId, String patientName) {
        initComponents();
        this.loggedInPatientId = patientId;
        this.loggedInPatientName = patientName;
        controller = new AppointmentController();
        initializeAppointmentForm();
    }

    private void initializeAppointmentForm() {
        SelectDentist.removeAllItems();
        SelectDentist.addItem("Select Dentist");
        SelectDentist.setEnabled(false);

        dentistTimetxt.removeAllItems();
        dentistTimetxt.addItem("Select Time");
        dentistTimetxt.setEnabled(false);

        AppoinmentDatetxt.addPropertyChangeListener("date", evt -> loadDentistsByDate());
        SelectDentist.addActionListener(evt -> loadAvailableTimes());
    }

    private void loadDentistsByDate() {
        if (updatingComboBoxes || AppoinmentDatetxt.getDate() == null) return;

        updatingComboBoxes = true;
        SelectDentist.removeAllItems();
        dentistTimetxt.removeAllItems();
        dentistTimetxt.addItem("Select Time");
        dentistTimetxt.setEnabled(false);

        try {
            List<String> dentists = controller.getDentistsByDate(AppoinmentDatetxt.getDate());
            if (!dentists.isEmpty()) {
                for (String d : dentists) {
                    SelectDentist.addItem(d);
                }
                SelectDentist.setEnabled(true);
            } else {
                SelectDentist.addItem("No dentists available");
                SelectDentist.setEnabled(false);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Dentists load failed.\n" + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            updatingComboBoxes = false;
        }
    }

    private void loadAvailableTimes() {
        if (updatingComboBoxes || AppoinmentDatetxt.getDate() == null || SelectDentist.getSelectedItem() == null) return;

        String selectedDentist = SelectDentist.getSelectedItem().toString();
        if (selectedDentist.equals("Select Dentist") || selectedDentist.equals("No dentists available")) return;

        updatingComboBoxes = true;
        dentistTimetxt.removeAllItems();

        try {
            java.sql.Date selectedDate = new java.sql.Date(AppoinmentDatetxt.getDate().getTime());
            List<String> timeList = controller.getAvailableTimes(selectedDate, selectedDentist);

            if (!timeList.isEmpty()) {
                for (String timeSlot : timeList) {
                    dentistTimetxt.addItem(timeSlot);
                }
                dentistTimetxt.setEnabled(true);
            } else {
                dentistTimetxt.addItem("No time available");
                dentistTimetxt.setEnabled(false);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Available time load failed.\n" + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            updatingComboBoxes = false;
        }
    }
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
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setPreferredSize(new java.awt.Dimension(1260, 750));
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
    String dentist = String.valueOf(SelectDentist.getSelectedItem());
    String time = String.valueOf(dentistTimetxt.getSelectedItem());
    String treatment = String.valueOf(jComboBox2.getSelectedItem());

    
    String result = controller.createAppointment(patientName, patientAgeStr, mobileNumber, dentist, date, time, treatment);

    if (result.startsWith("SUCCESS:")) {
        String pdfPath = result.split(":")[1];
        
        
        JOptionPane.showMessageDialog(this, "Appointment created successfully!");
        
        // PDF  (Pop-up)
        try {
            java.io.File pdfFile = new java.io.File(pdfPath);
            if (pdfFile.exists() && java.awt.Desktop.isDesktopSupported()) {
                java.awt.Desktop.getDesktop().open(pdfFile);
            } else {
                JOptionPane.showMessageDialog(this, "PDF Created success fully: \n path:C:\\Users\\ashan\\Desktop\\Appointments");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error opening PDF: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    } else if (result.startsWith("SUCCESS_NO_PDF:")) {
        JOptionPane.showMessageDialog(this, "Appointment created, but PDF failed: " + result.split(":")[1], "Warning", JOptionPane.WARNING_MESSAGE);
    } else {
        // Error Handling
        switch (result) {
            case "ERR_NAME": JOptionPane.showMessageDialog(this, "Please enter patient name."); PName.requestFocus(); break;
            case "ERR_AGE_EMPTY": JOptionPane.showMessageDialog(this, "Please enter patient age."); PAge.requestFocus(); break;
            case "ERR_AGE_FORMAT": JOptionPane.showMessageDialog(this, "Please enter a valid numeric age."); PAge.requestFocus(); break;
            case "ERR_MOBILE": JOptionPane.showMessageDialog(this, "Please enter mobile number."); PNumber.requestFocus(); break;
            case "ERR_DATE": JOptionPane.showMessageDialog(this, "Please select an appointment date."); break;
            case "ERR_DENTIST": JOptionPane.showMessageDialog(this, "Please select a dentist."); break;
            case "ERR_TIME": JOptionPane.showMessageDialog(this, "Please select a time."); break;
            default: JOptionPane.showMessageDialog(this, "Database Error: " + result, "Error", JOptionPane.ERROR_MESSAGE); break;
        }
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

    
    
}
