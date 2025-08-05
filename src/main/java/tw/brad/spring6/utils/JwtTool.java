package tw.brad.spring6.utils;

import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JwtTool {
	private static final long EXP_TIME = 10 * 60 * 1000;
	private static final String SKEY = "BradChao1999DogCat12345677654321abcdefg";
	private static final Key KEY = Keys.hmacShaKeyFor(SKEY.getBytes()); 
	
	public static String createToken(String email) {
		return Jwts.builder()
				.setSubject(email)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXP_TIME))
				.signWith(KEY, SignatureAlgorithm.HS256)
				.compact();
	}
	public static String parseToken(String token) {
		Key sKey = Keys.hmacShaKeyFor(SKEY.getBytes());
		JwtParser parser = Jwts.parserBuilder().setSigningKey(sKey).build();
		
		Claims claims = parser.parseClaimsJws(token).getBody();
		return  claims.getSubject();
	}
}
