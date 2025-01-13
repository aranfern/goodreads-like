package com.github.aranfern.infrastructure;

import com.github.aranfern.application.JwtService;
import com.github.aranfern.domain.InvalidJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
  private final JwtService jwtService;

  public JwtAuthenticationFilter(JwtService jwtService) {
    this.jwtService = jwtService;
  }

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    try {
      String token = getJwt(request);

      if (!jwtService.isTokenValid(token)) {
        markResponseAsUnauthorized(response);
        return;
      }

      authenticate(request);

      filterChain.doFilter(request, response);
    } catch (RuntimeException e) {
      markResponseAsUnauthorized(response);
    }
  }

  private String getJwt(HttpServletRequest request) {
    String authHeader = request.getHeader("Authorization");

    if (authHeader == null || authHeader.isBlank() || !authHeader.startsWith("Bearer ")) {
      throw new InvalidJwtException();
    }

    return authHeader.substring(7);
  }

  private void markResponseAsUnauthorized(HttpServletResponse response) {
    response.setStatus(HttpStatus.UNAUTHORIZED.value());
  }

  private void authenticate(HttpServletRequest request) {
    UsernamePasswordAuthenticationToken authToken =
        new UsernamePasswordAuthenticationToken(null, null, Collections.emptyList());
    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
    SecurityContextHolder.getContext().setAuthentication(authToken);
  }
}
