package Ventanas;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class VentanaOpiniones extends Stage {

    public VentanaOpiniones() {
        Parent root= null;
        try {
            root  = FXMLLoader.load(getClass().getResource("../layouts/layoutVentanaOpiniones.fxml")) ;
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root,906,579);
        this.setScene(scene);
        this.setTitle("Opiniones usuarios");
        this.show();

        acciones();

    }

    private void acciones() {

    }
}
