package com.github.aranfern.application;

import com.github.aranfern.domain.Book;
import com.github.aranfern.infrastructure.BookRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BookService {
  private final BookRepository bookRepository;

  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public List<Book> findAll() {
    return bookRepository.findAll();
  }

  public void save(Book book) {
    bookRepository.save(book);
  }
}
