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

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Email)) return false;

        final Email email = (Email) o;

        return message.equals(email.message);
    }

    @Override
    public int hashCode() {
        return message.hashCode();
    }
}
