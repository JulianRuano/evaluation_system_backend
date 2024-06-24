package com.evaluation.system.authorization.auth.infrastructure.exceptions;

public class UserFoundException extends Exception{

    public UserFoundException() {
        super("Error: Usuario ya existe");
    }
    
}
