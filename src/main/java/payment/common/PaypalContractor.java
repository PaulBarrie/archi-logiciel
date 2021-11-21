package payment.common;

public class PaypalContractor extends Contractor {
    private static PaypalContractor instance;

    public PaypalContractor() {
        super("paypal", "https//paypal.com/pay");
    }

    public PaypalContractor getInstance() {
        if(instance == null) {
            instance = new PaypalContractor();
        }
        return instance;
    }
}
