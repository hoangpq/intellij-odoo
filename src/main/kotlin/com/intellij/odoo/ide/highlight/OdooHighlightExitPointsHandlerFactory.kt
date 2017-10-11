package com.intellij.odoo.ide.highlight

import com.intellij.codeInsight.highlighting.HighlightUsagesHandlerBase
import com.intellij.codeInsight.highlighting.HighlightUsagesHandlerFactoryBase
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.util.Consumer

class OdooHighlightExitPointsHandlerFactory : HighlightUsagesHandlerFactoryBase() {

    override fun createHighlightUsagesHandler(editor: Editor, file: PsiFile, target: PsiElement): HighlightUsagesHandlerBase<*>? {
        if (!target.text.startsWith("odoo.define")) {
            return null
        }
        return OdooHighlightExitPointsHandler(editor, file, target)
    }

    private class OdooHighlightExitPointsHandler(editor: Editor, file: PsiFile, var target: PsiElement) : HighlightUsagesHandlerBase<PsiElement>(editor, file) {

        override fun getTargets() = listOf(target)

        override fun computeUsages(targets: MutableList<PsiElement>?) {
            TODO("not implemented")
        }

        override fun selectTargets(targets: MutableList<PsiElement>?, selectionConsumer: Consumer<MutableList<PsiElement>>?) {
            TODO("not implemented")
        }

    }

}