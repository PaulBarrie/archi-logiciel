package payment.adapter;

import membership.common.payment.CBPayment;
import payment.common.CBContractor;

public class CBContractorAdapter extends ContractorAdapter {
    CBPayment cbPayment;
    CBContractor contractor;

    public CBContractorAdapter(Float amountToPay, CBPayment cbPayment) {
        super(amountToPay);
        this.cbPayment = cbPayment;
        this.contractor = new CBContractor().getInstance();
    }

    @Override
    protected String buildPaymentRequest() {
         return this.contractor.getEndpoint()+"?owner="+this.cbPayment.getOwnerName()+"&card_number=" +
                this.cbPayment.getCardNumber() + "&expiration=" + this.cbPayment.getExpirationDate() +
                 "&cvc=" + this.cbPayment.getCVC();
    }

    @Override
    protected boolean parseContractorResponse(String body) {
        //TODO: implement according to contractor specifications
        return true;
    }

    @Override
    public boolean pay() throws InterruptedException {
        String response = this.buildPaymentRequest();
        //Simulate time response
        Thread.sleep((long) 5000);
        return this.parseContractorResponse(response);
    }
}
