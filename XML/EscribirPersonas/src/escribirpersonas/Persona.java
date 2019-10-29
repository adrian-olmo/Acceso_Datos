/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escribirpersonas;

/**
 *
 * @author Usuario DAM 2
 */
import java.io.Serializable;

/**
 *
 * @author Usuario DAM 2
 */

    public class Persona implements Serializable {

        private String nombre;
        private int edad;

        public Persona(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        public Persona() {
            this.nombre = null;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setEdad(int edad) {
            this.edad = edad;
        }

        public String getNombre() {
            return this.nombre; //devuelve el nombre
        }

        public int getEdad() {
            return this.edad; //devuelve la edad
        }
    }//fin clase Persona
