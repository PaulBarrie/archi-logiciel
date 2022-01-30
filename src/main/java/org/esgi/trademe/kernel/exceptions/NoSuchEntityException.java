package org.esgi.trademe.kernel.exceptions;

import org.esgi.trademe.contract.domain.ContractID;
import org.esgi.trademe.project.domain.ProjectID;
import org.esgi.trademe.tradesman.domain.TradesmanID;
import org.esgi.trademe.contractor.domain.ContractorID;
import org.esgi.trademe.payment.domain.PaymentID;

public final class NoSuchEntityException extends RuntimeException {

    public NoSuchEntityException(String message) {
        super(message);
    }

    public static NoSuchEntityException withId(ContractorID id) {
        return new NoSuchEntityException(String.format("No contractor found with ID %d.", id.getValue()));
    }

    public static NoSuchEntityException withId(PaymentID id) {
        return new NoSuchEntityException(String.format("No payment found with ID %d.", id.getValue()));
    }

    public static NoSuchEntityException withId(TradesmanID id) {
        return new NoSuchEntityException(String.format("No tradesman found with ID %d.", id.getValue()));
    }

    public static NoSuchEntityException withId(ProjectID id) {
        return new NoSuchEntityException(String.format("No project found with ID %d.", id.getValue()));
    }

    public static NoSuchEntityException withId(ContractID id) {
        return new NoSuchEntityException(String.format("No contract found with ID %d.", id.getValue()));
    }
}
