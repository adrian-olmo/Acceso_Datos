/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturabuffer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class LecturaBuffer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            BufferedReader fichero = new BufferedReader(new FileReader("C:\\Users\\Usuario DAM 2\\Documents\\NetBeansProjects\\Acceso Datos\\Ticketmaster\\Artistas.txt"));
            String linea;
            while ((linea = fichero.readLine()) != null) {
                System.out.println(linea);
            }

            fichero.close();

        } catch (FileNotFoundException fn) {
            System.out.println("No se encuentra el archivo");

        } catch (IOException io) {
            System.out.println("Error de sys");
        }
    }

}
