package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.api.payments.TLSavedInfo
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestPaymentsGetSavedInfo : TLMethod<TLSavedInfo>() {
    private val _constructor: String = "payments.getSavedInfo#227d824b"

    override val constructorId: Int = CONSTRUCTOR_ID

    @Throws(IOException::class)
    override fun deserializeResponse(tlDeserializer: TLDeserializer): TLSavedInfo = tlDeserializer.readTLObject()

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestPaymentsGetSavedInfo) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x227d824b.toInt()
    }
}
