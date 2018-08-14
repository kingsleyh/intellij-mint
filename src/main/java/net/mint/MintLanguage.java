package net.mint;

import com.intellij.lang.Language;

public class MintLanguage extends Language {
    public static final MintLanguage INSTANCE = new MintLanguage();

    private MintLanguage() {
        super("Mint", "text/mint", "text/x-mint", "application/x-mint");
    }
}
