package BankOfIndia.BankOfIndia.service;

import BankOfIndia.BankOfIndia.exception.UserAlreadyExistException;
import BankOfIndia.BankOfIndia.exception.UserNotFoundException;
import BankOfIndia.BankOfIndia.exception.WrongPasswordException;

public interface AuthService {

    public boolean signUp(String email, String password) throws UserAlreadyExistException;

    public String logIn(String email, String password) throws UserNotFoundException, WrongPasswordException;

    public boolean validate(String token);

}
