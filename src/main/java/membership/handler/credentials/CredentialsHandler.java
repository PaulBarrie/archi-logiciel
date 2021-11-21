package membership.handler.credentials;

import membership.common.user.Credentials;
import membership.handler.Handler;

public abstract class CredentialsHandler implements Handler<Credentials> {
    private CredentialsHandler next;

    public void setNext(CredentialsHandler next) {
        this.next = next;
    }

    public abstract String check(Credentials credentials);

    public String checkNext(Credentials credentials) {
        if (next == null) {
            return null;
        }
        return next.check(credentials);
    }
    
}
