package com.evaluation.system.user.infrastructure.exceptions;

public class UserFoundException extends Exception{

    public UserFoundException() {
        super("Error: Usuario ya existe");
    }
    
}
