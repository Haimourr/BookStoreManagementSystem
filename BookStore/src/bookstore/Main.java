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
public class Main {
  public static void main(String[] args) {
        BookStore book= BookStore.getInstance();
        GuiManagement gui = new GuiManagement();
        book.addObserver(gui);

        
    }
}
