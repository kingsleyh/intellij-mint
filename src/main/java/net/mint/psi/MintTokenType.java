package net.mint.psi;

import com.intellij.psi.tree.IElementType;
import net.mint.MintLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class MintTokenType extends IElementType {
    public MintTokenType(@NotNull @NonNls String debugName) {
        super(debugName, MintLanguage.INSTANCE);
    }
}

