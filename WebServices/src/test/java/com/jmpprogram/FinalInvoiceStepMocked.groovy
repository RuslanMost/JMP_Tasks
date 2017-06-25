package com.jmpprogram

import spock.lang.Specification

class FinalInvoiceStepMocked extends Specification {

    def "different-customer-types-test"() {
        setup:
        def printerService = Mock(PrinterService)
        def emailService = Mock(EmailService)
        def finalInvoiceStep = new FinalInvoiceStep(printerService, emailService)

        def customerWhoWantsEmail = Mock(Customer) {
            getEmail() >> Mock(Email) {
                getMessage() >> "Some private email message"
            }
            isWantsEmail() >> true
        }
        def customerWhoWantsSnailMail = Mock(Customer) {
            getEmail() >> Mock(Email) {
                getMessage() >> _
            }
            isWantsEmail() >> false
        }
        def invoice = Mock(Invoice) {
            getInvoice() >> 123
        }

        when: "customer is normal and has an email inbox"
        finalInvoiceStep.handleInvoice(invoice, customerWhoWantsEmail)

        then: "nothing should be printed. Only an email should be sent"
        0 * printerService.printInvoice(invoice)
        1 * emailService.sendInvoice(invoice, customerWhoWantsEmail.email)
        assert customerWhoWantsEmail.email.message == "Some private email message"

        when: "customer is old fashioned and prefers snail mail"
        finalInvoiceStep.handleInvoice(invoice, customerWhoWantsSnailMail)

        then: "no email is available. A copy must have been sent to the printer"
        0 * emailService.sendInvoice(invoice, _ as Email)
        1 * printerService.printInvoice(invoice)
        assert customerWhoWantsSnailMail.email.message == null
    }
}
