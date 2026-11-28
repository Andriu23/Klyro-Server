package com.planificador.klyro.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String mensaje) {
        super(mensaje);
    }
}
