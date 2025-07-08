package src.models;

import java.util.Date;

public class DemoBook extends Book {
  DemoBook(String ISBN, String title, Date publishDate, double price, String author, String publisher) {
    super(ISBN, title, publishDate, price, author, publisher);
  }
}
