package com.github.aranfern.domain;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
  private UUID id;
  private String name;
}
