/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author cmeehan
 */
public class NewEmployeeFXMLController implements Initializable {

    @FXML private Button cancelNewEmployeeButton, submitNewEmployeeButton;
    @FXML private ComboBox prefix;
    @FXML private TextField firstName, lastName, cellPhone, homePhone, email, streetAddress, apartment, city, state, zipCode, country;
    @FXML private DatePicker birthday, startDate;
    @FXML private TextArea comments;
    @FXML 
    private void cancelNewEmployeeClick(ActionEvent event){
        Stage stage = (Stage) cancelNewEmployeeButton.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void submitNewEmployeeClick(ActionEvent event){
        Stage stage = (Stage) submitNewEmployeeButton.getScene().getWindow();
        String[] vars = new String[15];
        vars[0] = prefix.getSelectionModel().selectedItemProperty().toString();
        vars[1] = firstName.getText();
        vars[2] = lastName.getText();
        vars[3] = cellPhone.getText();
        vars[4] = homePhone.getText();
        vars[5] = email.getText();
        vars[6] = streetAddress.getText();
        vars[7] = apartment.getText();
        vars[8] = city.getText();
        vars[9] = state.getText();
        vars[10] = zipCode.getText();
        vars[11] = country.getText();
        vars[12] = birthday.getAccessibleText();
        vars[13] = startDate.getAccessibleText();
        vars[14] = comments.getText();
        new NewEmployee().NewEmployee(stage, vars);
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
