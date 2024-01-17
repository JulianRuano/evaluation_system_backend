package com.evaluation.system.exceptions;

public class UserFoundException extends Exception{

    public UserFoundException() {
        super("Error: Usuario ya existe");
    }
    
}
