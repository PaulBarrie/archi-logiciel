package org.esgi.trademe.contract.application.update.accept;



import org.esgi.trademe.contract.domain.Contract;
import org.esgi.trademe.contract.domain.ContractStatus;
import org.esgi.trademe.contract.exposition.ContractRepository;
import org.esgi.trademe.kernel.command.CommandHandler;
import org.esgi.trademe.kernel.event.Event;
import org.esgi.trademe.kernel.event.EventDispatcher;

public final class AcceptContractCommandHandler implements CommandHandler<AcceptContract, Contract> {

    private final ContractRepository contractRepository;
    private final EventDispatcher<Event> eventDispatcher;

    public AcceptContractCommandHandler(ContractRepository contractRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.contractRepository = contractRepository;
        this.eventDispatcher = eventEventDispatcher;
    }


    public static AcceptContractCommandHandler of(ContractRepository contractRepository, EventDispatcher<Event> eventEventDispatcher) {
        return new AcceptContractCommandHandler(contractRepository,eventEventDispatcher);
    }

    public Contract handle(AcceptContract createTradesman) {
        Contract contract = contractRepository.findById(createTradesman.getContractID());
        contract.setContractStatus(ContractStatus.ACCEPTED);
        contractRepository.add(contract);
        return contract;
    }
}
