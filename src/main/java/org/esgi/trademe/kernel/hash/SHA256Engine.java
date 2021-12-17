package org.esgi.trademe.kernel.hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Engine implements HashEngine {

    @Override
    public String encrypt(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(str.getBytes());
        return new String(messageDigest.digest());
    }
}
