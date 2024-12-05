package BankOfIndia.BankOfIndia.service;

import BankOfIndia.BankOfIndia.entity.BankEntity;
import BankOfIndia.BankOfIndia.exception.ResourceNotFoundException;

public interface TransactionService {

    public BankEntity withdraw( Long Id, double amt) throws ResourceNotFoundException;
    public BankEntity deposit( Long Id, double amt) throws ResourceNotFoundException;
}
