/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import Model.DBconnect;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class AdminPatient extends javax.swing.JFrame {

    
    public AdminPatient() {
        initComponents();
        // Call the method to load data when the UI initializes
        loadPatientData(); 
    }

    
    // Method to load data from the database to the JTable
    private void loadPatientData() {
        // SQL query to select required columns from patient_login table
        String sql = "SELECT full_name, email, dob, contact_no, nic, address FROM patient_login";
        
        try {
            // Establish the database connection
            // Note: Use your actual connection class and method here (e.g., DBconnect)
            Connection conn = DBconnect.getConnection(); // Adjust this based on your DBconnect class
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            // Get the table model from your JTable
            // Replace 'jTable1' with the actual variable name of your JTable if it's different
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            
            // Clear existing rows in the JTable to prevent data duplication on refresh
            model.setRowCount(0);
            
            // Loop through the database result set
            while (rs.next()) {
                // Fetch data from each column in the current row
                String name = rs.getString("full_name");
                String email = rs.getString("email");
                String dob = rs.getString("dob");
                String contact = rs.getString("contact_no");
                String nic = rs.getString("nic");
                String address = rs.getString("address");
                
                // Create an object array representing a single row in the JTable
                // Ensure the order matches your JTable columns: Full Name, Email, Date of Birth, Contact No, NIC, Address
                Object[] rowData = {name, email, dob, contact, nic, address};
                
                // Add the populated row to the table model
                model.addRow(rowData);
            }
            
            // Close database resources to prevent memory leaks
            rs.close();
            pst.close();
            conn.close(); // Only close if you are not using a persistent connection
            
        } catch (Exception e) {
            // Print error to console for debugging
            System.out.println("Error loading patient data: " + e.getMessage());
            e.printStackTrace();
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        createPatientAccountBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        Fnametxt = new javax.swing.JTextField();
        Emailtxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        contactNotxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        dobtxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        addresstxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setMinimumSize(new java.awt.Dimension(960, 776));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 102, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Home");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 230, 50));

        jPanel4.setBackground(new java.awt.Color(0, 102, 153));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Dentist Dashboard");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(50, 50, 50))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jPanel5.setBackground(new java.awt.Color(0, 153, 204));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Patient Dashboard");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(50, 50, 50))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Sunrise logo Light Small-01.png"))); // NOI18N
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 776));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 153));
        jLabel4.setText("Patient Dashboard");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 370, 50));

        createPatientAccountBtn.setFont(new java.awt.Font("Poppins", 1, 13)); // NOI18N
        createPatientAccountBtn.setText("Create Patient Account");
        createPatientAccountBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createPatientAccountBtnActionPerformed(evt);
            }
        });
        jPanel2.add(createPatientAccountBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 50, 190, 40));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Full Name", "Email", "Date of Birth", "Contact No", "NIC", "Address"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 710, 260));

        editBtn.setBackground(new java.awt.Color(204, 204, 204));
        editBtn.setText("Edit Data");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });
        jPanel2.add(editBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 600, 150, 40));

        deleteBtn.setBackground(new java.awt.Color(204, 204, 204));
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        jPanel2.add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 600, 150, 40));

        jLabel5.setText("Full Name");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 470, -1, -1));
        jPanel2.add(Fnametxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 470, 170, -1));
        jPanel2.add(Emailtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 470, 170, -1));

        jLabel6.setText("Email");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 470, -1, -1));
        jPanel2.add(contactNotxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 510, 170, -1));

        jLabel7.setText("Contact No");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 510, -1, -1));
        jPanel2.add(dobtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 510, 170, -1));

        jLabel8.setText("Date of birth");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 510, -1, -1));
        jPanel2.add(addresstxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 550, 170, -1));

        jLabel10.setText("Address");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 550, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
                                       
    // Check if a row is selected in the table
    int selectedRow = jTable1.getSelectedRow();
    
    // If no row is selected, show a warning message
    if (selectedRow == -1) {
        javax.swing.JOptionPane.showMessageDialog(this, "Please select a patient from the table to delete.");
        return;
    }

    // Ask for user confirmation before deleting
    int confirm = javax.swing.JOptionPane.showConfirmDialog(this, 
            "Are you sure you want to delete this patient's record?", 
            "Confirm Deletion", 
            javax.swing.JOptionPane.YES_NO_OPTION);
            
    // If the user clicks "Yes" (YES_OPTION)
    if (confirm == javax.swing.JOptionPane.YES_OPTION) {
        
        // Get the NIC from the selected row (Column index 4) to identify the record in the database
        String nic = jTable1.getValueAt(selectedRow, 4).toString();

        // SQL query to delete the record based on the NIC
        String sql = "DELETE FROM patient_login WHERE nic = ?";

        try {
            // Establish database connection (Update 'DBconnect' to your actual connection class)
            java.sql.Connection conn = DBconnect.getConnection();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            
            // Bind the NIC value to the SQL query
            pst.setString(1, nic);
            
            // Execute the delete query
            int deletedRows = pst.executeUpdate();
            
            if (deletedRows > 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "Patient record deleted successfully!");
                
                // Refresh the JTable to show the updated data (removes the deleted row from view)
                loadPatientData(); 
                
                // Clear the text fields after successful deletion
                Fnametxt.setText("");
                Emailtxt.setText("");
                dobtxt.setText("");
                contactNotxt.setText("");
                addresstxt.setText("");
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Deletion failed. Record not found.");
            }
            
            // Close database resources
            pst.close();
            conn.close();
            
        } catch (Exception e) {
            // Show error message if an exception occurs
            javax.swing.JOptionPane.showMessageDialog(this, "Error during deletion: " + e.getMessage());
            e.printStackTrace();
        }
    }

    }//GEN-LAST:event_deleteBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        int selectedRow = jTable1.getSelectedRow();
    if (selectedRow == -1) {
        javax.swing.JOptionPane.showMessageDialog(this, "Please select a patient from the table to edit.");
        return;
    }
    String name = Fnametxt.getText();
    String email = Emailtxt.getText();
    String dob = dobtxt.getText();
    String contact = contactNotxt.getText();
    String address = addresstxt.getText();
    
    String nic = jTable1.getValueAt(selectedRow, 4).toString();
    
    String sql = "UPDATE patient_login SET full_name=?, email=?, dob=?, contact_no=?, address=? WHERE nic=?";
    
    try {
        // Establish database connection (Update 'DBconnect' to your actual connection class)
        java.sql.Connection conn = DBconnect.getConnection();
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        
        // Bind the values to the SQL query
        pst.setString(1, name);
        pst.setString(2, email);
        pst.setString(3, dob);
        pst.setString(4, contact);
        pst.setString(5, address);
        pst.setString(6, nic); // This is for the WHERE clause
        
        // Execute the update query
        int updatedRows = pst.executeUpdate();
        
        if (updatedRows > 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Patient details updated successfully!");
            
            // Refresh the JTable to show the updated data
            // (Assuming you have the loadPatientData() method from the previous step)
            loadPatientData(); 
            
            // Optionally, clear the text fields after a successful update
            Fnametxt.setText("");
            Emailtxt.setText("");
            dobtxt.setText("");
            contactNotxt.setText("");
            addresstxt.setText("");
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Update failed. Please try again.");
        }
        
        // Close resources
        pst.close();
        conn.close();
        
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error during update: " + e.getMessage());
        e.printStackTrace();
    }
    
    }//GEN-LAST:event_editBtnActionPerformed

    private void createPatientAccountBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createPatientAccountBtnActionPerformed
        PatientSignUp patientAccount = new PatientSignUp();
        patientAccount.setVisible(true);

    }//GEN-LAST:event_createPatientAccountBtnActionPerformed

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        AdminDentist Dentist = new AdminDentist();
        Dentist.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        AdminHome home = new AdminHome();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable1.getModel();
    
    // Get the index of the selected row
    int selectedRow = jTable1.getSelectedRow();
    
    // Check if a row is actually selected
    if (selectedRow != -1) {
        
        Fnametxt.setText(model.getValueAt(selectedRow, 0).toString());
        Emailtxt.setText(model.getValueAt(selectedRow, 1).toString());
        dobtxt.setText(model.getValueAt(selectedRow, 2).toString());
        contactNotxt.setText(model.getValueAt(selectedRow, 3).toString());
        addresstxt.setText(model.getValueAt(selectedRow, 5).toString());
        
        
    }
    
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(AdminPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminPatient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Emailtxt;
    private javax.swing.JTextField Fnametxt;
    private javax.swing.JTextField addresstxt;
    private javax.swing.JTextField contactNotxt;
    private javax.swing.JButton createPatientAccountBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextField dobtxt;
    private javax.swing.JButton editBtn;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
