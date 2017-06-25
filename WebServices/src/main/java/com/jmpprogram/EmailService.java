package com.jmpprogram;

public class EmailService {
    public void sendInvoice(final Invoice invoice, final Email email) {
        System.out.println("Invoice is " + invoice.getInvoice() + " message is " + email.getMessage());
    }
}
