package BankOfIndia.BankOfIndia.repository;

import BankOfIndia.BankOfIndia.entity.BankEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository <BankEntity, Long>{
}
