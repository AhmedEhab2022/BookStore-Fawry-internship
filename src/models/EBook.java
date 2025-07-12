package src.models;

import java.util.Date;

import src.interfaces.Buyable;
import src.interfaces.Sendable;
import src.services.BuyingService;

public class EBook extends Book implements Sendable, Buyable {
  private String fileType;

  EBook(String ISBN, String title, Date publishDate, double price, String author, String publisher, String fileType) {
    super(ISBN, title, publishDate, price, author, publisher);
    this.fileType = fileType;
  }

  @Override
  public String getFileType() {
    return fileType;
  }

  public void setFileType(String fileType) {
    this.fileType = fileType;
  }

  @Override
  public double buy(String email, String address) {
    BuyingService.addSendableBook(this);
    return BuyingService.buy(getISBN(), 1, email, address);
  }

}
