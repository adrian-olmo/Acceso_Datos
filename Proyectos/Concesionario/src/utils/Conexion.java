package utils;
import java.sql.*;

public class Conexion {

    Connection conexion = null;

    public static Connection conexionBD(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/bd_concesionario", "admin", "admin");
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }


}
