package dev.fanie.ktap.processing

import javax.annotation.processing.Messager
import javax.lang.model.element.AnnotationMirror
import javax.lang.model.element.AnnotationValue
import javax.lang.model.element.Element
import javax.tools.Diagnostic.Kind

fun Messager.error(error: CharSequence) = this.printMessage(Kind.ERROR, error)

fun Messager.error(error: CharSequence, element: Element) = this.printMessage(Kind.ERROR, error, element)

fun Messager.error(error: CharSequence, element: Element, annotationMirror: AnnotationMirror) =
    this.printMessage(Kind.ERROR, error, element, annotationMirror)

fun Messager.error(
    error: CharSequence,
    element: Element,
    annotationMirror: AnnotationMirror,
    annotationValue: AnnotationValue
) = this.printMessage(Kind.ERROR, error, element, annotationMirror, annotationValue)

fun Messager.error(error: Throwable) = this.printMessage(Kind.ERROR, error.localizedMessage)

fun Messager.error(error: Throwable, element: Element) = this.printMessage(Kind.ERROR, error.localizedMessage, element)

fun Messager.error(error: Throwable, element: Element, annotationMirror: AnnotationMirror) =
    this.printMessage(Kind.ERROR, error.localizedMessage, element, annotationMirror)

fun Messager.error(
    error: Throwable,
    element: Element,
    annotationMirror: AnnotationMirror,
    annotationValue: AnnotationValue
) = this.printMessage(Kind.ERROR, error.localizedMessage, element, annotationMirror, annotationValue)

fun Messager.warning(warning: CharSequence, mandatory: Boolean = false) =
    this.printMessage(mandatory.warningType, warning)

fun Messager.warning(warning: CharSequence, element: Element, mandatory: Boolean = false) =
    this.printMessage(mandatory.warningType, warning, element)

fun Messager.warning(
    warning: CharSequence,
    element: Element,
    annotationMirror: AnnotationMirror,
    mandatory: Boolean = false
) = this.printMessage(mandatory.warningType, warning, element, annotationMirror)

fun Messager.warning(
    warning: CharSequence,
    element: Element,
    annotationMirror: AnnotationMirror,
    annotationValue: AnnotationValue,
    mandatory: Boolean = false
) = this.printMessage(mandatory.warningType, warning, element, annotationMirror, annotationValue)

fun Messager.note(note: CharSequence) = this.printMessage(Kind.NOTE, note)

fun Messager.note(note: CharSequence, element: Element) = this.printMessage(Kind.NOTE, note, element)

fun Messager.note(note: CharSequence, element: Element, annotationMirror: AnnotationMirror) =
    this.printMessage(Kind.NOTE, note, element, annotationMirror)

fun Messager.note(
    note: CharSequence,
    element: Element,
    annotationMirror: AnnotationMirror,
    annotationValue: AnnotationValue
) = this.printMessage(Kind.NOTE, note, element, annotationMirror, annotationValue)

fun Messager.other(other: CharSequence) = this.printMessage(Kind.OTHER, other)

fun Messager.other(other: CharSequence, element: Element) = this.printMessage(Kind.OTHER, other, element)

fun Messager.other(other: CharSequence, element: Element, annotationMirror: AnnotationMirror) =
    this.printMessage(Kind.OTHER, other, element, annotationMirror)

fun Messager.other(
    other: CharSequence,
    element: Element,
    annotationMirror: AnnotationMirror,
    annotationValue: AnnotationValue
) = this.printMessage(Kind.OTHER, other, element, annotationMirror, annotationValue)

private val Boolean.warningType get() = if (this) Kind.MANDATORY_WARNING else Kind.WARNING
