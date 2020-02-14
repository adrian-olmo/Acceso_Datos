package Controladoras;

import FuncionesMongo.Conectar;
import Ventanas.VentanaListar;
import Ventanas.VentanaLogIn;
import Ventanas.VentanaOpiniones;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladoraVentanaUno implements Initializable {

    @FXML
    JFXButton btnListar, btnAdministrar,btnOpiniones;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    acciones();
    }

    private void acciones() {
        btnListar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                VentanaListar vListar = new VentanaListar();
                Stage stage = (Stage) btnListar.getScene().getWindow();
                stage.close();
            }
        });
        btnOpiniones.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                VentanaOpiniones vOpiniones = new VentanaOpiniones();
                Stage stage = (Stage) btnListar.getScene().getWindow();
                stage.hide();

            }
        });
        btnAdministrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                VentanaLogIn vLogin = new VentanaLogIn();
                Stage stage = (Stage) btnAdministrar.getScene().getWindow();
                stage.hide();
            }
        });
    }
}
