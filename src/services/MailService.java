package src.services;

import java.util.List;

import src.interfaces.Sendable;

public class MailService {
  List<Sendable> sendableBooks;

  MailService(List<Sendable> sendableBooks) {
    this.sendableBooks = sendableBooks;
  }
}
