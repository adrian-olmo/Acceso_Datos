/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller_vehiculos;

/**
 *
 * @author Adri
 */
public class Vehiculo {
    
    private String modelo;
    private String marca;
    private int CV; 
    private String matricula; 
    private int idVehiculo;

    public Vehiculo(String modelo, String marca, int CV, String matricula, int idVehiculo) {
        this.modelo = modelo;
        this.marca = marca;
        this.CV = CV;
        this.matricula = matricula;
        this.idVehiculo = idVehiculo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCV() {
        return CV;
    }

    public void setCV(int CV) {
        this.CV = CV;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    

    @Override
    public String toString() {
        return "Vehiculo: " + "\nModelo: " + modelo + "\nMarca: " + marca + "\nCV: " + CV + "\nMatricula: " + matricula + "\nIdVehiculo: " + idVehiculo +"\n";
    }
    
    
    
    
    
    
    
    
    
}
