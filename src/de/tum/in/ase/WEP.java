package de.tum.in.ase;

// Annotate this class with the appropriate security level.
@SecurityLevel(category = SecurityCategory.DEPRECATED)
public class WEP extends Encryption {
    public WEP() {
        super("This encryption is deprecated, and not recommended to use anymore.");
    }
}
