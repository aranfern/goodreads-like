package com.github.aranfern.infrastructure;

import com.github.aranfern.domain.Book;
import com.github.aranfern.domain.BookNotFoundException;
import com.github.aranfern.domain.BookRepository;
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

  @Override
  public Book getById(UUID id) {
    if (!books.containsKey(id)) {
      throw new BookNotFoundException();
    }

    return books.get(id);
  }
}
