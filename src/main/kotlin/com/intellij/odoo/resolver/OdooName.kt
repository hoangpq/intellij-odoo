package com.intellij.odoo.resolver

data class OdooName(val type: String, val name: String) {

    val fullName by lazy { "$type:$name" }
    val displayName by lazy {
        name
    }

    companion object {
        fun from(fullName: String): OdooName? {
            val parts = fullName.split(":")
            return when {
                parts.count() == 2 -> OdooName(parts[0], parts[1])
                else -> null
            }
        }

    }
}
