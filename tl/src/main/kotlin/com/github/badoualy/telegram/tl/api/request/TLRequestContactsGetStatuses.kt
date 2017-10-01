package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.api.TLContactStatus
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestContactsGetStatuses : TLMethod<TLObjectVector<TLContactStatus>>() {
    private val _constructor: String = "contacts.getStatuses#c4a353ee"

    override val constructorId: Int = CONSTRUCTOR_ID

    @Throws(IOException::class)
    override fun deserializeResponse(tlDeserializer: TLDeserializer): TLObjectVector<TLContactStatus> = tlDeserializer.readTLVector<TLContactStatus>()

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestContactsGetStatuses) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc4a353ee.toInt()
    }
}
