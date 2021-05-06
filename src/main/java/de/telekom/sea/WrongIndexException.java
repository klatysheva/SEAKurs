package de.telekom.sea;

public class WrongIndexException extends RuntimeException {
    private String message;

    public WrongIndexException(int index, int length) {
        message = "Wrong index: " + index + ". Index must be in the range from 0 to " + length + ".";
        System.out.println(message);
    }
}
