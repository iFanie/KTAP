package dev.fanie.ktap.type

import dev.fanie.ktap.fake.typeMirror
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import javax.lang.model.type.TypeKind
import javax.lang.model.type.TypeMirror

internal class KTypeMirrorTest {
    @Test
    fun `given type is boolean, when getting toString(), then the result is the expected`() {
        val boolean = typeMirror(kind = TypeKind.BOOLEAN)
        val underTest = kTypeMirror(typeMirror = boolean, isOptional = false)
        assertEquals(Boolean::class.qualifiedName.toString(), underTest.stringValue)
    }

    @Test
    fun `given type is byte, when getting toString(), then the result is the expected`() {
        val byte = typeMirror(kind = TypeKind.BYTE)
        val underTest = kTypeMirror(typeMirror = byte, isOptional = false)
        assertEquals(Byte::class.qualifiedName.toString(), underTest.stringValue)
    }

    @Test
    fun `given type is short, when getting toString(), then the result is the expected`() {
        val short = typeMirror(kind = TypeKind.SHORT)
        val underTest = kTypeMirror(typeMirror = short, isOptional = false)
        assertEquals(Short::class.qualifiedName.toString(), underTest.stringValue)
    }

    @Test
    fun `given type is int, when getting toString(), then the result is the expected`() {
        val int = typeMirror(kind = TypeKind.INT)
        val underTest = kTypeMirror(typeMirror = int, isOptional = false)
        assertEquals(Int::class.qualifiedName.toString(), underTest.stringValue)
    }

    @Test
    fun `given type is long, when getting toString(), then the result is the expected`() {
        val long = typeMirror(kind = TypeKind.LONG)
        val underTest = kTypeMirror(typeMirror = long, isOptional = false)
        assertEquals(Long::class.qualifiedName.toString(), underTest.stringValue)
    }

    @Test
    fun `given type is char, when getting toString(), then the result is the expected`() {
        val char = typeMirror(kind = TypeKind.CHAR)
        val underTest = kTypeMirror(typeMirror = char, isOptional = false)
        assertEquals(Char::class.qualifiedName.toString(), underTest.stringValue)
    }

    @Test
    fun `given type is float, when getting toString(), then the result is the expected`() {
        val float = typeMirror(kind = TypeKind.FLOAT)
        val underTest = kTypeMirror(typeMirror = float, isOptional = false)
        assertEquals(Float::class.qualifiedName.toString(), underTest.stringValue)
    }

    @Test
    fun `given type is double, when getting toString(), then the result is the expected`() {
        val double = typeMirror(kind = TypeKind.DOUBLE)
        val underTest = kTypeMirror(typeMirror = double, isOptional = false)
        assertEquals(Double::class.qualifiedName.toString(), underTest.stringValue)
    }

    @Test
    fun `given type is not primitive and optional, when getting toString(), then the result is the expected`() {
        val definition = "com.some.Type"
        val type = typeMirror(kind = TypeKind.OTHER, toString = definition)
        val underTest = kTypeMirror(typeMirror = type, isOptional = true)
        assertEquals("$definition?", underTest.stringValue)
    }

    @Test
    fun `given type is not primitive and not optional, when getting toString(), then the result is the expected`() {
        val definition = "com.some.other.Type"
        val type = typeMirror(kind = TypeKind.OTHER, toString = definition)
        val underTest = kTypeMirror(typeMirror = type, isOptional = false)
        assertEquals(definition, underTest.stringValue)
    }
}

private fun kTypeMirror(
    typeMirror: TypeMirror,
    isOptional: Boolean
) = object : KTypeMirror(typeMirror) {
    override val isOptional: Boolean = isOptional
}