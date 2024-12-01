package BankOfIndia.BankOfIndia.service;

import BankOfIndia.BankOfIndia.entity.BankEntity;
import BankOfIndia.BankOfIndia.exception.ResourceNotFoundException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.*;

public interface BankServiceImpl {

    public BankEntity createAccount(BankEntity bankEntity);

    public List<BankEntity> getAllAccounts();

    public BankEntity getAccountById(Long id) throws UsernameNotFoundException;

    public BankEntity updateAccount(BankEntity bankEntity, Long Id) throws ResourceNotFoundException;

    public void deleteAccount(Long id) throws ResourceNotFoundException;


}
