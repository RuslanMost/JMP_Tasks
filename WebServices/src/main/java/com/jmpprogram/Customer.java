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

    public void setWantsEmail(final boolean wantsEmail) {
        this.wantsEmail = wantsEmail;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;

        final Customer customer = (Customer) o;

        if (wantsEmail != customer.wantsEmail) return false;
        return email.equals(customer.email);
    }

    @Override
    public int hashCode() {
        int result = (wantsEmail ? 1 : 0);
        result = 31 * result + email.hashCode();
        return result;
    }
}
