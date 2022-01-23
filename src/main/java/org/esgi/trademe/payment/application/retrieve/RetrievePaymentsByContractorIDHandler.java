package org.esgi.trademe.payment.application.retrieve;


import org.esgi.trademe.kernel.query.QueryHandler;
import org.esgi.trademe.payment.domain.PaymentRepository;
import org.esgi.trademe.payment.exposition.PaymentDTO;

import java.util.List;
import java.util.stream.Collectors;

public final class RetrievePaymentsByContractorIDHandler implements QueryHandler<RetrievePaymentsByContractorID, List<PaymentDTO>> {

    private final PaymentRepository paymentRepository;

    public RetrievePaymentsByContractorIDHandler(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<PaymentDTO> handle(RetrievePaymentsByContractorID query) {
        return paymentRepository.findByContractor(query.contractorID)
                .stream()
                .map(PaymentDTO::of)
                .collect(Collectors.toList());

    }
}
