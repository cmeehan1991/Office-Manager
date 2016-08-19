package Main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Email.EmailMain;
import Employee.EmployeeMain;
import java.io.IOException;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author cmeehan
 */
public class MainController implements Initializable {

    public Parent root;
    @FXML
    private Button EmailButton;
    private Button NewEmployeeButton;

    @FXML
    private void handleEmailButton(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        new EmailMain().start(stage);
    }
    
    @FXML
    private void openNewEmployee(ActionEvent event) throws IOException{
        Stage stage = new Stage();
        new EmployeeMain().start(stage);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
