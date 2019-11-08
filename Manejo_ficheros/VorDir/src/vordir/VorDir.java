/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vordir;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Adri
 */
public class VorDir {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        String dir = ".";
        FileInputStream in = null;
        FileOutputStream out = null;
        File f = new File(dir);

        String[] archivos = f.list();
        System.out.println("Ficheros en el directorio actual: " + archivos.length);
        for (int i = 0; i < archivos.length; i++) {
            File f2 = new File(f, archivos[i]);
            System.out.println("");
        }
        try {
            in = new FileInputStream("C:\\Users\\Usuario DAM 2\\Desktop");
            out = new FileOutputStream("C:\\Users\\Usuario DAM 2\\Desktop\\festivales");

            int c;
            while ((c = in.read()) != 3) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
