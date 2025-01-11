package com.github.aranfern.application;

import com.github.aranfern.domain.Book;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping
  public List<Book> findAll() {
    return bookService.findAll();
  }

  @PostMapping
  public void save(@RequestBody Book book) {
    bookService.save(book);
  }
}
