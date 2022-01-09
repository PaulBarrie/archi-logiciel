package org.esgi.trademe.payment.application.retrieve;


import org.esgi.trademe.kernel.query.QueryHandler;
import org.esgi.trademe.payment.domain.PaymentRepository;
import org.esgi.trademe.payment.exposition.PaymentDTO;

import java.util.List;
import java.util.stream.Collectors;

public final class RetrievePaymentsByMemberIDHandler implements QueryHandler<RetrievePaymentsByMemberID, List<PaymentDTO>> {

    private final PaymentRepository paymentRepository;

    public RetrievePaymentsByMemberIDHandler(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<PaymentDTO> handle(RetrievePaymentsByMemberID query) {
        return paymentRepository.findByMember(query.memberID)
                .stream()
                .map(PaymentDTO::of)
                .collect(Collectors.toList());

    }
}
