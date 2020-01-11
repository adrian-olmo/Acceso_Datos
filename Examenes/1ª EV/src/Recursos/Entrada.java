/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursos;

import com.thoughtworks.xstream.XStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
public class Entrada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

        Alojamiento alojamiento;
        Cliente cliente;
        Localidad localidad;
        Reserva reserva;
        Servicio servicio;

        /*-----------------------------------------------------------------------------------*/
        //Cada vez que el programa se ejecuta, crea automaticamente la carpeta
        File directorio = new File("src/Hotels");
        if (directorio.mkdir()) {
            System.out.println("Carpeta Hotels creada");
        } else {
            System.out.println("Fallo al crear carpeta");
        }

        //A partir de estas separaciones comenzaremos a crear los ficheros vacios en la ruta indicada
        /*-----------------------------------------------------------------------------------*/
        File alojamiento_vacio = new File("src/Ej1_FicherosVacios/Alojamiento_vacio.txt");
        FileOutputStream fileout_alojamiento = new FileOutputStream(alojamiento_vacio);
        ObjectOutputStream alojaminetodata = new ObjectOutputStream(fileout_alojamiento);

        /*-----------------------------------------------------------------------------------*/
        File localidad_vacio = new File("src/Ej1_FicherosVacios/Localidad_vacio.txt");
        FileOutputStream fileout_localidad = new FileOutputStream(localidad_vacio);
        ObjectOutputStream localidaddata = new ObjectOutputStream(fileout_localidad);

        /*-----------------------------------------------------------------------------------*/
        File servicio_vacio = new File("src/Ej1_FicherosVacios/Servicio_vacio.txt");
        FileOutputStream fileout_servicio = new FileOutputStream(servicio_vacio);
        ObjectOutputStream serviciodata = new ObjectOutputStream(fileout_servicio);

        /*-----------------------------------------------------------------------------------*/
        File cliente_vacio = new File("src/Ej1_FicherosVacios/Cliente_vacio.txt");
        FileOutputStream fileout_cliente = new FileOutputStream(cliente_vacio);
        ObjectOutputStream clientedata = new ObjectOutputStream(fileout_cliente);

        /*-----------------------------------------------------------------------------------*/
        File reserva_vacio = new File("src/Ej1_FicherosVacios/Reserva_vacio.txt");
        FileOutputStream fileout_reserva = new FileOutputStream(reserva_vacio);
        ObjectOutputStream reservadata = new ObjectOutputStream(fileout_reserva);

        /*-----------------------------------------------------------------------------------*/
        //Listado de la ruta absoluta de la carpeta Hotels
        System.out.println("-----------------------------------------------------");
        System.out.println(directorio);
        /*-----------------------------------------------------------------------------------*/
        //Listado de la ruta de los ficheros vacios
        System.out.println("-----------------------------------------------------");
        File carpeta = new File("src/Ej1_FicherosVacios");
        String[] listado = carpeta.list();
        if (listado == null || listado.length == 0) {
            System.out.println("No hay elementos dentro de la carpeta actual");
            return;
        } else {
            for (int i = 0; i < listado.length; i++) {
                System.out.println(listado[i]);
            }
        }

        /*-----------------------------------------------------------------------------------*/
        //Rellenamos el fichero de Alojamiento y lo leemos por pantalla
        File ficheroalojamiento = new File("src/Ej2_LecturaFicheros/Alojamiento.txt");
        FileOutputStream salida_alojamiento = new FileOutputStream(ficheroalojamiento);
        ObjectOutputStream aloj_rellenodata = new ObjectOutputStream(salida_alojamiento);

        FileInputStream filein_alojamiento = new FileInputStream(ficheroalojamiento);
        ObjectInputStream dataIS_alojamiento = new ObjectInputStream(filein_alojamiento);

        String nombre_alojamiento[] = {"NH", "SOL", "RESORT", "VILLA", "VP"};
        String localidad_alojamiento[] = {"Alcorcon", "Galicia", "Sevilla", "Barcelona", "Madrid"};
        String tipo_alojamiento[] = {"Hotel 4*", "Hotel 5*", "Hotel 4*", "Hotel 3*", "Hotel 5*"};
        double valoracion_alojamiento[] = {4.5, 5.2, 3.6, 8.2, 9.6};
        System.out.println("-----------------------------------------------------");

        for (int i = 0; i < valoracion_alojamiento.length; i++) {
            alojamiento = new Alojamiento(nombre_alojamiento[i], localidad_alojamiento[i], tipo_alojamiento[i], valoracion_alojamiento[i]);
            aloj_rellenodata.writeObject(alojamiento);
        }

        try {
            while (true) {
                alojamiento = (Alojamiento) dataIS_alojamiento.readObject();

                System.out.printf("%s;%s;%s;%.1f \n", alojamiento.getNombre(), alojamiento.getLocalidad(), alojamiento.getTipoaloj(), alojamiento.getValoracion());
            }
        } catch (EOFException eo) {
            System.out.println("");
            System.out.println("FIN DE LECTURA");
        }
        dataIS_alojamiento.close();

    }
}
