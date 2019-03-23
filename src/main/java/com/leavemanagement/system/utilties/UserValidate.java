package com.leavemanagement.system.utilties;

import com.leavemanagement.system.exception.LeaveManagementException;

import java.util.regex.Pattern;

public class UserValidate {

    public void validateEmail(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        try{
        if (email == null || !pat.matcher(email).matches())
            throw new LeaveManagementException("Email not Valid.");}
        catch (LeaveManagementException e) {
            e.printStackTrace();
        }
    }

    public void validateName(String name){
        try {

        if(!(name.length()<50)){
            throw new LeaveManagementException("Name too Long.");
        }else if (name.length()==0){
            throw new LeaveManagementException("Set the name");
        }
        }
        catch (LeaveManagementException e) {
                e.printStackTrace();
            }

    }
}
