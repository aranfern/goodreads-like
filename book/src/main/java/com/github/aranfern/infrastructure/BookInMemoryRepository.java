package com.github.aranfern.infrastructure;

import com.github.aranfern.domain.Book;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public class BookInMemoryRepository implements BookRepository {
  @Override
  public List<Book> findAll() {
    return List.of(
        new Book(UUID.randomUUID(), "Book A"),
        new Book(UUID.randomUUID(), "Book B"),
        new Book(UUID.randomUUID(), "Book C"));
  }
}
