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
public class Cliente implements Serializable{
    
    String nombre, dni, direccion;
    int telefono, puntos_acumulados;

    public Cliente(String nombre, String dni, String direccion, int telefono, int puntos_acumulados) {
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.puntos_acumulados = puntos_acumulados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getPuntos_acumulados() {
        return puntos_acumulados;
    }

    public void setPuntos_acumulados(int puntos_acumulados) {
        this.puntos_acumulados = puntos_acumulados;
    }

    @Override
    public String toString() {
        return "Cliente:" + "nombre;" + nombre + "dni;" + dni + "direccion;" + direccion + "telefono;" + telefono + "puntos_acumulados;" + puntos_acumulados + '}';
    }
    
    
}
