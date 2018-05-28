
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.Iterator;
import org.bson.Document;

import com.mongodb.BulkWriteOperation;
import com.mongodb.BulkWriteResult;
import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ParallelScanOptions;
import com.mongodb.ServerAddress;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PERSONAL
 */
public class Conexion {

    public Conexion() {

    }

    public static void main(String[] args) {
        MongoClient mongo = new MongoClient("LocalHost", 27017);

        // Accessing the database 
        MongoDatabase database = mongo.getDatabase("basedatos");

        MongoCollection<Document> collection;
        collection = database.getCollection("tabla");
        
        Cursor  cursor =  (Cursor) collection.find();
        
        while (cursor.hasNext()){
            System.out.println(cursor.next());
        }
            
        
    }
}
