/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListadoDirectorios;

import java.io.File;

/**
 *
 * @author Usuario DAM 2
 */
public class ListadoDirectorios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String direccion = "C:\\Users\\Usuario DAM 2\\Documents\\NetBeansProjects\\Acceso Datos\\Ticketmaster";
        File f = new File(direccion);
        String[] ficheros = f.list();
        System.out.println("Lista de ficheros: ");
        for (int i = 0; i < ficheros.length; i++) {
            File f2 = new File(f, ficheros[i]);
            System.out.println(f2.getName());
            f2.isDirectory();

        }
    }

}
