package net.mint.psi.references;

public enum MintReferenceTarget {
    SYMBOL("symbol"),
    MODULE("module");

    private final String displayName;

    MintReferenceTarget(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return this.displayName;
    }
}
