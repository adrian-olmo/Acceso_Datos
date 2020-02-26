package Controladoras;

import FuncionesMongo.Conectar;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import utils.Agencia;
import utils.Coche;
import utils.Proveedor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladoraInsertar implements Initializable {

    @FXML
    TextField txtbastidor, txtmarca, txtmodelo, txtprecio, txtidAgencia, txtciudadAgencia, txtidProveedor, txtnombreProveedor, txtcv;
    @FXML
    Button btnImagen, btnregistrar;
    @FXML
    ImageView imagen;

    Conectar conectar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        acciones();
instancias();
    }

    private void instancias() {
    conectar = new Conectar();
    }

    private void acciones() {

        btnImagen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                Stage mainStage = new Stage();
                fileChooser.setInitialDirectory(new File("src/resources"));
                File selectedFile;
                selectedFile = fileChooser.showOpenDialog(mainStage);
                System.out.println(selectedFile.getName());
                String imagenCoche = selectedFile.getName();

                try {
                    BufferedImage bi = ImageIO.read(selectedFile);  // retrieve image
                    Image image = new Image(getClass().getResourceAsStream("../resources/" + imagenCoche));
                    imagen.setImage(image);
                    //ImageIO.write(bi, "png", outputfile);
                } catch (IOException e) {
                    // handle exception
                }
                //TODO Guardar Imagen
                //imagen.setImage(new Image(String.valueOf(selectedFile)));

                //if (selectedFile != null) {
                //.display(selectedFile);
                //}
                //  File selectedFile = fileChooser.showOpenDialog(mainStage);

            }
        });

        btnregistrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String foto = imagen.getImage().toString();
                String bastidor;
                bastidor = txtbastidor.getText();
                String marca = txtmarca.getText();
                String modelo = txtmodelo.getText();
                String cv = txtcv.getText();
                String precio = txtprecio.getText();
                String idAgencia = txtidAgencia.getText();
                String ciudadagencia = txtciudadAgencia.getText();
                String idProveedor = txtidProveedor.getText();
                String nombreProveedor = txtnombreProveedor.getText();
                Agencia agencia = new Agencia(idAgencia, ciudadagencia);
                Proveedor proveedor = new Proveedor(idProveedor, nombreProveedor);
                Coche coche = new Coche(bastidor, foto, cv, marca, modelo, precio, proveedor, agencia);
                conectar.insertarCoche(coche);
            }
        });
    }
}
