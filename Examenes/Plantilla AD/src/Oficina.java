import java.io.Serializable;
import java.util.ArrayList;

public class Oficina implements Serializable {
    private int id;
    private String nombre;
    private Persona persona;

    public Oficina(int id, String nombre, Persona persona) {
        this.id = id;
        this.nombre = nombre;
        this.persona = persona;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Persona getPersona() {
        return persona;
    }

    @Override
    public String toString() {
        return "Oficina{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", persona=" + persona +
                '}';
    }
}
