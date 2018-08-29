package net.mint.highlighting;

import com.intellij.lang.annotation.Annotation;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import static net.mint.psi.MintElementTypes.*;

import static com.intellij.patterns.PlatformPatterns.psiElement;

public class MintSyntaxHighlightAnnotator implements Annotator {
    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (psiElement(FUN_OR_GET_STATEMENT).accepts(element)) {
            PsiElement first = element.getChildren()[0];
            String text = first.getText();
            Annotation ann = holder.createInfoAnnotation(first, text);
            ann.setTextAttributes(MintSyntaxHighlighter.FUNCTION_DECLARATION);
        } else if (psiElement(OF_TYPE).accepts(element)) {
            Annotation ann = holder.createInfoAnnotation(element, element.getText());
            ann.setTextAttributes(MintSyntaxHighlighter.OF_TYPE_NAME);
        }
    }
}