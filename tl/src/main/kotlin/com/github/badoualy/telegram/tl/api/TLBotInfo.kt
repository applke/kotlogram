package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * botInfo#98e81d3a
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLBotInfo() : TLObject() {
    var userId: Int = 0

    var description: String = ""

    var commands: TLObjectVector<TLBotCommand> = TLObjectVector()

    private val _constructor: String = "botInfo#98e81d3a"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            userId: Int,
            description: String,
            commands: TLObjectVector<TLBotCommand>
    ) : this() {
        this.userId = userId
        this.description = description
        this.commands = commands
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(userId)
        writeString(description)
        writeTLVector(commands)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        userId = readInt()
        description = readString()
        commands = readTLVector<TLBotCommand>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(description)
        size += commands.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLBotInfo) return false
        if (other === this) return true

        return userId == other.userId
                && description == other.description
                && commands == other.commands
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x98e81d3a.toInt()
    }
}
