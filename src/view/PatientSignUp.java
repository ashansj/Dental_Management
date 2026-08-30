

package view;
import Model.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class PatientSignUp extends javax.swing.JFrame {


    public PatientSignUp() {
        initComponents();
        
        
    }
    
    private void clearFields() {
    fnametxt.setText("");
    emailtxt.setText("");
    dobtxt.setText("");
    nictxt.setText("");
    contactnotxt.setText("");
    pwstxt.setText("");
    confirmpwstxt.setText("");
    addresstxt.setText("");
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fnametxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nictxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        dobtxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        emailtxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        contactnotxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        addresstxt = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        createPatientAccBtn = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        confirmpwstxt = new javax.swing.JPasswordField();
        pwstxt = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Create Patient Account");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Sunrise logo Light Small-01.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 128));

        jLabel2.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel2.setText("Full Name *");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        fnametxt.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        fnametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnametxtActionPerformed(evt);
            }
        });
        getContentPane().add(fnametxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 360, 40));

        jLabel3.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel3.setText("NIC / Passport Number *");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, -1, -1));

        nictxt.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        getContentPane().add(nictxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, 360, 40));

        jLabel4.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel4.setText("Date of Birth *");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        dobtxt.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        getContentPane().add(dobtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 360, 40));

        jLabel5.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel5.setText("Email Address *");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, -1, -1));

        emailtxt.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        getContentPane().add(emailtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, 360, 40));

        jLabel6.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel6.setText("Password *");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 410, -1, -1));

        jLabel7.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel7.setText("Contact Number *");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, -1, -1));

        contactnotxt.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        getContentPane().add(contactnotxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 360, 40));

        addresstxt.setColumns(20);
        addresstxt.setRows(5);
        jScrollPane1.setViewportView(addresstxt);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 564, 360, 164));

        jLabel8.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel8.setText("Address*");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, -1, -1));

        jLabel9.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel9.setText("Confirm Password *");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 520, -1, -1));

        createPatientAccBtn.setBackground(new java.awt.Color(0, 102, 102));
        createPatientAccBtn.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        createPatientAccBtn.setForeground(new java.awt.Color(255, 255, 255));
        createPatientAccBtn.setText("Create Patient Account");
        createPatientAccBtn.setToolTipText("");
        createPatientAccBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createPatientAccBtnActionPerformed(evt);
            }
        });
        getContentPane().add(createPatientAccBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 690, -1, -1));

        jButton11.setBackground(new java.awt.Color(0, 102, 102));
        jButton11.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Cancel");
        jButton11.setToolTipText("");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 690, -1, -1));

        confirmpwstxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmpwstxtActionPerformed(evt);
            }
        });
        getContentPane().add(confirmpwstxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 564, 360, 42));
        getContentPane().add(pwstxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 451, 360, 40));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void createPatientAccBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createPatientAccBtnActionPerformed
        String fullName = fnametxt.getText().trim();
        String email = emailtxt.getText().trim();
        String dob = dobtxt.getText().trim();
        String nic = nictxt.getText().trim();
        String contactNo = contactnotxt.getText().trim();
        String password = new String(pwstxt.getPassword());
        String confirmPws = new String(confirmpwstxt.getPassword());
        String address = addresstxt.getText().trim();
        
        
        if (fullName.isEmpty() || email.isEmpty() || dob.isEmpty() || nic.isEmpty() || 
        contactNo.isEmpty() || password.isEmpty() || address.isEmpty()) {
        
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Please Enter details!", 
            "Warning", 
            javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }
        if (!password.equals(confirmPws)) {
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Passwords not match!", 
            "Error", 
            javax.swing.JOptionPane.ERROR_MESSAGE);
        return;
    }
        
        try {

        Connection con = DBconnect.getConnection();

        
        String sql = "INSERT INTO patient_login (full_name, email, dob, nic, contact_no, password, address) VALUES (?, ?, ?, ?, ?, ?, ?);";
        
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, fullName);
        pst.setString(2, email);
        pst.setString(3, dob);
        pst.setString(4, nic);
        pst.setString(5, contactNo);
        pst.setString(6, password);
        pst.setString(7, address);

        int rowsInserted = pst.executeUpdate();

        if (rowsInserted > 0) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Patient registed!", 
                "Success", 
                javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
            
            clearFields();
        }
        
        } catch (Exception e) {
    javax.swing.JOptionPane.showMessageDialog(this, 
        "Database Error: " + e.getMessage(), 
        "Error", 
        javax.swing.JOptionPane.ERROR_MESSAGE);
}
        
    }//GEN-LAST:event_createPatientAccBtnActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void fnametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnametxtActionPerformed

    private void confirmpwstxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmpwstxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmpwstxtActionPerformed


    public static void main(String args[]) {


        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PatientSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PatientSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PatientSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PatientSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }



        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PatientSignUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea addresstxt;
    private javax.swing.JPasswordField confirmpwstxt;
    private javax.swing.JTextField contactnotxt;
    private javax.swing.JButton createPatientAccBtn;
    private javax.swing.JTextField dobtxt;
    private javax.swing.JTextField emailtxt;
    private javax.swing.JTextField fnametxt;
    private javax.swing.JButton jButton11;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nictxt;
    private javax.swing.JPasswordField pwstxt;
    // End of variables declaration//GEN-END:variables
}
