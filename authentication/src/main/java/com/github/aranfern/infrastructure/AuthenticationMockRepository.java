package com.github.aranfern.infrastructure;

import com.github.aranfern.domain.LoginRequest;
import com.github.aranfern.domain.LoginResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class AuthenticationMockRepository implements AuthenticationRepository {
  @Value("${security.jwt.secret-key}")
  private String secretKey;

  @Override
  public LoginResponse login(LoginRequest loginRequest) {
    return new LoginResponse(buildToken(loginRequest.getUsername()), "Bearer");
  }

  private String buildToken(String username) {
    Map<String, Object> claims = new HashMap<>();

    return Jwts.builder()
        .setClaims(claims)
        .setSubject(username)
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour
        .signWith(getSignInKey(), SignatureAlgorithm.HS256)
        .compact();
  }

  private Key getSignInKey() {
    byte[] keyBytes = Decoders.BASE64.decode(secretKey);
    return Keys.hmacShaKeyFor(keyBytes);
  }
}
