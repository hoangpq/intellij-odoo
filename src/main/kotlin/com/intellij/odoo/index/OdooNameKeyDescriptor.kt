package com.intellij.odoo.index

import com.intellij.odoo.resolver.OdooName
import com.intellij.util.io.IOUtil
import com.intellij.util.io.KeyDescriptor
import java.io.DataInput
import java.io.DataOutput

class OdooNameKeyDescriptor : KeyDescriptor<OdooName> {
    override fun isEqual(val1: OdooName?, val2: OdooName?) = (val1 == val2)

    override fun save(storage: DataOutput, value: OdooName) {
        IOUtil.writeUTF(storage, value.fullName)
    }

    override fun read(storage: DataInput): OdooName? {
        return OdooName.from(IOUtil.readUTF(storage))
    }

    override fun getHashCode(value: OdooName) = value.hashCode()

}
