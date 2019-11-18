
package ejercicio_repaso1;

public class Ejercicio_Repaso1 {

    
    public static void main(String[] args) throws ClassNotFoundException {
        
        BBDD baseDatos = new BBDD();
        baseDatos.agregar5empresarios();
        baseDatos.exportar();
        baseDatos.importar();
        
    }
    
}
