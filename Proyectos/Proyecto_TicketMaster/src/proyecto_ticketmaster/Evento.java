/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_ticketmaster;
import java.io.Serializable;

/**
 *
 * @author Adri
 */
public class Evento implements Serializable {

    String nombre, fecha, artistas, recintos, localidades;
    int id;

    public Evento() {
    }

    public Evento(String nombre, String fecha, String artistas, String recintos, String localidades, int id) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.artistas = artistas;
        this.recintos = recintos;
        this.localidades = localidades;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getArtistas() {
        return artistas;
    }

    public void setArtistas(String artistas) {
        this.artistas = artistas;
    }

    public String getRecintos() {
        return recintos;
    }

    public void setRecintos(String recintos) {
        this.recintos = recintos;
    }

    public String getLocalidades() {
        return localidades;
    }

    public void setLocalidades(String localidades) {
        this.localidades = localidades;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Evento{" + "nombre=" + nombre + ", fecha=" + fecha + ", artistas=" + artistas + ", recintos=" + recintos + ", localidades=" + localidades + ", id=" + id + '}';
    }

}
