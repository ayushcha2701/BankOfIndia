package BankOfIndia.BankOfIndia.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BankEntity extends BaseModel {

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
    private Double balance;

    @ElementCollection(fetch = FetchType.EAGER) // Automatically fetch the list
    @CollectionTable(name = "amt_deposit", joinColumns = @JoinColumn(name = "bank_id"))
    private List<Double> amtDeposit;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "amt_withdraw", joinColumns = @JoinColumn(name = "bank_id"))
    private List<Double> amtWithdraw;

}
