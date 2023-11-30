package travel.management.system;

import java.sql.*;

public class DbConnection {
    
    Connection c;
    Statement s;
    DbConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelmanagementsystem", "root", "admin");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
