package de.tum.in.ase;

import org.checkerframework.checker.nullness.qual.*;

public abstract class Encryption {

    // TODO: What kind of annotation is needed here?
    private String securityWarning;

    // TODO: Annotate the parameter with the appropriate annotation.
    public Encryption(String securityWarning) {
        this.securityWarning = securityWarning;
    }
    
    public Encryption() {
        this.securityWarning = "";
    }

    public @Nullable String getSecurityWarning() {
        return securityWarning;
    }
}
