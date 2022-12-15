package reaexample;

import javax.crypto.Cipher;
import java.security.*;

public class RSAExample {
    private static boolean signed;
    public String encyptRSA(String Data) throws Exception{
        //Creating a Signature object
        Signature sign = Signature.getInstance("SHA256withRSA");

        //Creating KeyPair generator object
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");

        //Initializing the key pair generator
        keyPairGen.initialize(2048);

        //Generating the pair of keys
        KeyPair pair = keyPairGen.generateKeyPair();

        //Getting the privatekey from the key pair
        PrivateKey privKey = pair.getPrivate();

        //Initializing the signature with PrivateKey
        sign.initSign(privKey);  //accepts a PrivateKey object

        //Creating a Cipher object
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

        //Initializing a Cipher object
        cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());

        //adding data to the cipher
        byte[] input = Data.getBytes();
        cipher.update(input);
        sign.update(input); //Update the initialized Signature object

        //Calculating the signature
        byte[] signature = sign.sign(); //returns the signature bytes of the updated data.

        //Initializing the signature with PublicKey
        sign.initVerify(pair.getPublic()); // accepts a PublicKey object.
        sign.update(input); // Update the data to be verified

        //Verifying the signature
        signed = sign.verify(signature); // Signature class accepts another signature object and verifies it with the current one

        //encrypting the data
        byte[] cipherText = cipher.doFinal();
        String encyptedValue = new String(cipherText, "UTF8");
        return encyptedValue;
    }
    public String decyptRSA(String Data) throws Exception{
        //Creating KeyPair generator object
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");

        //Initializing the key pair generator
        keyPairGen.initialize(2048);

        //Generating the pair of keys
        KeyPair pair = keyPairGen.generateKeyPair();

        //Creating a Cipher object
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

        //Initializing a Cipher object for encryption with public key
        cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());

        //adding data to the cipher
        byte[] input = Data.getBytes();
        cipher.update(input);

        //encrypting the data
        byte[] cipherText = cipher.doFinal();

        //Initializing the cipher for decryption with private key
        cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());

        //Decrypting the text
        byte[] decipheredText = cipher.doFinal(cipherText);
        String decryptedValue = new String(decipheredText);
        return decryptedValue;
    }
    public boolean getSinged(){
        return signed;
    }

    public void verifying(boolean signed){
        //Creating KeyPair generator object
        if(signed){
            System.out.println("Signature verified");
        }else{
            System.out.println("Invalid signature");
        }
    }
}
