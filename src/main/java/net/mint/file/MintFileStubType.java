package net.mint.file;

import com.intellij.psi.tree.IStubFileElementType;
import net.mint.MintLanguage;


public class MintFileStubType extends IStubFileElementType {
    public static final MintFileStubType INSTANCE = new MintFileStubType();

    private MintFileStubType() {
        super(MintLanguage.INSTANCE);
    }
}


