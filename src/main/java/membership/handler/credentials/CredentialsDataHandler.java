package membership.handler.credentials;

import membership.common.user.Credentials;
import membership.handler.Handler;
import membership.handler.validator.user.CredentialsValidator;

public class CredentialsDataHandler extends CredentialsHandler {
    private CredentialsHandler next;

    @Override
    public Handler<Credentials> setNext(Handler next) {
        this.next=(CredentialsHandler) next;
        return next;
    }

    @Override
    public String check(Credentials credentials) {
        CredentialsValidator validator=CredentialsValidator.of(credentials);
        String error = validator.isValid();

        if(error != null) {
            return error;
        }
        return checkNext(credentials);
    }
}
