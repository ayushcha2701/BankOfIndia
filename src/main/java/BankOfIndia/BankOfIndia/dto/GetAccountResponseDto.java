package BankOfIndia.BankOfIndia.dto;


import BankOfIndia.BankOfIndia.entity.BankEntity;
import BankOfIndia.BankOfIndia.entity.TypeOfAccount;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
public class GetAccountResponseDto {

    private Long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String email;
    private TypeOfAccount typeOfAccount;
    private String address;
    private String city;
    private String state;
    private String country;
    private String pincode;
    private String phoneNumber;
    private Double initialDeposit;

    public static GetAccountResponseDto fromAcct(BankEntity bankEntity){

        GetAccountResponseDto accountResponseDto = new GetAccountResponseDto();

        accountResponseDto.setId(bankEntity.getId());
        accountResponseDto.setFirstName(bankEntity.getFirstName());
        accountResponseDto.setLastName(bankEntity.getLastName());
        accountResponseDto.setDateOfBirth(bankEntity.getDateOfBirth());
        accountResponseDto.setEmail(bankEntity.getEmail());
        accountResponseDto.setTypeOfAccount(bankEntity.getTypeOfAccount());
        accountResponseDto.setAddress(bankEntity.getAddress());
        accountResponseDto.setCity(bankEntity.getCity());
        accountResponseDto.setState(bankEntity.getState());
        accountResponseDto.setCountry(bankEntity.getCountry());
        accountResponseDto.setPincode(bankEntity.getPincode());
        accountResponseDto.setPhoneNumber(bankEntity.getPhoneNumber());
        accountResponseDto.setInitialDeposit(bankEntity.getInitialDeposit());

        return accountResponseDto;
    }

}
