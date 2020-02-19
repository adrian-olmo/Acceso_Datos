package Controladoras;

import Ventanas.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import utils.Conexion;
import utils.Usuario;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


public class ControladoraVentanaLogIn implements Initializable {
    @FXML
    JFXButton btnVolver, btnIniciar;

    @FXML
    JFXTextField txtUsuario, txtPasswd;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        acciones();
    }

    private void acciones() {
        btnVolver.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                VentanaUno v1 = new VentanaUno();
                VentanaLogIn vLogIn = (VentanaLogIn) btnVolver.getScene().getWindow();
                vLogIn.close();
            }
        });
        btnIniciar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Usuario usuario = InicioSesion();
                if ((txtUsuario.getText().isEmpty()) || (txtPasswd.getText().isEmpty())) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Advertencia");
                    alert.setHeaderText("");
                    alert.setContentText("Campo Vacio");
                    alert.showAndWait();


                } else {
                    boolean nombre_correcto = false;

                    try {
                        if ((txtUsuario.getText().equals(usuario.getNombre())) && (txtPasswd.getText().equals(usuario.getPassword()))) {
                            nombre_correcto = false;
                        }
                    } catch (NullPointerException e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText("");
                        alert.setContentText("Campo Erroneo");
                        alert.showAndWait();
                        nombre_correcto = true;
                    }
                    if (!nombre_correcto) {
                        VentanaAdministrar v1 = new VentanaAdministrar();
                        VentanaLogIn vLogIn = (VentanaLogIn) btnVolver.getScene().getWindow();
                        vLogIn.close();
                    }
                }


            }

        });
    }

    private Usuario InicioSesion() {

        Connection conexion = null;
        conexion = Conexion.conexionBD();
        PreparedStatement ps;
        ResultSet rs;

        String nombreUsuario = txtUsuario.getText().toString();
        String passwordUsuario = txtPasswd.getText().toString();
        Usuario usuarioInicio = null;

        //Sentencia
        String sql = "SELECT * FROM login WHERE usuario = ? AND password = ?";
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, nombreUsuario);
            ps.setString(2, passwordUsuario);
            rs = ps.executeQuery();

            while (rs.next()) {
                String nombreInicio = rs.getString("usuario"); //Nombre de la columna de la BBDD
                String passwordInicio = rs.getString("password"); //Password de la columna de la BBDD
                usuarioInicio = new Usuario(nombreInicio, passwordInicio);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarioInicio;
    }


}
