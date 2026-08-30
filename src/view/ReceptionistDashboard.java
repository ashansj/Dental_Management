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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ReceptionistDashboard extends javax.swing.JFrame {

    /**
     * Creates new form ReceptionistDashboard
     */
    public ReceptionistDashboard() {
        initComponents();
        setLocationRelativeTo(null);
    }
        
        
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        endAppoinmentBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        DentistNote = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(0, 102, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Sunrise logo Light Small-01.png"))); // NOI18N
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jButton1.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jButton1.setText("Create Appointment");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 102, 153));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 782, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel1.setText("Appointment ID:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine", "Unit Price", "Quantity", "Total"
            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setRowHeight(25);
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel2.setText("Total Amount :");

        jLabel3.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel3.setText("RS 00.00");

        endAppoinmentBtn.setText("End Appointment and Generate Bill");
        endAppoinmentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endAppoinmentBtnActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 153));
        jLabel4.setText("Appointment Fee : RS. 1500.00");

        jLabel5.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel5.setText("Note:");

        DentistNote.setColumns(20);
        DentistNote.setRows(5);
        jScrollPane2.setViewportView(DentistNote);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 752, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(endAppoinmentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(37, 37, 37)
                                        .addComponent(jLabel3))))
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(27, 27, 27)
                .addComponent(endAppoinmentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Create_Appoinment CA = new Create_Appoinment();
        CA.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        
DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); 

    String appIdStr = jTextField1.getText().trim();
    if (appIdStr.isEmpty()) {
        jLabel3.setText("RS 0.00");
        return;
    }

    try {
        int appointmentId = Integer.parseInt(appIdStr);
        java.sql.Connection con = Model.DBconnect.getConnection();
        
        
        String query = "SELECT m.med_name, m.price, p.quantity, p.total_price " +
                       "FROM patient_prescriptions p " +
                       "JOIN medicines m ON p.med_id = m.med_id " +
                       "WHERE p.appointment_id = ?";
        
        String noteQuery = "SELECT note FROM patient_prescriptions WHERE appointment_id = ? LIMIT 1";
    java.sql.PreparedStatement pstNote = con.prepareStatement(noteQuery);
    pstNote.setInt(1, appointmentId);
    java.sql.ResultSet rsNote = pstNote.executeQuery();
    
    if (rsNote.next()) {
        String fetchedNote = rsNote.getString("note");
        DentistNote.setText(fetchedNote);
    } else {
        DentistNote.setText("");
    }
                       
        java.sql.PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, appointmentId);
        java.sql.ResultSet rs = pst.executeQuery();

        double medicinesTotal = 0.0;

        while (rs.next()) {
            String medName = rs.getString("med_name");
            double unitPrice = rs.getDouble("price");
            int qty = rs.getInt("quantity");
            double totalPrice = rs.getDouble("total_price");

            medicinesTotal += totalPrice;

            
            model.addRow(new Object[]{medName, unitPrice, qty, totalPrice});
        }

        
        double appointmentFee = 1500.00;
        double grandTotal = medicinesTotal + appointmentFee;

        jLabel3.setText("RS " + String.format("%.2f", grandTotal));

    } catch (NumberFormatException e) {
        
    } catch (Exception e) {
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }
        
    }//GEN-LAST:event_jTextField1KeyReleased

    private void endAppoinmentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endAppoinmentBtnActionPerformed
        
        String appIdStr = jTextField1.getText().trim();
    
    if (appIdStr.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Please enter or check the Appointment ID first!");
        return;
    }
    
    try {
        int appointmentId = Integer.parseInt(appIdStr);
        java.sql.Connection con = Model.DBconnect.getConnection();
        
        // 1. Get patient and dentist details from appointments table
        String appQuery = "SELECT PName, PNumber, dentist_name FROM appointments WHERE appointment_id = ?";
        java.sql.PreparedStatement pstApp = con.prepareStatement(appQuery);
        pstApp.setInt(1, appointmentId);
        java.sql.ResultSet rsApp = pstApp.executeQuery();
        
        String patientName = "";
        String mobileNo = "";
        String dentistName = "";
        
        if (rsApp.next()) {
            patientName = rsApp.getString("PName");
            mobileNo = rsApp.getString("PNumber");
            dentistName = rsApp.getString("dentist_name");
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Appointment ID not found in database!");
            return;
        }
        
        // 2. Create PDF table for medicines before looping
        com.lowagie.text.pdf.PdfPTable pdfTable = new com.lowagie.text.pdf.PdfPTable(4);
        pdfTable.setWidthPercentage(100);
        pdfTable.setSpacingBefore(10f);
        pdfTable.setSpacingAfter(10f);
        
        pdfTable.addCell("Medicine");
        pdfTable.addCell("Unit Price");
        pdfTable.addCell("Quantity");
        pdfTable.addCell("Total");

        String medDetailsStr = "";
        double medicinesTotal = 0.0;
        
        // Fetch prescriptions and medicines details
        String presQuery = "SELECT m.med_name, m.price, p.quantity, p.total_price FROM patient_prescriptions p JOIN medicines m ON p.med_id = m.med_id WHERE p.appointment_id = ?";
        java.sql.PreparedStatement pstPres = con.prepareStatement(presQuery);
        pstPres.setInt(1, appointmentId);
        java.sql.ResultSet rsPres = pstPres.executeQuery();
        
        // Loop through result set to populate both string details, total, and PDF table simultaneously
        while (rsPres.next()) {
            String medName = rsPres.getString("med_name");
            double unitPrice = rsPres.getDouble("price");
            int qty = rsPres.getInt("quantity");
            double totPrice = rsPres.getDouble("total_price");
            
            medicinesTotal += totPrice;
            medDetailsStr += medName + " (Qty: " + qty + ", Price: " + totPrice + "); ";
            
            // Add rows directly to PDF table here to avoid scrolling issues
            pdfTable.addCell(medName);
            pdfTable.addCell(String.valueOf(unitPrice));
            pdfTable.addCell(String.valueOf(qty));
            pdfTable.addCell(String.valueOf(totPrice));
        }
        
        String noteText = DentistNote.getText().trim();
        double appointmentFee = 1500.00;
        double totalAmount = medicinesTotal + appointmentFee;
        
        // 3. Insert data into completed_appointments table (Transfer)
        String insertQuery = "INSERT INTO completed_appointments (appointment_id, patient_name, mobile_no, dentist_name, appointment_fee, medicines_detail, note, total_amount) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        java.sql.PreparedStatement pstInsert = con.prepareStatement(insertQuery);
        pstInsert.setInt(1, appointmentId);
        pstInsert.setString(2, patientName);
        pstInsert.setString(3, mobileNo);
        pstInsert.setString(4, dentistName);
        pstInsert.setDouble(5, appointmentFee);
        pstInsert.setString(6, medDetailsStr);
        pstInsert.setString(7, noteText);
        pstInsert.setDouble(8, totalAmount);
        pstInsert.executeUpdate();
        
        // 4. Delete the appointment from active appointments table
        String deleteQuery = "DELETE FROM appointments WHERE appointment_id = ?";
        java.sql.PreparedStatement pstDelete = con.prepareStatement(deleteQuery);
        pstDelete.setInt(1, appointmentId);
        pstDelete.executeUpdate();
        
        // 5. Generate PDF Bill using OpenPDF
        String dest = "Bill_" + appointmentId + ".pdf";
        com.lowagie.text.Document document = new com.lowagie.text.Document();
        com.lowagie.text.pdf.PdfWriter.getInstance(document, new java.io.FileOutputStream(dest));
        document.open();
        
        com.lowagie.text.Font titleFont = new com.lowagie.text.Font(com.lowagie.text.Font.HELVETICA, 20, com.lowagie.text.Font.BOLD, java.awt.Color.BLUE);
        com.lowagie.text.Font normalFont = new com.lowagie.text.Font(com.lowagie.text.Font.HELVETICA, 12, com.lowagie.text.Font.NORMAL);
        com.lowagie.text.Font boldFont = new com.lowagie.text.Font(com.lowagie.text.Font.HELVETICA, 12, com.lowagie.text.Font.BOLD);
        
        document.add(new com.lowagie.text.Paragraph("SUNRISE DENTAL CLINIC", titleFont));
        document.add(new com.lowagie.text.Paragraph("Patient Treatment Bill", boldFont));
        document.add(new com.lowagie.text.Paragraph("------------------------------------------------------------------------------------------------------------------"));
        
        document.add(new com.lowagie.text.Paragraph("Appointment ID : " + appointmentId, normalFont));
        document.add(new com.lowagie.text.Paragraph("Patient Name     : " + patientName, normalFont));
        document.add(new com.lowagie.text.Paragraph("Mobile No          : " + mobileNo, normalFont));
        document.add(new com.lowagie.text.Paragraph("Dentist Name    : " + dentistName, normalFont));
        document.add(new com.lowagie.text.Paragraph("------------------------------------------------------------------------------------------------------------------"));
        
        document.add(new com.lowagie.text.Paragraph("Prescription & Medicines:", boldFont));
        
        // Add the pre-populated PDF table to document
        document.add(pdfTable);
        
        document.add(new com.lowagie.text.Paragraph("Note : " + noteText, normalFont));
        document.add(new com.lowagie.text.Paragraph("------------------------------------------------------------------------------------------------------------------"));
        document.add(new com.lowagie.text.Paragraph("Appointment Fee : RS. " + String.format("%.2f", appointmentFee), normalFont));
        document.add(new com.lowagie.text.Paragraph("Total Amount       : RS. " + String.format("%.2f", totalAmount), boldFont));
        
        document.close();
        
        javax.swing.JOptionPane.showMessageDialog(this, "Appointment completed, transferred, and Bill PDF generated successfully!");
        
        // Clear UI components
        jTextField1.setText("");
        DentistNote.setText("");
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        jLabel3.setText("RS 0.00");
        
        // Automatically open the generated PDF bill
        if (java.awt.Desktop.isDesktopSupported()) {
            java.awt.Desktop.getDesktop().open(new java.io.File(dest));
        }

    } catch (Exception e) {
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }
        
        
    }//GEN-LAST:event_endAppoinmentBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ReceptionistDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReceptionistDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReceptionistDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReceptionistDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReceptionistDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea DentistNote;
    private javax.swing.JButton endAppoinmentBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
