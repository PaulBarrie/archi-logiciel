package org.esgi.trademe.payment.domain;

import org.esgi.trademe.kernel.Repository;
import org.esgi.trademe.contractor.domain.ContractorID;

import java.util.List;

public interface PaymentRepository extends Repository<PaymentID, Payment> {
    List<Payment> findByContractor(ContractorID contractorID);
}
