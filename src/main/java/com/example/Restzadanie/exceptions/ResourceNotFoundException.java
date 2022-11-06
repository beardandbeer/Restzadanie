package com.example.Restzadanie.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException() {
        super("Nie znaleziono zasobu!");
    }
}
