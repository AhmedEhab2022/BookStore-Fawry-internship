package src.models;

import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
  private static Map<String, InventoryBook> books;

  Inventory() {
    books = new HashMap<>();
  }

  public void add(InventoryBook book) {
    if (books.containsKey(book.getISBN())) {
      InventoryBook InvBook = books.get(book.getISBN());
      InvBook.setQuantity(InvBook.getQuantity() + 1);
      books.replace(book.getISBN(), InvBook);
    } else {
      books.put(book.getISBN(), book);
    }
  }

  public void removeOutdated(long numOfYears) {
    for (Map.Entry<String, InventoryBook> entry : books.entrySet()) {
      Date oldDate = entry.getValue().getPublishDate();
      LocalDate localDate = oldDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
      long pubYear = localDate.getYear();
      long currentYear = LocalDate.now().getYear(); 
      if (currentYear - pubYear <= 0) {
        books.remove(entry.getKey());
      }
    }
  }

  public static InventoryBook getBook(String ISBN) {
    return books.get(ISBN);
  }

  public static boolean isAvailable(String ISBN) {
    if (!books.containsKey(ISBN))
      return false;

    return books.get(ISBN).isSaleable();
  }

  public static void reduceQuantity(String ISBN, long quantity) {
    InventoryBook book = books.get(ISBN);
    if (book.getQuantity() < quantity) {
      throw new IllegalStateException("Not enough stock for book: " + book.getTitle());
    } else if (book.getQuantity() == quantity) {
      books.remove(book.getISBN());
    }
    book.setQuantity(book.getQuantity() - quantity);
    books.replace(book.getISBN(), book);
  }
}
