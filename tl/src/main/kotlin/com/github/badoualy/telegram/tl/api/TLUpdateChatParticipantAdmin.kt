package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * updateChatParticipantAdmin#b6901959
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateChatParticipantAdmin() : TLAbsUpdate() {
    var chatId: Int = 0

    var userId: Int = 0

    var isAdmin: Boolean = false

    var version: Int = 0

    private val _constructor: String = "updateChatParticipantAdmin#b6901959"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            chatId: Int,
            userId: Int,
            isAdmin: Boolean,
            version: Int
    ) : this() {
        this.chatId = chatId
        this.userId = userId
        this.isAdmin = isAdmin
        this.version = version
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(chatId)
        writeInt(userId)
        writeBoolean(isAdmin)
        writeInt(version)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        chatId = readInt()
        userId = readInt()
        isAdmin = readBoolean()
        version = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_BOOLEAN
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateChatParticipantAdmin) return false
        if (other === this) return true

        return chatId == other.chatId
                && userId == other.userId
                && isAdmin == other.isAdmin
                && version == other.version
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb6901959.toInt()
    }
}
