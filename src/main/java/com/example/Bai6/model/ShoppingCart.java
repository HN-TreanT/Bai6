package com.example.Bai6.model;

import com.example.Bai6.Book.Book;
import com.example.Bai6.Book.BookDAO;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private ArrayList itemsOrdered;


    public ShoppingCart() {
        itemsOrdered = new ArrayList();
    }

    public List getItemsOrdered() {
        return(itemsOrdered);
    }


    public synchronized void addItem(String itemID) {
        ItemOrder order;
        for(int i=0; i<itemsOrdered.size(); i++) {
            order = (ItemOrder)itemsOrdered.get(i);
            if (order.getItemId().equals(itemID)) {
                order.incrementNumItems();
                return;
            }
        }
//        ItemOrder newOrder = new ItemOrder(BookDAO.getBookByID(itemID));
        Book book = BookDAO.getBookByID(itemID);
        ItemOrder newOrder = new ItemOrder(book);
        itemsOrdered.add(newOrder);
    }

    public synchronized void setNumOrdered(String itemID,
                                           int numOrdered) {
        ItemOrder order;
        for(int i=0; i<itemsOrdered.size(); i++) {
            order = (ItemOrder)itemsOrdered.get(i);
            if (order.getItemId().equals(itemID)) {
                if (numOrdered <= 0) {
                    itemsOrdered.remove(i);
                } else {
                    order.setNumberBook(numOrdered);
                }
                return;
            }
        }
        ItemOrder newOrder =
                new ItemOrder(BookDAO.getBookByID(itemID));
        itemsOrdered.add(newOrder);
    }
}
