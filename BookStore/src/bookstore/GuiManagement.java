/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author ammar
 */
public class GuiManagement implements BookObserver{
    
    private JFrame frame;
    private JTextArea catalogTextArea;

    public GuiManagement() {
        frame = new JFrame("Bookstore Management System");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        catalogTextArea = new JTextArea();
        catalogTextArea.setEditable(false);

        JButton addButton = new JButton("Add Book");
        JButton viewButton = new JButton("View Catalog");
        JButton updateButton = new JButton("Update Inventory");
        JButton deleteButton = new JButton("Delete Book");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
          String title = JOptionPane.showInputDialog(frame, "Enter book title:");
        String author = JOptionPane.showInputDialog(frame, "Enter author:");
        String quantityStr = JOptionPane.showInputDialog(frame, "Enter quantity:");
        String priceStr = JOptionPane.showInputDialog(frame, "Enter price:");

        try {
            int quantity = Integer.parseInt(quantityStr);
            double price = Double.parseDouble(priceStr);

            Book book = new Book(title,author,price,quantity) {};
            BookStore.getInstance().addBook(book);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input format. Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
        }
            }
        });

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                       List<Book> catalog = BookStore.getInstance().getCatalog();
        StringBuilder catalogText = new StringBuilder("Book Catalog:\n");

        for (Book book : catalog) {
            catalogText.append(book.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(frame, catalogText.toString(), "Book Catalog", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  String title = JOptionPane.showInputDialog(frame, "Enter book title to update:");
        String quantityStr = JOptionPane.showInputDialog(frame, "Enter new quantity:");
        String author = JOptionPane.showInputDialog(frame, "Enter new author:");
        String Price= JOptionPane.showInputDialog(frame, "Enter new price:");

        try {
            int newQuantity = Integer.parseInt(quantityStr);
            double newPrice = Double.parseDouble(Price);
            BookStore.getInstance().updateInventory(title,author, newQuantity,newPrice);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid quantity format. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String title = JOptionPane.showInputDialog(frame, "Enter book title to delete:");
        System.out.println("Deleting book with title: " + title);
        BookStore.getInstance().deleteBook(title);
    }
});
        
        


        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        frame.setLayout(new BorderLayout());
        frame.add(catalogTextArea, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    @Override
    public void update() {
      
        StringBuilder catalogText = new StringBuilder();
        for (Book book : BookStore.getInstance().getCatalog()) {
            catalogText.append(book.toString()).append("\n");
        }
        catalogTextArea.setText(catalogText.toString());
    }
     
}
