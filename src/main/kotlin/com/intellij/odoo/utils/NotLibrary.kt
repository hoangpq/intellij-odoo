package com.intellij.odoo.utils

import com.intellij.patterns.PatternCondition
import com.intellij.util.ProcessingContext
import com.intellij.util.indexing.FileContent

val IGNORE_FOLDER = listOf("doc", "models", "tests", "i18n")

object NotLibrary : PatternCondition<FileContent>("notExcluded") {
    override fun accepts(content: FileContent, context: ProcessingContext?): Boolean {
        return !IGNORE_FOLDER.all { content.file.parent.name.startsWith(it) }
    }

}
