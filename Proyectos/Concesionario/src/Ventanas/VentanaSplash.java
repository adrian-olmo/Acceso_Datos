package Ventanas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class VentanaSplash extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../layouts/layoutControladoraSplash.fxml"));
        Scene scene = new Scene(root, 700, 500);
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        //primaryStage.getIcons().add(new Image("resources/icono.png"));
        primaryStage.show();
    }
    public void mostrar(){
        launch();
    }
}
