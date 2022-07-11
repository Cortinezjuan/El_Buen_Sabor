package com.app.elbuensabor.Excepciones;

public class CredencialInvalidaException extends Exception{
    private static final long serialVersionUID = 1L;

    public CredencialInvalidaException(String message) {
        super(message);
    }
}
