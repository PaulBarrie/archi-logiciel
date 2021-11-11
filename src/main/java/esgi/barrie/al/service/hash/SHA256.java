package esgi.barrie.al.service.hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 implements Hash {

    @Override
    public String encrypt(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(str.getBytes());
        return new String(messageDigest.digest());
    }
}
