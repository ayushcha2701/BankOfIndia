package BankOfIndia.BankOfIndia.service;

import BankOfIndia.BankOfIndia.entity.Auth.Session;
import BankOfIndia.BankOfIndia.entity.Auth.User;
import BankOfIndia.BankOfIndia.exception.UserAlreadyExistException;
import BankOfIndia.BankOfIndia.exception.UserNotFoundException;
import BankOfIndia.BankOfIndia.exception.WrongPasswordException;
import BankOfIndia.BankOfIndia.repository.authUser.AuthUserRepository;
import BankOfIndia.BankOfIndia.repository.authUser.SessionRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.*;

@Service
public class AuthServiceImpl implements AuthService {

    private AuthUserRepository authUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private SecretKey key = Jwts.SIG.HS256.key().build();
    private SessionRepository sessionRepository;

    AuthServiceImpl(AuthUserRepository authUserRepository,
                    BCryptPasswordEncoder bCryptPasswordEncoder,
                    SessionRepository sessionRepository) {
        this.authUserRepository = authUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.sessionRepository = sessionRepository;
    }
    @Override
    public boolean signUp(String email, String password) throws UserAlreadyExistException {

        if(authUserRepository.findByEmail(email).isPresent()) {
             throw new UserAlreadyExistException("User with this email: "+email+" already exist");
        }

        User user = new User();
        user.setEmail(email);
        user.setPassword(bCryptPasswordEncoder.encode(password));

        authUserRepository.save(user);
        return true;
    }

    @Override
    public String logIn(String email, String password) throws UserNotFoundException, WrongPasswordException {
        Optional<User> user = authUserRepository.findByEmail(email);

        if(user.isEmpty()){
            throw new UserNotFoundException("User with this email: "+email+" does not exist");
        }

        boolean matches = bCryptPasswordEncoder.
                matches(password,user.get().getPassword());

        if(matches){
            String token = createJwtToken(user.get().getId(), new ArrayList<>());
            Session session  = new Session();
            session.setToken(token);
            session.setUser(user.get());

            Calendar calendar = Calendar.getInstance();
            Date currentDate = calendar.getTime();

            calendar.add(Calendar.DAY_OF_MONTH, 30);
            Date datePlus30Days = calendar.getTime();
            session.setExpiringAt(datePlus30Days);

            sessionRepository.save(session);

            return token;

        } else{
                throw new WrongPasswordException("Wrong password");
        }
    }


    private String createJwtToken(Long userId, List<String> roles) {

        Map<String, Object> dataInJwt = new HashMap<>();
        dataInJwt.put("user_id", userId);
        dataInJwt.put("roles", roles);

        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();

        calendar.add(Calendar.DAY_OF_MONTH, 30);
        Date datePlus30Days = calendar.getTime();

        String token = Jwts.builder()
                .claims(dataInJwt)
                .expiration(datePlus30Days)
                .issuedAt(new Date())
                .signWith(key)
                .compact();

        return token;
    }

    public boolean validate(String token) {
        try {
            Jws<Claims> claims = Jwts.parser().
                    verifyWith(key).
                    build().
                    parseSignedClaims(token);
            Date expiryAt = claims.getPayload().getExpiration();
            Long userId = claims.getPayload().get("user_id", Long.class);
        } catch(Exception e ){
            return false;
        }
        return true;
    }
}
