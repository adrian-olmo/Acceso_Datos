package utils;


public class Coche {

    private String bastidor, cv;
    private String marca, modelo, imagen;
    private String precio;

    private Proveedor Proveedor;
    private Agencia Agencia;

    public Coche() {
    }

    public Coche(String bastidor, String imagen, String cv, String marca, String modelo, String precio, Proveedor Proveedor, Agencia Agencia) {
        this.bastidor = bastidor;
        this.imagen = imagen;
        this.cv = cv;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.Proveedor = Proveedor;
        this.Agencia = Agencia;
    }


    public String getbastidor() {
        return bastidor;
    }

    public void setbastidor(String bastidor) {
        this.bastidor = bastidor;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
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

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Proveedor getProveedor() {
        return Proveedor;
    }

    public void setProveedor(utils.Proveedor Proveedor) {
        this.Proveedor = Proveedor;
    }

    public Agencia getAgencia() {
        return Agencia;
    }

    public void setAgencia(Agencia Agencia) {
        this.Agencia = Agencia;
    }

    @Override
    public String toString() {
        return bastidor + " " + marca + " - " + modelo;
    }

    public String mostrarDatos(){
        return "Coche{" +
                "bastidor='" + bastidor + '\'' +
                ", cv='" + cv + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", imagen='" + imagen + '\'' +
                ", precio='" + precio + '\'' +
                ", Proveedor=" + Proveedor +
                ", Agencia=" + Agencia +
                '}';
    }
}
