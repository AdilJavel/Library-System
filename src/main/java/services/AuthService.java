package services;

import libs.AccessToken;
import libs.LoginLib;
import entities.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import repositories.interfaces.IUserRepository;
import services.interfaces.IAuthService;

import javax.inject.Inject;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Random;

public class AuthService implements IAuthService {

    @Inject
    private IUserRepository repository;

    @Override
    public AccessToken authenticateUser(LoginLib data) throws Exception {
        User user = signInUser(data);
        String token = issueToken(user);
        return new AccessToken(token);
    }

    private User signInUser(LoginLib data) throws Exception {
        User user = repository.getUserByLogin(data.getUsername(), data.getPassword());
        if (user == null) {
            throw new Exception("Authentication failed!");
        }
        return user;
    }

    private String issueToken(User user) { // ??????
        Instant now = Instant.now();
        String secretWord = "TheStrongestSecretKeyICanThinkOf";
        return Jwts.builder()
                .setIssuer(user.getUsername())
                .setIssuedAt(Date.from(now))
                .claim("1d20", new Random().nextInt(20) + 1)
                .setExpiration(Date.from(now.plus(10, ChronoUnit.MINUTES)))
                .signWith(Keys.hmacShaKeyFor(secretWord.getBytes()))
                .compact();
    }

    @Override
    public User getUserByUsername(String issuer) {
        return repository.getUserByUsername(issuer);
    }
}