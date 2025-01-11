package com.github.aranfern.application;

import com.github.aranfern.domain.Book;
import java.util.List;
import java.util.UUID;
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

  @GetMapping("/{id}")
  public Book getById(@PathVariable(name = "id") UUID id) {
    return bookService.getById(id);
  }

  @PostMapping
  public void save(@RequestBody Book book) {
    bookService.save(book);
  }
}
