package utils;

public class Agencia {

    private String id_agencia;
    private String ciudad;

    public Agencia() {
    }

    public Agencia(String id_agencia, String ciudad) {
        this.id_agencia = id_agencia;
        this.ciudad = ciudad;
    }

    public String getId_agencia() {
        return id_agencia;
    }

    public void setId_agencia(String id_agencia) {
        this.id_agencia = id_agencia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Agencia{" +
                "id_agencia='" + id_agencia + '\'' +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}
