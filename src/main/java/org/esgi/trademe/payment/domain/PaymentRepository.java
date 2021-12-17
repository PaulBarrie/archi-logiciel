package org.esgi.trademe.payment.domain;

import org.esgi.trademe.kernel.Repository;
import org.esgi.trademe.member.domain.MemberID;
import org.esgi.trademe.payment.exposition.PaymentDTO;

import java.util.List;

public interface PaymentRepository extends Repository<PaymentID, Payment> {
    List<Payment> findByMember(MemberID memberID);
}
