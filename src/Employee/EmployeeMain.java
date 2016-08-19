/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author cmeehan
 */
public class EmployeeMain extends Application {
    private Parent root;
    @Override
    public void start(Stage stage) throws IOException {
         root = FXMLLoader.load(getClass().getResource("NewEmployeeFXML.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("Styles/NewEmployeeFXML.css");
        scene.getStylesheets().add("Styles/MainFXML.css");

        stage.setScene(scene);
        stage.setTitle("New Emplyee");
        stage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
