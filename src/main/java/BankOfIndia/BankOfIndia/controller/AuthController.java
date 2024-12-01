package BankOfIndia.BankOfIndia.controller;

import BankOfIndia.BankOfIndia.exception.UserAlreadyExistException;
import BankOfIndia.BankOfIndia.exception.WrongPasswordException;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import BankOfIndia.BankOfIndia.dto.RequestStatus;
import BankOfIndia.BankOfIndia.dto.loginDto.LogInRequestDto;
import BankOfIndia.BankOfIndia.dto.loginDto.LogInResponseDto;
import BankOfIndia.BankOfIndia.dto.singUpDto.SingUpRequestDto;
import BankOfIndia.BankOfIndia.dto.singUpDto.SingUpResponseDto;
import BankOfIndia.BankOfIndia.service.AuthServiceImpl;

@RestController
@RequestMapping("/boi")
public class AuthController {

    private AuthServiceImpl authServiceImpl;

    AuthController(AuthServiceImpl authServiceImpl) {
        this.authServiceImpl = authServiceImpl;
    }

    @PostMapping("/signup")
    public ResponseEntity<SingUpResponseDto> signUp(@RequestBody SingUpRequestDto request) throws UserAlreadyExistException {

        SingUpResponseDto response = new SingUpResponseDto();
        try{
            if (authServiceImpl.signUp(request.getEmail(), request.getPassword())) {
                response.setRequestStatus(RequestStatus.SUCCESS);

            } else {
                response.setRequestStatus(RequestStatus.FAILURE);
            }

            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            
            response.setRequestStatus(RequestStatus.FAILURE);
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }

    }

    @PostMapping("/login")
    public ResponseEntity<LogInResponseDto> signIn(@RequestBody LogInRequestDto singUpRequestDto) {
        try {
            String token = authServiceImpl.logIn(singUpRequestDto.getEmail(), singUpRequestDto.getPassword());
            LogInResponseDto responseDto = new LogInResponseDto();
            responseDto.setRequestStatus(RequestStatus.SUCCESS);
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            headers.add("AUTH_TOKEN", token);
            ResponseEntity<LogInResponseDto> response = new ResponseEntity<>(responseDto, headers, HttpStatus.OK);
            return response;
        } catch (Exception e) {
            LogInResponseDto loginDto = new LogInResponseDto();
            loginDto.setRequestStatus(RequestStatus.FAILURE);
            ResponseEntity<LogInResponseDto> response = new ResponseEntity<>(
                    loginDto, null, HttpStatus.BAD_REQUEST
            );
            return response;
        }
    }

    @GetMapping("/validate")
    public boolean validate(@RequestParam("token") String token) {
                return authServiceImpl.validate(token);
    }

}
