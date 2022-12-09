package de.tum.in.ase;

import org.checkerframework.checker.nullness.qual.*;

public abstract class Encryption {

    // What kind of annotation is needed here?
    @Nullable
    private String securityWarning;

    // Annotate the parameter with the appropriate annotation.
    public Encryption(@Nullable String securityWarning) {
        this.securityWarning = securityWarning;
    }
    
    public Encryption() {
        this.securityWarning = "";
    }

    public @Nullable String getSecurityWarning() {
        return securityWarning;
    }
}
