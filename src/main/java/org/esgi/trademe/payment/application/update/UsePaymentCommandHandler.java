package org.esgi.trademe.payment.application.update;

import org.esgi.trademe.kernel.command.CommandHandler;
import org.esgi.trademe.kernel.event.Event;
import org.esgi.trademe.kernel.event.EventDispatcher;
import org.esgi.trademe.payment.domain.*;

public final class UsePaymentCommandHandler implements CommandHandler<UsePayment, Boolean> {

    private final PaymentRepository paymentRepository;
    private final PaymentService paymentService;
    private final EventDispatcher<Event> eventDispatcher;

    private UsePaymentCommandHandler(PaymentRepository paymentRepository, PaymentService paymentService, EventDispatcher<Event> eventDispatcher) {
        this.paymentRepository = paymentRepository;
        this.paymentService = paymentService;
        this.eventDispatcher = eventDispatcher;
    }

    public static UsePaymentCommandHandler of(PaymentRepository paymentRepository, PaymentService paymentService, EventDispatcher<Event> eventDispatcher) {
        return new UsePaymentCommandHandler(paymentRepository, paymentService, eventDispatcher);
    }


    public Boolean handle(UsePayment createPayment) {
        Boolean response = paymentService.pay(createPayment.getFromPayment(), createPayment.getToPayment(), createPayment.getAmount());

        return response;
    }
}
