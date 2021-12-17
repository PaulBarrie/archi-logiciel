package org.esgi.trademe.payment.application.create;


import org.esgi.trademe.kernel.command.Command;
import org.esgi.trademe.member.domain.MemberID;
import org.esgi.trademe.payment.domain.PaymentMode;


/**
 * Command object
 */
@SuppressWarnings("all")
public final class CreatePayment implements Command {
    private final MemberID memberID;
    private final PaymentMode paymentMode;

    public CreatePayment(MemberID memberID, PaymentMode paymentMode) {
        this.memberID = memberID;
        this.paymentMode = paymentMode;
    }

    public static CreatePayment of(MemberID memberID, PaymentMode paymentMode) {
        return new CreatePayment(memberID, paymentMode);
    }

    public MemberID getMemberID() {
        return memberID;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }
}
