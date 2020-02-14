package Controladoras;

import FuncionesMongo.Conectar;
import Ventanas.VentanaListar;
import Ventanas.VentanaUno;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import utils.Coche;

import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;

public class ControladoraListar implements Initializable {


    @FXML
    JFXButton btnVolver, btnComprar;
    @FXML
    JFXListView listaCoches;
    @FXML
    Label lblBastidor, lblMarca, lblModelo, lblAgencia, lblCV, lblPrecio, lblProveedor;
    @FXML
    ImageView imagenCoche;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        acciones();
        listarElementos();
    }

    private void listarElementos() {

        ObservableList listaAlumnos = FXCollections.observableArrayList();
        Conectar conectar = new Conectar();

        listaAlumnos.addAll(conectar.listarCoches());
// se asocia la lista de datos a la tabla
        listaCoches.setItems(listaAlumnos);
    }

    private void acciones() {
        btnVolver.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                VentanaUno v1 = new VentanaUno();
                VentanaListar ventanaListar = (VentanaListar) btnVolver.getScene().getWindow();
                ventanaListar.close();
            }
        });

        listaCoches.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                Coche c = (Coche) listaCoches.getSelectionModel().getSelectedItem();
                rellenarDatos(c);
            }
        });

        btnComprar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Coche c = (Coche) listaCoches.getSelectionModel().getSelectedItem();
                try {
                    Alert alerta = new Alert(Alert.AlertType.CONFIRMATION, c.mostrarDatos(), ButtonType.NEXT);
                    alerta.setTitle("Coche elegido");
                    alerta.show();
                    /*if(alerta.){

                    }*/
                } catch (NullPointerException e) {
                    Alert alerta = new Alert(Alert.AlertType.WARNING, "ELIGE UN COCHE", ButtonType.OK);
                    alerta.setTitle("Error");
                    alerta.show();
                }

            }
        });
    }

    private void rellenarDatos(Coche c) {
        lblBastidor.setText("BASTIDOR: "+c.getbastidor());
        lblMarca.setText("MARCA: "+c.getMarca());
        lblModelo.setText("MODELO: "+c.getModelo());
        lblCV.setText("CV: "+c.getCv());
        imagenCoche.setImage(new Image(getClass().getResourceAsStream("../resources/" + c.getImagen())));
        lblPrecio.setText("PRECIO: "+c.getPrecio() + " €");
        lblAgencia.setText("ID_AGENCIA: "+c.getAgencia().getCiudad());
        lblProveedor.setText("PROVEEDOR: "+c.getProveedor().getEmpresa());

    }

}

