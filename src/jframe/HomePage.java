/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author 7skiessolutions
 */
public class HomePage extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    Color mouseEnterColor = new Color(0,0,0);
    Color mouseExitColor = new Color(51,51,51);
     DefaultTableModel model;
    public HomePage() {
        initComponents();
        showPieChart();
        setStudentDetailsToDatabase();
        setBookDetailsToDatabase();
        setDataToCards();
        
    }
    
    
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
           model=(DefaultTableModel)table_student.getModel();
           model.addRow(obj);
           
       }
        
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    public void setBookDetailsToDatabase(){
    try {
         Connection con =DBConnection.getConnection();
        Statement st=con.createStatement();
       ResultSet rs= st.executeQuery("select *  from book_details");
       while(rs.next()){
           String bookId=rs.getString("book_id");
           String bookName=rs.getString("bookname");
           String bookAuthor=rs.getString("author");
           int bookQuantity=rs.getInt("quantity");
           Object[] obj={bookId,bookName,bookAuthor,bookQuantity};
           model=(DefaultTableModel)table_books.getModel();
           model.addRow(obj);
           
       }
        
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    public void  setDataToCards(){
    Statement st=null;
    ResultSet rs=null;
    long l=System.currentTimeMillis();
        Date todayDate= new Date(l);
        
        try {
            Connection con =DBConnection.getConnection();
            st=con.createStatement();
            rs =st.executeQuery("select * from book_details");
            rs.last();
         lbl_noOfBooks.setText(Integer.toString(rs.getRow())); 
         // no of  students 
             rs =st.executeQuery("select * from student_details");
            rs.last();
         lbl_noofStudents.setText(Integer.toString(rs.getRow())); 
         
         // list of  issued book
            rs =st.executeQuery("select * from issue_book_details");
            rs.last();
         lbl_noOfIssuedBooks.setText(Integer.toString(rs.getRow())); 
          String sql="select *  from issue_book_details where due_date < ? and status = ? ";
        PreparedStatement pst=con.prepareStatement(sql);
        pst.setDate(1, todayDate);
        pst.setString(2, "pending");
         // list of  issued book
            rs =pst.executeQuery();
            rs.last();
         lbl_noOfDefaulter.setText(Integer.toString(rs.getRow())); 
         
         
         
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    
    public void showPieChart(){
        
        //create dataset
      DefaultPieDataset barDataset = new DefaultPieDataset( );
      
        try {
              Connection con =DBConnection.getConnection();
              String sql="select  book_name ,count(*) as issue_count from issue_book_details group by book_id";
        Statement st=con.createStatement();
       ResultSet rs= st.executeQuery(sql);
       while(rs.next()){
       barDataset.setValue(rs.getString("book_name"), new Double(rs.getDouble("issue_count")));
       }
        } catch (Exception e) {
        }
 
      
      //create chart
       JFreeChart piechart = ChartFactory.createPieChart("Issue Book Details",barDataset, true,true,false);//explain
      
        PiePlot piePlot =(PiePlot) piechart.getPlot();
      
       //changing pie chart blocks colors
       piePlot.setSectionPaint("IPhone 5s", new Color(255,255,102));
        piePlot.setSectionPaint("SamSung Grand", new Color(102,255,102));
        piePlot.setSectionPaint("MotoG", new Color(255,102,153));
        piePlot.setSectionPaint("Nokia Lumia", new Color(0,204,204));
      
       
        piePlot.setBackgroundPaint(Color.white);
        
        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        panelPieChart.removeAll();
        panelPieChart.add(barChartPanel, BorderLayout.CENTER);
        panelPieChart.validate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSPopuMenu1 = new rojerusan.RSPopuMenu();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jPanel45 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jPanel48 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jPanel49 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jPanel50 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jPanel51 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jPanel52 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jPanel53 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jPanel54 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jPanel55 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jPanel56 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jPanel57 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jPanel58 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jPanel59 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jPanel60 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel61 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jPanel62 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jPanel63 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jPanel96 = new javax.swing.JPanel();
        jLabel99 = new javax.swing.JLabel();
        jPanel97 = new javax.swing.JPanel();
        jLabel100 = new javax.swing.JLabel();
        jPanel98 = new javax.swing.JPanel();
        jLabel101 = new javax.swing.JLabel();
        jPanel99 = new javax.swing.JPanel();
        jLabel102 = new javax.swing.JLabel();
        jPanel100 = new javax.swing.JPanel();
        jLabel103 = new javax.swing.JLabel();
        jPanel101 = new javax.swing.JPanel();
        jLabel104 = new javax.swing.JLabel();
        jPanel102 = new javax.swing.JPanel();
        jLabel105 = new javax.swing.JLabel();
        jPanel103 = new javax.swing.JPanel();
        jLabel106 = new javax.swing.JLabel();
        jPanel104 = new javax.swing.JPanel();
        jLabel107 = new javax.swing.JLabel();
        jPanel105 = new javax.swing.JPanel();
        jLabel108 = new javax.swing.JLabel();
        jPanel106 = new javax.swing.JPanel();
        jLabel109 = new javax.swing.JLabel();
        jPanel107 = new javax.swing.JPanel();
        jLabel110 = new javax.swing.JLabel();
        jPanel108 = new javax.swing.JPanel();
        jLabel111 = new javax.swing.JLabel();
        jPanel109 = new javax.swing.JPanel();
        jLabel112 = new javax.swing.JLabel();
        jPanel110 = new javax.swing.JPanel();
        jLabel113 = new javax.swing.JLabel();
        jPanel111 = new javax.swing.JPanel();
        jLabel114 = new javax.swing.JLabel();
        jPanel112 = new javax.swing.JPanel();
        jLabel115 = new javax.swing.JLabel();
        jPanel113 = new javax.swing.JPanel();
        jLabel116 = new javax.swing.JLabel();
        jPanel114 = new javax.swing.JPanel();
        jLabel117 = new javax.swing.JLabel();
        jPanel115 = new javax.swing.JPanel();
        jLabel118 = new javax.swing.JLabel();
        jPanel116 = new javax.swing.JPanel();
        jLabel119 = new javax.swing.JLabel();
        jPanel117 = new javax.swing.JPanel();
        jLabel120 = new javax.swing.JLabel();
        jPanel118 = new javax.swing.JPanel();
        jLabel121 = new javax.swing.JLabel();
        jPanel119 = new javax.swing.JPanel();
        jLabel122 = new javax.swing.JLabel();
        jPanel120 = new javax.swing.JPanel();
        jLabel123 = new javax.swing.JLabel();
        jPanel121 = new javax.swing.JPanel();
        jLabel124 = new javax.swing.JLabel();
        jPanel122 = new javax.swing.JPanel();
        jLabel125 = new javax.swing.JLabel();
        jPanel123 = new javax.swing.JPanel();
        jLabel126 = new javax.swing.JLabel();
        jPanel124 = new javax.swing.JPanel();
        jLabel127 = new javax.swing.JLabel();
        jPanel125 = new javax.swing.JPanel();
        jLabel128 = new javax.swing.JLabel();
        jPanel126 = new javax.swing.JPanel();
        jLabel129 = new javax.swing.JLabel();
        jPanel127 = new javax.swing.JPanel();
        jLabel130 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jPanel64 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jPanel65 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jPanel66 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jPanel67 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jPanel68 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jPanel69 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jPanel70 = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jPanel71 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        jPanel72 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jPanel73 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        jPanel74 = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        jPanel75 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        jPanel76 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        jPanel77 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        jPanel78 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        jPanel79 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        jPanel80 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        jPanel81 = new javax.swing.JPanel();
        jLabel84 = new javax.swing.JLabel();
        jPanel82 = new javax.swing.JPanel();
        jLabel85 = new javax.swing.JLabel();
        jPanel83 = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        jPanel84 = new javax.swing.JPanel();
        jLabel87 = new javax.swing.JLabel();
        jPanel85 = new javax.swing.JPanel();
        jLabel88 = new javax.swing.JLabel();
        jPanel86 = new javax.swing.JPanel();
        jLabel89 = new javax.swing.JLabel();
        jPanel87 = new javax.swing.JPanel();
        jLabel90 = new javax.swing.JLabel();
        jPanel88 = new javax.swing.JPanel();
        jLabel91 = new javax.swing.JLabel();
        jPanel89 = new javax.swing.JPanel();
        jLabel92 = new javax.swing.JLabel();
        jPanel90 = new javax.swing.JPanel();
        jLabel93 = new javax.swing.JLabel();
        jPanel91 = new javax.swing.JPanel();
        jLabel94 = new javax.swing.JLabel();
        jPanel92 = new javax.swing.JPanel();
        jLabel95 = new javax.swing.JLabel();
        jPanel93 = new javax.swing.JPanel();
        jLabel96 = new javax.swing.JLabel();
        jPanel94 = new javax.swing.JPanel();
        jLabel97 = new javax.swing.JLabel();
        jPanel95 = new javax.swing.JPanel();
        jLabel98 = new javax.swing.JLabel();
        jPanel128 = new javax.swing.JPanel();
        jLabel131 = new javax.swing.JLabel();
        jPanel129 = new javax.swing.JPanel();
        jLabel132 = new javax.swing.JLabel();
        jPanel130 = new javax.swing.JPanel();
        jLabel133 = new javax.swing.JLabel();
        jPanel131 = new javax.swing.JPanel();
        jLabel134 = new javax.swing.JLabel();
        jPanel132 = new javax.swing.JPanel();
        jLabel135 = new javax.swing.JLabel();
        jPanel133 = new javax.swing.JPanel();
        jLabel136 = new javax.swing.JLabel();
        jPanel134 = new javax.swing.JPanel();
        jLabel137 = new javax.swing.JLabel();
        jPanel135 = new javax.swing.JPanel();
        jLabel138 = new javax.swing.JLabel();
        jPanel136 = new javax.swing.JPanel();
        jLabel139 = new javax.swing.JLabel();
        jPanel137 = new javax.swing.JPanel();
        jLabel140 = new javax.swing.JLabel();
        jPanel138 = new javax.swing.JPanel();
        jLabel141 = new javax.swing.JLabel();
        jPanel139 = new javax.swing.JPanel();
        jLabel142 = new javax.swing.JLabel();
        jPanel140 = new javax.swing.JPanel();
        jLabel143 = new javax.swing.JLabel();
        jPanel141 = new javax.swing.JPanel();
        jLabel144 = new javax.swing.JLabel();
        jPanel142 = new javax.swing.JPanel();
        jLabel145 = new javax.swing.JLabel();
        jPanel143 = new javax.swing.JPanel();
        jLabel146 = new javax.swing.JLabel();
        jPanel144 = new javax.swing.JPanel();
        jLabel147 = new javax.swing.JLabel();
        jPanel145 = new javax.swing.JPanel();
        jLabel148 = new javax.swing.JLabel();
        jPanel146 = new javax.swing.JPanel();
        jLabel149 = new javax.swing.JLabel();
        jPanel147 = new javax.swing.JPanel();
        jLabel150 = new javax.swing.JLabel();
        jPanel148 = new javax.swing.JPanel();
        jLabel151 = new javax.swing.JLabel();
        jPanel149 = new javax.swing.JPanel();
        jLabel152 = new javax.swing.JLabel();
        jPanel150 = new javax.swing.JPanel();
        jLabel153 = new javax.swing.JLabel();
        jPanel151 = new javax.swing.JPanel();
        jLabel154 = new javax.swing.JLabel();
        jPanel152 = new javax.swing.JPanel();
        jLabel155 = new javax.swing.JLabel();
        jPanel153 = new javax.swing.JPanel();
        jLabel156 = new javax.swing.JLabel();
        jPanel154 = new javax.swing.JPanel();
        jLabel157 = new javax.swing.JLabel();
        jPanel155 = new javax.swing.JPanel();
        jLabel158 = new javax.swing.JLabel();
        jPanel156 = new javax.swing.JPanel();
        jLabel159 = new javax.swing.JLabel();
        jPanel157 = new javax.swing.JPanel();
        jLabel160 = new javax.swing.JLabel();
        jPanel158 = new javax.swing.JPanel();
        jLabel161 = new javax.swing.JLabel();
        jPanel159 = new javax.swing.JPanel();
        jLabel162 = new javax.swing.JLabel();
        jPanel160 = new javax.swing.JPanel();
        jLabel163 = new javax.swing.JLabel();
        jPanel161 = new javax.swing.JPanel();
        jLabel164 = new javax.swing.JLabel();
        jPanel162 = new javax.swing.JPanel();
        jLabel165 = new javax.swing.JLabel();
        jPanel163 = new javax.swing.JPanel();
        jLabel166 = new javax.swing.JLabel();
        jPanel164 = new javax.swing.JPanel();
        jLabel167 = new javax.swing.JLabel();
        jPanel165 = new javax.swing.JPanel();
        jLabel168 = new javax.swing.JLabel();
        jPanel166 = new javax.swing.JPanel();
        jLabel169 = new javax.swing.JLabel();
        jPanel167 = new javax.swing.JPanel();
        jLabel170 = new javax.swing.JLabel();
        jPanel168 = new javax.swing.JPanel();
        jLabel171 = new javax.swing.JLabel();
        jPanel169 = new javax.swing.JPanel();
        jLabel172 = new javax.swing.JLabel();
        jPanel170 = new javax.swing.JPanel();
        jLabel173 = new javax.swing.JLabel();
        jPanel171 = new javax.swing.JPanel();
        jLabel174 = new javax.swing.JLabel();
        jPanel172 = new javax.swing.JPanel();
        jLabel175 = new javax.swing.JLabel();
        jPanel173 = new javax.swing.JPanel();
        jLabel176 = new javax.swing.JLabel();
        jPanel174 = new javax.swing.JPanel();
        jLabel177 = new javax.swing.JLabel();
        jPanel175 = new javax.swing.JPanel();
        jLabel178 = new javax.swing.JLabel();
        jPanel176 = new javax.swing.JPanel();
        jLabel179 = new javax.swing.JLabel();
        jPanel177 = new javax.swing.JPanel();
        jLabel180 = new javax.swing.JLabel();
        jPanel178 = new javax.swing.JPanel();
        jLabel181 = new javax.swing.JLabel();
        jPanel179 = new javax.swing.JPanel();
        jLabel182 = new javax.swing.JLabel();
        jPanel180 = new javax.swing.JPanel();
        jLabel183 = new javax.swing.JLabel();
        jPanel181 = new javax.swing.JPanel();
        jLabel184 = new javax.swing.JLabel();
        jPanel182 = new javax.swing.JPanel();
        jLabel185 = new javax.swing.JLabel();
        jPanel183 = new javax.swing.JPanel();
        jLabel186 = new javax.swing.JLabel();
        jPanel184 = new javax.swing.JPanel();
        jLabel187 = new javax.swing.JLabel();
        jPanel185 = new javax.swing.JPanel();
        jLabel188 = new javax.swing.JLabel();
        jPanel186 = new javax.swing.JPanel();
        jLabel189 = new javax.swing.JLabel();
        jPanel187 = new javax.swing.JPanel();
        jLabel190 = new javax.swing.JLabel();
        jPanel188 = new javax.swing.JPanel();
        jLabel191 = new javax.swing.JLabel();
        jPanel189 = new javax.swing.JPanel();
        jLabel192 = new javax.swing.JLabel();
        jPanel190 = new javax.swing.JPanel();
        jLabel193 = new javax.swing.JLabel();
        jPanel191 = new javax.swing.JPanel();
        jLabel194 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel192 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        lbl_noOfBooks = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        lbl_noofStudents = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        lbl_noOfIssuedBooks = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        lbl_noOfDefaulter = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_student = new rojerusan.RSTableMetro();
        jLabel195 = new javax.swing.JLabel();
        jLabel197 = new javax.swing.JLabel();
        panelPieChart = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_books = new rojerusan.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 101, -1, -1));

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_menu_48px_1.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("X");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 20, -1, 40));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/male_user_50px.png"))); // NOI18N
        jLabel7.setText("welcom  Admin");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 10, -1, 50));

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Library Manegment System");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, 70));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(102, 102, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Exit_26px_2.png"))); // NOI18N
        jLabel3.setText("  Logout");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel10.setText("Manage Books");
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel18.setBackground(new java.awt.Color(51, 51, 51));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel21.setText("Return Book");
        jPanel18.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel19.setBackground(new java.awt.Color(51, 51, 51));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel22.setText("Manage Books");
        jPanel19.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel18.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel4.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel28.setBackground(new java.awt.Color(51, 51, 51));
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel31.setText("View Records");
        jPanel28.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel29.setBackground(new java.awt.Color(51, 51, 51));
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel32.setText("Manage Books");
        jPanel29.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel28.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel30.setBackground(new java.awt.Color(51, 51, 51));
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel33.setText("Return Book");
        jPanel30.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel31.setBackground(new java.awt.Color(51, 51, 51));
        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel34.setText("Manage Books");
        jPanel31.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel30.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel28.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel4.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 230, 40));

        jPanel40.setBackground(new java.awt.Color(51, 51, 51));
        jPanel40.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel43.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel43.setText("View Records");
        jPanel40.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel41.setBackground(new java.awt.Color(51, 51, 51));
        jPanel41.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel44.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel44.setText("Manage Books");
        jPanel41.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel40.add(jPanel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel42.setBackground(new java.awt.Color(51, 51, 51));
        jPanel42.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel45.setText("Return Book");
        jPanel42.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel43.setBackground(new java.awt.Color(51, 51, 51));
        jPanel43.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel46.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel46.setText("Manage Books");
        jPanel43.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel42.add(jPanel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel40.add(jPanel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel44.setBackground(new java.awt.Color(51, 51, 51));
        jPanel44.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel47.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel47.setText("View Records");
        jPanel44.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel45.setBackground(new java.awt.Color(51, 51, 51));
        jPanel45.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel48.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel48.setText("Manage Books");
        jPanel45.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel44.add(jPanel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel46.setBackground(new java.awt.Color(51, 51, 51));
        jPanel46.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel49.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel49.setText("Return Book");
        jPanel46.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel47.setBackground(new java.awt.Color(51, 51, 51));
        jPanel47.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel50.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel50.setText("Manage Books");
        jPanel47.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel46.add(jPanel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel44.add(jPanel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel40.add(jPanel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 230, 40));

        jPanel4.add(jPanel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 230, 40));

        jPanel48.setBackground(new java.awt.Color(51, 51, 51));
        jPanel48.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel51.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel51.setText("View Issued Books");
        jPanel48.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel49.setBackground(new java.awt.Color(51, 51, 51));
        jPanel49.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel52.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel52.setText("Manage Books");
        jPanel49.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel48.add(jPanel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel50.setBackground(new java.awt.Color(51, 51, 51));
        jPanel50.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel53.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel53.setText("Return Book");
        jPanel50.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel51.setBackground(new java.awt.Color(51, 51, 51));
        jPanel51.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel54.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel54.setText("Manage Books");
        jPanel51.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel50.add(jPanel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel48.add(jPanel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel52.setBackground(new java.awt.Color(51, 51, 51));
        jPanel52.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel55.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel55.setText("View Records");
        jPanel52.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel53.setBackground(new java.awt.Color(51, 51, 51));
        jPanel53.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel56.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel56.setText("Manage Books");
        jPanel53.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel52.add(jPanel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel54.setBackground(new java.awt.Color(51, 51, 51));
        jPanel54.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel57.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel57.setText("Return Book");
        jPanel54.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel55.setBackground(new java.awt.Color(51, 51, 51));
        jPanel55.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel58.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel58.setText("Manage Books");
        jPanel55.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel54.add(jPanel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel52.add(jPanel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel48.add(jPanel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 230, 40));

        jPanel56.setBackground(new java.awt.Color(51, 51, 51));
        jPanel56.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel59.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel59.setText("View Records");
        jPanel56.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel57.setBackground(new java.awt.Color(51, 51, 51));
        jPanel57.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel60.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel60.setText("Manage Books");
        jPanel57.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel56.add(jPanel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel58.setBackground(new java.awt.Color(51, 51, 51));
        jPanel58.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel61.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel61.setText("Return Book");
        jPanel58.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel59.setBackground(new java.awt.Color(51, 51, 51));
        jPanel59.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel62.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel62.setText("Manage Books");
        jPanel59.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel58.add(jPanel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel56.add(jPanel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel60.setBackground(new java.awt.Color(51, 51, 51));
        jPanel60.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel63.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel63.setText("View Records");
        jPanel60.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel61.setBackground(new java.awt.Color(51, 51, 51));
        jPanel61.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel64.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel64.setText("Manage Books");
        jPanel61.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel60.add(jPanel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel62.setBackground(new java.awt.Color(51, 51, 51));
        jPanel62.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel65.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel65.setText("Return Book");
        jPanel62.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel63.setBackground(new java.awt.Color(51, 51, 51));
        jPanel63.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel66.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel66.setText("Manage Books");
        jPanel63.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel62.add(jPanel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel60.add(jPanel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel56.add(jPanel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 230, 40));

        jPanel48.add(jPanel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 230, 40));

        jPanel4.add(jPanel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 230, 40));

        jPanel96.setBackground(new java.awt.Color(51, 51, 51));
        jPanel96.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel99.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(255, 255, 255));
        jLabel99.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel99.setText("Defaulter List");
        jPanel96.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel97.setBackground(new java.awt.Color(51, 51, 51));
        jPanel97.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel100.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(255, 255, 255));
        jLabel100.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel100.setText("Manage Books");
        jPanel97.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel96.add(jPanel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel98.setBackground(new java.awt.Color(51, 51, 51));
        jPanel98.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel101.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(255, 255, 255));
        jLabel101.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel101.setText("Return Book");
        jPanel98.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel99.setBackground(new java.awt.Color(51, 51, 51));
        jPanel99.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel102.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(255, 255, 255));
        jLabel102.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel102.setText("Manage Books");
        jPanel99.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel98.add(jPanel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel96.add(jPanel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel100.setBackground(new java.awt.Color(51, 51, 51));
        jPanel100.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel103.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(255, 255, 255));
        jLabel103.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel103.setText("View Records");
        jPanel100.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel101.setBackground(new java.awt.Color(51, 51, 51));
        jPanel101.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel104.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(255, 255, 255));
        jLabel104.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel104.setText("Manage Books");
        jPanel101.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel100.add(jPanel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel102.setBackground(new java.awt.Color(51, 51, 51));
        jPanel102.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel105.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(255, 255, 255));
        jLabel105.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel105.setText("Return Book");
        jPanel102.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel103.setBackground(new java.awt.Color(51, 51, 51));
        jPanel103.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel106.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(255, 255, 255));
        jLabel106.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel106.setText("Manage Books");
        jPanel103.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel102.add(jPanel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel100.add(jPanel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel96.add(jPanel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 230, 40));

        jPanel104.setBackground(new java.awt.Color(51, 51, 51));
        jPanel104.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel107.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(255, 255, 255));
        jLabel107.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel107.setText("View Records");
        jPanel104.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel105.setBackground(new java.awt.Color(51, 51, 51));
        jPanel105.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel108.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel108.setForeground(new java.awt.Color(255, 255, 255));
        jLabel108.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel108.setText("Manage Books");
        jPanel105.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel104.add(jPanel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel106.setBackground(new java.awt.Color(51, 51, 51));
        jPanel106.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel109.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(255, 255, 255));
        jLabel109.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel109.setText("Return Book");
        jPanel106.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel107.setBackground(new java.awt.Color(51, 51, 51));
        jPanel107.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel110.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(255, 255, 255));
        jLabel110.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel110.setText("Manage Books");
        jPanel107.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel106.add(jPanel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel104.add(jPanel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel108.setBackground(new java.awt.Color(51, 51, 51));
        jPanel108.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel111.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(255, 255, 255));
        jLabel111.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel111.setText("View Records");
        jPanel108.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel109.setBackground(new java.awt.Color(51, 51, 51));
        jPanel109.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel112.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(255, 255, 255));
        jLabel112.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel112.setText("Manage Books");
        jPanel109.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel108.add(jPanel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel110.setBackground(new java.awt.Color(51, 51, 51));
        jPanel110.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel113.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(255, 255, 255));
        jLabel113.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel113.setText("Return Book");
        jPanel110.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel111.setBackground(new java.awt.Color(51, 51, 51));
        jPanel111.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel114.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(255, 255, 255));
        jLabel114.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel114.setText("Manage Books");
        jPanel111.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel110.add(jPanel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel108.add(jPanel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel104.add(jPanel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 230, 40));

        jPanel96.add(jPanel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 230, 40));

        jPanel112.setBackground(new java.awt.Color(51, 51, 51));
        jPanel112.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel115.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(255, 255, 255));
        jLabel115.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel115.setText("View Issued Books");
        jPanel112.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel113.setBackground(new java.awt.Color(51, 51, 51));
        jPanel113.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel116.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel116.setForeground(new java.awt.Color(255, 255, 255));
        jLabel116.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel116.setText("Manage Books");
        jPanel113.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel112.add(jPanel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel114.setBackground(new java.awt.Color(51, 51, 51));
        jPanel114.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel117.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(255, 255, 255));
        jLabel117.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel117.setText("Return Book");
        jPanel114.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel115.setBackground(new java.awt.Color(51, 51, 51));
        jPanel115.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel118.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel118.setForeground(new java.awt.Color(255, 255, 255));
        jLabel118.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel118.setText("Manage Books");
        jPanel115.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel114.add(jPanel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel112.add(jPanel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel116.setBackground(new java.awt.Color(51, 51, 51));
        jPanel116.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel119.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel119.setForeground(new java.awt.Color(255, 255, 255));
        jLabel119.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel119.setText("View Records");
        jPanel116.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel117.setBackground(new java.awt.Color(51, 51, 51));
        jPanel117.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel120.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel120.setForeground(new java.awt.Color(255, 255, 255));
        jLabel120.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel120.setText("Manage Books");
        jPanel117.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel116.add(jPanel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel118.setBackground(new java.awt.Color(51, 51, 51));
        jPanel118.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel121.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel121.setForeground(new java.awt.Color(255, 255, 255));
        jLabel121.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel121.setText("Return Book");
        jPanel118.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel119.setBackground(new java.awt.Color(51, 51, 51));
        jPanel119.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel122.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel122.setForeground(new java.awt.Color(255, 255, 255));
        jLabel122.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel122.setText("Manage Books");
        jPanel119.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel118.add(jPanel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel116.add(jPanel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel112.add(jPanel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 230, 40));

        jPanel120.setBackground(new java.awt.Color(51, 51, 51));
        jPanel120.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel123.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel123.setForeground(new java.awt.Color(255, 255, 255));
        jLabel123.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel123.setText("View Records");
        jPanel120.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel121.setBackground(new java.awt.Color(51, 51, 51));
        jPanel121.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel124.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel124.setForeground(new java.awt.Color(255, 255, 255));
        jLabel124.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel124.setText("Manage Books");
        jPanel121.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel120.add(jPanel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel122.setBackground(new java.awt.Color(51, 51, 51));
        jPanel122.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel125.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel125.setForeground(new java.awt.Color(255, 255, 255));
        jLabel125.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel125.setText("Return Book");
        jPanel122.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel123.setBackground(new java.awt.Color(51, 51, 51));
        jPanel123.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel126.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel126.setForeground(new java.awt.Color(255, 255, 255));
        jLabel126.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel126.setText("Manage Books");
        jPanel123.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel122.add(jPanel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel120.add(jPanel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel124.setBackground(new java.awt.Color(51, 51, 51));
        jPanel124.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel127.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel127.setForeground(new java.awt.Color(255, 255, 255));
        jLabel127.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel127.setText("View Records");
        jPanel124.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel125.setBackground(new java.awt.Color(51, 51, 51));
        jPanel125.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel128.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel128.setForeground(new java.awt.Color(255, 255, 255));
        jLabel128.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel128.setText("Manage Books");
        jPanel125.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel124.add(jPanel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel126.setBackground(new java.awt.Color(51, 51, 51));
        jPanel126.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel129.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel129.setForeground(new java.awt.Color(255, 255, 255));
        jLabel129.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel129.setText("Return Book");
        jPanel126.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel127.setBackground(new java.awt.Color(51, 51, 51));
        jPanel127.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel130.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel130.setForeground(new java.awt.Color(255, 255, 255));
        jLabel130.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel130.setText("Manage Books");
        jPanel127.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel126.add(jPanel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel124.add(jPanel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel120.add(jPanel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 230, 40));

        jPanel112.add(jPanel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 230, 40));

        jPanel96.add(jPanel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 230, 40));

        jPanel4.add(jPanel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 230, 40));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 240, 40));

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel4.setText("  Home Page");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 240, 40));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Features");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 70, -1));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel9.setText("  LMS Dashboard");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 230, 40));

        jPanel14.setBackground(new java.awt.Color(51, 51, 51));
        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel14MouseClicked(evt);
            }
        });
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Read_Online_26px.png"))); // NOI18N
        jLabel17.setText("  Manage Students");
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel17MouseExited(evt);
            }
        });
        jPanel14.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel15.setBackground(new java.awt.Color(51, 51, 51));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel18.setText("Manage Books");
        jPanel15.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel14.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel3.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 230, 40));

        jPanel16.setBackground(new java.awt.Color(51, 51, 51));
        jPanel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel16MouseClicked(evt);
            }
        });
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Sell_26px.png"))); // NOI18N
        jLabel19.setText("  Issue Book");
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel19MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel19MouseExited(evt);
            }
        });
        jPanel16.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel17.setBackground(new java.awt.Color(51, 51, 51));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel20.setText("Manage Books");
        jPanel17.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel16.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel3.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 230, 40));

        jPanel20.setBackground(new java.awt.Color(51, 51, 51));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Return_Purchase_26px.png"))); // NOI18N
        jLabel23.setText("  Return Book");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel23MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel23MouseExited(evt);
            }
        });
        jPanel20.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel21.setBackground(new java.awt.Color(51, 51, 51));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel24.setText("Manage Books");
        jPanel21.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel20.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel22.setBackground(new java.awt.Color(51, 51, 51));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel25.setText("Return Book");
        jPanel22.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel23.setBackground(new java.awt.Color(51, 51, 51));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel26.setText("Manage Books");
        jPanel23.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel22.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel20.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel3.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 230, 40));

        jPanel32.setBackground(new java.awt.Color(51, 51, 51));
        jPanel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_View_Details_26px.png"))); // NOI18N
        jLabel35.setText("  View Records");
        jLabel35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel35MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel35MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel35MouseExited(evt);
            }
        });
        jPanel32.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel33.setBackground(new java.awt.Color(51, 51, 51));
        jPanel33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel36.setText("Manage Books");
        jPanel33.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel32.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel34.setBackground(new java.awt.Color(51, 51, 51));
        jPanel34.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel37.setText("Return Book");
        jPanel34.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel35.setBackground(new java.awt.Color(51, 51, 51));
        jPanel35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel38.setText("Manage Books");
        jPanel35.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel34.add(jPanel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel32.add(jPanel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel36.setBackground(new java.awt.Color(51, 51, 51));
        jPanel36.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel39.setText("View Records");
        jPanel36.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel37.setBackground(new java.awt.Color(51, 51, 51));
        jPanel37.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel40.setText("Manage Books");
        jPanel37.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel36.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel38.setBackground(new java.awt.Color(51, 51, 51));
        jPanel38.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel41.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel41.setText("Return Book");
        jPanel38.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel39.setBackground(new java.awt.Color(51, 51, 51));
        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel42.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel42.setText("Manage Books");
        jPanel39.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel38.add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel36.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel32.add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 230, 40));

        jPanel3.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 230, 40));

        jPanel64.setBackground(new java.awt.Color(51, 51, 51));
        jPanel64.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel67.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Books_26px.png"))); // NOI18N
        jLabel67.setText("   View Issued Books");
        jLabel67.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel67MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel67MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel67MouseExited(evt);
            }
        });
        jPanel64.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 200, -1));

        jPanel65.setBackground(new java.awt.Color(51, 51, 51));
        jPanel65.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel68.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel68.setText("Manage Books");
        jPanel65.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel64.add(jPanel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel66.setBackground(new java.awt.Color(51, 51, 51));
        jPanel66.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel69.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel69.setText("Return Book");
        jPanel66.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel67.setBackground(new java.awt.Color(51, 51, 51));
        jPanel67.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel70.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel70.setText("Manage Books");
        jPanel67.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel66.add(jPanel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel64.add(jPanel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel68.setBackground(new java.awt.Color(51, 51, 51));
        jPanel68.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel71.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel71.setText("View Records");
        jPanel68.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel69.setBackground(new java.awt.Color(51, 51, 51));
        jPanel69.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel72.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel72.setText("Manage Books");
        jPanel69.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel68.add(jPanel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel70.setBackground(new java.awt.Color(51, 51, 51));
        jPanel70.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel73.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel73.setText("Return Book");
        jPanel70.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel71.setBackground(new java.awt.Color(51, 51, 51));
        jPanel71.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel74.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel74.setText("Manage Books");
        jPanel71.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel70.add(jPanel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel68.add(jPanel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel64.add(jPanel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 230, 40));

        jPanel72.setBackground(new java.awt.Color(51, 51, 51));
        jPanel72.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel75.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel75.setText("View Records");
        jPanel72.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel73.setBackground(new java.awt.Color(51, 51, 51));
        jPanel73.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel76.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel76.setText("Manage Books");
        jPanel73.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel72.add(jPanel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel74.setBackground(new java.awt.Color(51, 51, 51));
        jPanel74.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel77.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel77.setText("Return Book");
        jPanel74.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel75.setBackground(new java.awt.Color(51, 51, 51));
        jPanel75.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel78.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel78.setText("Manage Books");
        jPanel75.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel74.add(jPanel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel72.add(jPanel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel76.setBackground(new java.awt.Color(51, 51, 51));
        jPanel76.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel79.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(255, 255, 255));
        jLabel79.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel79.setText("View Records");
        jPanel76.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel77.setBackground(new java.awt.Color(51, 51, 51));
        jPanel77.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel80.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 255, 255));
        jLabel80.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel80.setText("Manage Books");
        jPanel77.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel76.add(jPanel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel78.setBackground(new java.awt.Color(51, 51, 51));
        jPanel78.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel81.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(255, 255, 255));
        jLabel81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel81.setText("Return Book");
        jPanel78.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel79.setBackground(new java.awt.Color(51, 51, 51));
        jPanel79.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel82.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(255, 255, 255));
        jLabel82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel82.setText("Manage Books");
        jPanel79.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel78.add(jPanel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel76.add(jPanel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel72.add(jPanel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 230, 40));

        jPanel64.add(jPanel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 230, 40));

        jPanel80.setBackground(new java.awt.Color(51, 51, 51));
        jPanel80.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel83.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(255, 255, 255));
        jLabel83.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel83.setText("View Issued Books");
        jPanel80.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel81.setBackground(new java.awt.Color(51, 51, 51));
        jPanel81.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel84.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(255, 255, 255));
        jLabel84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel84.setText("Manage Books");
        jPanel81.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel80.add(jPanel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel82.setBackground(new java.awt.Color(51, 51, 51));
        jPanel82.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel85.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(255, 255, 255));
        jLabel85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel85.setText("Return Book");
        jPanel82.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel83.setBackground(new java.awt.Color(51, 51, 51));
        jPanel83.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel86.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(255, 255, 255));
        jLabel86.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel86.setText("Manage Books");
        jPanel83.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel82.add(jPanel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel80.add(jPanel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel84.setBackground(new java.awt.Color(51, 51, 51));
        jPanel84.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel87.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(255, 255, 255));
        jLabel87.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel87.setText("View Records");
        jPanel84.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel85.setBackground(new java.awt.Color(51, 51, 51));
        jPanel85.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel88.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(255, 255, 255));
        jLabel88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel88.setText("Manage Books");
        jPanel85.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel84.add(jPanel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel86.setBackground(new java.awt.Color(51, 51, 51));
        jPanel86.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel89.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(255, 255, 255));
        jLabel89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel89.setText("Return Book");
        jPanel86.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel87.setBackground(new java.awt.Color(51, 51, 51));
        jPanel87.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel90.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(255, 255, 255));
        jLabel90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel90.setText("Manage Books");
        jPanel87.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel86.add(jPanel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel84.add(jPanel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel80.add(jPanel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 230, 40));

        jPanel88.setBackground(new java.awt.Color(51, 51, 51));
        jPanel88.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel91.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(255, 255, 255));
        jLabel91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel91.setText("View Records");
        jPanel88.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel89.setBackground(new java.awt.Color(51, 51, 51));
        jPanel89.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel92.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(255, 255, 255));
        jLabel92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel92.setText("Manage Books");
        jPanel89.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel88.add(jPanel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel90.setBackground(new java.awt.Color(51, 51, 51));
        jPanel90.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel93.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(255, 255, 255));
        jLabel93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel93.setText("Return Book");
        jPanel90.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel91.setBackground(new java.awt.Color(51, 51, 51));
        jPanel91.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel94.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(255, 255, 255));
        jLabel94.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel94.setText("Manage Books");
        jPanel91.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel90.add(jPanel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel88.add(jPanel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel92.setBackground(new java.awt.Color(51, 51, 51));
        jPanel92.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel95.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(255, 255, 255));
        jLabel95.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel95.setText("View Records");
        jPanel92.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel93.setBackground(new java.awt.Color(51, 51, 51));
        jPanel93.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel96.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(255, 255, 255));
        jLabel96.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel96.setText("Manage Books");
        jPanel93.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel92.add(jPanel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel94.setBackground(new java.awt.Color(51, 51, 51));
        jPanel94.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel97.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(255, 255, 255));
        jLabel97.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel97.setText("Return Book");
        jPanel94.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel95.setBackground(new java.awt.Color(51, 51, 51));
        jPanel95.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel98.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(255, 255, 255));
        jLabel98.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel98.setText("Manage Books");
        jPanel95.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel94.add(jPanel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel92.add(jPanel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel88.add(jPanel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 230, 40));

        jPanel80.add(jPanel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 230, 40));

        jPanel64.add(jPanel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 230, 40));

        jPanel3.add(jPanel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 230, 40));

        jPanel128.setBackground(new java.awt.Color(51, 51, 51));
        jPanel128.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel131.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel131.setForeground(new java.awt.Color(255, 255, 255));
        jLabel131.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Conference_26px.png"))); // NOI18N
        jLabel131.setText("  Defaulter List");
        jLabel131.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel131MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel131MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel131MouseExited(evt);
            }
        });
        jPanel128.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel129.setBackground(new java.awt.Color(51, 51, 51));
        jPanel129.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel132.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel132.setForeground(new java.awt.Color(255, 255, 255));
        jLabel132.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel132.setText("Manage Books");
        jPanel129.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel128.add(jPanel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel130.setBackground(new java.awt.Color(51, 51, 51));
        jPanel130.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel133.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel133.setForeground(new java.awt.Color(255, 255, 255));
        jLabel133.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel133.setText("Return Book");
        jPanel130.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel131.setBackground(new java.awt.Color(51, 51, 51));
        jPanel131.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel134.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel134.setForeground(new java.awt.Color(255, 255, 255));
        jLabel134.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel134.setText("Manage Books");
        jPanel131.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel130.add(jPanel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel128.add(jPanel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel132.setBackground(new java.awt.Color(51, 51, 51));
        jPanel132.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel135.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel135.setForeground(new java.awt.Color(255, 255, 255));
        jLabel135.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel135.setText("View Records");
        jPanel132.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel133.setBackground(new java.awt.Color(51, 51, 51));
        jPanel133.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel136.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel136.setForeground(new java.awt.Color(255, 255, 255));
        jLabel136.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel136.setText("Manage Books");
        jPanel133.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel132.add(jPanel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel134.setBackground(new java.awt.Color(51, 51, 51));
        jPanel134.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel137.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel137.setForeground(new java.awt.Color(255, 255, 255));
        jLabel137.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel137.setText("Return Book");
        jPanel134.add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel135.setBackground(new java.awt.Color(51, 51, 51));
        jPanel135.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel138.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel138.setForeground(new java.awt.Color(255, 255, 255));
        jLabel138.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel138.setText("Manage Books");
        jPanel135.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel134.add(jPanel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel132.add(jPanel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel128.add(jPanel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 230, 40));

        jPanel136.setBackground(new java.awt.Color(51, 51, 51));
        jPanel136.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel139.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel139.setForeground(new java.awt.Color(255, 255, 255));
        jLabel139.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel139.setText("View Records");
        jPanel136.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel137.setBackground(new java.awt.Color(51, 51, 51));
        jPanel137.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel140.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel140.setForeground(new java.awt.Color(255, 255, 255));
        jLabel140.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel140.setText("Manage Books");
        jPanel137.add(jLabel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel136.add(jPanel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel138.setBackground(new java.awt.Color(51, 51, 51));
        jPanel138.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel141.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel141.setForeground(new java.awt.Color(255, 255, 255));
        jLabel141.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel141.setText("Return Book");
        jPanel138.add(jLabel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel139.setBackground(new java.awt.Color(51, 51, 51));
        jPanel139.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel142.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel142.setForeground(new java.awt.Color(255, 255, 255));
        jLabel142.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel142.setText("Manage Books");
        jPanel139.add(jLabel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel138.add(jPanel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel136.add(jPanel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel140.setBackground(new java.awt.Color(51, 51, 51));
        jPanel140.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel143.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel143.setForeground(new java.awt.Color(255, 255, 255));
        jLabel143.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel143.setText("View Records");
        jPanel140.add(jLabel143, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel141.setBackground(new java.awt.Color(51, 51, 51));
        jPanel141.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel144.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel144.setForeground(new java.awt.Color(255, 255, 255));
        jLabel144.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel144.setText("Manage Books");
        jPanel141.add(jLabel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel140.add(jPanel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel142.setBackground(new java.awt.Color(51, 51, 51));
        jPanel142.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel145.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel145.setForeground(new java.awt.Color(255, 255, 255));
        jLabel145.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel145.setText("Return Book");
        jPanel142.add(jLabel145, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel143.setBackground(new java.awt.Color(51, 51, 51));
        jPanel143.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel146.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel146.setForeground(new java.awt.Color(255, 255, 255));
        jLabel146.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel146.setText("Manage Books");
        jPanel143.add(jLabel146, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel142.add(jPanel143, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel140.add(jPanel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel136.add(jPanel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 230, 40));

        jPanel128.add(jPanel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 230, 40));

        jPanel144.setBackground(new java.awt.Color(51, 51, 51));
        jPanel144.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel147.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel147.setForeground(new java.awt.Color(255, 255, 255));
        jLabel147.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel147.setText("View Issued Books");
        jPanel144.add(jLabel147, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel145.setBackground(new java.awt.Color(51, 51, 51));
        jPanel145.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel148.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel148.setForeground(new java.awt.Color(255, 255, 255));
        jLabel148.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel148.setText("Manage Books");
        jPanel145.add(jLabel148, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel144.add(jPanel145, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel146.setBackground(new java.awt.Color(51, 51, 51));
        jPanel146.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel149.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel149.setForeground(new java.awt.Color(255, 255, 255));
        jLabel149.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel149.setText("Return Book");
        jPanel146.add(jLabel149, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel147.setBackground(new java.awt.Color(51, 51, 51));
        jPanel147.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel150.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel150.setForeground(new java.awt.Color(255, 255, 255));
        jLabel150.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel150.setText("Manage Books");
        jPanel147.add(jLabel150, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel146.add(jPanel147, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel144.add(jPanel146, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel148.setBackground(new java.awt.Color(51, 51, 51));
        jPanel148.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel151.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel151.setForeground(new java.awt.Color(255, 255, 255));
        jLabel151.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel151.setText("View Records");
        jPanel148.add(jLabel151, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel149.setBackground(new java.awt.Color(51, 51, 51));
        jPanel149.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel152.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel152.setForeground(new java.awt.Color(255, 255, 255));
        jLabel152.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel152.setText("Manage Books");
        jPanel149.add(jLabel152, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel148.add(jPanel149, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel150.setBackground(new java.awt.Color(51, 51, 51));
        jPanel150.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel153.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel153.setForeground(new java.awt.Color(255, 255, 255));
        jLabel153.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel153.setText("Return Book");
        jPanel150.add(jLabel153, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel151.setBackground(new java.awt.Color(51, 51, 51));
        jPanel151.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel154.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel154.setForeground(new java.awt.Color(255, 255, 255));
        jLabel154.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel154.setText("Manage Books");
        jPanel151.add(jLabel154, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel150.add(jPanel151, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel148.add(jPanel150, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel144.add(jPanel148, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 230, 40));

        jPanel152.setBackground(new java.awt.Color(51, 51, 51));
        jPanel152.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel155.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel155.setForeground(new java.awt.Color(255, 255, 255));
        jLabel155.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel155.setText("View Records");
        jPanel152.add(jLabel155, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel153.setBackground(new java.awt.Color(51, 51, 51));
        jPanel153.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel156.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel156.setForeground(new java.awt.Color(255, 255, 255));
        jLabel156.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel156.setText("Manage Books");
        jPanel153.add(jLabel156, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel152.add(jPanel153, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel154.setBackground(new java.awt.Color(51, 51, 51));
        jPanel154.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel157.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel157.setForeground(new java.awt.Color(255, 255, 255));
        jLabel157.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel157.setText("Return Book");
        jPanel154.add(jLabel157, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel155.setBackground(new java.awt.Color(51, 51, 51));
        jPanel155.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel158.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel158.setForeground(new java.awt.Color(255, 255, 255));
        jLabel158.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel158.setText("Manage Books");
        jPanel155.add(jLabel158, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel154.add(jPanel155, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel152.add(jPanel154, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel156.setBackground(new java.awt.Color(51, 51, 51));
        jPanel156.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel159.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel159.setForeground(new java.awt.Color(255, 255, 255));
        jLabel159.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel159.setText("View Records");
        jPanel156.add(jLabel159, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel157.setBackground(new java.awt.Color(51, 51, 51));
        jPanel157.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel160.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel160.setForeground(new java.awt.Color(255, 255, 255));
        jLabel160.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel160.setText("Manage Books");
        jPanel157.add(jLabel160, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel156.add(jPanel157, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel158.setBackground(new java.awt.Color(51, 51, 51));
        jPanel158.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel161.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel161.setForeground(new java.awt.Color(255, 255, 255));
        jLabel161.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel161.setText("Return Book");
        jPanel158.add(jLabel161, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel159.setBackground(new java.awt.Color(51, 51, 51));
        jPanel159.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel162.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel162.setForeground(new java.awt.Color(255, 255, 255));
        jLabel162.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel162.setText("Manage Books");
        jPanel159.add(jLabel162, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel158.add(jPanel159, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel156.add(jPanel158, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel152.add(jPanel156, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 230, 40));

        jPanel144.add(jPanel152, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 230, 40));

        jPanel128.add(jPanel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 230, 40));

        jPanel160.setBackground(new java.awt.Color(51, 51, 51));
        jPanel160.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel163.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel163.setForeground(new java.awt.Color(255, 255, 255));
        jLabel163.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel163.setText("Defaulter List");
        jPanel160.add(jLabel163, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel161.setBackground(new java.awt.Color(51, 51, 51));
        jPanel161.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel164.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel164.setForeground(new java.awt.Color(255, 255, 255));
        jLabel164.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel164.setText("Manage Books");
        jPanel161.add(jLabel164, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel160.add(jPanel161, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel162.setBackground(new java.awt.Color(51, 51, 51));
        jPanel162.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel165.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel165.setForeground(new java.awt.Color(255, 255, 255));
        jLabel165.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel165.setText("Return Book");
        jPanel162.add(jLabel165, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel163.setBackground(new java.awt.Color(51, 51, 51));
        jPanel163.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel166.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel166.setForeground(new java.awt.Color(255, 255, 255));
        jLabel166.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel166.setText("Manage Books");
        jPanel163.add(jLabel166, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel162.add(jPanel163, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel160.add(jPanel162, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel164.setBackground(new java.awt.Color(51, 51, 51));
        jPanel164.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel167.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel167.setForeground(new java.awt.Color(255, 255, 255));
        jLabel167.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel167.setText("View Records");
        jPanel164.add(jLabel167, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel165.setBackground(new java.awt.Color(51, 51, 51));
        jPanel165.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel168.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel168.setForeground(new java.awt.Color(255, 255, 255));
        jLabel168.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel168.setText("Manage Books");
        jPanel165.add(jLabel168, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel164.add(jPanel165, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel166.setBackground(new java.awt.Color(51, 51, 51));
        jPanel166.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel169.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel169.setForeground(new java.awt.Color(255, 255, 255));
        jLabel169.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel169.setText("Return Book");
        jPanel166.add(jLabel169, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel167.setBackground(new java.awt.Color(51, 51, 51));
        jPanel167.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel170.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel170.setForeground(new java.awt.Color(255, 255, 255));
        jLabel170.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel170.setText("Manage Books");
        jPanel167.add(jLabel170, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel166.add(jPanel167, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel164.add(jPanel166, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel160.add(jPanel164, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 230, 40));

        jPanel168.setBackground(new java.awt.Color(51, 51, 51));
        jPanel168.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel171.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel171.setForeground(new java.awt.Color(255, 255, 255));
        jLabel171.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel171.setText("View Records");
        jPanel168.add(jLabel171, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel169.setBackground(new java.awt.Color(51, 51, 51));
        jPanel169.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel172.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel172.setForeground(new java.awt.Color(255, 255, 255));
        jLabel172.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel172.setText("Manage Books");
        jPanel169.add(jLabel172, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel168.add(jPanel169, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel170.setBackground(new java.awt.Color(51, 51, 51));
        jPanel170.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel173.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel173.setForeground(new java.awt.Color(255, 255, 255));
        jLabel173.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel173.setText("Return Book");
        jPanel170.add(jLabel173, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel171.setBackground(new java.awt.Color(51, 51, 51));
        jPanel171.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel174.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel174.setForeground(new java.awt.Color(255, 255, 255));
        jLabel174.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel174.setText("Manage Books");
        jPanel171.add(jLabel174, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel170.add(jPanel171, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel168.add(jPanel170, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel172.setBackground(new java.awt.Color(51, 51, 51));
        jPanel172.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel175.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel175.setForeground(new java.awt.Color(255, 255, 255));
        jLabel175.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel175.setText("View Records");
        jPanel172.add(jLabel175, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel173.setBackground(new java.awt.Color(51, 51, 51));
        jPanel173.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel176.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel176.setForeground(new java.awt.Color(255, 255, 255));
        jLabel176.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel176.setText("Manage Books");
        jPanel173.add(jLabel176, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel172.add(jPanel173, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel174.setBackground(new java.awt.Color(51, 51, 51));
        jPanel174.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel177.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel177.setForeground(new java.awt.Color(255, 255, 255));
        jLabel177.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel177.setText("Return Book");
        jPanel174.add(jLabel177, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel175.setBackground(new java.awt.Color(51, 51, 51));
        jPanel175.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel178.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel178.setForeground(new java.awt.Color(255, 255, 255));
        jLabel178.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel178.setText("Manage Books");
        jPanel175.add(jLabel178, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel174.add(jPanel175, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel172.add(jPanel174, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel168.add(jPanel172, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 230, 40));

        jPanel160.add(jPanel168, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 230, 40));

        jPanel176.setBackground(new java.awt.Color(51, 51, 51));
        jPanel176.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel179.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel179.setForeground(new java.awt.Color(255, 255, 255));
        jLabel179.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel179.setText("View Issued Books");
        jPanel176.add(jLabel179, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel177.setBackground(new java.awt.Color(51, 51, 51));
        jPanel177.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel180.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel180.setForeground(new java.awt.Color(255, 255, 255));
        jLabel180.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel180.setText("Manage Books");
        jPanel177.add(jLabel180, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel176.add(jPanel177, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel178.setBackground(new java.awt.Color(51, 51, 51));
        jPanel178.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel181.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel181.setForeground(new java.awt.Color(255, 255, 255));
        jLabel181.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel181.setText("Return Book");
        jPanel178.add(jLabel181, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel179.setBackground(new java.awt.Color(51, 51, 51));
        jPanel179.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel182.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel182.setForeground(new java.awt.Color(255, 255, 255));
        jLabel182.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel182.setText("Manage Books");
        jPanel179.add(jLabel182, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel178.add(jPanel179, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel176.add(jPanel178, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel180.setBackground(new java.awt.Color(51, 51, 51));
        jPanel180.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel183.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel183.setForeground(new java.awt.Color(255, 255, 255));
        jLabel183.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel183.setText("View Records");
        jPanel180.add(jLabel183, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel181.setBackground(new java.awt.Color(51, 51, 51));
        jPanel181.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel184.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel184.setForeground(new java.awt.Color(255, 255, 255));
        jLabel184.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel184.setText("Manage Books");
        jPanel181.add(jLabel184, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel180.add(jPanel181, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel182.setBackground(new java.awt.Color(51, 51, 51));
        jPanel182.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel185.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel185.setForeground(new java.awt.Color(255, 255, 255));
        jLabel185.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel185.setText("Return Book");
        jPanel182.add(jLabel185, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel183.setBackground(new java.awt.Color(51, 51, 51));
        jPanel183.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel186.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel186.setForeground(new java.awt.Color(255, 255, 255));
        jLabel186.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel186.setText("Manage Books");
        jPanel183.add(jLabel186, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel182.add(jPanel183, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel180.add(jPanel182, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel176.add(jPanel180, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 230, 40));

        jPanel184.setBackground(new java.awt.Color(51, 51, 51));
        jPanel184.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel187.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel187.setForeground(new java.awt.Color(255, 255, 255));
        jLabel187.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel187.setText("View Records");
        jPanel184.add(jLabel187, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel185.setBackground(new java.awt.Color(51, 51, 51));
        jPanel185.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel188.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel188.setForeground(new java.awt.Color(255, 255, 255));
        jLabel188.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel188.setText("Manage Books");
        jPanel185.add(jLabel188, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel184.add(jPanel185, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel186.setBackground(new java.awt.Color(51, 51, 51));
        jPanel186.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel189.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel189.setForeground(new java.awt.Color(255, 255, 255));
        jLabel189.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel189.setText("Return Book");
        jPanel186.add(jLabel189, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel187.setBackground(new java.awt.Color(51, 51, 51));
        jPanel187.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel190.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel190.setForeground(new java.awt.Color(255, 255, 255));
        jLabel190.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel190.setText("Manage Books");
        jPanel187.add(jLabel190, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel186.add(jPanel187, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel184.add(jPanel186, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel188.setBackground(new java.awt.Color(51, 51, 51));
        jPanel188.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel191.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel191.setForeground(new java.awt.Color(255, 255, 255));
        jLabel191.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel191.setText("View Records");
        jPanel188.add(jLabel191, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel189.setBackground(new java.awt.Color(51, 51, 51));
        jPanel189.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel192.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel192.setForeground(new java.awt.Color(255, 255, 255));
        jLabel192.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel192.setText("Manage Books");
        jPanel189.add(jLabel192, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel188.add(jPanel189, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel190.setBackground(new java.awt.Color(51, 51, 51));
        jPanel190.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel193.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel193.setForeground(new java.awt.Color(255, 255, 255));
        jLabel193.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel193.setText("Return Book");
        jPanel190.add(jLabel193, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel191.setBackground(new java.awt.Color(51, 51, 51));
        jPanel191.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel194.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel194.setForeground(new java.awt.Color(255, 255, 255));
        jLabel194.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel194.setText("Manage Books");
        jPanel191.add(jLabel194, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel190.add(jPanel191, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel188.add(jPanel190, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        jPanel184.add(jPanel188, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 230, 40));

        jPanel176.add(jPanel184, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 230, 40));

        jPanel160.add(jPanel176, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 230, 40));

        jPanel128.add(jPanel160, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 230, 40));

        jPanel3.add(jPanel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 230, 40));

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Book_26px.png"))); // NOI18N
        jLabel11.setText("  Manage Books");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel11MouseExited(evt);
            }
        });
        jPanel8.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel9.setBackground(new java.awt.Color(51, 51, 51));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel12.setText("Manage Books");
        jPanel9.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 40));

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, -1, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 240, 760));

        jPanel192.setBackground(new java.awt.Color(255, 255, 255));
        jPanel192.setForeground(new java.awt.Color(255, 255, 255));
        jPanel192.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(204, 204, 204));
        jPanel10.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 51, 51)));

        lbl_noOfBooks.setFont(new java.awt.Font("Sitka Heading", 0, 50)); // NOI18N
        lbl_noOfBooks.setForeground(new java.awt.Color(102, 102, 102));
        lbl_noOfBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Book_Shelf_50px.png"))); // NOI18N
        lbl_noOfBooks.setText("10");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(lbl_noOfBooks)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lbl_noOfBooks)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel192.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 200, 120));

        jLabel13.setFont(new java.awt.Font("Sitka Heading", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("No of Books");
        jPanel192.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jPanel11.setBackground(new java.awt.Color(204, 204, 204));
        jPanel11.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(102, 102, 255)));

        lbl_noofStudents.setFont(new java.awt.Font("Sitka Heading", 0, 50)); // NOI18N
        lbl_noofStudents.setForeground(new java.awt.Color(102, 102, 102));
        lbl_noofStudents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_People_50px.png"))); // NOI18N
        lbl_noofStudents.setText("10");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(lbl_noofStudents)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lbl_noofStudents)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel192.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 200, 120));

        jLabel16.setFont(new java.awt.Font("Sitka Heading", 1, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("No of Students");
        jPanel192.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, -1, 30));

        jPanel12.setBackground(new java.awt.Color(204, 204, 204));
        jPanel12.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 51, 51)));

        lbl_noOfIssuedBooks.setFont(new java.awt.Font("Sitka Heading", 0, 50)); // NOI18N
        lbl_noOfIssuedBooks.setForeground(new java.awt.Color(102, 102, 102));
        lbl_noOfIssuedBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Sell_26px.png"))); // NOI18N
        lbl_noOfIssuedBooks.setText("10");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(lbl_noOfIssuedBooks)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lbl_noOfIssuedBooks)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel192.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 200, 120));

        jLabel28.setFont(new java.awt.Font("Sitka Heading", 1, 20)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(102, 102, 102));
        jLabel28.setText("Issued Books");
        jPanel192.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, -1, 30));

        jPanel13.setBackground(new java.awt.Color(204, 204, 204));
        jPanel13.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(102, 102, 255)));

        lbl_noOfDefaulter.setFont(new java.awt.Font("Sitka Heading", 0, 50)); // NOI18N
        lbl_noOfDefaulter.setForeground(new java.awt.Color(102, 102, 102));
        lbl_noOfDefaulter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Conference_26px.png"))); // NOI18N
        lbl_noOfDefaulter.setText("10");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(lbl_noOfDefaulter)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbl_noOfDefaulter)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel192.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 80, 200, 120));

        jLabel30.setFont(new java.awt.Font("Sitka Heading", 1, 20)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(102, 102, 102));
        jLabel30.setText("Defaulter List");
        jPanel192.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 50, -1, 30));

        table_student.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Id", "Name", "Course", "Branch"
            }
        ));
        table_student.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        table_student.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        table_student.setColorBordeHead(new java.awt.Color(51, 51, 51));
        table_student.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        table_student.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        table_student.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        table_student.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        table_student.setFuenteFilasSelect(new java.awt.Font("Yu Gothic Light", 1, 20)); // NOI18N
        table_student.setFuenteHead(new java.awt.Font("Yu Gothic Light", 1, 20)); // NOI18N
        table_student.setRowHeight(50);
        jScrollPane1.setViewportView(table_student);

        jPanel192.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 510, 190));

        jLabel195.setFont(new java.awt.Font("Sitka Heading", 1, 20)); // NOI18N
        jLabel195.setForeground(new java.awt.Color(102, 102, 102));
        jLabel195.setText("Students Details");
        jPanel192.add(jLabel195, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jLabel197.setFont(new java.awt.Font("Sitka Heading", 1, 20)); // NOI18N
        jLabel197.setForeground(new java.awt.Color(102, 102, 102));
        jLabel197.setText("Books Details");
        jPanel192.add(jLabel197, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, -1, -1));

        panelPieChart.setLayout(new java.awt.BorderLayout());
        jPanel192.add(panelPieChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 290, 370, 280));

        table_books.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Id", "Name", "Author", "Quantity"
            }
        ));
        table_books.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        table_books.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        table_books.setColorBordeHead(new java.awt.Color(51, 51, 51));
        table_books.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        table_books.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        table_books.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        table_books.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        table_books.setFuenteFilasSelect(new java.awt.Font("Yu Gothic Light", 1, 20)); // NOI18N
        table_books.setFuenteHead(new java.awt.Font("Yu Gothic Light", 1, 20)); // NOI18N
        table_books.setRowHeight(50);
        jScrollPane3.setViewportView(table_books);

        jPanel192.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 510, 190));

        getContentPane().add(jPanel192, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 960, 760));

        setSize(new java.awt.Dimension(1200, 799));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
ManageBooks managebook=new ManageBooks();
managebook.setVisible(true);
this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
     jPanel7.setBackground(mouseEnterColor);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseEntered

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited
        jPanel7.setBackground(mouseExitColor);   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseExited

    private void jLabel17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseEntered
    jPanel7.setBackground(mouseEnterColor);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel17MouseEntered

    private void jLabel17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseExited
        jPanel7.setBackground(mouseExitColor);  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel17MouseExited

    private void jLabel19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseEntered
       jPanel7.setBackground(mouseEnterColor);   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel19MouseEntered

    private void jLabel19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseExited
        jPanel7.setBackground(mouseExitColor); // TODO add your handling code here:
    }//GEN-LAST:event_jLabel19MouseExited

    private void jLabel23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseEntered
      jPanel7.setBackground(mouseEnterColor);  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseEntered

    private void jLabel23MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseExited
        jPanel7.setBackground(mouseExitColor);  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseExited

    private void jLabel35MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseEntered
      jPanel7.setBackground(mouseEnterColor);   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel35MouseEntered

    private void jLabel35MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseExited
        jPanel7.setBackground(mouseExitColor);// TODO add your handling code here:
    }//GEN-LAST:event_jLabel35MouseExited

    private void jLabel67MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel67MouseEntered
      jPanel7.setBackground(mouseEnterColor);  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel67MouseEntered

    private void jLabel67MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel67MouseExited
      jPanel7.setBackground(mouseExitColor);  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel67MouseExited

    private void jLabel131MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel131MouseEntered
       jPanel7.setBackground(mouseEnterColor);   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel131MouseEntered

    private void jLabel131MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel131MouseExited
       jPanel7.setBackground(mouseExitColor);  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel131MouseExited

    private void jPanel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseClicked
       
    }//GEN-LAST:event_jPanel14MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
          ManageStudents manageStudents=new ManageStudents();
manageStudents.setVisible(true);
this.dispose();//
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jPanel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseClicked
       


    }//GEN-LAST:event_jPanel16MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
           IssuedBook issuedBook=new IssuedBook();
issuedBook.setVisible(true);
this.dispose();//
     
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        returnBook book=new returnBook();
book.setVisible(true);
this.dispose();/// TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseClicked
         ViewAllRecord book=new ViewAllRecord();
book.setVisible(true);
this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jLabel35MouseClicked

    private void jLabel67MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel67MouseClicked
IssuedBookDetails issued=new IssuedBookDetails();
        issued.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel67MouseClicked

    private void jLabel131MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel131MouseClicked
DefaulterList list=new DefaulterList();
list.setVisible(true);
this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jLabel131MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
login_page login=new login_page();
login.setVisible(true);
this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel179;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel181;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel183;
    private javax.swing.JLabel jLabel184;
    private javax.swing.JLabel jLabel185;
    private javax.swing.JLabel jLabel186;
    private javax.swing.JLabel jLabel187;
    private javax.swing.JLabel jLabel188;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel190;
    private javax.swing.JLabel jLabel191;
    private javax.swing.JLabel jLabel192;
    private javax.swing.JLabel jLabel193;
    private javax.swing.JLabel jLabel194;
    private javax.swing.JLabel jLabel195;
    private javax.swing.JLabel jLabel197;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel100;
    private javax.swing.JPanel jPanel101;
    private javax.swing.JPanel jPanel102;
    private javax.swing.JPanel jPanel103;
    private javax.swing.JPanel jPanel104;
    private javax.swing.JPanel jPanel105;
    private javax.swing.JPanel jPanel106;
    private javax.swing.JPanel jPanel107;
    private javax.swing.JPanel jPanel108;
    private javax.swing.JPanel jPanel109;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel110;
    private javax.swing.JPanel jPanel111;
    private javax.swing.JPanel jPanel112;
    private javax.swing.JPanel jPanel113;
    private javax.swing.JPanel jPanel114;
    private javax.swing.JPanel jPanel115;
    private javax.swing.JPanel jPanel116;
    private javax.swing.JPanel jPanel117;
    private javax.swing.JPanel jPanel118;
    private javax.swing.JPanel jPanel119;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel120;
    private javax.swing.JPanel jPanel121;
    private javax.swing.JPanel jPanel122;
    private javax.swing.JPanel jPanel123;
    private javax.swing.JPanel jPanel124;
    private javax.swing.JPanel jPanel125;
    private javax.swing.JPanel jPanel126;
    private javax.swing.JPanel jPanel127;
    private javax.swing.JPanel jPanel128;
    private javax.swing.JPanel jPanel129;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel130;
    private javax.swing.JPanel jPanel131;
    private javax.swing.JPanel jPanel132;
    private javax.swing.JPanel jPanel133;
    private javax.swing.JPanel jPanel134;
    private javax.swing.JPanel jPanel135;
    private javax.swing.JPanel jPanel136;
    private javax.swing.JPanel jPanel137;
    private javax.swing.JPanel jPanel138;
    private javax.swing.JPanel jPanel139;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel140;
    private javax.swing.JPanel jPanel141;
    private javax.swing.JPanel jPanel142;
    private javax.swing.JPanel jPanel143;
    private javax.swing.JPanel jPanel144;
    private javax.swing.JPanel jPanel145;
    private javax.swing.JPanel jPanel146;
    private javax.swing.JPanel jPanel147;
    private javax.swing.JPanel jPanel148;
    private javax.swing.JPanel jPanel149;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel150;
    private javax.swing.JPanel jPanel151;
    private javax.swing.JPanel jPanel152;
    private javax.swing.JPanel jPanel153;
    private javax.swing.JPanel jPanel154;
    private javax.swing.JPanel jPanel155;
    private javax.swing.JPanel jPanel156;
    private javax.swing.JPanel jPanel157;
    private javax.swing.JPanel jPanel158;
    private javax.swing.JPanel jPanel159;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel160;
    private javax.swing.JPanel jPanel161;
    private javax.swing.JPanel jPanel162;
    private javax.swing.JPanel jPanel163;
    private javax.swing.JPanel jPanel164;
    private javax.swing.JPanel jPanel165;
    private javax.swing.JPanel jPanel166;
    private javax.swing.JPanel jPanel167;
    private javax.swing.JPanel jPanel168;
    private javax.swing.JPanel jPanel169;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel170;
    private javax.swing.JPanel jPanel171;
    private javax.swing.JPanel jPanel172;
    private javax.swing.JPanel jPanel173;
    private javax.swing.JPanel jPanel174;
    private javax.swing.JPanel jPanel175;
    private javax.swing.JPanel jPanel176;
    private javax.swing.JPanel jPanel177;
    private javax.swing.JPanel jPanel178;
    private javax.swing.JPanel jPanel179;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel180;
    private javax.swing.JPanel jPanel181;
    private javax.swing.JPanel jPanel182;
    private javax.swing.JPanel jPanel183;
    private javax.swing.JPanel jPanel184;
    private javax.swing.JPanel jPanel185;
    private javax.swing.JPanel jPanel186;
    private javax.swing.JPanel jPanel187;
    private javax.swing.JPanel jPanel188;
    private javax.swing.JPanel jPanel189;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel190;
    private javax.swing.JPanel jPanel191;
    private javax.swing.JPanel jPanel192;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel68;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel71;
    private javax.swing.JPanel jPanel72;
    private javax.swing.JPanel jPanel73;
    private javax.swing.JPanel jPanel74;
    private javax.swing.JPanel jPanel75;
    private javax.swing.JPanel jPanel76;
    private javax.swing.JPanel jPanel77;
    private javax.swing.JPanel jPanel78;
    private javax.swing.JPanel jPanel79;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel80;
    private javax.swing.JPanel jPanel81;
    private javax.swing.JPanel jPanel82;
    private javax.swing.JPanel jPanel83;
    private javax.swing.JPanel jPanel84;
    private javax.swing.JPanel jPanel85;
    private javax.swing.JPanel jPanel86;
    private javax.swing.JPanel jPanel87;
    private javax.swing.JPanel jPanel88;
    private javax.swing.JPanel jPanel89;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel90;
    private javax.swing.JPanel jPanel91;
    private javax.swing.JPanel jPanel92;
    private javax.swing.JPanel jPanel93;
    private javax.swing.JPanel jPanel94;
    private javax.swing.JPanel jPanel95;
    private javax.swing.JPanel jPanel96;
    private javax.swing.JPanel jPanel97;
    private javax.swing.JPanel jPanel98;
    private javax.swing.JPanel jPanel99;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_noOfBooks;
    private javax.swing.JLabel lbl_noOfDefaulter;
    private javax.swing.JLabel lbl_noOfIssuedBooks;
    private javax.swing.JLabel lbl_noofStudents;
    private javax.swing.JPanel panelPieChart;
    private rojerusan.RSPopuMenu rSPopuMenu1;
    private rojerusan.RSTableMetro table_books;
    private rojerusan.RSTableMetro table_student;
    // End of variables declaration//GEN-END:variables
}
