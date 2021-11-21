package membership.handler.user;


import membership.common.user.User;
import membership.handler.Handler;

public abstract class UserHandler implements Handler<User> {
    private UserHandler next;

    @Override
    public abstract String check(User user);

    @Override
    public Handler<User> setNext(Handler<User> next) {
        this.next = (UserHandler) next;
        return next;
    }

    @Override
    public String checkNext(User user) {
        if (next == null) {
            return null;
        }
        return next.check(user);
    }
}
