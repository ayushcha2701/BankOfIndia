package BankOfIndia.BankOfIndia.repository.Auth;

import BankOfIndia.BankOfIndia.entity.Auth.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthUserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
