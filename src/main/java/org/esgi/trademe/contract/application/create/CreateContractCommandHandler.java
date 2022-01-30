package org.esgi.trademe.contract.application.create;




import org.esgi.trademe.contract.domain.Contract;
import org.esgi.trademe.contract.domain.ContractID;
import org.esgi.trademe.contract.exposition.ContractRepository;
import org.esgi.trademe.kernel.command.CommandHandler;
import org.esgi.trademe.kernel.event.Event;
import org.esgi.trademe.kernel.event.EventDispatcher;

public final class CreateContractCommandHandler implements CommandHandler<CreateContract, Contract> {

    private final ContractRepository contractRepository;
    private final EventDispatcher<Event> eventDispatcher;

    public CreateContractCommandHandler(ContractRepository contractRepository, EventDispatcher<Event> eventDispatcher) {
        this.contractRepository = contractRepository;
        this.eventDispatcher = eventDispatcher;
    }

    public static CreateContractCommandHandler of(ContractRepository contractRepository, EventDispatcher<Event> eventDispatcher) {
        return new CreateContractCommandHandler(contractRepository, eventDispatcher);
    }

    public Contract handle(CreateContract createContract) {
        final ContractID contractID = contractRepository.nextIdentity();
        Contract contract = Contract.of(contractID, createContract.getProjectID(), createContract.getTradesmanID(),
                createContract.getHourlyWage(), createContract.getHoursPerMonth(), createContract.getWorkDomain());
        contractRepository.add(contract);
        eventDispatcher.dispatch(new CreateContractEvent(contractID));
        return contract;
    }
}
