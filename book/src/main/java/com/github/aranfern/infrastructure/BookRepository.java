package com.github.aranfern.infrastructure;

import com.github.aranfern.domain.Book;
import java.util.List;
import java.util.UUID;

public interface BookRepository {
  List<Book> findAll();

  void save(Book book);

  Book getById(UUID id);
}
