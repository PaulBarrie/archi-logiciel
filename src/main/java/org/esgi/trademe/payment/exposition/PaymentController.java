package org.esgi.trademe.payment.exposition;

import org.esgi.trademe.kernel.command.CommandBus;
import org.esgi.trademe.kernel.exceptions.InvalidEntryException;
import org.esgi.trademe.kernel.exceptions.PaymentRejectedException;
import org.esgi.trademe.kernel.query.QueryBus;
import org.esgi.trademe.member.application.retrieve.all.RetrieveMembers;
import org.esgi.trademe.member.domain.Member;
import org.esgi.trademe.member.domain.MemberID;
import org.esgi.trademe.member.exposition.MemberDTO;
import org.esgi.trademe.payment.application.create.CreatePayment;
import org.esgi.trademe.payment.application.retrieve.RetrievePaymentsByMemberID;
import org.esgi.trademe.payment.application.update.UsePayment;
import org.esgi.trademe.payment.domain.AccountIdentityPayment;
import org.esgi.trademe.payment.domain.CreditCardPayment;
import org.esgi.trademe.payment.domain.Payment;
import org.esgi.trademe.payment.domain.SubscriptionDetails;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
@RestController
public final class PaymentController {

    private final QueryBus queryBus;
    private final CommandBus commandBus;
    private final SubscriptionDetails subscriptionDetails;


    public PaymentController(QueryBus queryBus, CommandBus commandBus, SubscriptionDetails subscriptionDetails) {
        this.queryBus = queryBus;
        this.commandBus = commandBus;
        this.subscriptionDetails = subscriptionDetails;
    }

    @PostMapping(value="/payment", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PaymentDTO> addPayment(@RequestParam(required = true)  int memberID,
                                                 @RequestParam(required = true) Map<String, String> paymentDetails) throws InvalidEntryException, NoSuchAlgorithmException {

        if (paymentDetails.containsKey("owner") && paymentDetails.containsKey("number") && paymentDetails.containsKey("expiration")
        && paymentDetails.containsKey("security_number")) {
            // Then it's credit card
            final Payment payment = commandBus.send(CreatePayment.of(MemberID.of(memberID), CreditCardPayment.of(
                    paymentDetails.get("owner"), paymentDetails.get("number"), paymentDetails.get("expiration"),
                    paymentDetails.get("security_number"))
            ));
            PaymentDTO paymentDTO = PaymentDTO.of(payment);
            return ResponseEntity.ok(paymentDTO);
        } else if(paymentDetails.containsKey("account_identifier") && paymentDetails.containsKey("bank_identifier")) {
            // Then it's Account Identity
            final Payment payment = commandBus.send(CreatePayment.of(MemberID.of(memberID), AccountIdentityPayment.of(
                    paymentDetails.get("account_identifier"), paymentDetails.get("bank_identifier"))));
            PaymentDTO paymentDTO = PaymentDTO.of(payment);
            return ResponseEntity.ok(paymentDTO);
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping(value = "/payments", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PaymentsDTO> getAll() {
//        final List<PaymentDTO> members = queryBus.send(new RetrievePayment(paymentID));
        PaymentsDTO membersDTOResult = new PaymentsDTO();
        membersDTOResult.members = null;
        return ResponseEntity.ok(membersDTOResult);
    }

    //Every Month on the last Friday
    @Scheduled(cron = "* * * * * *", zone = "Europe/Paris")
    public void paySubscription() throws InvalidEntryException, NoSuchAlgorithmException {
        List<MemberDTO> members = queryBus.send(new RetrieveMembers());
        for(MemberDTO member: members) {
            List<Payment> payments = queryBus.send(new RetrievePaymentsByMemberID(member.getId()));
            if(payments.size() == 0) break;
            Payment payment = payments.get(0);
            Boolean response = commandBus.send(new UsePayment(payment.getPaymentMode(), subscriptionDetails.getPaymentMode(),
                    subscriptionDetails.getMonthlyAmount()));
            System.out.println(String.format("%s %s paid subscription", member.getFirstname(), member.getLastname()));

            if(!response) {
                throw new PaymentRejectedException(String.format("Member %s can't pay subscription with payment %s",
                        member.getId().toString(), payment.getId().toString()));
            }
        }
    }

//    @Scheduled(cron = "0 0 12 6L * ?", zone = "Europe/Paris")
//    public void payContractor() {
//        List<Project> projects = queryBus.send(new RetrieveProjectByStatus(ProjectStatus.ACCEPTED));
//        for(Project project: projects) {
//            Payment fromPayment =queryBus.send(new RetrievePaymentsByMemberID(project.getMemberID()));
//            Payment toPayment =queryBus.send(new RetrievePaymentsByContractorID(project.getMemberID()));
//            Boolean response = commandBus.send(new UsePayment(payment, null, 10F));
//            if(!response) {
//                throw new PaymentRejectedException(String.format("Member %s can't pay subscritpion with payment %s",
//                        member.getId().toString(), payment.getId().toString()));
//            }
//        }
//    }

}
