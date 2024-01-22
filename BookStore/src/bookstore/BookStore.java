/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ammar
 */
public class BookStore {
   private List<Book> catalog;
    private List<BookObserver> observers;

    private static BookStore instance;

    private BookStore() {
        catalog = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static BookStore getInstance() {
        if (instance == null) {
            instance = new BookStore();
        }
        return instance;
    }

    public void addObserver(BookObserver observer) {
        observers.add(observer);
    }

    public void addBook(Book book) {
        catalog.add(book);
        notifyObservers("");
    }

    public List<Book> getCatalog() {
        return catalog;
    }

   public void updateInventory(String title, String author, int newQuantity, double newPrice) {

    for (Iterator<Book> iterator = catalog.iterator(); iterator.hasNext();) {
        Book book = iterator.next();
        if (book.getTitle().equals(title)) {
            
            iterator.remove();
            break;  
        }
    }

    // Add the new book with the updated quantity and price
    Book newBook = new Book(title, author, newPrice, newQuantity);
    catalog.add(newBook);

    notifyObservers("Catalog Updated ");
}


    public void deleteBook(String title) {
        catalog.removeIf(book -> book.getTitle().equals(title));
        notifyObservers("");
    }
    
    
    

    private void notifyObservers(String string) {
        for (BookObserver observer : observers) {
            observer.update();
        }
    }
}
