package com.intellij.odoo.navigation

import com.intellij.navigation.GotoRelatedItem
import com.intellij.navigation.GotoRelatedProvider
import com.intellij.odoo.resolver.OdooName
import com.intellij.openapi.actionSystem.DataContext
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiManager

class OdooGotoRelatedProvider : GotoRelatedProvider() {

    override fun getItems(context: DataContext): List<GotoRelatedItem> {
        val project = PlatformDataKeys.PROJECT.getData(context) ?: return listOf()
        val file = PlatformDataKeys.VIRTUAL_FILE.getData(context) ?: return listOf()

        val psiManager = PsiManager.getInstance(project)

        return getItems(file, project)
                .map { OdooGotoRelatedItem.from(it.first, psiManager.findFile(it.second)) }
                .filterNotNull()
    }

    fun getItems(file: VirtualFile, project: Project): List<Pair<OdooName, VirtualFile>> {
        return listOf()
    }

}
