/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Email;

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
public class EmailMain extends Application {

    Parent root;

    @Override
    public void start(Stage stage) throws IOException {
        root = FXMLLoader.load(getClass().getResource("EmailFXML.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("Styles/MainFXML.css");

        stage.setScene(scene);
        stage.setTitle("Email Communications");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
