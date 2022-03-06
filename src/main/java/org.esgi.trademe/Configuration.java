package org.esgi.trademe;

import org.esgi.trademe.contract.application.create.CreateContractEventListener;
import org.esgi.trademe.contract.application.retrieve.by_project.RetrieveContractByProject;
import org.esgi.trademe.contract.application.retrieve.by_project.RetrieveContractByProjectEvent;
import org.esgi.trademe.contract.application.retrieve.by_project.RetrieveContractByProjectEventListener;
import org.esgi.trademe.contract.application.retrieve.by_project.RetrieveContractByProjectHandler;
import org.esgi.trademe.payment.application.retrieve.RetrievePaymentsByContractorID;
import org.esgi.trademe.payment.application.retrieve.RetrievePaymentsByContractorIDHandler;
import org.esgi.trademe.payment.application.update.UsePayment;
import org.esgi.trademe.payment.application.update.UsePaymentCommandHandler;
import org.esgi.trademe.payment.application.update.UsePaymentEvent;
import org.esgi.trademe.payment.application.update.UsePaymentEventListener;
import org.esgi.trademe.payment.domain.AccountIdentityPayment;
import org.esgi.trademe.payment.domain.PaymentService;
import org.esgi.trademe.payment.domain.SubscriptionDetails;
import org.esgi.trademe.payment.infrastructure.StubbedPaymentService;
import org.esgi.trademe.contract.application.create.CreateContract;
import org.esgi.trademe.contract.application.create.CreateContractCommandHandler;
import org.esgi.trademe.contract.application.create.CreateContractEvent;
import org.esgi.trademe.contract.application.retrieve.all.RetrieveContracts;
import org.esgi.trademe.contract.application.retrieve.all.RetrieveContractsHandler;
import org.esgi.trademe.contract.application.retrieve.by_tradesman.RetrieveContractByTradesman;
import org.esgi.trademe.contract.application.retrieve.by_tradesman.RetrieveContractByTradesmanHandler;
import org.esgi.trademe.contract.application.retrieve.by_id.RetrieveContractByID;
import org.esgi.trademe.contract.application.retrieve.by_id.RetrieveContractByIDHandler;
import org.esgi.trademe.contract.application.update.accept.AcceptContract;
import org.esgi.trademe.contract.application.update.accept.AcceptContractCommandHandler;
import org.esgi.trademe.contract.application.update.accept.AcceptContractEvent;
import org.esgi.trademe.contract.application.update.accept.AcceptContractEventListener;
import org.esgi.trademe.contract.exposition.ContractRepository;
import org.esgi.trademe.contract.infrastructure.InMemoryContractRepository;
import org.esgi.trademe.project.application.create.CreateProject;
import org.esgi.trademe.project.application.create.CreateProjectCommandHandler;
import org.esgi.trademe.project.application.create.CreateProjectEvent;
import org.esgi.trademe.project.application.create.CreateProjectEventListener;
import org.esgi.trademe.project.application.retrieve.all.RetrieveProjects;
import org.esgi.trademe.project.application.retrieve.all.RetrieveProjectsEvent;
import org.esgi.trademe.project.application.retrieve.all.RetrieveProjectsEventListener;
import org.esgi.trademe.project.application.retrieve.all.RetrieveProjectsHandler;
import org.esgi.trademe.project.application.retrieve.by_contractor.RetrieveProjectByContractor;
import org.esgi.trademe.project.application.retrieve.by_contractor.RetrieveProjectByContractorEvent;
import org.esgi.trademe.project.application.retrieve.by_contractor.RetrieveProjectByContractorEventListener;
import org.esgi.trademe.project.application.retrieve.by_contractor.RetrieveProjectByContractorHandler;
import org.esgi.trademe.project.application.retrieve.by_id.RetrieveProjectByID;
import org.esgi.trademe.project.application.retrieve.by_id.RetrieveProjectByIDEvent;
import org.esgi.trademe.project.application.retrieve.by_id.RetrieveProjectByIDEventListener;
import org.esgi.trademe.project.application.retrieve.by_id.RetrieveProjectByIDHandler;
import org.esgi.trademe.project.application.retrieve.by_status.RetrieveProjectByStatusEvent;
import org.esgi.trademe.project.application.retrieve.by_status.RetrieveProjectByStatusEventListener;
import org.esgi.trademe.project.application.update.activate.ActivateProject;
import org.esgi.trademe.project.application.update.activate.ActivateProjectCommandHandler;
import org.esgi.trademe.project.application.update.activate.ActivateProjectEvent;
import org.esgi.trademe.project.application.update.activate.ActivateProjectEventListener;
import org.esgi.trademe.project.application.update.assign_tradesmen.AssignTradesmenToProject;
import org.esgi.trademe.project.application.update.assign_tradesmen.AssignTradesmenToProjectCommandHandler;
import org.esgi.trademe.project.application.update.assign_tradesmen.AssignTradesmenToProjectEvent;
import org.esgi.trademe.project.application.update.assign_tradesmen.AssignTradesmenToProjectEventListener;
import org.esgi.trademe.project.exposition.ProjectRepository;
import org.esgi.trademe.project.infrastructure.InMemoryProjectRepository;
import org.esgi.trademe.tradesman.application.create.CreateTradesman;
import org.esgi.trademe.tradesman.application.create.CreateTradesmanCommandHandler;
import org.esgi.trademe.tradesman.application.create.CreateTradesmanEventListener;
import org.esgi.trademe.tradesman.application.create.CreateTradesmanEvent;
import org.esgi.trademe.tradesman.application.create.education_level.AddTradesmanEducationLevel;
import org.esgi.trademe.tradesman.application.create.education_level.AddTradesmanEducationLevelCommandHandler;
import org.esgi.trademe.tradesman.application.create.education_level.AddTradesmanEducationLevelEvent;
import org.esgi.trademe.tradesman.application.create.education_level.AddTradesmanEducationLevelEventListener;
import org.esgi.trademe.tradesman.application.create.experience.AddTradesmanExperience;
import org.esgi.trademe.tradesman.application.create.experience.AddTradesmanExperienceCommandHandler;
import org.esgi.trademe.tradesman.application.create.experience.AddTradesmanExperienceEvent;
import org.esgi.trademe.tradesman.application.create.experience.AddTrademanExperienceEventListener;
import org.esgi.trademe.tradesman.application.retrieve.all.RetrieveTradesmen;
import org.esgi.trademe.tradesman.application.retrieve.all.RetrieveTradesmenEvent;
import org.esgi.trademe.tradesman.application.retrieve.all.RetrieveTradesmenEventListener;
import org.esgi.trademe.tradesman.application.retrieve.all.RetrieveTradesmenHandler;
import org.esgi.trademe.tradesman.application.retrieve.by_id.RetrieveTradesmanByID;
import org.esgi.trademe.tradesman.application.retrieve.by_id.RetrieveTradesmanByIDEvent;
import org.esgi.trademe.tradesman.application.retrieve.by_id.RetrieveTradesmanByIDEventListener;
import org.esgi.trademe.tradesman.application.retrieve.by_id.RetrieveTradesmanByIDHandler;
import org.esgi.trademe.tradesman.application.retrieve.search.RetrieveTradesmanByDomain;
import org.esgi.trademe.tradesman.application.retrieve.search.RetrieveTradesmanByDomainEvent;
import org.esgi.trademe.tradesman.application.retrieve.search.RetrieveTradesmanByDomainEventListener;
import org.esgi.trademe.tradesman.application.retrieve.search.RetrieveTradesmanByDomainHandler;
import org.esgi.trademe.tradesman.domain.TradesmanRepository;
import org.esgi.trademe.tradesman.infrastructure.InMemoryTradesmanRepository;
import org.esgi.trademe.kernel.command.Command;
import org.esgi.trademe.kernel.command.CommandBus;
import org.esgi.trademe.kernel.command.CommandHandler;
import org.esgi.trademe.kernel.command.SimpleCommandBus;
import org.esgi.trademe.kernel.event.Event;
import org.esgi.trademe.kernel.event.EventDispatcher;
import org.esgi.trademe.kernel.event.EventListener;
import org.esgi.trademe.kernel.query.Query;
import org.esgi.trademe.kernel.query.QueryBus;
import org.esgi.trademe.kernel.query.QueryHandler;
import org.esgi.trademe.kernel.query.SimpleQueryBus;
import org.esgi.trademe.contractor.application.create.CreateContractor;
import org.esgi.trademe.contractor.application.create.CreateContractorCommandHandler;
import org.esgi.trademe.contractor.application.create.CreateContractorEvent;
import org.esgi.trademe.contractor.application.create.CreateContractorEventListener;
import org.esgi.trademe.contractor.application.retrieve.all.RetrieveContractors;
import org.esgi.trademe.contractor.application.retrieve.all.RetrieveContractorsHandler;
import org.esgi.trademe.contractor.application.retrieve.by_id.RetrieveContractorByID;
import org.esgi.trademe.contractor.application.retrieve.by_id.RetrieveContractorByIDHandler;
import org.esgi.trademe.contractor.application.update.ModifyContractorAddressCommandHandler;
import org.esgi.trademe.contractor.application.update.ModifyContractorAddressEvent;
import org.esgi.trademe.contractor.application.update.ModifyContractorAddressEventListener;
import org.esgi.trademe.contractor.domain.ContractorRepository;
import org.esgi.trademe.contractor.infrastructure.DefaultEventDispatcher;
import org.esgi.trademe.contractor.infrastructure.InMemoryContractorRepository;
import org.esgi.trademe.payment.application.create.CreatePayment;
import org.esgi.trademe.payment.application.create.CreatePaymentCommandHandler;
import org.esgi.trademe.payment.application.create.CreatePaymentEvent;
import org.esgi.trademe.payment.application.create.CreatePaymentEventListener;
import org.esgi.trademe.payment.domain.PaymentRepository;
import org.esgi.trademe.payment.infrastructure.InMemoryPaymentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.context.annotation.Configuration
@ComponentScan
public class Configuration {

    /*
        REPOSITORIES
     */
    @Bean
    public ContractorRepository contractorRepository() {
        return new InMemoryContractorRepository();
    }

    @Bean
    public PaymentRepository paymentRepository() {
        return new InMemoryPaymentRepository();
    }

    @Bean
    public TradesmanRepository tradesmanRepository() { return new InMemoryTradesmanRepository();}

    @Bean
    public ProjectRepository projectRepository() { return new InMemoryProjectRepository();}

    @Bean
    public ContractRepository contractRepository() {return new InMemoryContractRepository();}

    @Bean
    public PaymentService paymentService() {return new StubbedPaymentService();}

    @Bean
    public SubscriptionDetails subscriptionDetails() {
        return new SubscriptionDetails(AccountIdentityPayment.of("FR45664654556744", "CMUT678797"), 10F);
    }
    /*
        EVENT DISPATCHERS
     */

    @Bean
    public EventDispatcher<Event> contractorEventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        listenerMap.put(ModifyContractorAddressEvent.class, List.of(new ModifyContractorAddressEventListener()));
        listenerMap.put(CreateContractorEvent.class, List.of(new CreateContractorEventListener()));
        return new DefaultEventDispatcher(listenerMap);
    }

    @Bean
    public EventDispatcher<Event> paymentEventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        listenerMap.put(CreatePaymentEvent.class, List.of(new CreatePaymentEventListener()));
        listenerMap.put(UsePaymentEvent.class, List.of(new UsePaymentEventListener()));
        return new DefaultEventDispatcher(listenerMap);
    }

    @Bean
    public EventDispatcher<Event> tradesmanEventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        listenerMap.put(CreateTradesmanEvent.class, List.of(new CreateTradesmanEventListener()));
        listenerMap.put(AddTradesmanEducationLevelEvent.class, List.of(new AddTradesmanEducationLevelEventListener()));
        listenerMap.put(AddTradesmanExperienceEvent.class, List.of(new AddTrademanExperienceEventListener()));
        listenerMap.put(RetrieveTradesmanByDomainEvent.class, List.of(new RetrieveTradesmanByDomainEventListener()));
        listenerMap.put(RetrieveTradesmenEvent.class, List.of(new RetrieveTradesmenEventListener()));
        listenerMap.put(RetrieveTradesmanByIDEvent.class, List.of(new RetrieveTradesmanByIDEventListener()));
        return new DefaultEventDispatcher(listenerMap);
    }

    @Bean
    public EventDispatcher<Event> projectEventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        listenerMap.put(CreateProjectEvent.class, List.of(new CreateProjectEventListener()));
        listenerMap.put(ActivateProjectEvent.class, List.of(new ActivateProjectEventListener()));
        listenerMap.put(AssignTradesmenToProjectEvent.class, List.of(new AssignTradesmenToProjectEventListener()));
        listenerMap.put(RetrieveProjectsEvent.class, List.of(new RetrieveProjectsEventListener()));
        listenerMap.put(RetrieveProjectByIDEvent.class, List.of(new RetrieveProjectByIDEventListener()));
        listenerMap.put(RetrieveProjectByStatusEvent.class, List.of(new RetrieveProjectByStatusEventListener()));
        listenerMap.put(RetrieveProjectByContractorEvent.class, List.of(new RetrieveProjectByContractorEventListener()));
        return new DefaultEventDispatcher(listenerMap);
    }

    @Bean
    public EventDispatcher<Event> contractEventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        listenerMap.put(CreateContractEvent.class, List.of(new CreateContractEventListener()));
        listenerMap.put(AcceptContractEvent.class, List.of(new AcceptContractEventListener()));
        listenerMap.put(RetrieveContractByProjectEvent.class, List.of(new RetrieveContractByProjectEventListener()));
        return new DefaultEventDispatcher(listenerMap);
    }

    /*
        COMMAND HANDLERS
     */

    /* CONTRACTORS */
    @Bean
    public CreateContractorCommandHandler createContractorCommandHandler() {
        return CreateContractorCommandHandler.of(contractorRepository(), contractorEventDispatcher());
    }

    @Bean
    public ModifyContractorAddressCommandHandler modifyUserAddressCommandHandler() {
        return new ModifyContractorAddressCommandHandler(contractorRepository(), contractorEventDispatcher());
    }

    /* PAYMENT */

    @Bean
    public CreatePaymentCommandHandler createPaymentCommandHandler() {
        return CreatePaymentCommandHandler.of(paymentRepository(), paymentEventDispatcher());
    }

    @Bean
    public AddTradesmanExperienceCommandHandler createTradesmanCommandHandler() {
        return AddTradesmanExperienceCommandHandler.of(tradesmanRepository(), tradesmanEventDispatcher());
    }

    @Bean
    public CreateProjectCommandHandler createProjectCommandHandler() {
        return CreateProjectCommandHandler.of(projectRepository(), projectEventDispatcher());
    }
    /* CONTRACTS */

    @Bean
    public CreateContractCommandHandler createContractCommandHandler() {
        return CreateContractCommandHandler.of(contractRepository(), contractEventDispatcher());
    }

    @Bean
    public AcceptContractCommandHandler acceptContractCommandHandler() {
        return AcceptContractCommandHandler.of(contractRepository(), tradesmanEventDispatcher());
    }

    @Bean
    public CommandBus commandBus() {
        final Map<Class<? extends Command>, CommandHandler> commandHandlerMap = Map.ofEntries(
                Map.entry(CreateContractor.class, CreateContractorCommandHandler.of(contractorRepository(), contractorEventDispatcher())),
                Map.entry(CreatePayment.class, CreatePaymentCommandHandler.of(paymentRepository(), paymentEventDispatcher())),
                Map.entry(UsePayment.class, UsePaymentCommandHandler.of(paymentRepository(), paymentService(), paymentEventDispatcher())),
                Map.entry(CreateTradesman.class, CreateTradesmanCommandHandler.of(tradesmanRepository(), tradesmanEventDispatcher())),
                Map.entry(AddTradesmanExperience.class, AddTradesmanExperienceCommandHandler.of(tradesmanRepository(), tradesmanEventDispatcher())),
                Map.entry(AddTradesmanEducationLevel.class, AddTradesmanEducationLevelCommandHandler.of(tradesmanRepository(), tradesmanEventDispatcher())),
                Map.entry(CreateProject.class, CreateProjectCommandHandler.of(projectRepository(), projectEventDispatcher())),
                Map.entry(AssignTradesmenToProject.class, AssignTradesmenToProjectCommandHandler.of(projectRepository(), contractRepository(), tradesmanRepository(), projectEventDispatcher())),
                Map.entry(ActivateProject.class, ActivateProjectCommandHandler.of(projectRepository(), contractRepository(), projectEventDispatcher())),
                Map.entry(CreateContract.class, CreateContractCommandHandler.of(contractRepository(), contractEventDispatcher())),
                Map.entry(AcceptContract.class, AcceptContractCommandHandler.of(contractRepository(), contractEventDispatcher()))
                );
        return new SimpleCommandBus(commandHandlerMap);
    }

    /*
        QUERY HANDLERS
     */
    @Bean
    public QueryBus queryBus() {
        final Map<Class<? extends Query>, QueryHandler> queryHandlerMap = Map.ofEntries(
                Map.entry(RetrieveContractors.class, new RetrieveContractorsHandler(contractorRepository())),
                Map.entry(RetrieveContractorByID.class, new RetrieveContractorByIDHandler(contractorRepository())),
                Map.entry(RetrievePaymentsByContractorID.class, new RetrievePaymentsByContractorIDHandler(paymentRepository())),
                Map.entry(RetrieveTradesmen.class, new RetrieveTradesmenHandler(tradesmanRepository())),
                Map.entry(RetrieveTradesmanByID.class, new RetrieveTradesmanByIDHandler(tradesmanRepository())),
                Map.entry(RetrieveTradesmanByDomain.class, new RetrieveTradesmanByDomainHandler(tradesmanRepository())),
                Map.entry(RetrieveProjectByContractor.class, new RetrieveProjectByContractorHandler(projectRepository())),
                Map.entry(RetrieveProjectByID.class, new RetrieveProjectByIDHandler(projectRepository(), contractRepository())),
                Map.entry(RetrieveProjects.class, new RetrieveProjectsHandler(projectRepository())),
                Map.entry(RetrieveContracts.class, new RetrieveContractsHandler(contractRepository())),
                Map.entry(RetrieveContractByID.class, new RetrieveContractByIDHandler(contractRepository())),
                Map.entry(RetrieveContractByTradesman.class, new RetrieveContractByTradesmanHandler(contractRepository())),
                Map.entry(RetrieveContractByProject.class, new RetrieveContractByProjectHandler(contractRepository()))
                );
        return new SimpleQueryBus(queryHandlerMap);
    }


}
