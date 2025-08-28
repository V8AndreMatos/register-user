package com.register.user.exceptions;

public class EmailNotFoundException extends RuntimeException{

    public EmailNotFoundException(String msg){
        super("Email " +msg+ " não encontrado");
    }
}
