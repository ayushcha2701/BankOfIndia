package BankOfIndia.BankOfIndia.dto;

import BankOfIndia.BankOfIndia.entity.BankEntity;
import BankOfIndia.BankOfIndia.entity.TypeOfAccount;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class AccountRequestDto {

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

    public BankEntity createAcctReq(){

        BankEntity bankEntity = new BankEntity();
        bankEntity.setFirstName(this.firstName);
        bankEntity.setLastName(this.lastName);
        bankEntity.setLastName(this.lastName);
        bankEntity.setEmail(this.email);
        bankEntity.setTypeOfAccount(this.typeOfAccount);
        bankEntity.setAddress(this.address);
        bankEntity.setCity(this.city);
        bankEntity.setState(this.state);
        bankEntity.setCountry(this.country);
        bankEntity.setPincode(this.pincode);
        bankEntity.setPhoneNumber(this.phoneNumber);
        bankEntity.setInitialDeposit(this.initialDeposit);

        return bankEntity;
    }

}
