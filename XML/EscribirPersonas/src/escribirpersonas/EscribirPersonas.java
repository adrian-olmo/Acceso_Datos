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
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario DAM 2
 */
public class EscribirPersonas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File fichero = new File("¡src\\escribirpersonas\\Artista.txt");
        FileInputStream filein = null;
        ObjectInputStream dataOs = null;
        ListaPersona listaper = null;

        try {
            filein = new FileInputStream(fichero);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EscribirPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            dataOs = new ObjectInputStream(filein);
            //System.out.println(dataOs);
        } catch (IOException ex) {
            Logger.getLogger(EscribirPersonas.class.getName()).log(Level.SEVERE, null, ex);

            System.out.println("Comienza el proceso...");

            //Creamos un objeto Lista de Personas
            listaper = new ListaPersona();

            while (true) {
                Persona persona = (Persona) dataOs.readObject();

                listaper.add(persona); //añadir persona a la lista
            }
        }
        dataOs.close(); //cerrar stream de entrada

        try {
            XStream xstream = new XStream();
            //cambiar de nombre a las etiquetas XML
            xstream.alias("ListaPersonasMunicipio", ListaPersona.class);
            xstream.alias("DatosPersona", Persona.class);

            //quitar etiqueta lista (atributo de la clase ListaPersonas)
            xstream.addImplicitCollection(ListaPersona.class, "lista");
            //Insertar los objetos en el XML
            xstream.toXML(listaper, new FileOutputStream("Personas.xml"));
            System.out.println("Creando fichero XML...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
