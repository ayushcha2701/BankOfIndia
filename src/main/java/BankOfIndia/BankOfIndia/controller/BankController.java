package BankOfIndia.BankOfIndia.controller;

import BankOfIndia.BankOfIndia.dto.AccountRequestDto;
import BankOfIndia.BankOfIndia.dto.GetAccountResponseDto;
import BankOfIndia.BankOfIndia.dto.GetAllAccountResponseDto;
import BankOfIndia.BankOfIndia.entity.BankEntity;
import BankOfIndia.BankOfIndia.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import BankOfIndia.BankOfIndia.dto.AccountResponseDto;
import BankOfIndia.BankOfIndia.service.BankServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BankController {

    private BankServiceImpl bankServiceImpl;

    BankController(BankServiceImpl bankServiceImpl) {
        this.bankServiceImpl = bankServiceImpl;
    }

    @PostMapping("/createAccount")
    public ResponseEntity<AccountResponseDto>createAccount
            (@RequestBody AccountRequestDto createAccountRequestDto) {

        AccountResponseDto response = new AccountResponseDto();
        BankEntity bankEntity = createAccountRequestDto.createAcctReq();
        BankEntity saveBankEntity = bankServiceImpl.createAccount(bankEntity);
        return ResponseEntity.ok(response.fromAcct(saveBankEntity));

    }

    @GetMapping("/getAccount")
    public ResponseEntity<GetAllAccountResponseDto> getAllAccount() {

        List<BankEntity> bankEntityList = bankServiceImpl.getAllAccounts();
        List<GetAccountResponseDto> accountDtos = bankEntityList.stream()
                .map(GetAccountResponseDto::fromAcct)
                .collect(Collectors.toList());

        GetAllAccountResponseDto responseDto = new GetAllAccountResponseDto();
        responseDto.setAccounts(accountDtos);

        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/getAccount/{id}")
    public ResponseEntity<GetAccountResponseDto> getAccountById(@PathVariable Long id) {

        BankEntity bankEntity = bankServiceImpl.getAccountById(id);
        GetAccountResponseDto responseDto = GetAccountResponseDto.fromAcct(bankEntity);

        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/updateAccount/{id}")
    public ResponseEntity<GetAccountResponseDto> updateAccount(@PathVariable Long id, @RequestBody GetAccountResponseDto accountDto) {
        try {

            BankEntity bankEntity = new BankEntity();
            bankEntity.setFirstName(accountDto.getFirstName());
            bankEntity.setLastName(accountDto.getLastName());
            bankEntity.setDateOfBirth(accountDto.getDateOfBirth());
            bankEntity.setTypeOfAccount(accountDto.getTypeOfAccount());
            bankEntity.setAddress(accountDto.getAddress());
            bankEntity.setCity(accountDto.getCity());
            bankEntity.setState(accountDto.getState());
            bankEntity.setCountry(accountDto.getCountry());
            bankEntity.setPincode(accountDto.getPincode());
            bankEntity.setPhoneNumber(accountDto.getPhoneNumber());
            bankEntity.setInitialDeposit(accountDto.getInitialDeposit());

            BankEntity updatedEntity = bankServiceImpl.updateAccount(bankEntity, id);

            GetAccountResponseDto updatedDto = GetAccountResponseDto.fromAcct(updatedEntity);
            return ResponseEntity.ok(updatedDto);

        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/deleteAccount/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
        try {
            bankServiceImpl.deleteAccount(id);
            return ResponseEntity.ok("Account deleted successfully");
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found with ID: " + id);
        }
    }

}
