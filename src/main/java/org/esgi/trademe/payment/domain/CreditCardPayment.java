package org.esgi.trademe.payment.domain;

import java.util.Objects;

public final class CreditCardPayment implements PaymentMode {
    private final String ownerName;
    private final String cardNumber;
    private final String expirationDate;
    private final String securityNumber;

    private CreditCardPayment(String ownerName, String cardNumber, String expirationDate, String securityNumber) {
        this.ownerName = ownerName;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.securityNumber = securityNumber;
    }

    public static CreditCardPayment of(String ownerName, String cardNumber, String expirationDate, String securityNumber) {
        return new CreditCardPayment(ownerName, cardNumber, expirationDate, securityNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCardPayment creditCardPayment = (CreditCardPayment) o;
        return Objects.equals(ownerName, creditCardPayment.ownerName) && Objects.equals(cardNumber, creditCardPayment.cardNumber) &&
                Objects.equals(expirationDate, creditCardPayment.expirationDate) && Objects.equals(securityNumber, creditCardPayment.securityNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ownerName, cardNumber, expirationDate, securityNumber);
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "owner=" + ownerName +
                ", card_number='" + cardNumber + '\'' +
                ", expiration='" + expirationDate + '\'' +
                ", security_code=" + securityNumber +
                '}';
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

    public String getSecurityNumber() {
        return securityNumber;
    }
}
