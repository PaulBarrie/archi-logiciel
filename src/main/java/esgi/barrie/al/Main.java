package esgi.barrie.cc1;

import esgi.barrie.cc1.controller.UserController;
import esgi.barrie.cc1.infrastructure.db.JsonFsDB;
import esgi.barrie.cc1.model.user.Address;
import esgi.barrie.cc1.model.user.Credentials;
import esgi.barrie.cc1.model.user.Phone;
import esgi.barrie.cc1.model.user.User;

import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Address address = Address.of("3", "rue de la Paix", "750002", "Paris", "FRANCE" );
        Phone phone = Phone.of(33, "123458955");
        Credentials credentials = Credentials.of("paulb", "motsdepasse");
        User user = User.of("Paul", "Barrié", "31/10/1995", "paul.barrie.calmels@gmail.com", credentials, phone, address);
        JsonFsDB db = new JsonFsDB("~/Documents/cours/architecture-logicielle/esgi-al-tps/cc1/data/db.json");
        UserController = UserController.of(user, db):
    }
}
