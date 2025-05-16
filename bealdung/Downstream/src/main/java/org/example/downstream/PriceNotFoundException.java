package org.example.downstream;

public class PriceNotFoundException extends RuntimeException{
    public PriceNotFoundException(String message) {
        super(message);
    }
}
