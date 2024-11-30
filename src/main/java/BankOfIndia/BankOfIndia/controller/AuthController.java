package BankOfIndia.BankOfIndia.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import BankOfIndia.BankOfIndia.dto.loginDto.LogInRequestDto;
import BankOfIndia.BankOfIndia.dto.loginDto.LogInResponseDto;
import BankOfIndia.BankOfIndia.dto.singUpDto.SingUpRequestDto;
import BankOfIndia.BankOfIndia.dto.singUpDto.SingUpResponseDto;

@RestController
@RequestMapping("/boi")
public class AuthController {

    @PostMapping("/signup")
    public SingUpResponseDto signUp(@RequestBody SingUpRequestDto singUpRequestDto) {
        return null;

    }

    @PostMapping("/login")
    public ResponseEntity<LogInResponseDto> signIn(@RequestBody LogInRequestDto singUpRequestDto) {
        return null;
    }

}
