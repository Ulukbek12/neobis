package com.example.week4.exception;

public class  UserNotFound extends RuntimeException{
    public UserNotFound(String message){
        super(message);
    }
    public UserNotFound(){
        super("User Not Found!");
    }
}
