package Controladoras;

import FuncionesMongo.Conectar;
import Ventanas.VentanaListar;
import Ventanas.VentanaOpiniones;
import Ventanas.VentanaUno;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import utils.Opinion;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladoraVentanaOpiniones implements Initializable {
    @FXML
    JFXButton btnVolver, btnEnviar;
    @FXML
    JFXTextField txtNombre, txtApellidos, txtDni, txtTelefono;
    @FXML
    JFXTextArea areaComentarios;
    Conectar conectar;

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

        btnEnviar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String nombre = txtNombre.getText();
                String apellidos = txtApellidos.getText();
                String dni = txtDni.getText();
                String telefono = txtTelefono.getText();
                String comentario = areaComentarios.getText();
                Opinion opinion = new Opinion(dni, nombre, apellidos, telefono, comentario);
                try{
                    conectar.insertarOpiniones(opinion);
                }
                catch(NullPointerException ex){
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Registrado");
                    alert.setHeaderText("Registro completado");
                    alert.setContentText("insertado con exito");
                    alert.show();

                }

            }
        });
    }
}
