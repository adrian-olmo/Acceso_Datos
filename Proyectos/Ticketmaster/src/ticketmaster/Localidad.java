/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketmaster;

import java.io.Serializable;

/**
 *
 * @author Adri
 */
public class Localidad implements Serializable{
    int id_localidad;
    String nombreCiudad;

    public Localidad(int id_localidad, String nombreCiudad) {
        this.id_localidad = id_localidad;
        this.nombreCiudad = nombreCiudad;
    }

    public int getId_localidad() {
        return id_localidad;
    }

    public void setId_localidad(int id_localidad) {
        this.id_localidad = id_localidad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    @Override
    public String toString() {
        return "Localidad{" + "id_localidad=" + id_localidad + ", nombreCiudad=" + nombreCiudad + '}';
    }
    
}

