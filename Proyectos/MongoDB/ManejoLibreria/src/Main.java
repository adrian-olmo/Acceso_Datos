import com.google.gson.Gson;
import com.mongodb.*;
import com.mongodb.MongoClient;
import com.mongodb.client.*;
import com.mongodb.util.JSON;
import netscape.javascript.JSObject;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONException;
import org.json.JSONObject;
import utils.Agencia;
import utils.Coche;
import utils.Proveedor;

import java.util.*;


public class Main {
    private MongoClient mongoClient;    // Java MongoDB client (Cliente Java MongoDB)
    private MongoDatabase mongodb;      // Database object (Objeto base de datos)

    public void connectDatabase(){
        mongoClient = new MongoClient("localhost", 27017);
        mongodb = mongoClient.getDatabase("agencia_coches");
    }

    public void listarAgencias(){
        MongoCollection<Document> collection = mongodb.getCollection("coches");
        MongoCursor<Document> cursor = collection.distinct("Agencia", Document.class).iterator();
        ArrayList<Agencia> listaAgencia = new ArrayList<>();
        Gson gson = new Gson();
        try {
            while (cursor.hasNext()) {
                String json = cursor.next().toJson();
                Gson g = new Gson();
                Agencia ag= g.fromJson(json, Agencia.class);

                listaAgencia.add(ag);
            }
        } finally {
            cursor.close();
        }
        for (Agencia ag: listaAgencia) {
            //System.out.println(ag);
        }
        System.out.println(listaAgencia.get(0));
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

    }

    public void insertarCoche(){

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

    public int borrarCoches(){
        int filas = 0;
        return filas;
    }

    public static void main(String args[]){
       Main javaMongodbList = new Main();
        javaMongodbList.connectDatabase();
        javaMongodbList.listarCoches();
        System.out.println();
      /*  javaMongodbList.listarClientes();
        javaMongodbList.insertarCoche();
        System.out.println("Agencias");
javaMongodbList.listarAgencias();*/
    }



}

