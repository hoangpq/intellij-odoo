package com.intellij.odoo.index

import com.intellij.odoo.resolver.OdooName
import com.intellij.util.indexing.*
class OdooNameIndex : ScalarIndexExtension<OdooName>() {

    override fun getVersion() = 4
    override fun getName() = NAME
    override fun dependsOnFileContent() = false
    override fun getKeyDescriptor() = OdooNameKeyDescriptor()

    override fun getInputFilter() = FileBasedIndex.InputFilter {
        it.extension in FILE_EXTENSIONS
    }

    override fun getIndexer() = DataIndexer<OdooName, Void?, FileContent> { inputData ->
        emptyMap()
    }

    companion object {
        val NAME: ID<OdooName, Void> = ID.create("odoo.names")
        private val FILE_EXTENSIONS = setOf("js")
    }

}