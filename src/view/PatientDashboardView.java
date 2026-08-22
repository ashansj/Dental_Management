/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import db.DBconnect;
    
public class PatientDashboardView extends javax.swing.JFrame {
    
    private int loggedInPatientId;
    private String loggedInPatientName;

    public PatientDashboardView() {
        initComponents();
    }

    public PatientDashboardView(
            int patientId,
            String patientName) {

        initComponents();

        this.loggedInPatientId = patientId;
        this.loggedInPatientName = patientName;

        nameLabel.setText(patientName);

        loadAppointments();
    }
    
    private void loadAppointments() {

    DefaultTableModel tableModel =
            (DefaultTableModel) jTable1.getModel();

    
    tableModel.setRowCount(0);

    String sql =
            "SELECT appointment_date, "
            + "dentist_name, "
            + "treatment_type, "
            + "appointment_time "
            + "FROM appointments "
            + "WHERE patient_id = ? "
            + "ORDER BY appointment_date ASC, "
            + "appointment_time ASC";

    try (Connection con = DBconnect.getConnection()) {

        if (con == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "Database connection failed."
            );
            return;
        }

        try (PreparedStatement pst =
                con.prepareStatement(sql)) {

            
            pst.setInt(1, loggedInPatientId);

            try (ResultSet rs = pst.executeQuery()) {

                while (rs.next()) {

                    Object[] appointmentRow = {
                        rs.getDate("appointment_date"),
                        rs.getString("dentist_name"),
                        rs.getString("treatment_type"),
                        rs.getString("appointment_time")
                    };

                    tableModel.addRow(appointmentRow);
                }
            }
        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                this,
                "Database Error: " + e.getMessage()
        );

        e.printStackTrace();
    }
}
    

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        Parent = new javax.swing.JPanel();
        Dashboard = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        nameLabel = new javax.swing.JLabel();
        Create_Appoinment = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        My_Booking = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1300, 700));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Sunrise logo Light Small-01.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(48, 45, 200, 59);

        jPanel3.setBackground(new java.awt.Color(0, 146, 219));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Dashboard");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(145, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(30, 160, 260, 54);

        jPanel7.setBackground(new java.awt.Color(0, 146, 219));

        jLabel6.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Help");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(207, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        jPanel1.add(jPanel7);
        jPanel7.setBounds(30, 230, 260, 50);

        jPanel8.setBackground(new java.awt.Color(0, 146, 219));

        jLabel7.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Log Out");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(178, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        jPanel1.add(jPanel8);
        jPanel8.setBounds(30, 300, 260, 50);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 290, 790);

        Parent.setLayout(new java.awt.CardLayout());

        Dashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(153, 204, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Dashboard.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, -1));

        jLabel20.setFont(new java.awt.Font("Poppins", 1, 36)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 102, 153));
        jLabel20.setText("Patient Dashboard");
        Dashboard.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, 40));

        jButton1.setBackground(new java.awt.Color(153, 204, 255));
        jButton1.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jButton1.setText("Create New Appoinment");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        Dashboard.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, -1, 41));

        jLabel23.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 102, 153));
        jLabel23.setText("Appoinment List");
        Dashboard.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, 40));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Date", "Doctor", "Reason", "Time"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jScrollPane1.setViewportView(jScrollPane2);

        Dashboard.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 720, 238));

        nameLabel.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        nameLabel.setText("Name of Logged parson");
        Dashboard.add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 230, -1));

        Parent.add(Dashboard, "card2");

        jLabel9.setText("jLabel9");

        jPanel10.setBackground(new java.awt.Color(153, 204, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 153));
        jLabel11.setText("Create Appoinment");
        jPanel10.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 13, -1, 87));

        jLabel21.setFont(new java.awt.Font("Poppins", 1, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 102, 153));
        jLabel21.setText("Create Appoinment");

        javax.swing.GroupLayout Create_AppoinmentLayout = new javax.swing.GroupLayout(Create_Appoinment);
        Create_Appoinment.setLayout(Create_AppoinmentLayout);
        Create_AppoinmentLayout.setHorizontalGroup(
            Create_AppoinmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Create_AppoinmentLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(367, 367, 367))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Create_AppoinmentLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(Create_AppoinmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Create_AppoinmentLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel21))))
        );
        Create_AppoinmentLayout.setVerticalGroup(
            Create_AppoinmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Create_AppoinmentLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(171, 171, 171)
                .addComponent(jLabel9)
                .addContainerGap(403, Short.MAX_VALUE))
        );

        Parent.add(Create_Appoinment, "card3");

        jLabel22.setFont(new java.awt.Font("Poppins", 1, 36)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 102, 153));
        jLabel22.setText("My Appoinment");

        jPanel11.setBackground(new java.awt.Color(153, 204, 255));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 153));
        jLabel12.setText("My Appointment");
        jPanel11.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 13, -1, 87));

        javax.swing.GroupLayout My_BookingLayout = new javax.swing.GroupLayout(My_Booking);
        My_Booking.setLayout(My_BookingLayout);
        My_BookingLayout.setHorizontalGroup(
            My_BookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(My_BookingLayout.createSequentialGroup()
                .addGroup(My_BookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(My_BookingLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel22)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        My_BookingLayout.setVerticalGroup(
            My_BookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(My_BookingLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 590, Short.MAX_VALUE))
        );

        Parent.add(My_Booking, "card4");

        getContentPane().add(Parent);
        Parent.setBounds(290, 0, 780, 760);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        Parent.removeAll();
        Parent.add(Dashboard);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Create_Appoinment page =
        new Create_Appoinment(
                loggedInPatientId,
                loggedInPatientName
        );

page.setVisible(true);
this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PatientDashboardView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Create_Appoinment;
    private javax.swing.JPanel Dashboard;
    private javax.swing.JPanel My_Booking;
    private javax.swing.JPanel Parent;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel nameLabel;
    // End of variables declaration//GEN-END:variables
}
