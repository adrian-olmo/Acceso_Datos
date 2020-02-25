package Controladoras;

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
    TextField txtbastidor, txtmarca, txtmodelo,txtprecio, txtidAgencia, txtciudadAgencia, txtidProveedor,txtnombreProveedor;
    @FXML
    Button btnImagen, btnregistrar;
    @FXML
    ImageView imagen;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        acciones();

    }

    private void acciones() {

        btnImagen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                Stage mainStage = new Stage();
                fileChooser.setInitialDirectory(new File("src/resources"));
                File selectedFile;
                selectedFile =  fileChooser.showOpenDialog(mainStage);
                System.out.println(selectedFile.getName());
                String imagenCoche = selectedFile.getName();

                try {
                    BufferedImage bi = ImageIO.read(selectedFile);  // retrieve image
                    File outputfile = new File("src\\resources\\Mustang.jpg");
                    ImageIO.write(bi, "png", outputfile);
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
        Agencia agenciadd = new Agencia( idAgencia, ciudadAgencia);

        //Coche cocheadd = new Coche(bastidor, marca, modelo, precio, proveedoradd, nombreProveedor);

    }
}
