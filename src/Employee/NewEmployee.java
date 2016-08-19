/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

import Database.DBConnection;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author paintboy602
 */
public class NewEmployee {
    private Stage stage;
    private String prefix, firstName, lastName, cellPhone, homePhone, email, streetAddress, apartment, city, state, zipCode, country, birthday, startDate, comments; 
    
    protected void NewEmployee(Stage stage, String[] vars) throws ParseException{
        this.stage = stage;
        this.prefix = vars[0];
        this.firstName = vars[1];
        this.lastName = vars[2];
        this.cellPhone = vars[3];
        this.homePhone = vars[4];
        this.email = vars[5];
        this.streetAddress = vars[6];
        this.apartment = vars[7];
        this.city = vars[8];
        this.state = vars[9];
        this.zipCode = vars[10];
        this.country = vars[11];
        this.birthday = vars[12];
        this.startDate = vars[13];
        this.comments = vars[14];
        
        
        // Add the new employee to the database
        submitNewEmployee();
    }
    
    private void submitNewEmployee(){
        Connection conn = new DBConnection().connect();
        int uniqueID = 0;
        String SQL = "INSERT INTO EMPLOYEES (PREFIX, FIRST_NAME, LAST_NAME, CELL_PHONE, HOME_PHONE, EMAIL, STREET_ADDRESS, APARTMENT, CITY, STATE, ZIP_CODE, COUNTRY, BIRTHDAY, START_DATE, COMMENTS, ACCESS) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, prefix);
            ps.setString(2, firstName);
            ps.setString(3, lastName);
            ps.setString(4, cellPhone);
            ps.setString(5, homePhone);
            ps.setString(6, email);
            ps.setString(7, streetAddress);
            ps.setString(8, apartment);
            ps.setString(9, city);
            ps.setString(10, state);
            ps.setString(11, zipCode);
            ps.setString(12, country);
            ps.setString(13, birthday);
            ps.setString(14, startDate);
            ps.setString(15, comments);
            ps.setBoolean(16, true);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                uniqueID = rs.getInt(1);
                JOptionPane.showMessageDialog(null,"Employee "+uniqueID+" has been added successfully.","Success!",JOptionPane.INFORMATION_MESSAGE);
            }
            stage.close();
        }catch(SQLException | HeadlessException ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "There has been an error submitting this employee. Please try again.", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
}
