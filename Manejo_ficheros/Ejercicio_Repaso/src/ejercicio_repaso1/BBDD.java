/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_repaso1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author julia
 */
public class BBDD {
    File file = new File("./src/ficheros/Empresario.txt");
    Empresario empresariado;
    ArrayList<Empresario> listaEmpresario = new ArrayList();

    public void agregarEmpresario(Empresario emp) {
        listaEmpresario.add(emp);
    }

    public void eliminarEmpresario(int dni) {
        listaEmpresario.remove(dni);
    }

    public void agregar5empresarios() {
        for (int i = 0; i < 5; i++) {
            String[] nombres = {"Julian", "Ivan", "Adrian", "Karim", "Jesus"};
            String[] apellidos = {"Garcia", "Redondo", "Gordaco", "Benzema", "Ninoc"};
            String[] DNI = {"1", "2", "3", "4", "5"};
            int[] telefonos = {634984994, 634988994, 634784994, 634983994, 634584994};
            String nombre = nombres[i];
            String apellido = apellidos[i];
            String dni = DNI[i];
            int telefono = telefonos[i];
            Empresario emp = new Empresario(nombre, dni, apellido, telefono);
            listaEmpresario.add(emp);
        }
    }

    public void exportar() {
        ObjectOutputStream fichexportar = null;
        try {
            
            FileOutputStream ficheroExportar = new FileOutputStream(file);
            fichexportar = new ObjectOutputStream(ficheroExportar);
            fichexportar.writeObject(listaEmpresario);
        } catch (IOException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fichexportar.close();
            } catch (IOException ex) {
                Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void importar() throws ClassNotFoundException {
        try {
            FileInputStream ficheroImportar = new FileInputStream(file);
            ObjectInputStream fichImportar = new ObjectInputStream(ficheroImportar);
            System.out.println(fichImportar.readObject());
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}