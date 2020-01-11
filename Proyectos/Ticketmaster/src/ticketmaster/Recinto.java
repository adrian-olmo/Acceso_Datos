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
public class Recinto implements Serializable{
    int id_recinto,aforo;
    String nombre;
    double coste;

    public Recinto(int id_recinto, int aforo, String nombre, double coste) {
        this.id_recinto = id_recinto;
        this.aforo = aforo;
        this.nombre = nombre;
        this.coste = coste;
    }

    public int getId_recinto() {
        return id_recinto;
    }

    public void setId_recinto(int id_recinto) {
        this.id_recinto = id_recinto;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    @Override
    public String toString() {
        return "Recinto{" + "id_recinto=" + id_recinto + ", aforo=" + aforo + ", nombre=" + nombre + ", coste=" + coste + '}';
    }
    
}

