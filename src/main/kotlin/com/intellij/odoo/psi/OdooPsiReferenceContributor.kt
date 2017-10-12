package com.intellij.odoo.psi

import com.intellij.psi.PsiReferenceContributor
import com.intellij.psi.PsiReferenceRegistrar
import com.intellij.lang.javascript.psi.JSLiteralExpression
import com.intellij.patterns.StandardPatterns

class OdooPsiReferenceContributor : PsiReferenceContributor() {
    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        val provider = OdooPsiReferenceProvider()
        registrar.registerReferenceProvider(StandardPatterns.instanceOf(JSLiteralExpression::class.java), provider)
    }

}