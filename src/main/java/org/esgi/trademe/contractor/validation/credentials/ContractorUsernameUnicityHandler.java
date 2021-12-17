package org.esgi.trademe.contractor.validation.credentials;

import org.esgi.trademe.contractor.domain.Contractor;
import org.esgi.trademe.contractor.domain.ContractorRepository;
import org.esgi.trademe.contractor.validation.ContractorHandler;
import org.esgi.trademe.kernel.exceptions.AlreadyUsedParameterException;
import org.esgi.trademe.kernel.exceptions.InvalidEntryException;

import java.util.List;
import java.util.Objects;

public class ContractorUsernameUnicityHandler extends ContractorHandler {
    private ContractorHandler next;
    private final ContractorRepository contractorRepository;

    public ContractorUsernameUnicityHandler(ContractorRepository contractorRepository) {
        this.contractorRepository = contractorRepository;
    }

    @Override
    public void check(Contractor entity) throws InvalidEntryException {
        List<Contractor> contractors = contractorRepository.findAll();
        for (Contractor contractor : contractors) {
            if (Objects.equals(contractor.getCredentials().getUsername(), entity.getCredentials().getUsername())) {
                throw AlreadyUsedParameterException.with("Username", entity.getCredentials().getUsername());
            }
        }
        checkNext(entity);
    }
}
