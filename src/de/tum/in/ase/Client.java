// ---------------------------------------------
// You should not change anything in this class.
// ---------------------------------------------

package de.tum.in.ase;

import org.checkerframework.checker.nullness.qual.*;

import java.util.List;

import static java.util.Objects.isNull;

public class Client {

    private List<Encryption> compatibleEncryption;

    public Client(List<Encryption> compatibleEncryption) {
        this.compatibleEncryption = compatibleEncryption;
    }

    public void connectToAccessPoint(@NonNull AccessPoint ap, @Nullable String password) {

        if(ap.getEncryption() == null || password == null) {
            System.out.println("Client: Request connection without any encryption.");
            System.out.println("Client: Connection established.");
            return;
        }

        for(SecurityCategory category: SecurityCategory.values()) {

            boolean result = compatibleEncryption.stream().filter(e -> {
                Class<? extends Encryption> clazz = e.getClass();
                if(!isNull(clazz.getAnnotation(SecurityLevel.class))) {
                    return clazz.getAnnotation(SecurityLevel.class).category() == category;
                }
                return false;
            }).anyMatch(e -> {
                System.out.println(String.format("Client: Request connection with %s.", e.getClass().getSimpleName()));
                if (ap.requestConnection(e, password)) {
                    System.out.println("Client: Connection established.");
                    return true;
                }
                else {
                    System.out.println("Client: Request has been rejected.");
                    return false;
                }
            });

            if(result) {
                break;
            }
        }
    }

    //<editor-fold desc="Getters and Setters">
    public List<Encryption> getCompatibleEncryption() {
        return compatibleEncryption;
    }

    public void setCompatibleEncryption(List<Encryption> compatibleEncryption) {
        this.compatibleEncryption = compatibleEncryption;
    }
    //</editor-fold>
}
