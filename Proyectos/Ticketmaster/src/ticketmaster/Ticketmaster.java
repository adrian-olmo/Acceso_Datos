/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketmaster;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Usuario DAM 2
 */
public class Ticketmaster {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Se trabaja con los archivos por bloques
        //En cada bloque se realizaran todas las acciones correspondientes con cada uno de los ficheros (Crear, Leer, Escribir....)

        Scanner sc = new Scanner(System.in);
        Artista artista;
        Evento evento;
        Localidad localidad;
        Recinto recinto;
        TipoEvento tipoEvento;
        ArrayList<Evento> listaEvento = new ArrayList<Evento>();

        //Creamos, completamos y leemos el archivo de Eventos
        File ficheroevento = new File("Evento.txt");
        FileOutputStream fileout_evento = new FileOutputStream(ficheroevento);
        ObjectOutputStream eventodata = new ObjectOutputStream(fileout_evento);

        FileInputStream filein_evento = new FileInputStream(ficheroevento);
        ObjectInputStream dataIS_evento = new ObjectInputStream(filein_evento);

        String nombre_evento[] = {"FCB BARCELONA - REAL MADRID", "COMBO FRANCES 2019", "TRAP INTERNACIONAL", "GP JAPON F1", "THE HARLEM GLOBETROTTERS", "LA RESISTENCIA", "CONCURSO DE TRIPLES", "LA BOUCHE", "NOCTURNA FESTIVAL 2019", "BARCELONA VS VALENCIA BASKET"};
        String fecha_evento[] = {"11/10/2019", "15/10/2019", "21/10/2019", "24/11/2019", "30/11/2019", "02/01/2020", "15/03/2020", "06/05/2020", "11/07/2020", "20/09/2020"};
        String aritstas[] = {"BECKY G", "LINKIN PSRK", "50CENT", "DAVID BORNCANO", "LEWIS HALMINTON", "LEBRON JAMES", "RIHANNA", "PNL", "REAL MADRID", "NISKA",};
        int id[] = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        String recintos[] = {"CAMP NOU", "GRAN VIA", "IFEMA", "CIRCUITO SUZUKA", "CAJA MAGICA", "MADRID ARENA", "PABELLON DE CRISTAL", "KINEPOLIS", "TEATRO KAPITAL", "SHOKO"};
        String localidades[] = {"BARCELONA", "MADRID", "TOKIO", "MONACO", "BERLIN", "BUENOS AIRES", "ALCORCON", "BILBAO", "ESTONIA", "JERUSALEN",};

        for (int i = 0; i < id.length; i++) {
            evento = new Evento(nombre_evento[i], fecha_evento[i], aritstas[i], recintos[i], localidades[i], id[i]);
            eventodata.writeObject(evento);
            listaEvento.add(new Evento(nombre_evento[i], fecha_evento[i], aritstas[i], recintos[i], localidades[i], id[i]));
        }

        try {
            while (true) {
                evento = (Evento) dataIS_evento.readObject();
                System.out.printf("Nombre: %s, fecha: %s, artista: %s, id: %d, recinto: %s, localidad: %s %n", evento.getNombre(), evento.getFecha(), evento.getArtistas(), evento.getId(), evento.getRecintos(), evento.getLocalidades());
            }
        } catch (EOFException eo) {
            System.out.println("FIN DE LECTURA");
        }
        dataIS_evento.close();

        //Creamos y completamos el archivo de Artistas
        File ficheroartista = new File("Artista.txt");
        FileOutputStream fileout_artista = new FileOutputStream(ficheroartista);
        ObjectOutputStream artistadata = new ObjectOutputStream(fileout_artista);

        FileInputStream filein_artista = new FileInputStream(ficheroartista);
        ObjectInputStream dataIS_artista = new ObjectInputStream(filein_artista);

        int cod_artista[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String nombre_artista[] = {"BECKY G", "LINKIN PARK", "50CENT", "DAVID BORNCANO", "LEWIS HALMINTON", "LEBRON JAMES", "RIHANNA", "PNL", "REAL MADRID", "NISKA",};
        String estilo[] = {"Reggaeton", "Electronic rock", "Rap", "Humor", "Deportivo", "Deportivo", "Pop", "Trap", "Deportivo", "Trap"};

        for (int i = 0; i < cod_artista.length; i++) {
            artista = new Artista(cod_artista[i], nombre_artista[i], estilo[i]);
            artistadata.writeObject(artista);
        }

        try {
            while (true) {
                artista = (Artista) dataIS_artista.readObject();
                System.out.printf("Codigo: %d, nombre: %s, estilo: %s %n", artista.getCod_artista(), artista.getNombre(), artista.getEstilo());
            }
        } catch (EOFException eo) {
            System.out.println("FIN DE LECTURA");
        }
        dataIS_artista.close();

        //Creamos, completamos y leemos el archivo de Localidades
        File ficherolocalidad = new File("Localidad.txt");
        FileOutputStream fileout_localidad = new FileOutputStream(ficherolocalidad);
        ObjectOutputStream localidaddata = new ObjectOutputStream(fileout_localidad);

        FileInputStream filein_localidad = new FileInputStream(ficherolocalidad);
        ObjectInputStream dataIS_localidad = new ObjectInputStream(filein_localidad);

        int id_localidad[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String nombreCiudad[] = {"BARCELONA", "MADRID", "TOKIO", "MONACO", "BERLIN", "BUENOS AIRES", "ALCORCON", "BILBAO", "ESTONIA", "JERUSALEN"};

        for (int i = 0; i < id_localidad.length; i++) {
            localidad = new Localidad(id_localidad[i], nombreCiudad[i]);
            localidaddata.writeObject(localidad);
        }

        try {
            while (true) {
                localidad = (Localidad) dataIS_localidad.readObject();
                System.out.printf("Codigo: %d, nombre: %s %n", localidad.getId_localidad(), localidad.getNombreCiudad());
            }
        } catch (EOFException eo) {
            System.out.println("FIN DE LECTURA");
        }
        dataIS_localidad.close();
        

        //Creamos, completamos y leemos el archivo de Recintos
        File ficherorecinto = new File("Recinto.txt");
        FileOutputStream fileout_recinto = new FileOutputStream(ficherorecinto);
        ObjectOutputStream recintodata = new ObjectOutputStream(fileout_recinto);

        FileInputStream filein_recinto = new FileInputStream(ficherorecinto);
        ObjectInputStream dataIS_recinto = new ObjectInputStream(filein_recinto);

        int id_recinto[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int aforo[] = {500, 2500, 3600, 50, 89000, 4750, 1380, 69000, 1250, 7900};
        String nombre_recinto[] = {"CAMP NOU", "GRAN VIA", "IFEMA", "CIRCUITO SUZUKA", "CAJA MAGICA", "MADRID ARENA", "PABELLON DE CRISTAL", "KINEPOLIS", "TEATRO KAPITAL", "SHOKO"};
        double coste[] = {20.5, 30.0, 54.75, 6.99, 85.20, 65.75, 74.25, 100.50, 24.50, 240.20};

        for (int i = 0; i < id_recinto.length; i++) {
            recinto = new Recinto(id_recinto[i], aforo[i], nombre_recinto[i], coste[i]);
            recintodata.writeObject(recinto);
        }

        try {
            while (true) {
                recinto = (Recinto) dataIS_recinto.readObject();
                System.out.printf("Codigo: %d, nombre: %s, coste: %f, aforo: %d %n", recinto.getId_recinto(), recinto.getNombre(), recinto.getCoste(), recinto.getAforo());
            }
        } catch (EOFException eo) {
            System.out.println("FIN DE LECTURA");
        }
        dataIS_recinto.close();

        //Creamos, completamos y leemos el archivo de Tipos de Evento
        File fichero_tipoev = new File("TipoEvento.txt");
        FileOutputStream fileout_tipoev = new FileOutputStream(fichero_tipoev);
        ObjectOutputStream tipoevdata = new ObjectOutputStream(fileout_tipoev);

        FileInputStream filein_tipoev = new FileInputStream(fichero_tipoev);
        ObjectInputStream dataIS_tipoev = new ObjectInputStream(filein_tipoev);

        int id_evento[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String tipo[] = {"Musica", "Musica", "Musica", "Entrevista", "Deportes", "Deportes", "Musica", "Musica", "Deportes", "Musica"};

        for (int i = 0; i < id_recinto.length; i++) {
            tipoEvento = new TipoEvento(id_evento[i], tipo[i]);
            tipoevdata.writeObject(tipoEvento);
        }

        try {
            while (true) {
                tipoEvento = (TipoEvento) dataIS_tipoev.readObject();
                System.out.printf("Codigo: %d, tipo: %s %n", tipoEvento.getId_evento(), tipoEvento.getTipo());
            }
        } catch (EOFException eo) {
            System.out.println("FIN DE LECTURA");
        }
        dataIS_tipoev.close();

        
        
        System.out.println("1. Artista");
        System.out.println("2. Localidad");
        System.out.println("ELige una opcion");
        int opc = sc.nextInt();
        sc.nextLine();

        switch (opc) {
            case 1:
                System.out.println("Introduce el artista: ");
                String artistaS = sc.nextLine();
                for (Evento item : listaEvento) {
                    if (item.getArtistas().equals(artistaS)) {
                        System.out.println(item);
                        break;
                    }
                }
                break;
            case 2:
                System.out.println("Introduce la localidad: ");
                String localidadS = sc.nextLine();
                for (Evento item : listaEvento) {
                    if (item.getLocalidades().equals(localidadS)) {
                        System.out.println(item);
                        break;
                    }
                }
                break;
            default:
                System.out.println("Debe introducir una opción correcta");
                break;
        }
    }

}

