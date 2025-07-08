package src.services;

import java.util.List;

import src.interfaces.Shippable;

public class ShippingService {
  private List<Shippable> shippableBooks;

  ShippingService(List<Shippable> shippableBooks) {
    this.shippableBooks = shippableBooks;
  }
}
