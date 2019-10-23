/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_ticketmaster;

import java.io.Serializable;

/**
 *
 * @author Adri
 */
public class TipoEvento implements Serializable{
    int id_evento;
    String tipo;

    public TipoEvento(int id_evento, String tipo) {
        this.id_evento = id_evento;
        this.tipo = tipo;
    }

    public int getId_evento() {
        return id_evento;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "TipoEvento{" + "id_evento=" + id_evento + ", tipo=" + tipo + '}';
    }
    
}

