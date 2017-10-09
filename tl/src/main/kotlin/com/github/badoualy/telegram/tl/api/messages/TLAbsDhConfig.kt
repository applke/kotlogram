package com.github.badoualy.telegram.tl.api.messages

import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [messages.dhConfig#2c221edd][TLDhConfig]
 * * [messages.dhConfigNotModified#c0e24635][TLDhConfigNotModified]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsDhConfig : TLObject() {
    abstract var random: TLBytes
}