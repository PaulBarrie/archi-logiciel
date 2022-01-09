package org.esgi.trademe.payment.domain;

import java.util.Objects;

public final class AccountIdentityPayment implements PaymentMode {
    private final String accountIdentifier;
    private final String bankIdentifier;

    private AccountIdentityPayment(String accountIdentifier, String bankIdentifier) {
        this.accountIdentifier = accountIdentifier;
        this.bankIdentifier = bankIdentifier;
    }

    public static AccountIdentityPayment of(String accountIdentifier, String bankIdentifier) {
        return new AccountIdentityPayment(accountIdentifier, bankIdentifier);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountIdentityPayment accountIdentityPayment = (AccountIdentityPayment) o;
        return Objects.equals(accountIdentifier, accountIdentityPayment.accountIdentifier) &&
                Objects.equals(bankIdentifier, accountIdentityPayment.bankIdentifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountIdentifier,bankIdentifier);
    }

    @Override
    public String toString() {
        return "AccountIdentity{" +
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
