package org.esgi.trademe.payment.exposition.payment_mode;

import org.esgi.trademe.payment.domain.CreditCardPayment;

public class CreditCardPaymentDTO implements PaymentModeDTO {
    private final String ownerName;
    private final String cardNumber;
    private final String expirationDate;
    private final String securityNumber;

    private CreditCardPaymentDTO(String ownerName, String cardNumber, String expirationDate, String securityNumber) {
        this.ownerName = ownerName;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.securityNumber = securityNumber;
    }

    public static CreditCardPaymentDTO of(String ownerName, String cardNumber, String expirationDate, String securityNumber) {
        return new CreditCardPaymentDTO(ownerName, cardNumber, expirationDate, securityNumber);
    }

    @Override
    public String toString() {
        return "CreditCardDTO{" +
                "owner=" + ownerName +
                ", number='" + cardNumber + '\'' +
                ", expiration_date='" + expirationDate + '\'' +
                ", security_number='" + securityNumber + '\'' +
                '}';
    }
}
