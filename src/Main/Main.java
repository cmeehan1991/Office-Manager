/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author cmeehan
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("Styles/MainFXML.css");
        
        stage.setScene(scene);
        stage.setY(10.00);
        stage.setX(screenWidth() - stage.getWidth() / 2);
        stage.setTitle("Office Manager");
        stage.getIcons().add(new Image("Images/27900.png"));
        stage.setResizable(false);
        stage.setFullScreen(false);
        stage.show();
        stage.setOnCloseRequest((WindowEvent e) -> {
            Platform.exit();
        });
    }

    private double screenWidth() {
        double width;
        Rectangle2D rectangle = Screen.getPrimary().getBounds();
        width = rectangle.getWidth();
        return width;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
