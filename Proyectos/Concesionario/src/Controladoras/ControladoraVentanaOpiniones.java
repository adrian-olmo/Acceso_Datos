package Controladoras;

import Ventanas.VentanaListar;
import Ventanas.VentanaOpiniones;
import Ventanas.VentanaUno;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladoraVentanaOpiniones implements Initializable {
    @FXML
    JFXButton btnVolver, btnEnviar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        acciones();
    }

    private void acciones() {
        btnVolver.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                VentanaUno v1 = new VentanaUno();
                VentanaOpiniones vOpiniones = (VentanaOpiniones) btnVolver.getScene().getWindow();
                vOpiniones.close();

            }
        });
    }
}
