package dev.fanie.ktap.fake

import javax.annotation.processing.Messager
import javax.lang.model.element.AnnotationMirror
import javax.lang.model.element.AnnotationValue
import javax.lang.model.element.Element
import javax.tools.Diagnostic.Kind

internal data class MessagerPrint(
    val kind: Kind,
    val charSequence: CharSequence,
    val element: Element? = null,
    val annotationMirror: AnnotationMirror? = null,
    val annotationValue: AnnotationValue? = null
)

internal class MessagerState {
    private val prints = mutableListOf<MessagerPrint>()

    fun print(
        kind: Kind,
        charSequence: CharSequence,
        element: Element? = null,
        annotationMirror: AnnotationMirror? = null,
        annotationValue: AnnotationValue? = null
    ) {
        val newPrint = MessagerPrint(kind, charSequence, element, annotationMirror, annotationValue)
        prints.add(newPrint)
    }

    fun getLatestPrint() = prints.last()
}

internal fun messager(state: MessagerState) = object : Messager {
    override fun printMessage(p0: Kind, p1: CharSequence) {
        state.print(p0, p1)
    }

    override fun printMessage(p0: Kind, p1: CharSequence, p2: Element) {
        state.print(p0, p1, p2)
    }

    override fun printMessage(p0: Kind, p1: CharSequence, p2: Element, p3: AnnotationMirror) {
        state.print(p0, p1, p2, p3)
    }

    override fun printMessage(
        p0: Kind,
        p1: CharSequence,
        p2: Element?,
        p3: AnnotationMirror?,
        p4: AnnotationValue?
    ) {
        state.print(p0, p1, p2, p3, p4)
    }
}
