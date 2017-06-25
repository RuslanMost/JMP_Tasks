package com.jmpprogram;

public class FinalInvoiceStep {
    private PrinterService printerService;
    private EmailService emailService;

    public FinalInvoiceStep(final PrinterService printerService, final EmailService emailService) {
        this.printerService = printerService;
        this.emailService = emailService;
    }

    public void handleInvoice(final Invoice invoice, final Customer customer) {
        if (customer.isWantsEmail()) {
            emailService.sendInvoice(invoice, customer.getEmail());
        } else {
            printerService.printInvoice(invoice);
        }
    }
}
