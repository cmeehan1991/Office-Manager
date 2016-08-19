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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author cmeehan
 */
public class EmailFXMLController implements Initializable {
private Parent root;
    @FXML Button newEmailButton;
    
    @FXML private void newEmailButtonClick(ActionEvent event) throws IOException{
        Stage stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("NewEmailFXML.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("Styles/EmailFXML.css");

        stage.setScene(scene);
        stage.setTitle("New Email | Email Communications");
        stage.show();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
