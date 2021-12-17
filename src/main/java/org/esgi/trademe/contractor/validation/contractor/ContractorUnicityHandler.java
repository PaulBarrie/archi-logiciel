package org.esgi.trademe.contractor.validation.contractor;

import org.esgi.trademe.contractor.domain.Contractor;
import org.esgi.trademe.contractor.domain.ContractorRepository;
import org.esgi.trademe.contractor.validation.ContractorHandler;
import org.esgi.trademe.kernel.exceptions.AlreadyUsedParameterException;
import org.esgi.trademe.kernel.exceptions.InvalidEntryException;


import java.util.List;
import java.util.Objects;

public final class ContractorUnicityHandler extends ContractorHandler {
    private final ContractorRepository contractorRepository;

    public ContractorUnicityHandler(ContractorRepository contractorRepository) {
        this.contractorRepository = contractorRepository;
    }


    @Override
    public void check(Contractor contractor) throws InvalidEntryException {
        List<Contractor> existingContractor = contractorRepository.findAll();
        for (Contractor m : existingContractor) {
            if (Objects.equals(contractor.getEmail(), m.getEmail())) {
                throw  AlreadyUsedParameterException.forField("Email", contractor.getEmail());
            }
            if (Objects.equals(contractor.getFirstname(), m.getFirstname()) & Objects.equals(contractor.getLastname(), m.getLastname())) {
                throw new AlreadyUsedParameterException("Contractor " + contractor.getFirstname() + " " + contractor.getLastname() + " already exists.");
            }
        }
        checkNext(contractor);
    }
}
