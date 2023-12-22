/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package borrowingbooks;

import General.ConnectionProvider;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;


/**
 *
 * @author Dell
 */
public class BookBorrowers extends javax.swing.JFrame {
     
    private byte[] imageData;
    private String imagePath;
    /**
     * Creates new form BookBorrowers
     */
    
    public BookBorrowers() {
        initComponents();  
        this.showBookLibrarySystem();
        
         this.jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()){
                    int selectedRow = jTable1.getSelectedRow();
                    if(selectedRow != -1){
                         imageData  = (byte[]) jTable1.getValueAt(selectedRow,14);
                        
                        ImageIcon imageIcon = new ImageIcon(imageData);
                        Image scaledImage = imageIcon.getImage().getScaledInstance(136, 172, Image.SCALE_SMOOTH);
                        ImageIcon scaledIcon = new ImageIcon(scaledImage);
                        JPHOTO.setIcon(scaledIcon);
                    }
                }
            }
            
        });
    }
    
    
   
   
    
     public void showBookLibrarySystem(){
         try {
            // Create the SQL query with placeholders
            String getQuery = "SELECT * FROM library_table";


            // Create a connection
            ConnectionProvider dbc = new ConnectionProvider();
            String jdbcDriver = dbc.getJdbcDriver();
            String dbConnectionURL = dbc.getDbConnectionURL();
            String dbUsername = dbc.getDbUsername();
            String dbPassword = dbc.getDbPassword();
            Class.forName(jdbcDriver);
            Connection connection = DriverManager.getConnection(dbConnectionURL, dbUsername, dbPassword);

            // Create the PreparedStatement
            PreparedStatement statement = connection.prepareStatement(getQuery);

            statement.executeQuery();
            ResultSet resultSet = statement.executeQuery();
    
    // Process the result set as needed
    if (resultSet.next()) {
        

         // Create a table model to store data
        DefaultTableModel tableModel = new DefaultTableModel();
           // Override isCellEditable method to make all cells non-editable
            tableModel = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    // Make all cells non-editable
                    return false;
                }
            };
        jTable1.setModel(tableModel);
          
         
         
             // Set the row height
            int rowHeight = 30; // Set your desired row height
            this.jTable1.setRowHeight(rowHeight);
            
           
           

       // Get column names and add them to the table model
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = metaData.getColumnName(i);
            if (columnName.equals("Student_id") || columnName.equals("Last_Name") ||
                    columnName.equals("First_Name") || columnName.equals("Middle_Name") || columnName.equals("Phone_Number")
                    || columnName.equals("Gender") || columnName.equals("Section") || columnName.equals("Book_Name") 
                    || columnName.equals("Book_Number") || columnName.equals("Date_Borrowed") || columnName.equals("Time_Borrowed") || columnName.equals("Date_Returned")
                    || columnName.equals("Time_Returned")|| columnName.equals("Book_Status")|| columnName.equals("imageIcon")) {
                
                tableModel.addColumn(columnName);
               
            }else {
              System.out.println("No matching records found.");
              JOptionPane.showMessageDialog(this, "No record found!");
         }
     }

        // Add rows to the table model
        do {
            Object[] rowData = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                rowData[i - 1] = resultSet.getObject(i);
            }
            tableModel.addRow(rowData);
        } while (resultSet.next());

    } 

    // Close resources
    resultSet.close();
    statement.close();
    connection.close();

            System.out.println("Retrieved Successfully!");
         
        } catch (ClassNotFoundException | SQLException e) {
          JOptionPane.showMessageDialog(this, "Your MySQL has an Error");
          e.printStackTrace();
        }
        TableColumnModel columnModel = this.jTable1.getColumnModel();
         TableColumn columnToZero = columnModel.getColumn(14);
         columnToZero.setMinWidth(0);
         columnToZero.setMaxWidth(0);
         columnToZero.setPreferredWidth(0);
         columnToZero.setWidth(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        student_id_field = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        last_name_field = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        first_name_field = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        middle_name_field = new javax.swing.JTextField();
        section_field = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        phone_number_field = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        gender_combo_box = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        time_returned_field = new javax.swing.JTextField();
        book_status_combo_box = new javax.swing.JComboBox<>();
        date_returned_field = new javax.swing.JTextField();
        time_borrowed_field = new javax.swing.JTextField();
        date_borrowed_field = new javax.swing.JTextField();
        book_number_field = new javax.swing.JTextField();
        book_name_field = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        JPHOTO = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        search = new javax.swing.JButton();
        searchTF = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel1.setText("Student id :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 74, 25));

        student_id_field.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        student_id_field.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(student_id_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 200, -1));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel2.setText("Last Name: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 74, 23));

        last_name_field.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        last_name_field.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(last_name_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 200, -1));

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel3.setText("First Name :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 74, 25));

        first_name_field.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        first_name_field.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(first_name_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 200, -1));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel4.setText("Middle Name: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 90, 23));

        middle_name_field.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        middle_name_field.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(middle_name_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 200, -1));

        section_field.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        section_field.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(section_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 200, -1));

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel5.setText("Section :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 90, 23));

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel6.setText("Gender");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 74, 25));

        phone_number_field.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        phone_number_field.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(phone_number_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 200, -1));

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel7.setText("Phone Number: ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 90, 23));

        gender_combo_box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        gender_combo_box.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(gender_combo_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 200, 30));

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel8.setText("Time Returned :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 300, 90, 23));

        time_returned_field.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        time_returned_field.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(time_returned_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 300, 200, -1));

        book_status_combo_box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Returned", "Unreturned", "Lost", "Damage" }));
        book_status_combo_box.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(book_status_combo_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 200, 30));

        date_returned_field.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        date_returned_field.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(date_returned_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, 200, -1));

        time_borrowed_field.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        time_borrowed_field.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(time_borrowed_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 200, -1));

        date_borrowed_field.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        date_borrowed_field.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(date_borrowed_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 200, -1));

        book_number_field.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        book_number_field.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(book_number_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, 200, -1));

        book_name_field.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        book_name_field.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(book_name_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, 200, -1));

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel9.setText("Book Name :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 74, 25));

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel10.setText("Book Number : ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 90, 23));

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel11.setText("Date Borrowed :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, 90, 25));

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel12.setText("Time Borrowed :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 90, 23));

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel13.setText("Date Returned :");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, 90, 23));

        jLabel14.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel14.setText("Book Status :");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 340, 74, 25));

        JPHOTO.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 40, 57), 3));
        JPHOTO.setPreferredSize(new java.awt.Dimension(136, 172));
        jPanel1.add(JPHOTO, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 100, 140, 170));

        jButton9.setForeground(new java.awt.Color(37, 40, 57));
        jButton9.setText("BROWSE");
        jButton9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 280, 140, 30));

        jButton2.setText("SAVE");
        jButton2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        jButton2.setBorderPainted(false);
        jButton2.setPreferredSize(new java.awt.Dimension(64, 18));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 100, 30));

        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student_id", "Last_Name", "First_Name", "Middle_Name", "Phone_number", "Gender", "Section", "Book_Name", "Book_Number", "Date_Borrowed", "Time_Borrowed", "Date_Returned", "Time_Returned", "Book_Status", "imageIcon"
            }
        ));
        jTable1.setSelectionBackground(new java.awt.Color(0, 102, 102));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 890, 190));

        jButton1.setText("DELETE");
        jButton1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, 90, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel15.setText("LIST OF BORROWERS :");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 490, 40));

        search.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        search.setText("SEARCH");
        search.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        search.setBorderPainted(false);
        search.setMaximumSize(new java.awt.Dimension(72, 27));
        search.setMinimumSize(new java.awt.Dimension(72, 27));
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 400, 80, 30));

        searchTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(searchTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 400, 220, 30));

        jButton3.setText("UPDATE");
        jButton3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 100, 30));

        jButton4.setText("RESET");
        jButton4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        jButton4.setBorderPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 400, 90, 30));

        jButton5.setForeground(new java.awt.Color(0, 0, 51));
        jButton5.setText("List of Books");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 350, 100, 30));

        jButton6.setText("History");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 350, 100, 30));

        jButton7.setText("LOG OUT");
        jButton7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton7.setBorderPainted(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 400, 90, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String path = f.getAbsolutePath();
        try {
            BufferedImage bi = ImageIO.read(new File(path));
            Image img = bi.getScaledInstance(136, 172, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img);
            JPHOTO.setIcon(icon);
            imagePath = path;
        } catch (IOException ex) {
            Logger.getLogger(BookBorrowers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            InputStream inputStream = new FileInputStream(imagePath);
            // Create the SQL query with placeholders
            String insertQuery = "INSERT INTO library_table(Student_id,Last_Name,First_Name,Middle_Name,Phone_Number,Gender,Section,Book_Name,Book_Number,Date_Borrowed,Time_Borrowed,Date_Returned,Time_Returned,Book_Status,imageIcon) VALUE (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            // Create a connection
            ConnectionProvider dbc = new ConnectionProvider();
            String jdbcDriver = dbc.getJdbcDriver();
            String dbConnectionURL = dbc.getDbConnectionURL();
            String dbUsername = dbc.getDbUsername();
            String dbPassword = dbc.getDbPassword();
            Class.forName(jdbcDriver);
            Connection connection = DriverManager.getConnection(dbConnectionURL, dbUsername, dbPassword);

            // Create the PreparedStatement
            PreparedStatement statement = connection.prepareStatement(insertQuery);

            statement.setString(1, student_id_field.getText());
            statement.setString(2, last_name_field.getText());
            statement.setString(3, first_name_field.getText());
            statement.setString(4, middle_name_field.getText());
            statement.setString(5, phone_number_field.getText());
            statement.setString(6, String.valueOf(gender_combo_box.getSelectedItem()));
            statement.setString(7, section_field.getText());
            statement.setString(8, book_name_field.getText());
            statement.setString(9, book_number_field.getText());
            statement.setString(10, date_borrowed_field.getText());
            statement.setString(11, time_borrowed_field.getText());
            statement.setString(12, date_returned_field.getText());
            statement.setString(13, time_returned_field.getText());
            statement.setString(14, String.valueOf(book_status_combo_box.getSelectedItem()));
            statement.setBlob(15, inputStream);

            statement.executeUpdate();

            this.student_id_field.setText("");
            this.last_name_field.setText("");
            this.gender_combo_box.setSelectedItem("Male");
            this.first_name_field.setText("");
            this.book_name_field.setText("");
            this.book_status_combo_box.setSelectedItem("Returned");
            this.section_field.setText("");
            this.gender_combo_box.setSelectedItem("Male");
            this.phone_number_field.setText("");
            this.JPHOTO.setIcon(null);
            this.book_number_field.setText("");
            this.time_returned_field.setText("");
            this.date_returned_field.setText("");
            this.date_borrowed_field.setText("");
            this.middle_name_field.setText("");
            this.time_borrowed_field.setText("");

            
            
            showBookLibrarySystem();
            System.out.println("Add Successfully!");

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Your MySQL has an Error");
            e.printStackTrace();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BookBorrowers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();
    int SelectedRows = jTable1.getSelectedRow();
    student_id_field.setText(RecordTable.getValueAt(SelectedRows, 0).toString());
    last_name_field.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
    first_name_field.setText(RecordTable.getValueAt(SelectedRows, 2).toString());
    middle_name_field.setText(RecordTable.getValueAt(SelectedRows, 3).toString());
    phone_number_field.setText(RecordTable.getValueAt(SelectedRows, 4).toString());
    gender_combo_box.setSelectedItem(RecordTable.getValueAt(SelectedRows, 5).toString());
    section_field.setText(RecordTable.getValueAt(SelectedRows, 6).toString());
    book_name_field.setText(RecordTable.getValueAt(SelectedRows, 7).toString());
    book_number_field.setText(RecordTable.getValueAt(SelectedRows, 8).toString());
    date_borrowed_field.setText(RecordTable.getValueAt(SelectedRows, 9).toString());
    time_borrowed_field.setText(RecordTable.getValueAt(SelectedRows, 10).toString());
    date_returned_field.setText(RecordTable.getValueAt(SelectedRows, 11).toString());
    time_returned_field.setText(RecordTable.getValueAt(SelectedRows, 12).toString());
    book_status_combo_box.setSelectedItem(RecordTable.getValueAt(SelectedRows, 13).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          // TODO add your handling code here:
        // Delete function
int deleteItem;
DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();
int SelectedRows = jTable1.getSelectedRow();
try {
    student_id_field.setText(RecordTable.getValueAt(SelectedRows, 0).toString());
    deleteItem = JOptionPane.showConfirmDialog(this, "Confirm if you want to delete item ", "warning", JOptionPane.YES_NO_OPTION);

    if (deleteItem == JOptionPane.YES_OPTION) {

        // Create the SQL query with placeholders
        String deleteQuery = "DELETE FROM library_table WHERE Student_id = ?";

        // Create a connection
        ConnectionProvider dbc = new ConnectionProvider();
        String jdbcDriver = dbc.getJdbcDriver();
        String dbConnectionURL = dbc.getDbConnectionURL();
        String dbUsername = dbc.getDbUsername();
        String dbPassword = dbc.getDbPassword();
        Class.forName(jdbcDriver);
        Connection connection = DriverManager.getConnection(dbConnectionURL, dbUsername, dbPassword);

        // Create the PreparedStatement
        PreparedStatement statement = connection.prepareStatement(deleteQuery);

        // Bind the parameter
        statement.setString(1, student_id_field.getText());

        // Execute the DELETE query
        int rowsAffected = statement.executeUpdate();

        if (rowsAffected > 0) {
            this.student_id_field.setText("");
            this.last_name_field.setText("");
            this.gender_combo_box.setSelectedItem("Male");
            this.first_name_field.setText("");
            this.book_name_field.setText("");
            this.book_status_combo_box.setSelectedItem("Returned");
            this.section_field.setText("");
            this.gender_combo_box.setSelectedItem("Male");
            this.phone_number_field.setText("");
            this.JPHOTO.setIcon(null);
            this.book_number_field.setText("");
            this.time_returned_field.setText("");
            this.date_returned_field.setText("");
            this.date_borrowed_field.setText("");
            this.middle_name_field.setText("");
            this.time_borrowed_field.setText("");

        JOptionPane.showMessageDialog(this,"Record has been successfully deleted");
        } else {
            JOptionPane.showMessageDialog(this,"No record found with the given id_number.");
        }
        // Refresh the table with updated data
        DefaultTableModel tableModel = new DefaultTableModel();
        jTable1.setModel(tableModel);
        showBookLibrarySystem();
    }
} catch (ClassNotFoundException | SQLException e) {
    JOptionPane.showMessageDialog(this, "Your MySQL has an Error");
    e.printStackTrace();
}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
        try {
            // Create the SQL query with placeholders
            String searchQuery = "SELECT * FROM library_table WHERE Student_id LIKE ? OR Last_Name LIKE ? OR First_Name LIKE ? OR Middle_Name LIKE ? OR Phone_Number LIKE ? OR Gender LIKE ? OR Section LIKE ? OR Book_Name LIKE ? OR Book_Number LIKE ? OR Date_Borrowed LIKE ? OR Time_Borrowed LIKE ? OR Date_Returned LIKE ? OR Time_Returned LIKE ? OR Book_Status LIKE ?";

            // Create a connection
            ConnectionProvider dbc = new ConnectionProvider();
            String jdbcDriver = dbc.getJdbcDriver();
            String dbConnectionURL = dbc.getDbConnectionURL();
            String dbUsername = dbc.getDbUsername();
            String dbPassword = dbc.getDbPassword();
            Class.forName(jdbcDriver);
            Connection connection = DriverManager.getConnection(dbConnectionURL, dbUsername, dbPassword);

            // Create the PreparedStatement
            PreparedStatement statement = connection.prepareStatement(searchQuery);

            // Set search parameters
            String searchKeyword = "%" + searchTF.getText() + "%";

            for (int i = 1; i <= 14; i++) {
                statement.setString(i, searchKeyword);
            }

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Process the result set as needed
            if (resultSet.next()) {
                

                // Create a table model to store data
                DefaultTableModel tableModel = new DefaultTableModel();
                // Override isCellEditable method to make all cells non-editable
                tableModel = new DefaultTableModel() {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        // Make all cells non-editable
                        return false;
                    }
                };
                jTable1.setModel(tableModel);

                // Set the row height
                int rowHeight = 30; // Set your desired row height
                this.jTable1.setRowHeight(rowHeight);

                // Get column names and add them to the table model
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    if (columnName.equals("Student_id")
                        || columnName.equals("Last_Name")
                        || columnName.equals("First_Name")
                        || columnName.equals("Middle_Name")
                        || columnName.equals("Phone_Number")
                        || columnName.equals("Gender")
                        || columnName.equals("Section")
                        || columnName.equals("Book_Name")
                        || columnName.equals("Book_Number")
                        || columnName.equals("Date_Borrowed")
                        || columnName.equals("Time_Borrowed")
                        || columnName.equals("Date_Returned")
                        || columnName.equals("Time_Returned")
                        || columnName.equals("Book_Status")
                        || columnName.equals("imageIcon")) {
                        
                        tableModel.addColumn(columnName);
                    }
                    else {
                        System.out.println("No matching records found.");
                        JOptionPane.showMessageDialog(this, "No record found!");
                    }
                }

                // Add rows to the table model
                do {
                    Object[] rowData = new Object[columnCount];
                    for (int i = 1; i <= columnCount; i++) {
                        rowData[i - 1] = resultSet.getObject(i);
                    }
                    tableModel.addRow(rowData);
                } while (resultSet.next());

            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Your MySQL has an Error");
            e.printStackTrace();
        }
        TableColumnModel columnModel = this.jTable1.getColumnModel();
        TableColumn columnToZero = columnModel.getColumn(14);
        columnToZero.setMinWidth(0);
        columnToZero.setMaxWidth(0);
        columnToZero.setPreferredWidth(0);
        columnToZero.setWidth(0);
    }//GEN-LAST:event_searchActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
           // TODO add your handling code here:
       InputStream inputStream;
        // Create the SQL query for update using PreparedStatement
String updateQuery = "UPDATE library_table SET Last_Name=?, First_Name=?, Middle_Name=?, Phone_Number=?, Gender=?, Section=?, Book_Name=?, Book_Number=?, Date_Borrowed=?, Time_Borrowed =?, Date_Returned =?, Time_Returned =?, Book_Status =?, imageIcon =? WHERE Student_id =?";
try {
    // Create a connection
    ConnectionProvider dbc = new ConnectionProvider();
    String jdbcDriver = dbc.getJdbcDriver();
    String dbConnectionURL = dbc.getDbConnectionURL();
    String dbUsername = dbc.getDbUsername();
    String dbPassword = dbc.getDbPassword();
    Class.forName(jdbcDriver);
    Connection connection = DriverManager.getConnection(dbc.getDbConnectionURL(), dbc.getDbUsername(), dbc.getDbPassword());
    // Create the PreparedStatement
    PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);

    // Set the values for the PreparedStatement
    preparedStatement.setString(1, last_name_field.getText());
    preparedStatement.setString(2, first_name_field.getText());
    preparedStatement.setString(3, middle_name_field.getText());
    preparedStatement.setString(4, phone_number_field.getText());
    preparedStatement.setString(5, gender_combo_box.getSelectedItem().toString());
    preparedStatement.setString(6, section_field.getText());
    preparedStatement.setString(7, book_name_field.getText());
    preparedStatement.setString(8, book_number_field.getText());
    preparedStatement.setString(9, date_borrowed_field.getText());
    preparedStatement.setString(10, time_borrowed_field.getText());
    preparedStatement.setString(11, date_returned_field.getText());
    preparedStatement.setString(12,time_returned_field.getText());
    preparedStatement.setString(13, book_status_combo_box.getSelectedItem().toString());
    preparedStatement.setString(15, student_id_field.getText());
 if(imagePath != null){
            try {
                inputStream = new FileInputStream(imagePath);
                    preparedStatement.setBlob(14, inputStream);

            } catch (FileNotFoundException ex) {
                Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
            }

        }else{
            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(imageData);

                 preparedStatement.setBlob(14, byteInputStream);
                


        }
    // Execute the UPDATE query
    int rowsAffected = preparedStatement.executeUpdate();

    if (rowsAffected > 0) {
            this.student_id_field.setText("");
            this.last_name_field.setText("");
            this.gender_combo_box.setSelectedItem("Male");
            this.first_name_field.setText("");
            this.book_name_field.setText("");
            this.book_status_combo_box.setSelectedItem("Returned");
            this.section_field.setText("");
            this.gender_combo_box.setSelectedItem("Male");
            this.phone_number_field.setText("");
            this.JPHOTO.setIcon(null);
            this.book_number_field.setText("");
            this.time_returned_field.setText("");
            this.date_returned_field.setText("");
            this.date_borrowed_field.setText("");
            this.middle_name_field.setText("");
            this.time_borrowed_field.setText("");

        JOptionPane.showMessageDialog(this, "Record has been successfully updated");
    } else {
        JOptionPane.showMessageDialog(this, "No record found with the given student_id.");
    }

    // Refresh the table with updated data
    DefaultTableModel tableModel = new DefaultTableModel();
    jTable1.setModel(tableModel);
    showBookLibrarySystem();

    System.out.println("Update Successfully!");

} catch (ClassNotFoundException | SQLException e) {
    JOptionPane.showMessageDialog(this, "Your MySQL has an Error");
    e.printStackTrace();
}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
            this.student_id_field.setText("");
            this.last_name_field.setText("");
            this.gender_combo_box.setSelectedItem("Male");
            this.first_name_field.setText("");
            this.book_name_field.setText("");
            this.book_status_combo_box.setSelectedItem("Returned");
            this.section_field.setText("");
            this.gender_combo_box.setSelectedItem("Male");
            this.phone_number_field.setText("");
            this.JPHOTO.setIcon(null);
            this.book_number_field.setText("");
            this.time_returned_field.setText("");
            this.date_returned_field.setText("");
            this.date_borrowed_field.setText("");
            this.middle_name_field.setText("");
            this.time_borrowed_field.setText("");
            this.searchTF.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        BookListLog log = new BookListLog();
        log.setVisible(true); 
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        HistoryOfBooks book = new HistoryOfBooks();
        book.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed
private JFrame frame;
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
     frame = new JFrame("Log out");
       if(JOptionPane.showConfirmDialog(frame,"Confirm if you want to Log out","Apache NetBeans IDE",
               JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
       {
           LoginForm log = new LoginForm();
           log.setVisible(true);
           this.dispose();
       }
    }//GEN-LAST:event_jButton7ActionPerformed

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
            java.util.logging.Logger.getLogger(BookBorrowers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookBorrowers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookBorrowers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookBorrowers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookBorrowers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JPHOTO;
    private javax.swing.JTextField book_name_field;
    private javax.swing.JTextField book_number_field;
    private javax.swing.JComboBox<String> book_status_combo_box;
    private javax.swing.JTextField date_borrowed_field;
    private javax.swing.JTextField date_returned_field;
    private javax.swing.JTextField first_name_field;
    private javax.swing.JComboBox<String> gender_combo_box;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField last_name_field;
    private javax.swing.JTextField middle_name_field;
    private javax.swing.JTextField phone_number_field;
    private javax.swing.JButton search;
    private javax.swing.JTextField searchTF;
    private javax.swing.JTextField section_field;
    private javax.swing.JTextField student_id_field;
    private javax.swing.JTextField time_borrowed_field;
    private javax.swing.JTextField time_returned_field;
    // End of variables declaration//GEN-END:variables
}
