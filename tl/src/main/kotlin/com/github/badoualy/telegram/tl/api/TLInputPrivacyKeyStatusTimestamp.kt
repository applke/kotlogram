package com.github.badoualy.telegram.tl.api

/**
 * inputPrivacyKeyStatusTimestamp#4f96cb18
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputPrivacyKeyStatusTimestamp : TLAbsInputPrivacyKey() {
    private val _constructor: String = "inputPrivacyKeyStatusTimestamp#4f96cb18"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputPrivacyKeyStatusTimestamp) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x4f96cb18.toInt()
    }
}
