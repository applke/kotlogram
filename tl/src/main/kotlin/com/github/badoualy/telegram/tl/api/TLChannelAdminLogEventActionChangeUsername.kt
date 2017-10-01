package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * channelAdminLogEventActionChangeUsername#6a4afc38
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelAdminLogEventActionChangeUsername() : TLAbsChannelAdminLogEventAction() {
    var prevValue: String = ""

    var newValue: String = ""

    private val _constructor: String = "channelAdminLogEventActionChangeUsername#6a4afc38"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(prevValue: String, newValue: String) : this() {
        this.prevValue = prevValue
        this.newValue = newValue
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(prevValue)
        writeString(newValue)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        prevValue = readString()
        newValue = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(prevValue)
        size += computeTLStringSerializedSize(newValue)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelAdminLogEventActionChangeUsername) return false
        if (other === this) return true

        return prevValue == other.prevValue
                && newValue == other.newValue
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x6a4afc38.toInt()
    }
}
