package membership.handler.payment.cb;

import membership.common.payment.CBPayment;
import membership.common.payment.Payment;

public final class CBPaymentNotNullHandler extends CBPaymentHandler {


    @Override
    public String check(Payment payment) {
        CBPayment cbPayment = (CBPayment) payment;

        if(cbPayment.getOwnerName() == null) {
            return "Owner name must be provided.";
        }
        if(cbPayment.getCardNumber() == null) {
            return "Card number must be provided.";
        }
        if(cbPayment.getExpirationDate() == null) {
            return "Expiration date must be provided.";
        }
        if(cbPayment.getCVC() == null) {
            return "CVC must be provided.";
        }
        return checkNext(payment);
    }

}
