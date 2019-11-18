/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_repaso1;

import java.io.Serializable;

/**
 *
 * @author julia
 */
public class Empresario implements Serializable {

    private String nombre, DNI, apellidos;
    int telefono;

    public Empresario() {
    }

    public Empresario(String nombre, String DNI, String apellidos, int telefono) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.apellidos = apellidos;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Empresario: " + " nombre= " + nombre + "  apellidos= " + apellidos + "  DNI= " + DNI + "  telefono= " + telefono+ "\n";
    }

}
