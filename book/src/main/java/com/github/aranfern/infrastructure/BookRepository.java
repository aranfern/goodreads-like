package com.github.aranfern.infrastructure;

import com.github.aranfern.domain.Book;
import java.util.List;

public interface BookRepository {
  List<Book> findAll();
}
