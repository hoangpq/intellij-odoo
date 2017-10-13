package com.intellij.odoo.psi

import com.intellij.lang.javascript.psi.JSCallExpression
import com.intellij.odoo.project.OdooProjectComponent
import com.intellij.odoo.reference.OdooReference
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceProvider
import com.intellij.util.ProcessingContext


class OdooPsiReferenceProvider : PsiReferenceProvider() {
    override fun getReferencesByElement(element: PsiElement, context: ProcessingContext): Array<PsiReference> {
        val projectComponent = element.project.getComponent(OdooProjectComponent::class.java)
        val path = element.text
        if (isDefineCall(element)) {
            val ref: PsiReference = OdooReference(element, TextRange(1, path.length - 1))
            return arrayOf(ref)
        }
        return arrayOf()
    }

    fun isDefineCall(element: PsiElement): Boolean {

        if (element.text == "define") {
            println(element.text)
        }

        var prevEl = element.parent
        if (prevEl != null) {
            prevEl = prevEl.parent
        }
        if (prevEl is JSCallExpression) {
            if (prevEl.children.size > 1) {
                if (prevEl.children[0].text.toLowerCase() == "define") {
                    return true
                }
            }
        }
        return false
    }

}