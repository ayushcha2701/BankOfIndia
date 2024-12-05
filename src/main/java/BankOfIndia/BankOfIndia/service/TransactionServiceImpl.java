package BankOfIndia.BankOfIndia.service;

import BankOfIndia.BankOfIndia.entity.BankEntity;
import BankOfIndia.BankOfIndia.exception.ResourceNotFoundException;
import BankOfIndia.BankOfIndia.repository.BankRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TransactionServiceImpl implements TransactionService{

    private BankRepository bankRepository;

    public TransactionServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }
    @Override
    public BankEntity withdraw( Long Id, double amt) throws ResourceNotFoundException {

        BankEntity bankEntity = bankRepository.findById(Id).orElseThrow(()-> new ResourceNotFoundException("Account not found with ID: " + Id));
        bankEntity.setBalance(bankEntity.getBalance() - amt);
        if(bankEntity.getAmtWithdraw() == null){
            bankEntity.setAmtWithdraw(new ArrayList<>());
        }

        bankEntity.getAmtWithdraw().add(amt);
        return bankRepository.save(bankEntity);

    }

    @Override
    public BankEntity deposit( Long Id, double amt) throws ResourceNotFoundException {

        BankEntity bankEntity = bankRepository.findById(Id).
                orElseThrow(()-> new ResourceNotFoundException("Account not found with ID: " + Id));
        bankEntity.setBalance(bankEntity.getBalance() + amt);

        if(bankEntity.getAmtDeposit() == null){
            bankEntity.setAmtDeposit(new ArrayList<>());
        }
        bankEntity.getAmtDeposit().add(amt);
        return bankRepository.save(bankEntity);

    }
}
