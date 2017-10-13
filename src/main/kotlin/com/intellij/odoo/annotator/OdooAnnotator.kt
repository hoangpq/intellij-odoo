package com.intellij.odoo.annotator

import com.intellij.lang.annotation.*
import com.intellij.lang.javascript.JSElementType
import com.intellij.lang.javascript.psi.JSFunction
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.PsiUtil

class OdooAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        val psiElement = element as LeafPsiElement
        if (psiElement.elementType is JSElementType) {
            if (psiElement.text == "define") {
                val textRange = TextRange(element.textRange.startOffset, element.textRange.endOffset)
                println(textRange)
            }
        }
    }

    companion object {
        val GLOBAL_KEYWORD = "odoo"
        val DEFINE_KEYWORD = "define"
        val MODULE_NAME = ""
    }

}
