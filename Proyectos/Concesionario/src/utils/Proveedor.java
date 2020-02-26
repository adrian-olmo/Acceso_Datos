package utils;

public class Proveedor {

    private String id;
    private String empresa;

    public Proveedor() {
    }

    public Proveedor(String id, String empresa) {
        this.id = id;
        this.empresa = empresa;
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "id='" + id + '\'' +
                ", empresa='" + empresa + '\'' +
                '}';
    }
}
