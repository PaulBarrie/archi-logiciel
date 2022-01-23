package org.esgi.trademe;

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
import org.esgi.trademe.project.application.create.CreateProject;
import org.esgi.trademe.project.application.create.CreateProjectCommandHandler;
import org.esgi.trademe.project.application.create.CreateProjectEvent;
import org.esgi.trademe.project.application.retrieve.all.RetrieveProjects;
import org.esgi.trademe.project.application.retrieve.all.RetrieveProjectsHandler;
import org.esgi.trademe.project.application.retrieve.by_tradesman.RetrieveProjectByTradesman;
import org.esgi.trademe.project.application.retrieve.by_tradesman.RetrieveProjectByTradesmanHandler;
import org.esgi.trademe.project.application.retrieve.by_id.RetrieveProjectByID;
import org.esgi.trademe.project.application.retrieve.by_id.RetrieveProjectByIDHandler;
import org.esgi.trademe.project.application.update.AcceptProject;
import org.esgi.trademe.project.application.update.AcceptProjectCommandHandler;
import org.esgi.trademe.project.application.update.AcceptProjectEvent;
import org.esgi.trademe.project.application.update.AcceptProjectEventListener;
import org.esgi.trademe.project.exposition.ProjectRepository;
import org.esgi.trademe.project.infrastructure.InMemoryProjectRepository;
import org.esgi.trademe.trademan.application.create.CreateTradesman;
import org.esgi.trademe.trademan.application.create.CreateTradesmanCommandHandler;
import org.esgi.trademe.trademan.application.create.CreateTrademanEventListener;
import org.esgi.trademe.trademan.application.create.education_level.AddTradesmanEducationLevel;
import org.esgi.trademe.trademan.application.create.education_level.AddTradesmanEducationLevelCommandHandler;
import org.esgi.trademe.trademan.application.create.experience.AddTradesmanExperience;
import org.esgi.trademe.trademan.application.create.experience.AddTradesmanExperienceCommandHandler;
import org.esgi.trademe.trademan.application.create.experience.AddTradesmanExperienceEvent;
import org.esgi.trademe.trademan.application.create.experience.AddTrademanExperienceEventListener;
import org.esgi.trademe.trademan.application.retrieve.all.RetrieveTradesmen;
import org.esgi.trademe.trademan.application.retrieve.all.RetrieveTradesmenHandler;
import org.esgi.trademe.trademan.application.retrieve.by_id.RetrieveTradesmanByID;
import org.esgi.trademe.trademan.application.retrieve.by_id.RetrieveTradesmanByIDHandler;
import org.esgi.trademe.trademan.application.retrieve.search.RetrieveTradesmanByEducation;
import org.esgi.trademe.trademan.application.retrieve.search.RetrieveTradesmanByEducationHandler;
import org.esgi.trademe.trademan.domain.TradesmanRepository;
import org.esgi.trademe.trademan.infrastructure.InMemoryTradesmanRepository;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.context.annotation.Configuration
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
    public ProjectRepository contractRepository() {return new InMemoryProjectRepository();}

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
        listenerMap.put(AddTradesmanExperienceEvent.class, List.of(new AddTrademanExperienceEventListener()));
        return new DefaultEventDispatcher(listenerMap);
    }

    @Bean
    public EventDispatcher<Event> contractEventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        listenerMap.put(CreateProjectEvent.class, List.of(new CreateTrademanEventListener()));
        listenerMap.put(AcceptProjectEvent.class, List.of(new AcceptProjectEventListener()));
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

    /* CONTRACTS */

    @Bean
    public CreateProjectCommandHandler createContractCommandHandler() {
        return CreateProjectCommandHandler.of(contractRepository(), contractEventDispatcher());
    }

    @Bean
    public AcceptProjectCommandHandler acceptContractCommandHandler() {
        return AcceptProjectCommandHandler.of(contractRepository(), tradesmanEventDispatcher());
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
                Map.entry(CreateProject.class, CreateProjectCommandHandler.of(contractRepository(), contractEventDispatcher())),
                Map.entry(AcceptProject.class, AcceptProjectCommandHandler.of(contractRepository(), contractEventDispatcher()))
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
                Map.entry(RetrieveTradesmanByEducation.class, new RetrieveTradesmanByEducationHandler(tradesmanRepository())),
                Map.entry(RetrieveProjects.class, new RetrieveProjectsHandler(contractRepository())),
                Map.entry(RetrieveProjectByID.class, new RetrieveProjectByIDHandler(contractRepository())),
                Map.entry(RetrieveProjectByTradesman.class, new RetrieveProjectByTradesmanHandler(contractRepository()))
                );
        return new SimpleQueryBus(queryHandlerMap);
    }


}
