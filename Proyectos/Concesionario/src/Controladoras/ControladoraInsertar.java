package Controladoras;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import utils.Coche;
import utils.Proveedor;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladoraInsertar implements Initializable {

    @FXML
    TextField txtbastidor, txtmarca, txtmodelo,txtprecio, txtidAgencia, txtciudadAgencia, txtidProveedor,txtnombreProveedor;
    @FXML
    Button btnImagen, btnregistrar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        acciones();

    }

    private void acciones() {

        btnImagen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser cc = new FileChooser();
                System.out.println("HAZ ALGO UTIL");
            }
        });
    }


    private void agregarCoche(){
        String bastidor = txtbastidor.getText();
        String marca = txtmarca.getText();
        String modelo = txtmodelo.getText();
        double precio = Double.parseDouble(txtprecio.getText());
        String idAgencia = txtidAgencia.getText();
        String ciudadAgencia = txtciudadAgencia.getText();
        String idProveedor = txtidProveedor.getText();
        String nombreProveedor = txtnombreProveedor.getText();

        Proveedor proveedoradd = new Proveedor( idProveedor, nombreProveedor);
        Proveedor agenciadd = new Proveedor( idAgencia, ciudadAgencia);

        //Coche cocheadd = new Coche(bastidor, marca, modelo, precio, proveedoradd, nombreProveedor);

    }
}
