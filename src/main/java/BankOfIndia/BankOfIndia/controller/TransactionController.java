package BankOfIndia.BankOfIndia.controller;

import BankOfIndia.BankOfIndia.dto.AccountResponseDto;
import BankOfIndia.BankOfIndia.entity.BankEntity;
import BankOfIndia.BankOfIndia.exception.ResourceNotFoundException;
import BankOfIndia.BankOfIndia.service.TransactionServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boi")
public class TransactionController {

    private TransactionServiceImpl transactionService;

    TransactionController(TransactionServiceImpl transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/withdraw/{id}")
    public ResponseEntity<AccountResponseDto> withdraw(@PathVariable Long id, @RequestParam double amt)
            throws ResourceNotFoundException {
        BankEntity updateEntity = transactionService.withdraw(id, amt);
        return ResponseEntity.ok(AccountResponseDto.fromAcct(updateEntity));
    }

    @PostMapping("/deposit/{id}")
    public ResponseEntity<AccountResponseDto> deposit(@PathVariable Long id, @RequestParam double amt)
            throws ResourceNotFoundException {
        BankEntity updateEntity = transactionService.deposit(id, amt);
        return ResponseEntity.ok(AccountResponseDto.fromAcct(updateEntity));
    }


}
