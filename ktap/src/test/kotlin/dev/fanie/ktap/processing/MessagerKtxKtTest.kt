package dev.fanie.ktap.processing

import dev.fanie.ktap.fake.MessagerPrint
import dev.fanie.ktap.fake.MessagerState
import dev.fanie.ktap.fake.annotationMirror
import dev.fanie.ktap.fake.annotationValue
import dev.fanie.ktap.fake.element
import dev.fanie.ktap.fake.messager
import dev.fanie.ktap.processing.error
import dev.fanie.ktap.processing.note
import dev.fanie.ktap.processing.other
import dev.fanie.ktap.processing.warning
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import javax.annotation.processing.Messager
import javax.tools.Diagnostic.Kind

internal class MessagerKtxKtTest {
    private lateinit var state: MessagerState
    private lateinit var underTest: Messager

    @BeforeEach
    fun setUp() {
        state = MessagerState()
        underTest = messager(state)
    }

    @Test
    fun `when printing an error message, then the message is printed`() {
        val kind = Kind.ERROR
        val charSequence = "This is a test error message"
        underTest.error(charSequence)
        assertEquals(MessagerPrint(kind, charSequence), state.getLatestPrint())

        val element = element()
        underTest.error(charSequence, element)
        assertEquals(MessagerPrint(kind, charSequence, element), state.getLatestPrint())

        val annotationMirror = annotationMirror()
        underTest.error(charSequence, element, annotationMirror)
        assertEquals(
            MessagerPrint(kind, charSequence, element, annotationMirror),
            state.getLatestPrint()
        )

        val annotationValue = annotationValue()
        underTest.error(charSequence, element, annotationMirror, annotationValue)
        assertEquals(
            MessagerPrint(kind, charSequence, element, annotationMirror, annotationValue),
            state.getLatestPrint()
        )
    }

    @Test
    fun `when printing an error, then the message is printed`() {
        val kind = Kind.ERROR
        val throwable = IllegalStateException("This is a test error")
        underTest.error(throwable)
        assertEquals(MessagerPrint(kind, throwable.localizedMessage), state.getLatestPrint())

        val element = element()
        underTest.error(throwable, element)
        assertEquals(
            MessagerPrint(kind, throwable.localizedMessage, element),
            state.getLatestPrint()
        )

        val annotationMirror = annotationMirror()
        underTest.error(throwable, element, annotationMirror)
        assertEquals(
            MessagerPrint(kind, throwable.localizedMessage, element, annotationMirror),
            state.getLatestPrint()
        )

        val annotationValue = annotationValue()
        underTest.error(throwable, element, annotationMirror, annotationValue)
        assertEquals(
            MessagerPrint(kind, throwable.localizedMessage, element, annotationMirror, annotationValue),
            state.getLatestPrint()
        )
    }

    @Test
    fun `when printing a warning message, then the message is printed`() {
        val kind = Kind.WARNING
        val charSequence = "This is a test warning"
        underTest.warning(charSequence)
        assertEquals(MessagerPrint(kind, charSequence), state.getLatestPrint())

        val element = element()
        underTest.warning(charSequence, element)
        assertEquals(MessagerPrint(kind, charSequence, element), state.getLatestPrint())

        val annotationMirror = annotationMirror()
        underTest.warning(charSequence, element, annotationMirror)
        assertEquals(
            MessagerPrint(kind, charSequence, element, annotationMirror),
            state.getLatestPrint()
        )

        val annotationValue = annotationValue()
        underTest.warning(charSequence, element, annotationMirror, annotationValue)
        assertEquals(
            MessagerPrint(kind, charSequence, element, annotationMirror, annotationValue),
            state.getLatestPrint()
        )
    }

    @Test
    fun `when printing a mandatory warning message, then the message is printed`() {
        val kind = Kind.MANDATORY_WARNING
        val charSequence = "This is a test mandatory warning"
        underTest.warning(charSequence, mandatory = true)
        assertEquals(MessagerPrint(kind, charSequence), state.getLatestPrint())

        val element = element()
        underTest.warning(charSequence, element, mandatory = true)
        assertEquals(MessagerPrint(kind, charSequence, element), state.getLatestPrint())

        val annotationMirror = annotationMirror()
        underTest.warning(charSequence, element, annotationMirror, mandatory = true)
        assertEquals(
            MessagerPrint(kind, charSequence, element, annotationMirror),
            state.getLatestPrint()
        )

        val annotationValue = annotationValue()
        underTest.warning(charSequence, element, annotationMirror, annotationValue, mandatory = true)
        assertEquals(
            MessagerPrint(kind, charSequence, element, annotationMirror, annotationValue),
            state.getLatestPrint()
        )
    }

    @Test
    fun `when printing a note, then the message is printed`() {
        val kind = Kind.NOTE
        val charSequence = "This is a test note"
        underTest.note(charSequence)
        assertEquals(MessagerPrint(kind, charSequence), state.getLatestPrint())

        val element = element()
        underTest.note(charSequence, element)
        assertEquals(MessagerPrint(kind, charSequence, element), state.getLatestPrint())

        val annotationMirror = annotationMirror()
        underTest.note(charSequence, element, annotationMirror)
        assertEquals(
            MessagerPrint(kind, charSequence, element, annotationMirror),
            state.getLatestPrint()
        )

        val annotationValue = annotationValue()
        underTest.note(charSequence, element, annotationMirror, annotationValue)
        assertEquals(
            MessagerPrint(kind, charSequence, element, annotationMirror, annotationValue),
            state.getLatestPrint()
        )
    }

    @Test
    fun `when printing something else, then the message is printed`() {
        val kind = Kind.OTHER
        val charSequence = "This is a test message"
        underTest.other(charSequence)
        assertEquals(MessagerPrint(kind, charSequence), state.getLatestPrint())

        val element = element()
        underTest.other(charSequence, element)
        assertEquals(MessagerPrint(kind, charSequence, element), state.getLatestPrint())

        val annotationMirror = annotationMirror()
        underTest.other(charSequence, element, annotationMirror)
        assertEquals(
            MessagerPrint(kind, charSequence, element, annotationMirror),
            state.getLatestPrint()
        )

        val annotationValue = annotationValue()
        underTest.other(charSequence, element, annotationMirror, annotationValue)
        assertEquals(
            MessagerPrint(kind, charSequence, element, annotationMirror, annotationValue),
            state.getLatestPrint()
        )
    }
}