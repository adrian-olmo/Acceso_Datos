package FuncionesMongo;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import sun.management.resources.agent_sv;
import utils.*;

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

    public ArrayList<Clientes> listarClientes() {
        connectDatabase();
        ArrayList<Clientes> clientes = new ArrayList();
        String resultado = null;
        MongoCollection<Document> collection = mongodb.getCollection("clientes");
        MongoCursor<Document> cursor = collection.find().iterator();
        try {
            while (cursor.hasNext()) {
                resultado = cursor.next().toJson();

                Gson g = new Gson();
                Clientes cl = g.fromJson(resultado, Clientes.class);
                clientes.add(cl);
            }
        } finally {
            cursor.close();
        }
        mongoClient.close();
        return clientes;
    }


    public void insertarCoche(Coche coche) {
        MongoCollection<Document> collection = mongodb.getCollection("coches");
        Proveedor proveedor = new Proveedor();
        Agencia agencia = new Agencia();
        Document document = new Document("bastidor", coche.getbastidor()).append("marca", coche.getMarca()).append("modelo", coche.getModelo()).append("cv", coche.getCv()).append("imagen",
                coche.getImagen()).append("precio", coche.getPrecio()).append("Proveedor", new Document("id", proveedor.getid()).append("empresa", proveedor.getEmpresa())).append("Agencia", new Document("id_agencia", agencia.getId_agencia()).append("ciudad", agencia.getCiudad()));
        collection.insertOne(document);
    }

    //Metodo borrar coches Ivan
    public void borrarCoches(String valor) {
        connectDatabase();
        MongoCollection<Document> coleccion = mongodb.getCollection("coches");
        Document document = coleccion.find(Filters.eq("bastidor", valor)).first();
        coleccion.deleteOne(document);

        listarCoches();

        mongoClient.close();
    }

    public ArrayList<Opinion> listarOpiniones() {
        connectDatabase();
        ArrayList<Opinion> opiniones = new ArrayList<>();
        String resultado = null;
        MongoCollection<Document> collection = mongodb.getCollection("clientes");
        MongoCursor<Document> cursor = collection.find().iterator();
        while (cursor.hasNext()) {
            resultado = cursor.next().toJson();
            Gson g = new Gson();
            Opinion opinion = g.fromJson(resultado, Opinion.class);
            opiniones.add(opinion);
        }
        return opiniones;
    }

    public void insertarOpiniones(Opinion opinion) {
        connectDatabase();
        String dni = opinion.getDni();
        String nombre = opinion.getNombre();
        String apellido = opinion.getApellido();
        String telefono = opinion.getTelefono();
        String comentario = opinion.getComentario();

        Document doc = new Document("dni", dni)
                .append("nombre", nombre)
                .append("apellido", apellido)
                .append("telefono", telefono)
                .append("notas", comentario);
        MongoCollection<Document> coleccion = mongodb.getCollection("clientes");
    coleccion.insertOne(doc);
    }
}
