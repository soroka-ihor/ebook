package com.elib.exception;

public class GenreNotFoundException extends RuntimeException {
    public GenreNotFoundException() {
        super("Genre wasn't found.");
    }
}
