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
public class NonFictionBook extends Book {
    
     private String category;


    
    public NonFictionBook(String title, String author, double price, int quantity) {
        super(title, author, price, quantity);
    }

    
    
        public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

   
    
}
