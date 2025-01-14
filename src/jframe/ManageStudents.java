/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author 7skiessolutions
 */
public class ManageStudents extends javax.swing.JFrame {

    /**
     * Creates new form ManageBooks
     */
  
    DefaultTableModel model;
    public ManageStudents() {
        initComponents();
        setStudentDetailsToDatabase();
    }
    // to set the book details into the table
public void setStudentDetailsToDatabase(){
    try {
         Connection con =DBConnection.getConnection();
        Statement st=con.createStatement();
       ResultSet rs= st.executeQuery("select *  from student_details");
       while(rs.next()){
           String StudentId=rs.getString("student_id");
           String StudentName=rs.getString("studentname");
           String studentCourse=rs.getString("course");
           String studentBranch=rs.getString("branch");
           Object[] obj={StudentId,StudentName,studentCourse,studentBranch};
           model=(DefaultTableModel)tbl_studentDetails.getModel();
           model.addRow(obj);
           
       }
        
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    

//to add Student details to table

public boolean addStudent(){
boolean isAdded=false;
    int studentId=Integer.parseInt(student_id.getText());
    String studentName=student_name.getText();
    String studentCourse=combo_Course.getSelectedItem().toString();
    String studentBranch=combo_Branch.getSelectedItem().toString();
    
    try {
        Connection con=DBConnection.getConnection();
        String sql="insert into student_details  values(?,?,?,?)";
        PreparedStatement pst=con.prepareStatement(sql);
        pst.setInt(1, studentId);
        pst.setString(2, studentName);
        pst.setString(3, studentCourse);
        pst.setString(4, studentBranch);
        
        int rowCount=pst.executeUpdate();
        if(rowCount>0){
            isAdded=true;
        }else{
        isAdded=false;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    return isAdded;
}
//to Update book details to table

public boolean updateStudent(){
boolean isUpdate=false;
       int studentId=Integer.parseInt(student_id.getText());
    String studentName=student_name.getText();
    String studentCourse=combo_Course.getSelectedItem().toString();
    String studentBranch=combo_Branch.getSelectedItem().toString();
    
    try {
        Connection con=DBConnection.getConnection();
        String sql="update student_details  set studentname = ?,course = ?,branch = ? where student_id=?";
        PreparedStatement pst=con.prepareStatement(sql);
        
     
        pst.setString(1, studentName);
        pst.setString(2, studentCourse);
        pst.setString(3, studentBranch);
           pst.setInt(4, studentId);
        
        int rowCount=pst.executeUpdate();
        if(rowCount>0){
            isUpdate=true;
        }else{
        isUpdate=false;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    return isUpdate;
}
//to Delete book details to table

public boolean deleteBook(){
boolean isDelete=false;
    int studentId=Integer.parseInt(student_id.getText());

    
    try {
        Connection con=DBConnection.getConnection();
        String sql="delete from student_details  where student_id = ? ";
        PreparedStatement pst=con.prepareStatement(sql);
        
     
       
           pst.setInt(1, studentId);
        
        int rowCount=pst.executeUpdate();
        if(rowCount>0){
            isDelete=true;
        }else{
        isDelete=false;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    return isDelete;
}
//clear table
public void clearTable(){
DefaultTableModel model=(DefaultTableModel)tbl_studentDetails.getModel();
model.setRowCount(0);
}
/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        student_id = new app.bolivia.swing.JCTextField();
        jLabel10 = new javax.swing.JLabel();
        student_name = new app.bolivia.swing.JCTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        rSMaterialButtonRectangle1 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle2 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle3 = new rojerusan.RSMaterialButtonRectangle();
        jLabel17 = new javax.swing.JLabel();
        combo_Branch = new javax.swing.JComboBox<>();
        combo_Course = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_studentDetails = new rojerusan.RSTableMetro();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.setText("Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        student_id.setBackground(new java.awt.Color(0, 51, 204));
        student_id.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        student_id.setForeground(new java.awt.Color(255, 255, 255));
        student_id.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        student_id.setPhColor(new java.awt.Color(255, 255, 255));
        student_id.setPlaceholder("Enter Student Id");
        student_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                student_idFocusLost(evt);
            }
        });
        jPanel1.add(student_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 230, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 50, 50));

        student_name.setBackground(new java.awt.Color(0, 51, 204));
        student_name.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        student_name.setForeground(new java.awt.Color(255, 255, 255));
        student_name.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        student_name.setPhColor(new java.awt.Color(255, 255, 255));
        student_name.setPlaceholder("Enter Student Name");
        student_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                student_nameFocusLost(evt);
            }
        });
        jPanel1.add(student_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 230, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Enter Student Name");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 200, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 50, 50));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Select Course");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 200, -1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 50, 50));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Select Branch");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, 200, -1));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 50, 50));

        rSMaterialButtonRectangle1.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonRectangle1.setText("Delete");
        rSMaterialButtonRectangle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonRectangle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 580, 120, 60));

        rSMaterialButtonRectangle2.setBackground(new java.awt.Color(51, 102, 255));
        rSMaterialButtonRectangle2.setText("add");
        rSMaterialButtonRectangle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonRectangle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, 120, 60));

        rSMaterialButtonRectangle3.setBackground(new java.awt.Color(0, 153, 0));
        rSMaterialButtonRectangle3.setText("update");
        rSMaterialButtonRectangle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonRectangle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 580, 120, 60));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Enter Student Id");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 200, -1));

        combo_Branch.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        combo_Branch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IT", "CS", "Arts", "AGRI", " ", " " }));
        jPanel1.add(combo_Branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 460, 230, 30));

        combo_Course.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        combo_Course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MSC", "BSC", "PHD" }));
        jPanel1.add(combo_Course, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 230, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 830));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(102, 102, 255));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("X");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 40, 40));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 60, 40));

        tbl_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Id", "Student Name", "Course", "Branch"
            }
        ));
        tbl_studentDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_studentDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_studentDetails.setColorBordeHead(new java.awt.Color(51, 51, 51));
        tbl_studentDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_studentDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_studentDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tbl_studentDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_studentDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic Light", 1, 20)); // NOI18N
        tbl_studentDetails.setFuenteHead(new java.awt.Font("Yu Gothic Light", 1, 20)); // NOI18N
        tbl_studentDetails.setRowHeight(30);
        tbl_studentDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_studentDetailsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_studentDetails);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 730, 280));

        jLabel2.setBackground(new java.awt.Color(255, 51, 51));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Male_100px.png"))); // NOI18N
        jLabel2.setText("Manage Students");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, -1));

        jPanel6.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 300, 5));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 780, 830));

        setSize(new java.awt.Dimension(1200, 828));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void student_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_student_idFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_student_idFocusLost

    private void student_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_student_nameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_student_nameFocusLost

    private void rSMaterialButtonRectangle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle1ActionPerformed
          if(deleteBook()==true){
           JOptionPane.showMessageDialog(this, "student Deleted");
           clearTable();
           setStudentDetailsToDatabase();
       }else{
            JOptionPane.showMessageDialog(this, "Student Deletion Failed");
    }  // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle1ActionPerformed

    private void rSMaterialButtonRectangle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle2ActionPerformed
       if(addStudent()==true){
           JOptionPane.showMessageDialog(this, "Student Added");
           clearTable();
           setStudentDetailsToDatabase();
       }else{
            JOptionPane.showMessageDialog(this, "Student Addition Failed");
    }
    }//GEN-LAST:event_rSMaterialButtonRectangle2ActionPerformed

    private void rSMaterialButtonRectangle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle3ActionPerformed
         if(updateStudent()==true){
           JOptionPane.showMessageDialog(this, "student Updated");
           clearTable();
           setStudentDetailsToDatabase();
       }else{
            JOptionPane.showMessageDialog(this, "Student Updation Failed");
    }
    }//GEN-LAST:event_rSMaterialButtonRectangle3ActionPerformed

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
      System.exit(0);  // TODO add your handling code here:
    }//GEN-LAST:event_jPanel5MouseClicked

    private void tbl_studentDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_studentDetailsMouseClicked
    int rowno=tbl_studentDetails.getSelectedRow();
        TableModel model=tbl_studentDetails.getModel();
        
       student_id.setText(model.getValueAt(rowno, 0).toString());
       student_name.setText(model.getValueAt(rowno, 1).toString());
       combo_Course.setSelectedItem(model.getValueAt(rowno, 2));
       combo_Branch.setSelectedItem(model.getValueAt(rowno, 3));
      
    }//GEN-LAST:event_tbl_studentDetailsMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        HomePage page=new HomePage();
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

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
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_Branch;
    private javax.swing.JComboBox<String> combo_Course;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle1;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle2;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle3;
    private app.bolivia.swing.JCTextField student_id;
    private app.bolivia.swing.JCTextField student_name;
    private rojerusan.RSTableMetro tbl_studentDetails;
    // End of variables declaration//GEN-END:variables
}
