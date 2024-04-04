package com.example.week5.exception;


    public class UserExists extends RuntimeException{
        public UserExists(String message){
            super("User Already Exists" + message);
        }

        public UserExists() {
            super("User Already Exists");
        }
    }

