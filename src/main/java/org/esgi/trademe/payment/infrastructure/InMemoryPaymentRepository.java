package org.esgi.trademe.payment.infrastructure;


import org.esgi.trademe.kernel.exceptions.NoSuchEntityException;
import org.esgi.trademe.contractor.domain.ContractorID;

import org.esgi.trademe.payment.domain.Payment;
import org.esgi.trademe.payment.domain.PaymentID;
import org.esgi.trademe.payment.domain.PaymentRepository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


public final class InMemoryPaymentRepository implements PaymentRepository {

    private final AtomicInteger count = new AtomicInteger(0);

    private final Map<PaymentID, Payment> data = new ConcurrentHashMap<>();

    @Override
    public PaymentID nextIdentity() {
        return new PaymentID(count.incrementAndGet());
    }

    @Override
    public Payment findById(PaymentID id) {
        final Payment payment = data.get(id);
        if (payment == null) {
            throw NoSuchEntityException.withId(id);
        }
        return payment;
    }

    @Override
    public void add(Payment payment) {
        data.put(payment.getId(), payment);
    }

    @Override
    public void delete(PaymentID id) {
        data.remove(id);
    }


    @Override
    public List<Payment> findByContractor(ContractorID contractorID) {
        return List.copyOf(data.values().stream()
                .filter(payment -> payment.getContractorID().equals(contractorID))
                .collect(Collectors.toList()));
    }
}
