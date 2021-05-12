package de.telekom.sea;

public class WrongIdException extends RuntimeException {
    private String message;

    public WrongIdException(String id) {
        message = "This file can't be processed. Wrong id format (must be long).";
        System.out.println(message);
    }
}
