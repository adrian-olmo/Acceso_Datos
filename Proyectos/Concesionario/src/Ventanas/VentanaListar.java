package Ventanas;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class VentanaListar extends Stage {

    public VentanaListar() {
        Parent root= null;
        try {
           root  = FXMLLoader.load(getClass().getResource("../layouts/layoutVentanaListar.fxml")) ;
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root,906,579);
        this.setScene(scene);
        this.setTitle("Listando vehículos");
        this.show();
    }
}
