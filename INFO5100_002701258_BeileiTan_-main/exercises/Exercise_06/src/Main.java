import aesexample.AESExample;
import reaexample.RSAExample;

public class Main {
    public static void main(String args[]){
        AliceBob alice = new AliceBob();
        alice.setMessage("Hi Bob! Good Morning");
        String Alice = alice.getMessage();
        AliceBob bob = new AliceBob();
        bob.setMessage("Have a nice day");
        String Bob = bob.getMessage();

        AESExample aes = new AESExample("CBC/PKCS5Padding");
        RSAExample rsa = new RSAExample();
        try {
            System.out.println("---------------encryption of message using symmetric encryption AES--------------");
            String encdataA = aes.encyptAES(Alice);
            System.out.println("Encrypted Data from Alice to Bob using AES - " + encdataA);
            String decdataA = aes.decyptAES(encdataA);
            System.out.println("Decrypted Data from Alice to Bob using AES - " + decdataA);
            String encdataB = aes.encyptAES(Bob);
            System.out.println("Encrypted Data from Bob to Alice using AES - " + encdataB);
            String decdataB = aes.decyptAES(encdataB);
            System.out.println("Decrypted Data from Bob to Alice using AES - " + decdataB);
            System.out.println("---------------encryption of message using symmetric encryption RSA--------------");
            String encdataAA = rsa.encyptRSA(Alice);
            System.out.println("Encrypted Data from Alice to Bob using RSA - " + encdataAA);
            String decdataAA = rsa.decyptRSA(Alice);
            System.out.println("Decrypted Data from Alice to Bob using ASA - " + decdataAA);
            String encdataBB = rsa.encyptRSA(Bob);
            System.out.println("Encrypted Data from Bob to Alice using ASA - " + encdataBB);
            String decdataBB = rsa.decyptRSA(Bob);
            System.out.println("Decrypted Data from Bob to Alice using ASA - " + decdataBB);
            System.out.println("-------------- validating the signature using asymmetric encryption RSA --------------");
            //Verifying the signature
            rsa.verifying(rsa.getSinged());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
