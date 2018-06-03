/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MongoConection;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author PERSONAL
 */
public class MongoCon {

    public void createCollection(String nombre) {
        // Creating a Mongo client
        MongoClient mongo = new MongoClient("localhost", 27017);
        System.out.println("Connected to the database successfully");
        //Accessing the database
        MongoDatabase database = mongo.getDatabase("TURISMO");
        //Creating a collection
        database.createCollection(nombre);
        System.out.println("Collection " + nombre + " created successfully");

        mongo.close();
    }

    public void insertDocument(Document document, String coll) {
        // Creating a Mongo client
        MongoClient mongo = new MongoClient("localhost", 27017);
        // Creating Credentials
        System.out.println("Connected to the database successfully");
        // Accessing the database
        MongoDatabase database = mongo.getDatabase("TURISMO");
        // Retrieving a collection
        MongoCollection<Document> collection = database.getCollection(coll);
        System.out.println("Collection" + coll + " selected successfully");
        collection.insertOne(document);
        System.out.println("Document inserted successfully");
        mongo.close();
    }

    /**
     *
     * @param coll
     */
    public List<Document> getAllDocuments(String coll) {
        // Creating a Mongo client
        MongoClient mongo = new MongoClient("localhost", 27017);
        // Creating Credentials
        System.out.println("Connected to the database successfully");
        // Accessing the database
        MongoDatabase database = mongo.getDatabase("TURISMO");
        // Retrieving a collection
        MongoCollection<Document> collection = database.getCollection(coll);
        // Getting the iterable object
        FindIterable<Document> iterDoc = collection.find();

        List<Document> documentos = (List<Document>) collection.find().into(
                new ArrayList<Document>());
        mongo.close();
        return documentos;
    }

    /**
     * Prints all documents from a collection, please use filter to return
     * specific document
     *
     * @param coll
     * @param filter
     */
    public Document getAllDocuments(String coll, Document filter) {
        // Creating a Mongo client
        MongoClient mongo = new MongoClient("localhost", 27017);
        // Creating Credentials
        System.out.println("Connected to the database successfully");
        // Accessing the database
        MongoDatabase database = mongo.getDatabase("TURISMO");
        // Retrieving a collection
        MongoCollection<Document> collection = database.getCollection(coll);
        // Getting the iterable object
        FindIterable<Document> iterDoc = collection.find(filter);
        int i = 1;
        // Getting the iterator
        Iterator it = iterDoc.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            i++;
        }
        mongo.close();
        return iterDoc.first();
    }

    /**
     * Update doc by clients name
     *
     * @param coll: collection
     * @param nombre
     * @param key:
     * @param valor
     */
    public void updateDocument(String coll, String nombre, String key, String valor) {
        // Creating a Mongo client
        MongoClient mongo = new MongoClient("localhost", 27017);
        // Creating Credentials
        System.out.println("Connected to the database successfully");
        // Accessing the database
        MongoDatabase database = mongo.getDatabase("TURISMO");
        // Retrieving a collection
        MongoCollection<Document> collection = database.getCollection(coll);

        collection.updateOne(Filters.eq("nombre", nombre), Updates.set(key, valor));
        System.out.println("Document update successfully...");
        //Close conection
        mongo.close();
    }

    /**
     * Deletes doc from clientes
     *
     * @param nombre
     */
    public void deleteDocument(String nombre) {
        // Creating a Mongo client
        MongoClient mongo = new MongoClient("localhost", 27017);
        // Creating Credentials
        System.out.println("Connected to the database successfully");
        // Accessing the database
        MongoDatabase database = mongo.getDatabase("TURISMO");
        // Retrieving a collection
        MongoCollection<Document> collection = database.getCollection("clientes");
        collection.deleteOne(Filters.eq("nombre", nombre));
        System.out.println("Document update successfully...");
        //Close conection
        mongo.close();
    }

}
