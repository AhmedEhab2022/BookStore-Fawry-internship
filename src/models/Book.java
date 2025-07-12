package src.models;

import java.util.Date;

public abstract class Book {
  private String ISBN;
  private String title;
  private Date publishDate;
  private double price;
  private String author;
  private String publisher;

  Book(String ISBN, String title, Date publishDate, double price, String author, String publisher) {
    this.ISBN = ISBN;
    this.title = title;
    this.publishDate = publishDate;
    this.price = price;
    this.author = author;
    this.publisher = publisher;
  }

  public String getISBN() {
    return ISBN;
  }

  public String getTitle() {
    return title;
  }

  public Date getPublishDate() {
    return publishDate;
  }

  public double getPrice() {
    return price;
  }

  public String getAuthor() {
    return author;
  }

  public String getPublisher() {
    return publisher;
  }
}
