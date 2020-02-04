package utils;

import java.util.Set;

public class Coche {

    private int num_bastidor, imagen, cv;
    private String marca, modelo;
    private double precio;
    private Set<Proveedor> Proveedor;

    private Proveedor proveedor;
    private Agencia agencia;

    public Coche(int num_bastidor, int imagen, int cv, String marca, String modelo, double precio, Proveedor proveedor, Agencia agencia) {
        this.num_bastidor = num_bastidor;
        this.imagen = imagen;
        this.cv = cv;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.proveedor = proveedor;
        this.agencia = agencia;
    }

    public Coche(Set<Proveedor> proveedor) {
        Proveedor = proveedor;
    }

    public int getNum_bastidor() {
        return num_bastidor;
    }

    public void setNum_bastidor(int num_bastidor) {
        this.num_bastidor = num_bastidor;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "marca='" + marca + '\'' +
                '}';
    }
}
