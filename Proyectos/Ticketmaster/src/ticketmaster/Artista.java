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
public class Artista implements Serializable {

    int cod_artista;
    String nombre, estilo;

    public Artista(int cod_artista, String nombre, String estilo) {
        this.cod_artista = cod_artista;
        this.nombre = nombre;
        this.estilo = estilo;
    }

    public int getCod_artista() {
        return cod_artista;
    }

    public void setCod_artista(int cod_artista) {
        this.cod_artista = cod_artista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    @Override
    public String toString() {
        return "Artista{" + "cod_artista=" + cod_artista + ", nombre=" + nombre + ", estilo=" + estilo + '}';
    }

}
