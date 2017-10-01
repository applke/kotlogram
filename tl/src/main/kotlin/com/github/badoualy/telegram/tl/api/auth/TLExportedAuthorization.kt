package com.github.badoualy.telegram.tl.api.auth

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * auth.exportedAuthorization#df969c2d
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLExportedAuthorization() : TLObject() {
    var id: Int = 0

    var bytes: TLBytes = TLBytes.EMPTY

    private val _constructor: String = "auth.exportedAuthorization#df969c2d"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(id: Int, bytes: TLBytes) : this() {
        this.id = id
        this.bytes = bytes
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(id)
        writeTLBytes(bytes)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        id = readInt()
        bytes = readTLBytes()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLBytesSerializedSize(bytes)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLExportedAuthorization) return false
        if (other === this) return true

        return id == other.id
                && bytes == other.bytes
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xdf969c2d.toInt()
    }
}
