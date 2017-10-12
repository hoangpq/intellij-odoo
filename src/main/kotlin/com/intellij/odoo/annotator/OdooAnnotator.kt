package com.intellij.odoo.annotator

import com.intellij.lang.annotation.*
import com.intellij.lang.javascript.JSElementType
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement

class OdooAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        val psiElement = element as LeafPsiElement
        if (psiElement.elementType is JSElementType) {
            if (psiElement.text == "odoo") {
                val textRange = TextRange(element.textRange.startOffset, element.textRange.endOffset)
                // val annotation = holder.createInfoAnnotation(textRange, null)
                // annotation.textAttributes = DefaultLanguageHighlighterColors.GLOBAL_VARIABLE
            }
            if (psiElement.text == "define") {
                val textRange = TextRange(element.textRange.startOffset, element.textRange.endOffset)
                // val annotation = holder.createInfoAnnotation(textRange, null)
                // annotation.textAttributes = DefaultLanguageHighlighterColors.GLOBAL_VARIABLE
            }
        }
    }

    companion object {
        val GLOBAL_KEYWORD = "odoo"
        val DEFINE_KEYWORD = "define"
        val MODULE_NAME = ""
    }

}
