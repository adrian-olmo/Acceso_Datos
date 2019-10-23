/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SalidaDatos;

import java.io.*;

/**
 *
 * @author Usuario DAM 2
 */
public class SalidaDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File fichero = new File ("Fichero.dat");
        FileOutputStream fileout = new FileOutputStream(fichero);
        DataOutputStream dataUS = new DataOutputStream(fileout);
        
        String nombres[] = {"Ana","Maria","Miguel","Carlos","Pedro"};
        int edades[] = {14,15,16,17,18};
        
        for (int i = 0; i<edades.length;i++){
            dataUS.writeUTF(nombres[i]); //escribe el nombre
            dataUS.writeInt(edades[i]); //escribe la dedad
        }
        dataUS.close(); //cierra el stream
    }
    
}
