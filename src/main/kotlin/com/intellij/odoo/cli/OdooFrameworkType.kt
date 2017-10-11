package com.intellij.odoo.cli

import com.intellij.framework.FrameworkType
import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

object OdooFrameworkType : FrameworkType("Odoo") {
    override fun getIcon(): Icon = IconLoader.getIcon("/icons/odoo.jpeg")
    override fun getPresentableName(): String = "Odoo"
}
