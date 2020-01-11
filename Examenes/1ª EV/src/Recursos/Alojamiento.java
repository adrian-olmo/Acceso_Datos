/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursos;

import java.io.Serializable;

/**
 *
 * @author Usuario DAM 2
 */
public class Alojamiento implements Serializable{
    
    String nombre, localidad,tipoaloj;
    double valoracion;

    public Alojamiento(String nombre, String localidad, String tipoaloj, double valoracion) {
        this.nombre = nombre;
        this.localidad = localidad;
        this.tipoaloj = tipoaloj;
        this.valoracion = valoracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getTipoaloj() {
        return tipoaloj;
    }

    public void setTipoaloj(String tipoaloj) {
        this.tipoaloj = tipoaloj;
    }

    public double getValoracion() {
        return valoracion;
    }

    public void setValoracion(double valoracion) {
        this.valoracion = valoracion;
    }

    @Override
    public String toString() {
        return "Alojamiento: " + "nombre;" + nombre + "localidad;" + localidad + "tipoaloj;" + tipoaloj + "valoracion;" + valoracion + '}';
    }
    
    
}
