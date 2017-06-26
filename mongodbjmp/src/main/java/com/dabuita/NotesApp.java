package com.dabuita;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;

public class NotesApp {

    public static final String TEXT_EXPRESSION = "$text";
    public static final String SEARCH_EXPRESSION = "$search";
    public static final String TAG_FILED = "tag";
    public static final String NOTE_FIELD = "note";
    public static final String DATE_FIELD = "date";

    public static void main(String[] args) {
        if (args.length < 1) {
            return;
        }

        String local = "local";
        String nameOfCollection = "notes";
        String textIndex = "text";
        String deleteOperation = "delete";
        String findOperation = "find";
        String findByTextOperation = "findByText";
        String deleteByTextOperation = "deleteByText";
        String findAllOperation = "findAll";

        MongoClient client = new MongoClient();
        MongoDatabase db = client.getDatabase(local);
        MongoCollection<Document> notes = db.getCollection(nameOfCollection);
        notes.createIndex(new Document(TAG_FILED, textIndex));
        notes.createIndex(new Document(DATE_FIELD, textIndex));

        if (args.length == 1) {
            String arg = args[0];
            if (arg.equals(findOperation) || arg.equals(findAllOperation)) {
                print(findAllNotes(notes));
            }
        } else if (args.length == 2) {
            String operation = args[0];
            String valueToFind = args[1];
            if (operation.equals(findOperation)) {
                print(findByTag(notes, valueToFind));
            } else {
                if (operation.equals(findByTextOperation)) {
                    print(fullTextFind(notes, valueToFind));
                } else {
                    if (operation.equals(deleteByTextOperation)) {
                        System.out.println(deleteByText(notes, valueToFind));
                    }
                }
            }
        } else if (args.length == 3) {
            if (args[0].equals(deleteOperation)) {
                System.out.println(deleteNotesByField(notes, args));
            } else {
                System.out.println("Note --- " + createAndPersistNote(notes, args) + " --- was created.");
            }
        }
    }

    private static Document createAndPersistNote(final MongoCollection<Document> notes, final String[] fields) {
        String data = fields[0];
        String tag = fields[1];
        String noteText = fields[2];
        Document note = new Document(DATE_FIELD, data).append(TAG_FILED, tag).append(NOTE_FIELD, noteText);
        notes.insertOne(note);
        return note;
    }

    private static FindIterable<Document> findAllNotes(final MongoCollection<Document> notes) {
        return notes.find();
    }

    private static FindIterable<Document> findByTag(final MongoCollection<Document> notes, final String tagToFind) {
        return notes.find(new Document(TAG_FILED, tagToFind));
    }

    private static FindIterable<Document> fullTextFind(final MongoCollection<Document> notes, final String textToFind) {
        return notes.find(new Document(TEXT_EXPRESSION, new Document(SEARCH_EXPRESSION, textToFind)));
    }

    private static DeleteResult deleteByText(final MongoCollection<Document> notes, final String valueToFind) {
        return notes.deleteOne(new Document(TEXT_EXPRESSION, new Document(SEARCH_EXPRESSION, valueToFind)));
    }

    private static DeleteResult deleteNotesByField(final MongoCollection<Document> notes, final String[] args) {
        String fieldsToDelete = args[1];
        String valueToSearch = args[2];
        return notes.deleteOne(new Document(fieldsToDelete, valueToSearch));
    }

    private static void print(FindIterable<Document> docs) {
        docs.forEach((Block<? super Document>) System.out::println);
    }
}
