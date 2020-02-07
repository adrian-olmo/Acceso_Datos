import com.mongodb.*;
import com.mongodb.MongoClient;
import com.mongodb.client.*;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;
import utils.Agencia;
import utils.Coche;
import utils.Proveedor;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;


public class Main {
    private MongoClient mongoClient;    // Java MongoDB client (Cliente Java MongoDB)
    private MongoDatabase mongodb;      // Database object (Objeto base de datos)

    public void connectDatabase(){
        mongoClient = new MongoClient("localhost", 27017);
      mongodb = mongoClient.getDatabase("agencia_coches");
    }

    public void listarAgencias(){
        Bson filter = new Document("id_agencia", "Agencia");

        DistinctIterable<Agencia> collection = mongodb.getCollection("coches").distinct("Agencia", Agencia.class);
        DistinctIterable<Agencia> collectionfiltrada =  collection.filter(filter);
        MongoCursor<Document> cursor = (MongoCursor<Document>) collectionfiltrada.first();
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }
    }

    public void listarCoches(){
        MongoCollection<Document> collection = mongodb.getCollection("coches");
        MongoCursor<Document> cursor = collection.find().iterator();
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }
    }

    public void listarClientes(){
        MongoCollection<Document> collection = mongodb.getCollection("clientes");
        MongoCursor<Document> cursor = collection.find().iterator();
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }
    }

    public void insertarCoche(){
        int[] numeros = {1,2,3,4,5,6,7,8,9,0};
        String[] min={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","u","v","w","x","y","z"};
        Scanner sc = new Scanner(System.in);
        int bastidor = sc.nextInt();
        int imagen = 0;
        int cv  = sc.nextInt();
        String marca  = sc.next();
        String modelo = sc.next();
        Double precio = sc.nextDouble();

        System.out.println("Introducir proveedor");
        Proveedor proveedor1 = new Proveedor(sc.nextInt(), sc.next());
        System.out.println("Introducir agencia");
        Agencia agencia1 = new Agencia(sc.nextInt(), sc.next());
        Coche coche = new Coche(bastidor, imagen, cv, marca, modelo, precio, proveedor1, agencia1);


        MongoCollection<Document> collection = mongodb.getCollection("coches");
        Document document = new Document("dni", coche.getNum_bastidor()).append("cv", coche.getCv()).append("marca", coche.getMarca()). append("modelo", coche.getModelo()).append("precio",
                coche.getModelo()).append("Proveedor", new Document("empresa", proveedor1.getEmpresa()).append("id", proveedor1.getId_proveedor())).append("Agencia", new Document("ciudad", agencia1.getCiudad()).append("id_agencia", agencia1.getId_agencia()));
        collection.insertOne(document);
    }

    public void insertarCliente(){


    }

    public static void main(String args[]){
       Main javaMongodbList = new Main();
        javaMongodbList.connectDatabase();
        javaMongodbList.listarCoches();
        System.out.println();
       /* javaMongodbList.listarClientes();
        javaMongodbList.insertarCoche();*/
        System.out.println("Agencias");
javaMongodbList.listarAgencias();
    }



}

