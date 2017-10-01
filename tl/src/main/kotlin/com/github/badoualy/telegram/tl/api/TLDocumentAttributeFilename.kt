package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * documentAttributeFilename#15590068
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLDocumentAttributeFilename() : TLAbsDocumentAttribute() {
    var fileName: String = ""

    private val _constructor: String = "documentAttributeFilename#15590068"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(fileName: String) : this() {
        this.fileName = fileName
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(fileName)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        fileName = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(fileName)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLDocumentAttributeFilename) return false
        if (other === this) return true

        return fileName == other.fileName
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x15590068.toInt()
    }
}
