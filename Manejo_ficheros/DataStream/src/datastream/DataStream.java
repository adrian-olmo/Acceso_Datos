/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastream;
import java.io.*;
/**
 *
 * @author Adri
 */
public class DataStream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        File fichero = new File("Fichero.dat");
        FileInputStream filein = new FileInputStream(fichero);
        DataInputStream dataIS = new DataInputStream(filein);

        String n;
        int e;

        try {
            while (true) {
                n = dataIS.readUTF();
                e = dataIS.readInt();
                System.out.println("nombre: " + n + ", edad: " + e);
            }
        } catch (EOFException oc) {
            dataIS.close();
        }
    }

}
