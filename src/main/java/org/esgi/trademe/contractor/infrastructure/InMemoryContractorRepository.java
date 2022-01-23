package org.esgi.trademe.contractor.infrastructure;


import org.esgi.trademe.kernel.exceptions.NoSuchEntityException;
import org.esgi.trademe.contractor.domain.Contractor;
import org.esgi.trademe.contractor.domain.ContractorID;
import org.esgi.trademe.contractor.domain.ContractorRepository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public final class InMemoryContractorRepository implements ContractorRepository {

    private final AtomicInteger count = new AtomicInteger(0);

    private final Map<ContractorID, Contractor> data = new ConcurrentHashMap<>();

    @Override
    public ContractorID nextIdentity() {
        return  ContractorID.of(count.incrementAndGet());
    }

    @Override
    public Contractor findById(ContractorID id) {
        final Contractor user = data.get(id);
        if (user == null) {
            throw NoSuchEntityException.withId(id);
        }
        return user;
    }

    @Override
    public void add(Contractor contractor) {
        data.put(contractor.getId(), contractor);
    }

    @Override
    public void delete(ContractorID id) {
        data.remove(id);
    }

    @Override
    public List<Contractor> findAll() {
        return List.copyOf(data.values());
    }

    @Override
    public List<Contractor> findByCity(String city) {
        return List.copyOf(data.values().stream()
                .filter(contractor -> contractor.getAddress().getCity().equals(city)).collect(Collectors.toList()));
    }
}
