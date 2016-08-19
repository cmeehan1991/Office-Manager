/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

import Database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author paintboy602
 */
public class NewEmployee {
    private Stage stage;
    private String prefix, firstName, lastName, cellPhone, homePhone, email, streetAddress, apartment, city, state, zipCode, country, comments; 
    private Date birthday, startDate;
    private final DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
    
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
        this.birthday = dateFormat.parse(vars[12]);
        this.startDate = dateFormat.parse(vars[13]);
        this.comments = vars[14];
        
        
        
        submitNewEmployee();
    }
    
    private void submitNewEmployee(){
        Connection conn = new DBConnection().connect();
        String SQL = "INSERT INTO EMPLOYEES (PREFIX, FIRST_NAME, LAST_NAME, CELL_PHONE, HOME_PHONE, EMAIL, STREET_ADDRESS, APARTMENT, CITY, STATE, ZIP_CODE, COUNTRY, BIRTHDAY, START_DATE, COMMENTS, ACCESS) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = conn.prepareStatement(SQL);
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
            ps.setDate(13, birthday);
            ps.setDate(14, startDate);
            ps.setString(15, comments);
            ps.setBoolean(16, true);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "There has been an error submitting this employee. Please try again.", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
}
