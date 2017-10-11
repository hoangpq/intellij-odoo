package com.intellij.odoo.navigation

import com.intellij.navigation.GotoRelatedItem
import com.intellij.odoo.resolver.OdooName
import com.intellij.openapi.util.IconLoader
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile

class OdooGotoRelatedItem(val name: OdooName, element: PsiElement) : GotoRelatedItem(element) {

    override fun getCustomName() = name.displayName
    override fun getCustomContainerName() = ""
    override fun getCustomIcon() = IconLoader.getIcon("/icons/odoo.jpeg")

    companion object {
        fun from(name: OdooName?, psiFile: PsiFile?): OdooGotoRelatedItem? {
            return OdooGotoRelatedItem(name ?: return null, psiFile ?: return null)
        }
    }
}
