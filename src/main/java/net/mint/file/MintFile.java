package net.mint.file;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import net.mint.MintLanguage;
import org.jetbrains.annotations.NotNull;
import javax.swing.*;

public class MintFile extends PsiFileBase {
    public MintFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, MintLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return MintFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Crystal File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }


}

