/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.net.InetAddress;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author cmeehan
 */
public class DBConnection {

    private Connection DBConnect;

    public Connection connect() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connection Success");
        }
        catch (ClassNotFoundException cnfe){
            System.out.println("Connection Fail " + cnfe);
        }
        
        try{
            InetAddress addr; 
            Socket sock = new Socket("ns8140.hostgator.com", 3306);
            addr = sock.getInetAddress();
            System.out.println("Connected to "+addr);
            sock.close();
            
        }catch(java.io.IOException e){
            System.out.println("Error: "+e);
        }

        
        String url = "jdbc:mysql://ns8140.hostgator.com:3306/cmeehan_officemanager";
        String username = "cmeehan_prop_adm";
        String password = "Ilovemia2016!";
        try {
            DBConnect = (Connection) DriverManager.getConnection(url, username, password);
            System.out.println("Database Connected");
        } catch (SQLException se) {
            System.out.println("No Database: " + se);

        }
        return DBConnect;
    }
}
