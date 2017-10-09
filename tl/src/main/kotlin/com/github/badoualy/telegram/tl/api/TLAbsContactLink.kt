package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [contactLinkContact#d502c2d0][TLContactLinkContact]
 * * [contactLinkHasPhone#268f3f59][TLContactLinkHasPhone]
 * * [contactLinkNone#feedd3ad][TLContactLinkNone]
 * * [contactLinkUnknown#5f4f9247][TLContactLinkUnknown]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsContactLink : TLObject()