package esgi.barrie.al.service.payment;

import esgi.barrie.al.common.payment.PayOrder;
import esgi.barrie.al.common.payment.Payment;

public interface PaymentAdapter {
    String sendRequest();
    boolean requestApproved(String body);
    void pay() throws InterruptedException;
}
