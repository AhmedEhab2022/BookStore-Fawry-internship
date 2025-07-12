package src.services;

import java.util.ArrayList;
import java.util.List;

import src.interfaces.Sendable;
import src.interfaces.Shippable;
import src.models.Inventory;
import src.models.InventoryBook;

public class BuyingService {
  private static List<Shippable> shippableBooks = new ArrayList<>();
  private static List<Sendable> sendableBooks = new ArrayList<>();

  public static void addShippableBook(Shippable book) {
    if (book == null) {
      throw new IllegalArgumentException("Book cannot be null");
    }
    shippableBooks.add(book);
  }

  public static void addSendableBook(Sendable book) {
    if (book == null) {
      throw new IllegalArgumentException("Book cannot be null");
    }
    sendableBooks.add(book);
  }

  public static double buy(String ISBN, long quantity, String email, String address) {
    ShippingService shippingService;
    MailService mailService;
    InventoryBook book;

    // reduce the quantity of the book in the inventory
    if (!Inventory.isAvailable(ISBN)) {
      throw new IllegalArgumentException("The Book is not Available Or it is not for sale");
    }
    book = Inventory.getBook(ISBN);
    Inventory.reduceQuantity(ISBN, quantity);


    // send to shipping and mail services
    if (!shippableBooks.isEmpty())
      shippingService = new ShippingService(shippableBooks);

    if (!sendableBooks.isEmpty())
      mailService = new MailService(sendableBooks);

    return book.getPrice();
  }
}
