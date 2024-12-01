package BankOfIndia.BankOfIndia.repository.authUser;

import BankOfIndia.BankOfIndia.entity.Auth.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
