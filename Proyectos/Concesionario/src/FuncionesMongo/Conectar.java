package FuncionesMongo;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import utils.Agencia;
import utils.Coche;
import utils.Proveedor;

import java.util.ArrayList;
import java.util.Scanner;

public class Conectar {
    private MongoClient mongoClient;    // Java MongoDB client (Cliente Java MongoDB)
    private MongoDatabase mongodb;      // Database object (Objeto base de datos)

    public Conectar() {

    }

    public void connectDatabase() {
        mongoClient = new MongoClient("localhost", 27017);
        mongodb = mongoClient.getDatabase("agencia_coches");
        System.out.println("cargado");
    }

    public void listarAgencias() {
        MongoCollection<Document> collection = mongodb.getCollection("coches");
        MongoCursor<Document> cursor = collection.distinct("Agencia", Document.class).iterator();
        ArrayList<Agencia> listaAgencia = new ArrayList<>();
        Gson gson = new Gson();
        try {
            while (cursor.hasNext()) {
                String json = cursor.next().toJson();
                Gson g = new Gson();
                Agencia ag = g.fromJson(json, Agencia.class);

                listaAgencia.add(ag);
            }
        } finally {
            cursor.close();
        }
        for (Agencia ag : listaAgencia) {
            System.out.println(ag);
        }
    }


    public ArrayList<Coche> listarCoches() {
        connectDatabase();
        ArrayList<Coche> coches = new ArrayList();
        String resultado = null;
        MongoCollection<Document> collection = mongodb.getCollection("coches");
        MongoCursor<Document> cursor = collection.find().iterator();
        try {
            while (cursor.hasNext()) {
                resultado = cursor.next().toJson();

                Gson g = new Gson();
                Coche c = g.fromJson(resultado, Coche.class);
                coches.add(c);
            }
        } finally {
            cursor.close();
        }
        mongoClient.close();
        return coches;
    }

    public void listarClientes() {

    }

   /* public void insertarCoche() {

        Scanner sc = new Scanner(System.in);
        int bastidor = sc.nextInt();
        String imagen = null;
        int cv = sc.nextInt();
        String marca = sc.next();
        String modelo = sc.next();
        Double precio = sc.nextDouble();

        System.out.println("Introducir proveedor");
        Proveedor proveedor1 = new Proveedor(sc.next(), sc.next());
        System.out.println("Introducir agencia");
        Agencia agencia1 = new Agencia(sc.nextInt(), sc.next());
        Coche coche = new Coche(bastidor, imagen, cv, marca, modelo, precio, proveedor1, agencia1);


        MongoCollection<Document> collection = mongodb.getCollection("coches");
        Document document = new Document("dni", coche.getNum_bastidor()).append("cv", coche.getCv()).append("marca", coche.getMarca()).append("modelo", coche.getModelo()).append("precio",
                coche.getModelo()).append("Proveedor", new Document("empresa", proveedor1.getEmpresa()).append("id", proveedor1.getId_proveedor())).append("Agencia", new Document("ciudad", agencia1.getCiudad()).append("id_agencia", agencia1.getId_agencia()));
        collection.insertOne(document);
    }*/

    public void insertarCliente() {


    }

    /*public int borrarCoches() {
        MongoCollection<Document> coleccion = mongodb.getCollection("coches");
        MongoCursor<Document> cursor = coleccion.findOneAndDelete();
    }*/
}
