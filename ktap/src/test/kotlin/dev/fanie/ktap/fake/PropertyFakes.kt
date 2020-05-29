package dev.fanie.ktap.fake

import javax.lang.model.element.Name

internal fun CharSequence.asName() = object : Name {
    override fun get(index: Int): Char = this@asName[index]

    override fun contentEquals(p0: CharSequence?): Boolean = p0 == this@asName

    override fun subSequence(startIndex: Int, endIndex: Int): CharSequence = this@asName.subSequence(startIndex, endIndex)

    override val length: Int get() = this@asName.length

    override fun toString(): String = this@asName.toString()
}