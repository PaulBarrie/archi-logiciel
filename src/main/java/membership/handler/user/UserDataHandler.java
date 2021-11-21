package membership.handler.user;

import membership.common.user.User;
import membership.handler.Handler;
import membership.handler.validator.user.UserValidator;

public class UserDataHandler extends UserHandler {
    private UserHandler next;

    @Override
    public Handler<User> setNext(Handler next) {
        this.next = (UserHandler) next;
        return next;
    }

    @Override
    public String check(User user) {
        UserValidator validator = UserValidator.of(user);
        String error = validator.isValid();

        if( error != null) {
            return error;
        }

        return checkNext(user);
    }

}
