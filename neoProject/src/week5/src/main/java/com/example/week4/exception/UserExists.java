package com.example.week4.exception;


    public class UserExists extends RuntimeException{
        public UserExists(String message){
            super("User Already Exists" + message);
        }

        public UserExists() {
            super("User Already Exists");
        }
    }

