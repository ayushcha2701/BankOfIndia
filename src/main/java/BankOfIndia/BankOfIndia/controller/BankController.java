package BankOfIndia.BankOfIndia.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import BankOfIndia.BankOfIndia.dto.CreateAccountDto;
import BankOfIndia.BankOfIndia.service.BankServiceImpl;

@RestController
public class BankController {

    private BankServiceImpl bankServiceImpl;

    BankController(BankServiceImpl bankServiceImpl) {
        this.bankServiceImpl = bankServiceImpl;
    }

    @PostMapping("/createAccount")
    public void createAccount(@RequestBody CreateAccountDto createAccountDto) {

    }

    @GetMapping("/getAccount")
    public void getAllAccount() {
    }

    @GetMapping("/getAccount/{id}")
    public void getAccountById(@PathVariable Long id) {
    }

    @PutMapping("/updateAccount/{id}")
    public void updateAccount(@PathVariable Long id) {
    }

    @DeleteMapping("/deleteAccount/{id}")
    public void deleteAccount(@PathVariable Long id) {
    }

}
