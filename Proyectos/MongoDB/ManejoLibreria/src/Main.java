import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import utils.Agencia;
import utils.Coche;
import utils.Proveedor;

import java.util.Collection;
import java.util.Collections;


public class Main {
    private MongoClient mongoClient;    // Java MongoDB client (Cliente Java MongoDB)
    private MongoDatabase mongodb;      // Database object (Objeto base de datos)
    /**
     * We establish the connection with the database <b>test</b>.
     * Establecemos la conexión con la base de datos <b>test</b>.
     */
    public void connectDatabase(){
        setMongoClient(new MongoClient());
       setMongodb(getMongoClient().getDatabase("agencia_coches"));
    }
    /**
     * Obtenemos la lista de todos los restaurantes (cada uno es un documento)
     * de la base de datos y los mostramos por pantalla.
     */
    public void listRestaurants(){
        // Para devolver todos los documentos en una colección, llamamos al método find sin ningún documento <b>criteria</b>
        FindIterable<Document> iterable = getMongodb().getCollection("coches").find();

        // Iteramos los resultados y aplicacimos un bloque para cada documento.
        Proveedor proveedor = new Proveedor(1, "Ferrari");

        Coche coche = new Coche(Collections.singleton(proveedor));
        System.out.println(coche.toString());

        for (Document doc : iterable) {
            MongoCollection<Document> collection = mongodb.getCollection("Agencia");
            System.out.println(collection.);
            //System.out.println(doc.getString("marca"));
            //System.out.println(doc.get("Proveedor"));
            //System.out.println(doc.get(proveedor.getId_proveedor()));

            //System.out.println(doc.getString("modelo"));

        }
    }
    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public void setMongoClient(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    public MongoDatabase getMongodb() {
        return mongodb;
    }

    public void setMongodb(MongoDatabase mongodb) {
        this.mongodb = mongodb;
    }


    public static void main(String args[]){
       Main javaMongodbList = new Main();
        javaMongodbList.connectDatabase();
        javaMongodbList.listRestaurants();
        //javaMongodbList.listRestaurants();

    }



}

