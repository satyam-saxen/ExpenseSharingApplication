package utils;

import repositories.impl.InMemoryUserRepository;

import java.util.Map;

public class UserDataValidator {

    public Boolean validateName(String name){
        return name.length()>0;
    }
    public Boolean validatePhoneNumber(String phoneNumber){
        if(phoneNumber.length() != 10) return false;
        Boolean phoneNumberValidation = true;
        for(int index=0;index<phoneNumber.length();index++){
            if(phoneNumber.charAt(index)<'0' && phoneNumber.charAt(index)>'9'){
                phoneNumberValidation = false;
                break;
            }
        }
        return phoneNumberValidation;
    }
}