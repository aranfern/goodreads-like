package com.github.aranfern.application;

import com.github.aranfern.domain.InvalidJwtException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class JwtService {
  @Value("${security.jwt.secret-key}")
  private String secretKey;

  public boolean isTokenValid(String jwt) {
    try {
      return Jwts.parserBuilder()
          .setSigningKey(getSignInKey())
          .build()
          .parseClaimsJws(jwt)
          .getBody()
          .getExpiration()
          .after(new Date());
    } catch (Exception e) {
      log.info("Invalid JWT: ", e);
      throw new InvalidJwtException();
    }
  }

  private Key getSignInKey() {
    byte[] keyBytes = Decoders.BASE64.decode(secretKey);
    return Keys.hmacShaKeyFor(keyBytes);
  }
}
