package main;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Listas bd = new Listas();
        while (true) {
            //Menu del programa
            int opciones;
            Scanner sc = new Scanner(System.in);
            System.out.println("---- MENU -----");
            System.out.println("1. Listar");
            System.out.println("2. Aniadir");
            System.out.println("3. Borrar");
            System.out.println("4. exportarObjetos");
            System.out.println("5. importarObjetos");
            System.out.println("6. exportarXML personas");
            System.out.println("7. SALIR");
            opciones = sc.nextInt();
           //selector de opciones por switch
            switch (opciones) {
                case 1:
                    for(int i = 0; i < bd.getListaOficina().size(); i++){
                        System.out.println("- " + bd.getListaOficina().get(i));
                    }
                    break;
                case 2:
                    int idOfi;
                    System.out.print("Id oficina: ");
                    idOfi = sc.nextInt();

                    String nombreOfi;
                    System.out.print("Nombre oficina: ");
                    sc.nextLine();
                    nombreOfi = sc.next();

                    int idPer;
                    System.out.print("id persona: ");
                    idPer = sc.nextInt();

                    //----------------------------- Busco si existe la persona -----------------------------------------
                    Persona p = null;
                    boolean existePersona = false;
                    for (int i = 0; i < bd.getListaPersonas().size(); i++) {
                        if (bd.getListaPersonas().get(i).getId() == idPer) {
                            p = bd.getListaPersonas().get(i);
                            existePersona = true;
                            break;
                        }
                    }
                    if (!existePersona) {
                        double sueldoPer;
                        System.out.print("sueldo persona: ");
                        sueldoPer = sc.nextDouble();

                        String nombrePer;
                        System.out.print("Nombre persona: ");
                        sc.nextLine();
                        nombrePer = sc.next();

                        String apellidoPer;
                        System.out.print("Apellido persona: ");
                        sc.nextLine();
                        apellidoPer = sc.next();

                        p = new Persona(idPer, sueldoPer, nombrePer, apellidoPer);
                        bd.getListaPersonas().add(p);
                    }
//----------------------------------------------------------------------------------------------------------------------

                    bd.getListaOficina().add(new Oficina(idOfi, nombreOfi, p));   //agrego la nueva ofi a la lista

                    break;
                case 3:
                    int idOfiBorrar = 0;
                    System.out.print("Id oficina que borrar: ");
                    idOfi = sc.nextInt();
                    boolean existeOfi = false;
                    for (int i = 0; i < bd.getListaOficina().size(); i++) {
                        if (idOfiBorrar == bd.getListaOficina().get(i).getId()) {
                            bd.getListaOficina().remove(i);
                            System.out.println("SE ELIMINO CORRECTAMENTE LA OFICINA " + idOfiBorrar);
                            existeOfi = true;
                        }
                    }
                    if (!existeOfi)
                        System.out.println("NO SE ENCONTRO LA OFICINA");
                    break;
                case 4:
                    bd.exportarOBJ("src/Archivos/oficinas.obj", bd.getListaOficina());
                    bd.exportarOBJ("src/Archivos/personas.obj", bd.getListaPersonas());
                    break;
                case 5:
                    bd.importarOBJ();
                    System.out.println(bd.getListaOficina());
                    /*bd.leerXML("src/Archivos/personasId_1.xml");
                    bd.exportarTXT("src/Archivos/texto.txt", new String[]{"Frase uno","frase","dos"});
                    String[]leido = bd.importarTXT("src/Archivos/texto.txt");*/
                    break;
                case 6:
                    bd.exportarXML();
                    break;
                case 7:
                    System.exit(0);
                    break;

            }
        }
    }
}






