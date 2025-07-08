package src.models;

import java.util.Date;

public class InventoryBook {
  private String ISBN;
  private String title;
  private Date publishDate;
  private double price;
  private long quantity;
  private boolean saleable;

  InventoryBook(String ISBN, String title, Date publishDate, double price, boolean saleable) {
    this.ISBN = ISBN;
    this.title = title;
    this.publishDate = publishDate;
    this.price = price;
    this.quantity = 1;
    this.saleable = saleable;
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

  public long getQuantity() {
    return quantity;
  }

  public void setQuantity(long quantity) {
    this.quantity = quantity;
  }

  public boolean isSaleable() {
    return saleable;
  }
}
