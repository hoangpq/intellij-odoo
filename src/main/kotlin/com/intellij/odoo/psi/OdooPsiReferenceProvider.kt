package com.intellij.odoo.psi

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceProvider
import com.intellij.util.ProcessingContext

class OdooPsiReferenceProvider : PsiReferenceProvider() {
    override fun getReferencesByElement(element: PsiElement, context: ProcessingContext): Array<PsiReference> {

        println("getReferencesByElement");
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}