package com.intellij.odoo.reference

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference

class OdooReference(element: PsiElement, range: TextRange) : PsiReference {

    override fun getElement(): PsiElement {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun resolve(): PsiElement? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getVariants(): Array<Any> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRangeInElement(): TextRange {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCanonicalText(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun handleElementRename(newElementName: String?): PsiElement {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun bindToElement(element: PsiElement): PsiElement {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isSoft(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isReferenceTo(element: PsiElement?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}