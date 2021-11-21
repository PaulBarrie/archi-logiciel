package membership.common.hash;

import java.security.NoSuchAlgorithmException;

public interface Hash {
    String encrypt(String str) throws NoSuchAlgorithmException;
}
