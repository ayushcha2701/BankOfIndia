package BankOfIndia.BankOfIndia.mapper;

import BankOfIndia.BankOfIndia.dto.AccountRequestDto;
import BankOfIndia.BankOfIndia.dto.AccountResponseDto;
import BankOfIndia.BankOfIndia.dto.GetAccountResponseDto;
import BankOfIndia.BankOfIndia.entity.BankEntity;

public class BankMapper {

    // Converts AccountRequestDto to BankEntity
    public static BankEntity toEntity(AccountRequestDto requestDto) {
        BankEntity entity = new BankEntity();
        entity.setFirstName(requestDto.getFirstName());
        entity.setLastName(requestDto.getLastName());
        entity.setEmail(requestDto.getEmail());
        entity.setDateOfBirth(requestDto.getDateOfBirth());
        entity.setTypeOfAccount(requestDto.getTypeOfAccount());
        entity.setAddress(requestDto.getAddress());
        entity.setCity(requestDto.getCity());
        entity.setState(requestDto.getState());
        entity.setCountry(requestDto.getCountry());
        entity.setPincode(requestDto.getPincode());
        entity.setPhoneNumber(requestDto.getPhoneNumber());
        entity.setBalance(requestDto.getBalance());
        return entity;
    }

    // Converts GetAccountResponseDto to BankEntity
    public static BankEntity toEntity(GetAccountResponseDto responseDto) {
        BankEntity entity = new BankEntity();
        entity.setFirstName(responseDto.getFirstName());
        entity.setLastName(responseDto.getLastName());
        entity.setEmail(responseDto.getEmail());
        entity.setDateOfBirth(responseDto.getDateOfBirth());
        entity.setTypeOfAccount(responseDto.getTypeOfAccount());
        entity.setAddress(responseDto.getAddress());
        entity.setCity(responseDto.getCity());
        entity.setState(responseDto.getState());
        entity.setCountry(responseDto.getCountry());
        entity.setPincode(responseDto.getPincode());
        entity.setPhoneNumber(responseDto.getPhoneNumber());
        entity.setBalance(responseDto.getBalance());
        return entity;
    }

    // Converts BankEntity to AccountResponseDto
    public static AccountResponseDto toResponseDto(BankEntity entity) {
        AccountResponseDto responseDto = new AccountResponseDto();
        responseDto.setFirstName(entity.getFirstName());
        responseDto.setLastName(entity.getLastName());
        responseDto.setEmail(entity.getEmail());
        responseDto.setDateOfBirth(entity.getDateOfBirth());
        responseDto.setTypeOfAccount(entity.getTypeOfAccount());
        responseDto.setAddress(entity.getAddress());
        responseDto.setCity(entity.getCity());
        responseDto.setState(entity.getState());
        responseDto.setCountry(entity.getCountry());
        responseDto.setPincode(entity.getPincode());
        responseDto.setPhoneNumber(entity.getPhoneNumber());
        responseDto.setBalance(entity.getBalance());
        return responseDto;
    }

    // Converts BankEntity to GetAccountResponseDto
    public static GetAccountResponseDto toGetAccountResponseDto(BankEntity entity) {
        GetAccountResponseDto responseDto = new GetAccountResponseDto();
        responseDto.setFirstName(entity.getFirstName());
        responseDto.setLastName(entity.getLastName());
        responseDto.setEmail(entity.getEmail());
        responseDto.setDateOfBirth(entity.getDateOfBirth());
        responseDto.setTypeOfAccount(entity.getTypeOfAccount());
        responseDto.setAddress(entity.getAddress());
        responseDto.setCity(entity.getCity());
        responseDto.setState(entity.getState());
        responseDto.setCountry(entity.getCountry());
        responseDto.setPincode(entity.getPincode());
        responseDto.setPhoneNumber(entity.getPhoneNumber());
        responseDto.setBalance(entity.getBalance());
        return responseDto;
    }
}
