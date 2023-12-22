/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package General;
import java.sql.*;
/**
 *
 * @author Dell
 */
public class ConnectionProvider {
   
       private final String jdbcDriver = "com.mysql.cj.jdbc.Driver";
       private final String dbConnectionURL = "jdbc:mysql://localhost:3306/library_system";
       private final String dbUsername = "root";
       private final String dbPassword = "";

    
        
    
    public String getJdbcDriver() {
        return jdbcDriver;
    }

    public String getDbConnectionURL() {
        return dbConnectionURL;
    }

    public String getDbUsername() {
        return dbUsername;
    }

    public String getDbPassword() {
        return dbPassword;
    } 
}
