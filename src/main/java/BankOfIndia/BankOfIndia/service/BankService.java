package BankOfIndia.BankOfIndia.service;

import BankOfIndia.BankOfIndia.entity.BankEntity;
import BankOfIndia.BankOfIndia.exception.ResourceNotFoundException;
import BankOfIndia.BankOfIndia.repository.BankRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService implements BankServiceImpl {

    private BankRepository bankRepository;

    BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }
    @Override
    public BankEntity createAccount(BankEntity bankEntity) {

        return bankRepository.save(bankEntity);
    }

    @Override
    public List<BankEntity> getAllAccounts() {

        return bankRepository.findAll();
    }

    @Override
    public BankEntity getAccountById(Long id) throws UsernameNotFoundException {

        return bankRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Account not found with ID: " + id));
    }

    @Override
    public BankEntity updateAccount(BankEntity bankEntity, Long id) throws ResourceNotFoundException {
        BankEntity existingBankEntity = bankRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with ID: " + id));

        existingBankEntity.setFirstName(bankEntity.getFirstName());
        existingBankEntity.setLastName(bankEntity.getLastName());
        existingBankEntity.setDateOfBirth(bankEntity.getDateOfBirth());
        existingBankEntity.setTypeOfAccount(bankEntity.getTypeOfAccount());
        existingBankEntity.setAddress(bankEntity.getAddress());
        existingBankEntity.setCity(bankEntity.getCity());
        existingBankEntity.setState(bankEntity.getState());
        existingBankEntity.setCountry(bankEntity.getCountry());
        existingBankEntity.setPincode(bankEntity.getPincode());
        existingBankEntity.setPhoneNumber(bankEntity.getPhoneNumber());
        existingBankEntity.setBalance(bankEntity.getBalance());

        return bankRepository.save(existingBankEntity);
    }

    @Override
    public void deleteAccount(Long id) throws ResourceNotFoundException {
        BankEntity existingBankEntity = bankRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with ID: " + id));

        bankRepository.delete(existingBankEntity);
    }
}
