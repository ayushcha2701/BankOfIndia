package BankOfIndia.BankOfIndia.dto;

import java.sql.Date;
import BankOfIndia.BankOfIndia.entity.TypeOfAccount;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAccountDto {

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

}
