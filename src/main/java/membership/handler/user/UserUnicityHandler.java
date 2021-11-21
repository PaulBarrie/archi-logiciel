package membership.handler.user;

import membership.common.user.User;
import membership.handler.Handler;

import java.util.List;

public class UserUnicityHandler extends UserHandler {
    UserHandler next;

    @Override
    public Handler<User> setNext(Handler next) {
        this.next=(UserHandler) next;
        return next;
    }


    @Override
    public String checkNext(User user) {
        if (next == null) {
            return null;
        }
        return next.check(user);
    }

    @Override
    public String check(User user) {
        List<User> existingUser = List.of(
                User.of("Paul", "Barrié", "31/10/1995", "paul@barrie.fr", null, null),
                User.of("John", "Doe", "31/11/1956", "john@doe.com", null, null)
                );
        for (User u: existingUser) {
            if(user.getEmail() == u.getEmail()) {
                return "Email already used";
            }
            if(user.getFirstName() == u.getFirstName() & user.getLastName() == u.getLastName() && u.getBirth() == u.getBirth()) {
                return "User" + user.getFirstName() + " " + user.getLastName() + ", born the " + u.getBirth() + "already exists.";
            }
        }
        return checkNext(user);
    }
}
