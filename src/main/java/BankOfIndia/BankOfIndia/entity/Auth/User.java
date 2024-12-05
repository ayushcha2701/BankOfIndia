package BankOfIndia.BankOfIndia.entity.Auth;

import BankOfIndia.BankOfIndia.entity.BaseModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;
import java.util.*;

@Setter
@Getter
@Entity
public class User extends BaseModel {

    private String email;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Role> roles = new HashSet<>();
}
