package Controladoras;

import FuncionesMongo.Conectar;
import Ventanas.VentanaInsertar;
import Ventanas.VentanaUno;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import utils.Coche;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladoraAdministrar implements Initializable {
    @FXML
    JFXButton btnVolver, btnEliminar, btnInsertar, btnModificar;
    @FXML
    JFXListView listaCoches, listaOpiniones;
    @FXML
    JFXListView lista;
    ObservableList listaObs;
    Conectar conectar = new Conectar();




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listarCoches();
        listarClientes();
        acciones();

    }

    private void acciones() {
        btnVolver.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                VentanaUno vUno = new VentanaUno();
                Stage stage = (Stage) btnVolver.getScene().getWindow();
                stage.hide();
            }
        });

        btnInsertar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                VentanaInsertar ventanaInsertar = new VentanaInsertar();
            }
        });

        //Metodo borrar Ivan
        btnEliminar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Coche coche = (Coche) lista.getSelectionModel().getSelectedItem();
                conectar.borrarCoches(coche.getbastidor());
                listaObs.remove(coche);
                lista.refresh();
            }
        });


    }


    private void listarCoches() {

        ObservableList listaAlumnos = FXCollections.observableArrayList();
        Conectar conectar = new Conectar();

        listaAlumnos.addAll(conectar.listarCoches());
// se asocia la lista de datos a la tabla
        listaCoches.setItems(listaAlumnos);
    }

    private void listarClientes() {

        ObservableList listaCLientes = FXCollections.observableArrayList();
        Conectar conectar = new Conectar();

        listaCLientes.addAll(conectar.listarClientes());
// se asocia la lista de datos a la tabla
        listaOpiniones.setItems(listaCLientes);
    }
}
