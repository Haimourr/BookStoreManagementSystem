/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ammar
 */
public class FileManager {
    
     private static FileManager instance;
    private static final String FILE_PATH = "bookstore_data.txt";

    private FileManager() {
        // Private constructor to prevent instantiation
    }

    public static FileManager getInstance() {
        if (instance == null) {
            instance = new FileManager();
        }
        return instance;
    }

    public List<Book> readBooksFromFile() {
        List<Book> books = new ArrayList<>();

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            Object obj = inputStream.readObject();
            if (obj instanceof List) {
                books = (List<Book>) obj;
            }
        } catch (IOException | ClassNotFoundException e) {
            // Handle exceptions
        }

        return books;
    }

    public void writeBooksToFile(List<Book> books) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            outputStream.writeObject(books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
