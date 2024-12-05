package BankOfIndia.BankOfIndia.entity.Auth;

import BankOfIndia.BankOfIndia.entity.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@JsonDeserialize(as = Role.class)
public class Role extends BaseModel {
    private String role;
}
