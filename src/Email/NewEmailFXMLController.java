/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Email;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author cmeehan
 */
public class NewEmailFXMLController implements Initializable {

    @FXML
    private Button sendEmailButton;

    @FXML
    private TextField toTextField, ccTextField, bccTextField, subjectTextField;

    @FXML
    private TextArea messageTextArea;

    @FXML
    private void sendEmail(ActionEvent event) throws IOException {
        Stage stage = (Stage) sendEmailButton.getScene().getWindow();
        stage.setAlwaysOnTop(true);
        new SendEmail().SendEmail(toTextField.getText(), ccTextField.getText(), bccTextField.getText(), subjectTextField.getText(), messageTextArea.getText(), stage);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
