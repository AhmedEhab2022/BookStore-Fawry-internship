package src.services;

import src.models.Inventory;
import src.models.InventoryBook;

public class BuyingService {

  public static double buy(String ISBN, long quantity, String email, String address) {
    ShippingService shippingService;
    MailService mailService;
    InventoryBook book;

    // reduce the quantity of the book in the inventory
    if (!Inventory.isAvailable(ISBN)) {
      throw new IllegalArgumentException("The Book is not Available Or it is not for sale");
    }
    book = Inventory.getBook(ISBN);
    try {
      Inventory.reduceQuantity(ISBN, quantity);
    } catch (IllegalStateException e) {
      System.out.println(e.getMessage());
    }


    // send to shipping and mail services

    return book.getPrice();
  }
}
