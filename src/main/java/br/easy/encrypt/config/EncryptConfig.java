package br.easy.encrypt.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

/**
 * This class is signed with @Configuration because you could
 * need put a @DependsOn in another Configuration who depends on it.
 */
@Configuration("ENCRYPT_CONFIG")
public class EncryptConfig {

    private static final String ALGORITHM = "AES";

    private static String symmetricKey;

    @Value("${encrypt.key}")
    public void setSymmetricKey(String key){
        symmetricKey = key;
    }

    public static String encrypt(String str) {
        String encondedStr = "";
        byte[] bytes = symmetricKey.getBytes();

        try {
            Cipher c = Cipher.getInstance(ALGORITHM);
            Key key = new SecretKeySpec(bytes, ALGORITHM);
            c.init(Cipher.ENCRYPT_MODE, key);
            byte[] cipherData = c.doFinal(str.getBytes());
            encondedStr = Base64.getEncoder().encodeToString(cipherData);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return encondedStr;
    }

    public static String decrypt(String encryptedData) {
        String decodedStr = "";
        byte[] bytes = symmetricKey.getBytes();

        try {
            Key key = new SecretKeySpec(bytes, ALGORITHM);
            Cipher c = Cipher.getInstance(ALGORITHM);
            c.init(Cipher.DECRYPT_MODE, key);

            byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
            byte[] decodedValue = c.doFinal(decodedBytes);
            decodedStr = new String(decodedValue);

        }catch (Exception e) {
            e.printStackTrace();
        }

        return decodedStr;
    }

}
