/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repaso_examen;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Adri
 */
public class Repaso_Examen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Persona pers;

        File persona = new File("../Lectura/Personas.txt");
        FileOutputStream fileout_persona = new FileOutputStream(persona);
        ObjectOutputStream personadata = new ObjectOutputStream(fileout_persona);

        FileInputStream filein_persona = new FileInputStream(persona);
        ObjectInputStream dataIS_persona = new ObjectInputStream(filein_persona);

        String[] nombre_pers = {"Julian", "Ivan", "Adrian", "Karim", "Jesus"};
        String[] apellido_pers = {"Garcia", "Redondo", "Olmo", "Benzema", "Ninoc"};
        String[] DNI_pers = {"0", "1", "2", "3", "4"};
        int[] telefono_pers = {000000000, 111111111, 222222222, 333333333, 444444444};

        for (int i = 0; i < DNI_pers.length; i++) {
            pers = new Persona(nombre_pers[i], apellido_pers[i], DNI_pers[i], telefono_pers[i]);
            personadata.writeObject(pers);

        }
        try {
            while (true) {
                pers = (Persona) dataIS_persona.readObject();
                System.out.printf("DNI: %s, nombre: %s, apellido: %s %n", pers.getDNI(), pers.getNombre(), pers.getApellidos());
            }
        } catch (EOFException eo) {
            System.out.println("FIN DE LECTURA");
        }
        dataIS_persona.close();
    }

}
