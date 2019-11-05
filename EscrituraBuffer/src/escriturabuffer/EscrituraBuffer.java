/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escriturabuffer;

import java.io.*;

/**
 *
 * @author Adri
 */
public class EscrituraBuffer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        File fichero = new File("C:\\Users\\Usuario DAM 2\\Documents\\NetBeansProjects\\Acceso Datos\\Ticketmaster\\Artistas.txt");

        //Crear flujo de salida
        FileWriter fich = new FileWriter(fichero);

        String cadena = "Esto es una prueba con FileWriter";

        //Convierte la cadena en array de caracteres para extraerlos
        char[] cad = cadena.toCharArray();
        for (int i = 0; i < cad.length; i++) {
            fich.write(cad[i]); //se va escribiendo un caracter
        }
        fich.append(" * "); //se añade al final un *
        fich.close();

    }

}
