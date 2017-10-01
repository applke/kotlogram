package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * keyboardButtonCallback#683a5e46
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLKeyboardButtonCallback() : TLAbsKeyboardButton() {
    override var text: String = ""

    var data: TLBytes = TLBytes.EMPTY

    private val _constructor: String = "keyboardButtonCallback#683a5e46"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(text: String, data: TLBytes) : this() {
        this.text = text
        this.data = data
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(text)
        writeTLBytes(data)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        text = readString()
        data = readTLBytes()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(text)
        size += computeTLBytesSerializedSize(data)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLKeyboardButtonCallback) return false
        if (other === this) return true

        return text == other.text
                && data == other.data
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x683a5e46.toInt()
    }
}
