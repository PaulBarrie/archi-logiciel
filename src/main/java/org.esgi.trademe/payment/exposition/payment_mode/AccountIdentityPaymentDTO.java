package org.esgi.trademe.payment.exposition.payment_mode;


import java.util.Objects;

public final class AccountIdentityPaymentDTO implements PaymentModeDTO {
    private final String accountIdentifier;
    private final String bankIdentifier;

    private AccountIdentityPaymentDTO(String accountIdentifier, String bankIdentifier) {
        this.accountIdentifier = accountIdentifier;
        this.bankIdentifier = bankIdentifier;
    }

    public static AccountIdentityPaymentDTO of(String accountIdentifier, String bankIdentifier) {
        return new AccountIdentityPaymentDTO(accountIdentifier, bankIdentifier);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountIdentityPaymentDTO accountIdentityPayment = (AccountIdentityPaymentDTO) o;
        return Objects.equals(accountIdentifier, accountIdentityPayment.accountIdentifier) &&
                Objects.equals(bankIdentifier, accountIdentityPayment.bankIdentifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountIdentifier,bankIdentifier);
    }

    @Override
    public String toString() {
        return "AccountIdentityDTO{" +
                "account_identifier=" + accountIdentifier +
                ", bank_identifier='" + bankIdentifier + '\'' +
                '}';
    }

    public String getAccountIdentifier() {
        return accountIdentifier;
    }

    public String getBankIdentifier() {
        return bankIdentifier;
    }
}
