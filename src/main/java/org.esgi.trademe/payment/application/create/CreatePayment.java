package org.esgi.trademe.payment.application.create;


import org.esgi.trademe.kernel.command.Command;
import org.esgi.trademe.contractor.domain.ContractorID;
import org.esgi.trademe.payment.domain.PaymentMode;


/**
 * Command object
 */
@SuppressWarnings("all")
public final class CreatePayment implements Command {
    private final ContractorID contractorID;
    private final PaymentMode paymentMode;

    public CreatePayment(ContractorID contractorID, PaymentMode paymentMode) {
        this.contractorID = contractorID;
        this.paymentMode = paymentMode;
    }

    public static CreatePayment of(ContractorID contractorID, PaymentMode paymentMode) {
        return new CreatePayment(contractorID, paymentMode);
    }

    public ContractorID getContractorID() {
        return contractorID;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }
}
