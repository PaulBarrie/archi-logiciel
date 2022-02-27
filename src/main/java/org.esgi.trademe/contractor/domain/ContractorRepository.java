package org.esgi.trademe.contractor.domain;

import org.esgi.trademe.kernel.Repository;

import java.util.List;

public interface ContractorRepository extends Repository<ContractorID, Contractor> {
    List<Contractor> findAll();
    List<Contractor> findByCity(String city);
}
