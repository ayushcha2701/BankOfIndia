package BankOfIndia.BankOfIndia.dto.loginDto;

import BankOfIndia.BankOfIndia.dto.RequestStatus;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LogInResponseDto {
    private RequestStatus requestStatus;
}
