package com.github.badoualy.telegram.tl.api.updates

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * updates.channelDifferenceEmpty#3e11affb
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelDifferenceEmpty() : TLAbsChannelDifference() {
    @Transient
    override var _final: Boolean = false

    override var pts: Int = 0

    override var timeout: Int? = null

    private val _constructor: String = "updates.channelDifferenceEmpty#3e11affb"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            _final: Boolean,
            pts: Int,
            timeout: Int?
    ) : this() {
        this._final = _final
        this.pts = pts
        this.timeout = timeout
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(_final, 1)
        updateFlags(timeout, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(pts)
        doIfMask(timeout, 2) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        _final = isMask(1)
        pts = readInt()
        timeout = readIfMask(2) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(timeout, 2) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelDifferenceEmpty) return false
        if (other === this) return true

        return _flags == other._flags
                && _final == other._final
                && pts == other.pts
                && timeout == other.timeout
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x3e11affb.toInt()
    }
}
