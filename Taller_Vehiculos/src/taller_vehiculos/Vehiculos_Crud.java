/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller_vehiculos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Adri
 */
public class Vehiculos_Crud {

    private Connection conexion = null;

    public Vehiculos_Crud() throws SQLException {

        conexion = DriverManager.getConnection("jdbc:mysql://localhost/alquiler", "localhost", "localhost");

    }

    /*-------------------READ---------------------*/
    public Vehiculo read(Integer idVehiculo) throws SQLException {

        Vehiculo resultado = null;
        String sql = "SELECT * FROM vehiculo WHERE idVehiculo = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setInt(1, idVehiculo);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            resultado = new Vehiculo(
                    rs.getString("Modelo"),
                    rs.getString("Marca"),
                    rs.getInt("CV"),
                    rs.getString("Matricula"),
                    rs.getInt("idVehiculo"));
        }

        return resultado;
    }

    /*-------------------CREATE---------------------*/
    public Vehiculo create(Vehiculo vehiculo) throws SQLException {

        String sql = "INSERT INTO vehiculo VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, vehiculo.getModelo());
        ps.setString(2, vehiculo.getModelo());
        ps.setInt(3, vehiculo.getCV());
        ps.setString(4, vehiculo.getMatricula());
        ps.setInt(5, vehiculo.getId_Vehiculo());

        int rs = ps.executeUpdate();
        return null;
    }

    /*------------------UPDATE---------------------*/
    public Integer update(Vehiculo vehiculoupd) throws SQLException {

        String sql = "UPDATE vehiculo SET modelo = ?, marca = ?, cv = ?, matricula = ? WHERE idVehiculo = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setInt(1, vehiculoupd.getId_Vehiculo());
        ps.setString(2, vehiculoupd.getModelo());
        ps.setString(3, vehiculoupd.getMarca());
        ps.setInt(4, vehiculoupd.getCV());
        ps.setString(5, vehiculoupd.getMatricula());

        int rs = ps.executeUpdate();
        return rs;
    }

    /*------------------DELETE---------------------*/
    public Integer delete(Integer idVehiculo) throws SQLException {

        Vehiculo resultado = null;
        Integer filas;
        String sql = "DELETE FROM vehiculo WHERE idVehiculo = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setInt(1, idVehiculo);
        filas = ps.executeUpdate();

        return filas;
    }

    /*------------------LISTA TODOS LOS USUARIOS---------------------*/
    public ArrayList<Vehiculo> lista() throws SQLException {
        ArrayList<Vehiculo> listavehiculos = new ArrayList();
        String sql = "SELECT * FROM vehiculo;";
        ResultSet rs = conexion.createStatement().executeQuery(sql);
        while (rs.next()) {
            String modelo = rs.getString("Modelo");
            String marca = rs.getString("Marca");
            Integer cv = rs.getInt("CV");
            String matricula = rs.getString("Matricula");
            Integer idvehiculo = rs.getInt("IdVehiculo");

            Vehiculo vehiculo1 = new Vehiculo(modelo, marca, cv, matricula, idvehiculo);

            listavehiculos.add(vehiculo1);

        }
        return listavehiculos;
    }

    /*------------------CIERRA LA BASE DE DATOS---------------------*/
    public void close() throws SQLException {
        conexion.close();
    }
}
