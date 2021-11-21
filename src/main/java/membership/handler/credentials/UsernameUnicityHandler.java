package membership.handler.credentials;

import membership.common.user.Credentials;
import membership.handler.Handler;

import java.util.List;

public class UsernameUnicityHandler extends CredentialsHandler {
    private CredentialsHandler next;

    @Override
    public Handler<Credentials> setNext(Handler next) {
        this.next=(CredentialsHandler) next;
        return next;
    }

    @Override
    public String check(Credentials credentials) {
        List<String> unameList=List.of("paulzz", "doedoe", "lala", "lolo");
        for(String uname: unameList) {
            if (uname == credentials.getUsername()) {
                return "Username already exists";
            }
        }
        return this.checkNext(credentials);
    }
}
