package com.elib.exception;

public class LanguageNotFoundException extends RuntimeException {
    public LanguageNotFoundException() {
        super("Language not found");
    }
}
