package com.example.library.exception;

/**
 * Custom exception for not found books.
 */
public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message) {
        super(message);
    }
}
