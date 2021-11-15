package esgi.barrie.al.model.payment;

import esgi.barrie.al.model.user.User;

public abstract class Payment<T> {
    private String id;
    private User user;
    private T pay;

    protected Payment(String id, User user, T pay) {
        this.id = id;
        this.user = user;
        this.pay = pay;
    }
}
