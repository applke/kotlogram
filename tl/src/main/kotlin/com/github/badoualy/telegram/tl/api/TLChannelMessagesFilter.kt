package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * channelMessagesFilter#cd77d957
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelMessagesFilter() : TLAbsChannelMessagesFilter() {
    @Transient
    var excludeNewMessages: Boolean = false

    var ranges: TLObjectVector<TLMessageRange> = TLObjectVector()

    private val _constructor: String = "channelMessagesFilter#cd77d957"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(excludeNewMessages: Boolean, ranges: TLObjectVector<TLMessageRange>) : this() {
        this.excludeNewMessages = excludeNewMessages
        this.ranges = ranges
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(excludeNewMessages, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLVector(ranges)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        excludeNewMessages = isMask(2)
        ranges = readTLVector<TLMessageRange>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += ranges.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelMessagesFilter) return false
        if (other === this) return true

        return _flags == other._flags
                && excludeNewMessages == other.excludeNewMessages
                && ranges == other.ranges
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xcd77d957.toInt()
    }
}
