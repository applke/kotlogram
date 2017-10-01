package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.api.TLAbsInputUser
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestUsersGetUsers() : TLMethod<TLObjectVector<TLAbsUser>>() {
    var id: TLObjectVector<TLAbsInputUser> = TLObjectVector()

    private val _constructor: String = "users.getUsers#d91a548"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(id: TLObjectVector<TLAbsInputUser>) : this() {
        this.id = id
    }

    @Throws(IOException::class)
    override fun deserializeResponse(tlDeserializer: TLDeserializer): TLObjectVector<TLAbsUser> = tlDeserializer.readTLVector<TLAbsUser>()

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLVector(id)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        id = readTLVector<TLAbsInputUser>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += id.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestUsersGetUsers) return false
        if (other === this) return true

        return id == other.id
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xd91a548.toInt()
    }
}
