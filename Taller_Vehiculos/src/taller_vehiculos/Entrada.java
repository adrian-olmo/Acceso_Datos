/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller_vehiculos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Adri
 */
public class Entrada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);
        Vehiculos_Crud vehichulos = null;
        Vehiculo coche;
        String opcprincipal;

        //Realiza la conexion a la base de datos
        try {
            vehichulos = new Vehiculos_Crud();
        } catch (SQLException e) {
            System.err.println("Error al abrir la base de datos " + e.getMessage());
            System.exit(1);
        }
        System.out.println("Conexion Satisfactoria");

        /*------SE MUESTRA UN MENU CON DIFERENTES OPCIONES DE GESTION-------*/
        boolean salida = false;
        while (salida == false) {
            System.out.println("Elige una de las opciones del menu: ");
            System.out.println("1. Listar todos los vehiculo"); //Lista todos los usuarios
            System.out.println("2. Listar vehiculo concreto"); //Metodo SELECT
            System.out.println("3. Anadir un vehiculo"); //Metodo INSERT
            System.out.println("4. Actualizar un vehiculo"); //Metodo UPDATE
            System.out.println("5. Borra un vehiculo"); //Metodo DELETE
            System.out.println("6. Salir de la BBDD");

            opcprincipal = sc.nextLine();

            switch (opcprincipal) {
                /*------LISTADO DE TODOS LOS VEHICULOS DE LA BBDD-------*/
                case "1":
                    try {
                            ArrayList<Vehiculo> vehiculolista = vehichulos.lista();
                        for (int i = 0; i < vehiculolista.size(); i++) {
                            System.out.println(vehiculolista.get(i));
                        }
                    } catch (SQLException e) {
                        System.err.println("Error al listar: " + e.getMessage());
                    }
                    break;

                /*------LISTADO UN VEHICULO CONCRETO-------*/
                case "2":
                    try {
                        System.out.println("Inserta codigo de Vehiculo: ");
                        Integer idVehiculo = sc.nextInt();
                        coche = vehichulos.read(idVehiculo);
                        System.out.println(coche);
                    } catch (SQLException e) {
                        System.err.println("Error al leer " + e.getMessage());
                    }
                    break;

                /*------INSERTA UN VEHICULO EN LA BBDD-------*/
                case "3":
                    try {
                        System.out.println("Introduce los datos del vehiculo: ");

                        System.out.println("Modelo: ");
                        String modelo = sc.next();

                        System.out.println("Marca: ");
                        String marca = sc.next();

                        System.out.println("CV: ");
                        int cv = sc.nextInt();

                        System.out.println("Matricula: ");
                        String matricula = sc.next();

                        System.out.println("idVehiculo: ");
                        int id = sc.nextInt();

                        Vehiculo vehiculocreado = new Vehiculo(modelo, marca, cv, matricula, id);
                        vehichulos.create(vehiculocreado);

                    } catch (SQLException e) {
                        System.err.println("Error: " + e.getMessage());
                    }

                    break;

                /*------ACTUALIZA LOS DATOS DE UN VEHICULO-------*/
                case "4":
                    try {
                        System.out.println("Introduce el codigo del vehiculo");
                        int idVehiculo = sc.nextInt();
                        Vehiculo cocheupd = vehichulos.read(idVehiculo);

                        System.out.println("Modelo: ");
                        String actualizado = sc.next();

                        System.out.println("Marca: ");
                        actualizado = sc.next();

                        System.out.println("CV: ");
                        int CV = sc.nextInt();

                        System.out.println("Matricula: ");
                        actualizado = sc.next();

                        vehichulos.update(cocheupd);
                        int filas = vehichulos.update(cocheupd);
                        
                    } catch (SQLException e) {
                        System.err.println("Error al actualizar " + e.getMessage());
                    }
                    break;

                case "5":
                    try {
                        System.out.println("Introduce el vehiculo que quieres borrar");
                        int purga = sc.nextInt();
                        vehichulos.delete(purga);
                        System.out.println("Vehiculo borrado");
                    } catch (SQLException e) {
                        System.err.println("Error al borrar " + e.getMessage());
                    }
                    break;

                case "6":
                    System.out.println("Has salido de la BBDD");
                    salida = true;
                    break;
            }
        }

    }

}
