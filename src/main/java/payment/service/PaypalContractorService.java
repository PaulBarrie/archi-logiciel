package payment.service;

import membership.common.payment.PaypalPayment;
import payment.adapter.PaypalContractorAdapter;
import payment.common.PaypalContractor;

public class PaypalContractorService implements ContractorService{
    private final PaypalContractorAdapter paypalContractorAdapter;
    private final Float amount;

    public PaypalContractorService(Float amount,PaypalPayment paypalPayment) {
        this.paypalContractorAdapter = new PaypalContractorAdapter(amount, paypalPayment, new PaypalContractor());
        this.amount=amount;
    }

    @Override
    public void pay() {
        if (this.paypalContractorAdapter.pay()) {
            System.out.println(this.amount + "€ have been successfully paid !");
        } else {
            System.out.println("Failed to pay "+ this.amount + "€");
        }
    }
}
