import membership.common.payment.CBPayment;
import membership.common.user.User;
import membership.service.MembershipService;
import membership.service.MembershipWithCBService;
import payment.service.CBContractorService;
import payment.service.ContractorService;

import java.util.Map;

public class Main   {

    public static void main(String[] args) throws InterruptedException {
        // Registration process
        Map<String,String> userDetails= Map.ofEntries(
                Map.entry("firstname", "paul"),
                Map.entry("lastname", "barrié"),
                Map.entry("birth", "31/10/1995"),
                Map.entry("email", "paul@barrie.fr"));

        Map<String,String> credentials= Map.ofEntries(
                Map.entry("username", "paul"),
                Map.entry("password", "P@55word"));


        Map<String,String> payment= Map.ofEntries(
                Map.entry("owner", "Paul Barrié"),
                Map.entry("card_number", "5667 8954 7892 456 32"),
                Map.entry("expiration_date", "12/2025"),
                Map.entry("cvc", "123"));

        MembershipService service = new MembershipWithCBService();
        User user = service.registerUser(userDetails, credentials, payment);
        // Payment process
        ContractorService contractorService = new CBContractorService((float)30, (CBPayment) user.getPayment());
        contractorService.pay();
    }
}
