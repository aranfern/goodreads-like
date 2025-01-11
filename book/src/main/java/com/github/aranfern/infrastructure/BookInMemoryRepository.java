package com.github.aranfern.infrastructure;

import com.github.aranfern.domain.Book;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public class BookInMemoryRepository implements BookRepository {
  private final HashMap<UUID, Book> books = new HashMap<>();

  @Override
  public List<Book> findAll() {
    return books.values().stream().toList();
  }

  @Override
  public void save(Book book) {
    books.put(book.getId(), book);
  }
}
