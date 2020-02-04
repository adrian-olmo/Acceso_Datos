package utils;

public class Proveedor {

    private int id_proveedor;
    private String empresa;

    public Proveedor(int id_proveedor, String empresa) {
        this.id_proveedor = id_proveedor;
        this.empresa = empresa;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}
