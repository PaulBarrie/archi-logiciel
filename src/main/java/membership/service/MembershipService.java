package membership.service;

import membership.common.user.User;
import membership.handler.credentials.CredentialsDataHandler;
import membership.handler.credentials.CredentialsHandler;
import membership.handler.credentials.UsernameUnicityHandler;
import membership.handler.user.UserDataHandler;
import membership.handler.user.UserHandler;
import membership.handler.user.UserUnicityHandler;

import java.util.Map;

public abstract class MembershipService {
    UserHandler userHandler;
    CredentialsHandler credentialsHandler;

    public MembershipService() {
        this.userHandler= new UserDataHandler();
        userHandler.setNext(new UserUnicityHandler());
        this.credentialsHandler = new CredentialsDataHandler();
        this.credentialsHandler.setNext(new UsernameUnicityHandler());
    }

    public  abstract User registerUser(Map<String,String> userDetails, Map<String,String> credentialsDetails,
                             Map<String,String> paymentDetails);

}
