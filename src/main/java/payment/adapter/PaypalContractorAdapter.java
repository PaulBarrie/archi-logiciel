package payment.adapter;

import membership.common.payment.PaypalPayment;
import payment.common.PaypalContractor;

public class PaypalContractorAdapter extends ContractorAdapter {
    PaypalPayment paypalPayment;
    PaypalContractor contractor;

    public PaypalContractorAdapter(Float amountToPay, PaypalPayment paypalPayment, PaypalContractor contractor) {
        super(amountToPay);
        this.paypalPayment = paypalPayment;
        this.contractor = new PaypalContractor().getInstance();
    }


    @Override
    protected String buildPaymentRequest() {
        return this.contractor.getEndpoint()+"?user="+this.paypalPayment.getPaypalUserName()+"&token=" +
                this.paypalPayment.getPaypalAuthToken() + "&amount=" + this.getAmountToPay();
    }


    @Override
    protected boolean parseContractorResponse(String body) {
        //TODO: implement according to contractor specifications
        return true;
    }

    @Override
    public boolean pay() {
        String response = this.buildPaymentRequest();
        return this.parseContractorResponse(response);
    }
}
