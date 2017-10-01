package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.api.TLAbsInputNotifyPeer
import com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings
import com.github.badoualy.telegram.tl.api.TLInputNotifyUsers
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestAccountGetNotifySettings() : TLMethod<TLAbsPeerNotifySettings>() {
    var peer: TLAbsInputNotifyPeer = TLInputNotifyUsers()

    private val _constructor: String = "account.getNotifySettings#12b3ad31"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(peer: TLAbsInputNotifyPeer) : this() {
        this.peer = peer
    }

    @Throws(IOException::class)
    override fun deserializeResponse(tlDeserializer: TLDeserializer): TLAbsPeerNotifySettings = tlDeserializer.readTLObject()

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(peer)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        peer = readTLObject<TLAbsInputNotifyPeer>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += peer.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountGetNotifySettings) return false
        if (other === this) return true

        return peer == other.peer
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x12b3ad31.toInt()
    }
}
