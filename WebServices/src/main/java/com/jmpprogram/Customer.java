package com.jmpprogram;

public class Customer {
    private boolean wantsEmail;
    private Email email;
    public void wantsEmail(final boolean wantsEmail) {
        this.wantsEmail = wantsEmail;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(final Email email) {
        this.email = email;
    }

    public boolean isWantsEmail() {
        return wantsEmail;
    }
}
