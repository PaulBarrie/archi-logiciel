package esgi.barrie.al.model.payment;

import esgi.barrie.al.model.user.User;

public class PaypalPayment extends Payment<Object>{
    private final String user;
    private final String token;

    protected PaypalPayment(String id, User user, Object pay, String user1, String token) {
        super(id, user, pay);
        this.user = user1;
        this.token = token;
    }



}
