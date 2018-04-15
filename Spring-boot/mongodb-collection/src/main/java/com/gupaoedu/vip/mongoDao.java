package com.gupaoedu.vip;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;


public class mongoDao {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient("localhost",27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = mongoDatabase.getCollection("gupaoedu");
        Document doc = new Document("name","mongodb").append("type", "database")
                .append("count", 1)
                .append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
                .append("info", new Document("x", 203).append("y", 102));
//        collection.insertOne(doc);
        List<Document> documents = new ArrayList<Document>();
        for(int i=0 ; i<100 ;i++){
            documents.add(new Document("i"+i,i));
        }
//        collection.insertMany(documents);
        Document myDoc = collection.find().first();
        System.out.println(myDoc.toJson());
        MongoCursor<Document> mongoCursor = collection.find().iterator();
//        while(mongoCursor.hasNext()){
//            System.out.println(mongoCursor.next().toJson());
//        }
        myDoc = collection.find(eq("i1",1)).first();
        System.out.println(myDoc.toJson());
        for(int i=0 ; i<100 ;i++) {
            collection.deleteOne(eq("i"+i,i));
        }
    }
}
