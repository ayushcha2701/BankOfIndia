package BankOfIndia.BankOfIndia.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class GetAllAccountResponseDto {

    private List<GetAccountResponseDto>  accounts;
}
