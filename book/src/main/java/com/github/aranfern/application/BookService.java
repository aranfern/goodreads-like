package com.github.aranfern.application;

import com.github.aranfern.domain.Book;
import com.github.aranfern.infrastructure.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
  private final BookRepository bookRepository;

  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public List<Book> findAll() {
    return bookRepository.findAll();
  }
}
