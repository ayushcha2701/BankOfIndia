package BankOfIndia.BankOfIndia.dto;

import java.sql.Date;

import BankOfIndia.BankOfIndia.entity.BankEntity;
import BankOfIndia.BankOfIndia.entity.TypeOfAccount;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountResponseDto {

    private String firstName;
    private String lastName;
    private String email;
    private Date dateOfBirth;
    private TypeOfAccount typeOfAccount;
    private String address;
    private String city;
    private String state;
    private String country;
    private String pincode;
    private String phoneNumber;
    private Double initialDeposit;

    public static AccountResponseDto fromAcct(BankEntity bankEntity){
        AccountResponseDto createAccountResponseDto = new AccountResponseDto();
        createAccountResponseDto.setFirstName(bankEntity.getFirstName());
        createAccountResponseDto.setLastName(bankEntity.getLastName());
        createAccountResponseDto.setEmail(bankEntity.getEmail());
        createAccountResponseDto.setDateOfBirth(bankEntity.getDateOfBirth());
        createAccountResponseDto.setTypeOfAccount(bankEntity.getTypeOfAccount());
        createAccountResponseDto.setAddress(bankEntity.getAddress());
        createAccountResponseDto.setCity(bankEntity.getCity());
        createAccountResponseDto.setState(bankEntity.getState());
        createAccountResponseDto.setCountry(bankEntity.getCountry());
        createAccountResponseDto.setPincode(bankEntity.getPincode());
        createAccountResponseDto.setPhoneNumber(bankEntity.getPhoneNumber());
        createAccountResponseDto.setInitialDeposit(bankEntity.getInitialDeposit());
        return createAccountResponseDto;
    }

}
