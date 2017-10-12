package com.intellij.odoo.annotator

import com.intellij.lang.annotation.*
import com.intellij.lang.javascript.JSElementType
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement

class OdooAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        val psiElement = element as LeafPsiElement
        val elementType = psiElement.elementType as? JSElementType ?: return
        val text = psiElement.text
        println(text)
        if (text == GLOBAL_KEYWORD) {
            val annotation = holder.createInfoAnnotation(element.textRange, null)
            annotation.textAttributes = DefaultLanguageHighlighterColors.GLOBAL_VARIABLE
            // get next element
        }
        if (text == DEFINE_KEYWORD) {
            // get next element
            println(DEFINE_KEYWORD)
        }
    }

    companion object {
        val GLOBAL_KEYWORD = "odoo"
        val DEFINE_KEYWORD = "define"
        val MODULE_NAME = ""
    }

}
