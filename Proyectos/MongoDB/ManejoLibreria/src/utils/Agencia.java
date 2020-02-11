package utils;

public class Agencia {

    private int id_agencia;
    private String ciudad;

    public Agencia(int id_agencia, String ciudad) {
        this.id_agencia = id_agencia;
        this.ciudad = ciudad;
    }

    public int getId_agencia() {
        return id_agencia;
    }

    public void setId_agencia(int id_agencia) {
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
        return id_agencia + " - " + ciudad;
    }
}
