package de.tum.in.ase;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Client client = new Client(List.of(new WEP(), new WPA2(), new WPA3()));

        // This is for testing.
        System.out.println("Access Point: unencrypted");
        AccessPoint unencrypted = new AccessPoint("unencrypted", null, null);
        client.connectToAccessPoint(unencrypted, null);
        System.out.println();

        System.out.println("Access Point: encrypted");
        AccessPoint encrypted = new AccessPoint("encrypted", new WPA3(), "Il0ve!nfun");
        client.connectToAccessPoint(encrypted, "Il0ve!nfun");
        System.out.println();

        System.out.println("Access Point: encryptedWithWEP");
        AccessPoint encryptedWithWEP = new AccessPoint("encryptedWithWEP", new WEP(), "Il0ve!nfun");
        client.connectToAccessPoint(encryptedWithWEP, "Il0ve!nfun");
        System.out.println();

        // Source code below should be warned after implementing annotations.
        System.out.println("Access Point: null");
        AccessPoint invalidAccessPoint = new AccessPoint(null, null, null);
        client.connectToAccessPoint(invalidAccessPoint, null);
        System.out.println();
    }
}
