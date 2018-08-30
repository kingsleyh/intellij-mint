package net.mint.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFileFactory;
import net.mint.file.MintFile;
import net.mint.file.MintFileType;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class MintElementFactory {
    @Nullable
    public static MintProperName createProperName(Project project, String text) {
        final MintFile file = createFile(project, String.format("type Uniq%s=%s", text, text));
        return Optional.ofNullable(file.getFirstChild())
                .filter(e -> e instanceof MintOfType)
//                .flatMap(e -> ListUtils.head(((MintQualifiedName) e)))
                .map(e -> ((MintOfType) e).getTypePart().getQualifiedName().getProperName())
                .orElse(null);
    }

    @Nullable
    public static MintIdentifier createIdentifier(Project project, String text) {
        final MintFile file = createFile(project, String.format("%s=0", text));
        return (MintIdentifier) Optional.ofNullable(file.getFirstChild())
                .filter(e -> e instanceof MintIdentifier).orElse(null);
    }

//    @Nullable
//    public static ElmImportClause createImport(Project project, String moduleName) {
//        final ElmFile file = createFile(project, String.format("import %s", moduleName));
//        return Optional.ofNullable(file.getFirstChild())
//                .filter(e -> e instanceof ElmImportClause)
//                .map(e -> (ElmImportClause) e)
//                .orElse(null);
//    }

//    @Nullable
//    public static ElmImportClause createImportExposing(Project project, String moduleName, String valueName) {
//        return createImportExposing(project, moduleName, Arrays.asList(valueName));
//    }
//
//    @Nullable
//    public static ElmImportClause createImportExposing(Project project, String moduleName, List<String> exposedNames) {
//        String contents = String.join(", ", exposedNames);
//        final ElmFile file = createFile(project, String.format("import %s exposing (%s)", moduleName, contents));
//        return Optional.ofNullable(file.getFirstChild())
//                .filter(e -> e instanceof ElmImportClause)
//                .map(e -> (ElmImportClause) e)
//                .orElse(null);
//    }

//    @Nullable
//    public static PsiElement createFreshLine(Project project) {
//        final MintFile file = createFile(project, "\n");
//        return Optional.ofNullable(file.getFirstChild())
//                .filter(e -> e.getNode().getElementType() == ElmTypes.FRESH_LINE)
//                .orElse(null);
//    }

    private static MintFile createFile(Project project, String text) {
        String name = "Dummy.mint";
        return (MintFile) PsiFileFactory.getInstance(project)
                .createFileFromText(name, MintFileType.INSTANCE, text);
    }
}
