package org.esgi.trademe;

import org.esgi.trademe.kernel.Timer;
import org.esgi.trademe.payment.domain.AccountIdentityPayment;
import org.esgi.trademe.payment.domain.PaymentService;
import org.esgi.trademe.payment.domain.SubscriptionDetails;
import org.esgi.trademe.payment.infrastructure.StubbedPaymentService;
import org.esgi.trademe.project.application.create.CreateProject;
import org.esgi.trademe.project.application.create.CreateProjectCommandHandler;
import org.esgi.trademe.project.application.create.CreateProjectEvent;
import org.esgi.trademe.project.application.retrieve.all.RetrieveProjects;
import org.esgi.trademe.project.application.retrieve.all.RetrieveProjectsHandler;
import org.esgi.trademe.project.application.retrieve.by_contractor.RetrieveProjectByContractor;
import org.esgi.trademe.project.application.retrieve.by_contractor.RetrieveProjectByContractorHandler;
import org.esgi.trademe.project.application.retrieve.by_id.RetrieveProjectByID;
import org.esgi.trademe.project.application.retrieve.by_id.RetrieveProjectByIDHandler;
import org.esgi.trademe.project.application.update.AcceptProject;
import org.esgi.trademe.project.application.update.AcceptProjectCommandHandler;
import org.esgi.trademe.project.application.update.AcceptProjectEvent;
import org.esgi.trademe.project.application.update.AcceptProjectEventListener;
import org.esgi.trademe.project.exposition.ProjectRepository;
import org.esgi.trademe.project.infrastructure.InMemoryProjectRepository;
import org.esgi.trademe.contractor.application.create.CreateContractor;
import org.esgi.trademe.contractor.application.create.CreateContractorCommandHandler;
import org.esgi.trademe.contractor.application.create.CreateContractorEventListener;
import org.esgi.trademe.contractor.application.create.education_level.AddContractorEducationLevel;
import org.esgi.trademe.contractor.application.create.education_level.AddContractorEducationLevelCommandHandler;
import org.esgi.trademe.contractor.application.create.experience.AddContractorExperience;
import org.esgi.trademe.contractor.application.create.experience.AddContractorExperienceCommandHandler;
import org.esgi.trademe.contractor.application.create.experience.AddContractorExperienceEvent;
import org.esgi.trademe.contractor.application.create.experience.AddContractorExperienceEventListener;
import org.esgi.trademe.contractor.application.retrieve.all.RetrieveContractors;
import org.esgi.trademe.contractor.application.retrieve.all.RetrieveContractorsHandler;
import org.esgi.trademe.contractor.application.retrieve.by_id.RetrieveContractorByID;
import org.esgi.trademe.contractor.application.retrieve.by_id.RetrieveContractorByIDHandler;
import org.esgi.trademe.contractor.application.retrieve.search.RetrieveContractorByEducation;
import org.esgi.trademe.contractor.application.retrieve.search.RetrieveContractorByEducationHandler;
import org.esgi.trademe.contractor.domain.ContractorRepository;
import org.esgi.trademe.contractor.infrastructure.InMemoryContractorRepository;
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
import org.esgi.trademe.member.application.create.CreateMember;
import org.esgi.trademe.member.application.create.CreateMemberCommandHandler;
import org.esgi.trademe.member.application.create.CreateMemberEvent;
import org.esgi.trademe.member.application.create.CreateMemberEventListener;
import org.esgi.trademe.member.application.retrieve.all.RetrieveMembers;
import org.esgi.trademe.member.application.retrieve.all.RetrieveMembersHandler;
import org.esgi.trademe.member.application.retrieve.by_id.RetrieveMemberByID;
import org.esgi.trademe.member.application.retrieve.by_id.RetrieveMemberByIDHandler;
import org.esgi.trademe.member.application.update.ModifyMemberAddressCommandHandler;
import org.esgi.trademe.member.application.update.ModifyMemberAddressEvent;
import org.esgi.trademe.member.application.update.ModifyMemberAddressEventListener;
import org.esgi.trademe.member.domain.MemberRepository;
import org.esgi.trademe.member.infrastructure.DefaultEventDispatcher;
import org.esgi.trademe.member.infrastructure.InMemoryMemberRepository;
import org.esgi.trademe.payment.application.create.CreatePayment;
import org.esgi.trademe.payment.application.create.CreatePaymentCommandHandler;
import org.esgi.trademe.payment.application.create.CreatePaymentEvent;
import org.esgi.trademe.payment.application.create.CreatePaymentEventListener;
import org.esgi.trademe.payment.domain.PaymentRepository;
import org.esgi.trademe.payment.infrastructure.InMemoryPaymentRepository;
import org.springframework.context.annotation.Bean;

import java.sql.Time;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.context.annotation.Configuration
public class Configuration {

    /*
        REPOSITORIES
     */
    @Bean
    public MemberRepository memberRepository() {
        return new InMemoryMemberRepository();
    }

    @Bean
    public PaymentRepository paymentRepository() {
        return new InMemoryPaymentRepository();
    }

    @Bean
    public ContractorRepository contractorRepository() { return new InMemoryContractorRepository();}

    @Bean
    public ProjectRepository contractRepository() {return new InMemoryProjectRepository();}

    @Bean
    public PaymentService paymentService() {return new StubbedPaymentService();}

    // "0 0 12 6L * ?" -> every month
//    @Bean
//    public Timer paymentTimer() {
//        return Timer.of("30 0 0 ? * * *", "Europe/Paris");
//    }


    @Bean
    public SubscriptionDetails subscriptionDetails() {
        return new SubscriptionDetails(AccountIdentityPayment.of("FR45664654556744", "CMUT678797"), 10F);
    }
    /*
        EVENT DISPATCHERS
     */

    @Bean
    public EventDispatcher<Event> memberEventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        listenerMap.put(ModifyMemberAddressEvent.class, List.of(new ModifyMemberAddressEventListener()));
        listenerMap.put(CreateMemberEvent.class, List.of(new CreateMemberEventListener()));
        return new DefaultEventDispatcher(listenerMap);
    }

    @Bean
    public EventDispatcher<Event> paymentEventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        listenerMap.put(CreatePaymentEvent.class, List.of(new CreatePaymentEventListener()));
        return new DefaultEventDispatcher(listenerMap);
    }

    @Bean
    public EventDispatcher<Event> contractorEventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        listenerMap.put(AddContractorExperienceEvent.class, List.of(new AddContractorExperienceEventListener()));
        return new DefaultEventDispatcher(listenerMap);
    }

    @Bean
    public EventDispatcher<Event> contractEventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        listenerMap.put(CreateProjectEvent.class, List.of(new CreateContractorEventListener()));
        listenerMap.put(AcceptProjectEvent.class, List.of(new AcceptProjectEventListener()));
        return new DefaultEventDispatcher(listenerMap);
    }

    /*
        COMMAND HANDLERS
     */

    /* MEMBERS */
    @Bean
    public CreateMemberCommandHandler createMemberCommandHandler() {
        return CreateMemberCommandHandler.of(memberRepository(), memberEventDispatcher());
    }

    @Bean
    public ModifyMemberAddressCommandHandler modifyUserAddressCommandHandler() {
        return new ModifyMemberAddressCommandHandler(memberRepository(), memberEventDispatcher());
    }

    /* PAYMENT */

    @Bean
    public CreatePaymentCommandHandler createPaymentCommandHandler() {
        return CreatePaymentCommandHandler.of(paymentRepository(), paymentEventDispatcher());
    }

    @Bean
    public AddContractorExperienceCommandHandler createContractorCommandHandler() {
        return AddContractorExperienceCommandHandler.of(contractorRepository(), contractorEventDispatcher());
    }

    /* CONTRACTS */

    @Bean
    public CreateProjectCommandHandler createContractCommandHandler() {
        return CreateProjectCommandHandler.of(contractRepository(), contractEventDispatcher());
    }

    @Bean
    public AcceptProjectCommandHandler acceptContractCommandHandler() {
        return AcceptProjectCommandHandler.of(contractRepository(), contractorEventDispatcher());
    }

    @Bean
    public CommandBus commandBus() {
        final Map<Class<? extends Command>, CommandHandler> commandHandlerMap = Map.ofEntries(
                Map.entry(CreateMember.class, CreateMemberCommandHandler.of(memberRepository(), memberEventDispatcher())),
                Map.entry(CreatePayment.class, CreatePaymentCommandHandler.of(paymentRepository(), paymentEventDispatcher())),
                Map.entry(CreateContractor.class, CreateContractorCommandHandler.of(contractorRepository(), contractorEventDispatcher())),
                Map.entry(AddContractorExperience.class, AddContractorExperienceCommandHandler.of(contractorRepository(), contractorEventDispatcher())),
                Map.entry(AddContractorEducationLevel.class, AddContractorEducationLevelCommandHandler.of(contractorRepository(), contractorEventDispatcher())),
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
                Map.entry(RetrieveMembers.class, new RetrieveMembersHandler(memberRepository())),
                Map.entry(RetrieveMemberByID.class, new RetrieveMemberByIDHandler(memberRepository())),
                Map.entry(RetrieveContractors.class, new RetrieveContractorsHandler(contractorRepository())),
                Map.entry(RetrieveContractorByID.class, new RetrieveContractorByIDHandler(contractorRepository())),
                Map.entry(RetrieveContractorByEducation.class, new RetrieveContractorByEducationHandler(contractorRepository())),
                Map.entry(RetrieveProjects.class, new RetrieveProjectsHandler(contractRepository())),
                Map.entry(RetrieveProjectByID.class, new RetrieveProjectByIDHandler(contractRepository())),
                Map.entry(RetrieveProjectByContractor.class, new RetrieveProjectByContractorHandler(contractRepository()))
                );
        return new SimpleQueryBus(queryHandlerMap);
    }


}
