/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author cmeehan
 */
public class DBConnection {
    private Connection DBConnect;
    public Connection connect(){
         String url = "jdbc:mysql://ns8140.hostgator.com:3306/cmeehan_officemanager";
        String username = "cmeehan_prop_adm";
        String password = "&x?ml~3XH!4u";
        try {
            DBConnect = (Connection) DriverManager.getConnection(url, username, password);
            System.out.println("Database Connected");
        }
        catch(SQLException se){
            System.out.println("No Database " + se);
            
        }
        return DBConnect;
    }
}
