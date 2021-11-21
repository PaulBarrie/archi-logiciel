package payment.service;

import membership.common.payment.CBPayment;
import payment.adapter.CBContractorAdapter;


public class CBContractorService implements ContractorService{
    private final CBContractorAdapter cbContractorAdapter;
    private final Float amount;

    public CBContractorService(Float amount, CBPayment cbPayment) {
        this.cbContractorAdapter = new CBContractorAdapter(amount, cbPayment);
        this.amount=amount;
    }

    @Override
    public void pay() throws InterruptedException {
        System.out.println("Payment of " + this.amount + " underway...");
        if (this.cbContractorAdapter.pay()) {
            System.out.println(this.amount + "€ have been successfully paid !");
        } else {
            System.out.println("Failed to pay "+ this.amount + "€");
        }
    }

}
