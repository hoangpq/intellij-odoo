package com.intellij.odoo.cli

import com.intellij.framework.FrameworkType
import com.intellij.framework.detection.DetectedFrameworkDescription
import com.intellij.framework.detection.FileContentPattern
import com.intellij.framework.detection.FrameworkDetectionContext
import com.intellij.framework.detection.FrameworkDetector
import com.intellij.odoo.utils.NotLibrary
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.roots.ModifiableModelsProvider
import com.intellij.openapi.roots.ui.configuration.ModulesProvider
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.patterns.ElementPattern
import com.intellij.util.indexing.FileContent
import com.jetbrains.python.PythonFileType

class OdooCliFrameworkDetector : FrameworkDetector("Odoo") {

    /** The `odoo-bin` file is detected as plain text */
    override fun getFileType(): FileType = PythonFileType.INSTANCE

    override fun createSuitableFilePattern(): ElementPattern<FileContent> {
        return FileContentPattern.fileContent()
                .withName("odoo-bin")
                .with(NotLibrary)
    }

    override fun getFrameworkType(): FrameworkType = OdooFrameworkType

    override fun detect(newFiles: MutableCollection<VirtualFile>, context: FrameworkDetectionContext): MutableList<out DetectedFrameworkDescription> {
        val rootDir = newFiles.firstOrNull()?.parent
        if (rootDir != null) {
            return mutableListOf(OdooFrameworkDescription(rootDir, newFiles))
        }
        return mutableListOf()
    }

    private inner class OdooFrameworkDescription(val root: VirtualFile, val files: Collection<VirtualFile>) : DetectedFrameworkDescription() {

        override fun getSetupText() = "Configure this module for Odoo development"
        override fun getDetector() = this@OdooCliFrameworkDetector
        override fun hashCode() = files.hashCode()
        override fun equals(other: Any?) = other is OdooFrameworkDescription && this.files == other.files
        override fun getRelatedFiles() = files

        override fun setupFramework(modifiableModelsProvider: ModifiableModelsProvider, modulesProvider: ModulesProvider) {
            println(modulesProvider)
        }
    }

}
