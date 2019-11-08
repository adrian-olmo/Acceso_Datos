/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lectura;

import java.io.*;
/**
 *
 * @author Usuario DAM 2
 */
public class Lectura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        //Declarar fichero 
        File fichero = new File("C:\\Users\\Usuario DAM 2\\Documents\\NetBeansProjects\\Acceso_Datos\\Manejo_ficheros\\Lectura\\prueba.txt");
        //Crear el flujo de entrada
        FileReader fic = new FileReader(fichero);
        int i;
        while ((i = fic.read()) != -1) //se va leyendo un caracter
        {
            System.out.print((char) i);
        }
        fic.close();// cerrar fichero

    }
}
