package aesexample;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class AESExample {
    private static final String algorithm  = "AES";
    private byte[] keyValue;

    public AESExample(String key){
        keyValue = key.getBytes();
    }
    public String encyptAES(String Data) throws Exception{
        //Generating a Key
        Key secretKey = generateKey();
        // Creating a Cipher object
        Cipher c = Cipher.getInstance(algorithm);
        // The resulting SecretKey instance can be passed to the Cipher.init() method
        c.init(Cipher.ENCRYPT_MODE, secretKey);
        //adding data to the cipher using doFinal() or update()
        byte[] encVal = c.doFinal(Data.getBytes());
        String encyptedValue = new String(Base64.getEncoder().encode(encVal));
        return encyptedValue;
    }
    private Key generateKey(){
        Key secretKey = new SecretKeySpec(keyValue, algorithm);
        return secretKey;
    }
    public String decyptAES(String encyptedData) throws Exception{
        Key secretKey = generateKey();
        Cipher c = Cipher.getInstance(algorithm);
        c.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decoded = Base64.getDecoder().decode(encyptedData);
        byte[] decVal = c.doFinal(decoded);
        String decryptedValue = new String(decVal);
        return decryptedValue;
    }
}
