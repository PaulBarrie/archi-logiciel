package payment.common;

public class CBContractor extends Contractor {
    private static CBContractor instance;

    public CBContractor() {
        super("cb", "https//some-cb-pay-service/pay");
    }

    public CBContractor getInstance() {
        if(instance == null) {
            instance = new CBContractor();
        }
        return instance;
    }
}
