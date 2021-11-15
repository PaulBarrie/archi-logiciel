package esgi.barrie.al.service.payment;

import esgi.barrie.al.common.payment.PayOrder;

import java.util.Random;

public class PaypalPaymentAdapter implements PaymentAdapter {
    PayOrder payOrder;

    public PaypalPaymentAdapter(PayOrder payOrder) {
        this.payOrder = payOrder;
    }


    @Override
    public String sendRequest() {
        System.out.println("Sending payment request for " + this.payOrder.getAmount() + "€");
        //TODO: implement request
        String resp ="ok";
        return resp;
    }

    @Override
    public boolean requestApproved(String body) {
        Random random = new Random();
        return random.nextDouble() < 0.5;
    }

    @Override
    public void pay() throws InterruptedException {
        String resp = this.sendRequest();
        Thread.sleep((long)(Math.random() * 10000));
        if(requestApproved(resp)) {
            System.out.println("Payment was successful");
        }
        else  {
            System.out.println("Payment failed");
        }
    }
}
