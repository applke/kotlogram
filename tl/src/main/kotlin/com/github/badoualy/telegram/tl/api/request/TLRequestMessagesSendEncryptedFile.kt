package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputEncryptedFile
import com.github.badoualy.telegram.tl.api.TLInputEncryptedChat
import com.github.badoualy.telegram.tl.api.TLInputEncryptedFileEmpty
import com.github.badoualy.telegram.tl.api.messages.TLAbsSentEncryptedMessage
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesSendEncryptedFile() : TLMethod<TLAbsSentEncryptedMessage>() {
    var peer: TLInputEncryptedChat = TLInputEncryptedChat()

    var randomId: Long = 0L

    var data: TLBytes = TLBytes.EMPTY

    var file: TLAbsInputEncryptedFile = TLInputEncryptedFileEmpty()

    private val _constructor: String = "messages.sendEncryptedFile#9a901b66"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes,
            file: TLAbsInputEncryptedFile
    ) : this() {
        this.peer = peer
        this.randomId = randomId
        this.data = data
        this.file = file
    }

    @Throws(IOException::class)
    override fun deserializeResponse(tlDeserializer: TLDeserializer): TLAbsSentEncryptedMessage = tlDeserializer.readTLObject()

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(peer)
        writeLong(randomId)
        writeTLBytes(data)
        writeTLObject(file)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        peer = readTLObject<TLInputEncryptedChat>(TLInputEncryptedChat::class, TLInputEncryptedChat.CONSTRUCTOR_ID)
        randomId = readLong()
        data = readTLBytes()
        file = readTLObject<TLAbsInputEncryptedFile>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += peer.computeSerializedSize()
        size += SIZE_INT64
        size += computeTLBytesSerializedSize(data)
        size += file.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesSendEncryptedFile) return false
        if (other === this) return true

        return peer == other.peer
                && randomId == other.randomId
                && data == other.data
                && file == other.file
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9a901b66.toInt()
    }
}
