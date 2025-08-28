package com.register.user.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Object id) {

        super(" Id = " +id+ " não encontrado");

    }
}
