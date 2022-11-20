package de.tum.in.ase;

import org.checkerframework.checker.nullness.qual.*;

import static java.util.Objects.isNull;

public class AccessPoint {

    // TODO: What kind of annotation is needed for SSID?
    private String SSID;

    // TODO: What kind of annotation is needed for encryption?
    private Encryption encryption;

    // TODO: What kind of annotation is needed for password?
    private String password;

    // TODO: Annotate parameters with appropriate annotations.
    public AccessPoint(String SSID, Encryption encryption, String password) {
        this.SSID = SSID;
        this.encryption = encryption;
        this.password = password;
    }

    // You do not have to change anything in this method, but look at it and get the idea.
    public boolean requestConnection(Encryption encryption, String password) {

        // When encryption is null, this means there is no encryption for the access point.
        if (encryption == null) {
            System.out.println("AccessPoint: This access point is not encrypted.");
            System.out.println("AccessPoint: The request has been accepted.");
            return true;
        }

        // Checks whether the requested encryption method is compatible or not.
        Class<? extends Encryption> encryptionClass = encryption.getClass();
        if (encryptionClass != null && this.encryption != null && encryptionClass != this.encryption.getClass()) {
            System.out.println("AccessPoint: The requested encryption is not compatible.");
            System.out.println("AccessPoint: The request has been rejected.");
            return false;
        }

        // Checks whether the password matches.
        if (password == null || !password.equals(getPassword())) {
            System.out.println("AccessPoint: The password does not match.");
            System.out.println("AccessPoint: The request has been rejected.");
            return false;
        }

        // When the encryption scheme is compatible, checks the password.
        if (!isNull(encryptionClass) && !isNull(encryptionClass.getAnnotation(SecurityLevel.class))) {
            System.out.println(
                String.format(
                    "AccessPoint: The security category of the encryption %s is %s.",
                    encryptionClass.getSimpleName(),
                    encryptionClass.getAnnotation(SecurityLevel.class).category()
                )
            );
            System.out.println("AccessPoint: The request has been accepted.");
        }

        // If the encryption has the warning message, output it.
        if (encryption.getSecurityWarning() != null) {
            System.out.println("AccessPoint: [WARN] " + encryption.getSecurityWarning());
        }

        return true;
    }

    // TODO: What kind of annotation is needed here?
    public String toString() {
        return String.format("SSID: %s", SSID);
    }

    // <editor-fold desc="Getters and Setters">
    public @NonNull String getSSID() {
        return SSID;
    }

    public void setSSID(@NonNull String SSID) {
        this.SSID = SSID;
    }

    public @Nullable Encryption getEncryption() {
        return encryption;
    }

    public void setEncryption(@Nullable Encryption encryption) {
        this.encryption = encryption;
    }

    public @Nullable String getPassword() {
        return password;
    }

    public void setPassword(@Nullable String password) {
        this.password = password;
    }

    //</editor-fold>
}
