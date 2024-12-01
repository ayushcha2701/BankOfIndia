package BankOfIndia.BankOfIndia.service;

import BankOfIndia.BankOfIndia.exception.UserAlreadyExistException;

public interface AuthService {

    public boolean signUp(String email, String password) throws UserAlreadyExistException;

    public String logIn(String email, String password);

    public boolean validate(String token);

}
