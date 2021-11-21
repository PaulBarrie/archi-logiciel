package membership.common.payment;

public class PaypalPayment extends Payment {
    private String paypalUserName;
    private String paypalAuthToken;


    public PaypalPayment(String paypalUserName, String paypalAuthToken) {
        this.paypalUserName = paypalUserName;
        this.paypalAuthToken = paypalAuthToken;
    }

    public static PaypalPayment nullPayment() {
        return new PaypalPayment(null, null);
    }

    public void setPaypalUserName(String paypalUserName) {
        this.paypalUserName = paypalUserName;
    }

    public void setPaypalAuthToken(String paypalAuthToken) {
        this.paypalAuthToken = paypalAuthToken;
    }

    public String getPaypalUserName() {
        return paypalUserName;
    }

    public String getPaypalAuthToken() {
        return paypalAuthToken;
    }
}
