package com.intellij.odoo.annotator

import com.intellij.lang.annotation.*
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiLiteralExpression

class OdooAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element is PsiLiteralExpression) {
            val value = if (element.value is String) element.value as String else null
            if (value != null) {
                println(value)
            }
        }
    }

}
