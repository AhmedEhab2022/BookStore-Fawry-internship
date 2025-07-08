package src.interfaces;

import src.models.Book;

public interface Buyable {
  double buy(String email, String address);
}
