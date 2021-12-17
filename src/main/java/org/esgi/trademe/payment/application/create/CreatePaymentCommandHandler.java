package org.esgi.trademe.payment.application.create;

import org.esgi.trademe.kernel.command.CommandHandler;
import org.esgi.trademe.kernel.event.Event;
import org.esgi.trademe.kernel.event.EventDispatcher;
import org.esgi.trademe.payment.domain.*;

public final class CreatePaymentCommandHandler implements CommandHandler<CreatePayment, Payment> {

    private final PaymentRepository paymentRepository;
    private final EventDispatcher<Event> eventDispatcher;

    private CreatePaymentCommandHandler(PaymentRepository paymentRepository, EventDispatcher<Event> eventDispatcher) {
        this.paymentRepository = paymentRepository;
        this.eventDispatcher = eventDispatcher;
    }

    public static CreatePaymentCommandHandler of(PaymentRepository paymentRepository, EventDispatcher<Event> eventDispatcher) {
        return new CreatePaymentCommandHandler(paymentRepository, eventDispatcher);
    }


    public Payment handle(CreatePayment createPayment) {
        final PaymentID paymentID = paymentRepository.nextIdentity();
        Payment payment = null;

        if(createPayment.getPaymentMode().getClass().equals(CreditCardPayment.class)) {
            CreditCardPayment creditCardPayment = (CreditCardPayment) createPayment.getPaymentMode();
            payment =  Payment.of(paymentID, createPayment.getMemberID(), creditCardPayment);
        } else if(createPayment.getPaymentMode().getClass().equals(AccountIdentityPayment.class)) {
            AccountIdentityPayment accountIdentityPayment = (AccountIdentityPayment) createPayment.getPaymentMode();
            payment =  Payment.of(paymentID, createPayment.getMemberID(), accountIdentityPayment);
        }

        paymentRepository.add(payment);
        eventDispatcher.dispatch(new CreatePaymentEvent(paymentID));
        return payment;
    }
}
