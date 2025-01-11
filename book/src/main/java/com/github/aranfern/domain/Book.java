package com.github.aranfern.domain;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
  private UUID id;
  private String name;
  private String author;
  private String description;
  private Integer year;
  private String isbn;
  private Double averageRating;
  private String cover;
  private String language;
}
