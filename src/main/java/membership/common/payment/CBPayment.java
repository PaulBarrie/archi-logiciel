package membership.common.payment;

public class CBPayment extends Payment {
    private String ownerName;
    private String cardNumber;
    private String expirationDate;
    private String CVC;

    public CBPayment(String cardNumber, String expirationDate, String cvc) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.CVC = cvc;
    }

    public static CBPayment nullPayment() {
        return new CBPayment(null, null, null);
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setCVC(String CVC) {
        this.CVC = CVC;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getCVC() {
        return CVC;
    }
}
