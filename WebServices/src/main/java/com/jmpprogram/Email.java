package com.jmpprogram;

public class Email {
    private String message;

    public Email(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void showMessage() {
        System.out.println(message);
    }
}
