package net.mint.file;

import com.intellij.openapi.fileTypes.LanguageFileType;
import net.mint.MintLanguage;
import net.mint.icons.MintIcons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import javax.swing.*;

public class MintFileType extends LanguageFileType {

    public static final MintFileType INSTANCE = new MintFileType();
    public static final String DEFAULT_EXTENSION = "mint";

    private MintFileType() {
        super(MintLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Mint file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Mint file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return DEFAULT_EXTENSION;
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return MintIcons.FILE;
    }
}

