/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

/**
 *
 * @author ammar
 */
public class BookFactory {
    
    
      public static Book createBook(String title, String author, double price, int quantity,boolean isFiction) {
        
          if(isFiction){
              
              return new FictionBook(title, author, price, quantity);
          }
          else {
              return new NonFictionBook(title, author, price, quantity);
          }
    }
    
}
