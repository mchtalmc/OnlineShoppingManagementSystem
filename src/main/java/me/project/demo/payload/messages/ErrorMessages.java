package me.project.demo.payload.messages;

public class ErrorMessages {


    private ErrorMessages(){
    }
    public static final String EMAIL_ALREADY_EXIST = "Error : Email already exist in DB";
    public static final String PHONENUMBER_ALREADY_EXIST = "Error : Phone number already exist in DB";
    public static final String USER_NOT_FOUND ="Error: Not found with this %s" ;
}
