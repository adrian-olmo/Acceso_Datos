package Controladoras;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladoraInsertar implements Initializable {

    @FXML
    TextField txtbastidor, txtmarca, txtmodelo, txtimagen,txtprecio;
    @FXML
    Button btnimagen, btnregistrar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        acciones();

    }

    private void acciones() {

        btnimagen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
    }
}
