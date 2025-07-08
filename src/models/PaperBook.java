package src.models;

import java.util.Date;

import src.interfaces.Buyable;
import src.interfaces.Shippable;
import src.services.BuyingService;

public class PaperBook extends Book implements Shippable, Buyable {
  private long stockQuantity;
  private String stockName, stockAddress;
  private double weight;

  PaperBook(String ISBN, String title, Date publishDate, double price, String author, String publisher, long stockQuantity, String stockName, String stockAddress, double weight) {
    super(ISBN, title, publishDate, price, author, publisher);
    this.stockQuantity = stockQuantity;
    this.stockName = stockName;
    this.stockAddress = stockAddress;
    this.weight = weight;
  }

  @Override
  public double getWeight() {
    return weight;
  }

  @Override
  public double buy(String email, String address) {
    return BuyingService.buy(address, stockQuantity, email, address);
  }

  public String getStockName() {
    return stockName;
  }

  public String getStockAddress() {
    return stockAddress;
  }

  public long getStockQuantity() {
    return stockQuantity;
  }

  public void setStockAddress(String stockAddress) {
    this.stockAddress = stockAddress;
  }

  public void setStockName(String stockName) {
    this.stockName = stockName;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public void setStockQuantity(long stockQuantity) {
    this.stockQuantity = stockQuantity;
  }
}
