/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package borrowingbooks;

import General.ConnectionProvider;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;



/**
 *
 * @author Dell
 */
public class BookListLog extends javax.swing.JFrame {
   private String Book_id;
   private String Book_Name;
   private String Available_Books;

    /**
     * Creates new form BookListLog
     */
    
   
    public BookListLog() {
        initComponents();
        showListOfBooks();
    }
    
     public void showListOfBooks(){
         try {
            // Create the SQL query with placeholders
            String getQuery = "SELECT * FROM listofbooks";
           

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

           
            ResultSet resultSet = statement.executeQuery();
    
    // Process the result set as needed
    if (resultSet.next()) {
        
           this.Book_id = resultSet.getString("Book_id");
           this.Book_Name = resultSet.getString("Book_Name");
           this.Available_Books = resultSet.getString("Available_Books");
       
        // Display the retrieved data
       
           System.out.println("Book_id: " + this.Book_id);
           System.out.println("Book_Name: " + this.Book_Name);
           System.out.println("Available_Books: " + this.Available_Books);
           
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
            if (columnName.equals("Book_id") 
                    || columnName.equals("Book_Name") 
                    || columnName.equals("Available_Books")) {   
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        book_name_field = new javax.swing.JTextField();
        searchTF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        available_book_field = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        book_id_field = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "BookId", "Book_Name", "available_books"
            }
        ));
        jTable1.setSelectionBackground(new java.awt.Color(0, 102, 102));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 730, 310));

        jButton1.setText("Add Books");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 90, 30));

        jButton3.setText("Search");
        jButton3.setMaximumSize(new java.awt.Dimension(87, 23));
        jButton3.setMinimumSize(new java.awt.Dimension(87, 23));
        jButton3.setPreferredSize(new java.awt.Dimension(87, 23));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 240, 70, 30));
        jPanel1.add(book_name_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 180, 30));
        jPanel1.add(searchTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 170, 30));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Book Name :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 80, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Available Books :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 100, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("List of Books");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 280, -1));

        jButton4.setText("Delete Books");
        jButton4.setMaximumSize(new java.awt.Dimension(87, 23));
        jButton4.setMinimumSize(new java.awt.Dimension(87, 23));
        jButton4.setPreferredSize(new java.awt.Dimension(87, 23));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 110, 30));

        jButton5.setText("BACK");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 30));
        jPanel1.add(available_book_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 180, 30));

        jButton2.setText("Update");
        jButton2.setMaximumSize(new java.awt.Dimension(87, 23));
        jButton2.setMinimumSize(new java.awt.Dimension(87, 23));
        jButton2.setPreferredSize(new java.awt.Dimension(87, 23));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 100, 30));
        jPanel1.add(book_id_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 130, 0, -1));

        jButton6.setText("Clear");
        jButton6.setMaximumSize(new java.awt.Dimension(87, 23));
        jButton6.setMinimumSize(new java.awt.Dimension(87, 23));
        jButton6.setPreferredSize(new java.awt.Dimension(87, 23));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, 90, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 620));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
             
        try {   
            // Create the SQL query with placeholders
            String insertQuery = "INSERT INTO listofbooks(Book_Name,Available_Books) VALUE (?,?)";

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
           
            statement.setString(1, book_name_field.getText());
            statement.setString(2, available_book_field.getText());
            statement.executeUpdate();

            this.book_name_field.setText("");
            this.available_book_field.setText("");
            
            showListOfBooks();
            System.out.println("Add Successfully!");

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Your MySQL has an Error");
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       int deleteItem;
       DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();  
       int SelectedRows = jTable1.getSelectedRow();
       try {
         book_id_field.setText(RecordTable.getValueAt(SelectedRows, 0).toString());
    deleteItem = JOptionPane.showConfirmDialog(this, "Confirm if you want to delete item ", "warning", JOptionPane.YES_NO_OPTION);

    if (deleteItem == JOptionPane.YES_OPTION) {

        // Create the SQL query with placeholders
        String deleteQuery = "DELETE FROM listofbooks WHERE Book_id = ?";

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
        statement.setString(1, book_id_field.getText());
        
        
        int rowsAffected = statement.executeUpdate();

        if (rowsAffected > 0) {          
            this.book_id_field.setText("");
            this.book_name_field.setText("");
            this.available_book_field.setText("");
            

        JOptionPane.showMessageDialog(this,"Record has been successfully deleted");
        } else {
            JOptionPane.showMessageDialog(this,"No record found with the given id_number.");
        }
        // Refresh the table with updated data
        DefaultTableModel tableModel = new DefaultTableModel();
        jTable1.setModel(tableModel);
        showListOfBooks();
    }
    }catch (ClassNotFoundException | SQLException e) {
    JOptionPane.showMessageDialog(this, "Your MySQL has an Error");
    e.printStackTrace();
}
    
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        BookBorrowers book = new BookBorrowers();
        book.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();
    int SelectedRows = jTable1.getSelectedRow();   
    book_id_field.setText(RecordTable.getValueAt(SelectedRows, 0).toString());
    book_name_field.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
    available_book_field.setText(RecordTable.getValueAt(SelectedRows, 2).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
          try {
            // Create the SQL query with placeholders
            String searchQuery = "SELECT * FROM listofbooks WHERE Book_id LIKE ? OR Book_Name LIKE ? OR Available_Books LIKE ? ";

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

            for (int i = 1; i <= 3; i++) {
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
                    if (columnName.equals("Book_id")
                        || columnName.equals("Book_Name")
                        || columnName.equals("Available_Books")) {
                        
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
       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                // Create the SQL query for update using PreparedStatement
      
      String bookIdToUpdate = book_id_field.getText();
      String BookName = book_name_field.getText();
      String AvailableBooks = available_book_field.getText();
      
      String updateQuery = "UPDATE listofbooks SET Book_Name = ?, Available_Books = ? WHERE Book_id = ?";
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
    
    preparedStatement.setString(1, BookName);
    preparedStatement.setString(2,AvailableBooks);
    preparedStatement.setString(3, bookIdToUpdate);
    
    
    // Execute the UPDATE query
    int rowsAffected = preparedStatement.executeUpdate();

    if (rowsAffected > 0) {
           
            this.book_name_field.setText("");
            this.available_book_field.setText("");

        JOptionPane.showMessageDialog(this, "Record has been successfully updated");
    } else {
        JOptionPane.showMessageDialog(this, "No record found with the given student_id.");
    }

    // Refresh the table with updated data
    DefaultTableModel tableModel = new DefaultTableModel();
    jTable1.setModel(tableModel);
    showListOfBooks();

    System.out.println("Update Successfully!");
    
    preparedStatement.close();
    connection.close();

} catch (ClassNotFoundException | SQLException e) {
    JOptionPane.showMessageDialog(this, "Your MySQL has an Error");
    e.printStackTrace();
}

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.book_name_field.setText("");
        this.available_book_field.setText("");
        this.searchTF.setText("");     
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(BookListLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookListLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookListLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookListLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookListLog().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField available_book_field;
    private javax.swing.JTextField book_id_field;
    private javax.swing.JTextField book_name_field;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField searchTF;
    // End of variables declaration//GEN-END:variables
}
