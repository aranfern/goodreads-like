package com.github.aranfern.domain;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class InvalidJwtException extends RuntimeException {
  public InvalidJwtException() {
    super("Invalid JWT.");
  }
}
