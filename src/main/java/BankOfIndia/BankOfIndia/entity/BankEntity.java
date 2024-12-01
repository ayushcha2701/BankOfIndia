package BankOfIndia.BankOfIndia.entity;

import java.sql.Date;

import BankOfIndia.BankOfIndia.entity.Auth.BaseModel;
import BankOfIndia.BankOfIndia.entity.TypeOfAccount;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BankEntity extends BaseModel {

    private String firstName;
    private String lastName;
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
