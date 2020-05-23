package dev.fanie.ktap

import dev.fanie.ktap.util.executableElement
import dev.fanie.ktap.util.variableElement
import org.jetbrains.annotations.NotNull
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class ElementKtxKtTest {
    @Test
    fun `given an executable element without the NotNull annotation, when reading the 'isOptional' extension, then the value is false`() {
        val element = executableElement(annotations = listOf())

        assertTrue(element.isOptional())
    }

    @Test
    fun `given an executable element with the NotNull annotation, when reading the 'isOptional' extension, then the value is false`() {
        val element = executableElement(annotations = listOf(NotNull::class))

        assertFalse(element.isOptional())
    }

    @Test
    fun `given a variable element without the NotNull annotation, when reading the 'isOptional' extension, then the value is false`() {
        val element = variableElement(annotations = listOf())

        assertTrue(element.isOptional())
    }

    @Test
    fun `given a variable element with the NotNull annotation, when reading the 'isOptional' extension, then the value is false`() {
        val element = variableElement(annotations = listOf(NotNull::class))

        assertFalse(element.isOptional())
    }
}
