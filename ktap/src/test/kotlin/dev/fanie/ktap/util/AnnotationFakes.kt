package dev.fanie.ktap.util

import java.lang.reflect.Proxy
import javax.lang.model.element.AnnotationMirror
import javax.lang.model.element.AnnotationValue
import javax.lang.model.element.AnnotationValueVisitor
import javax.lang.model.element.ExecutableElement
import javax.lang.model.type.DeclaredType
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
internal fun <A : Annotation> annotation(kClass: KClass<out A>) =
    Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), arrayOf(kClass.java)) { _, _, _ -> wontDo() } as A

internal fun annotationMirror(
    annotationType: DeclaredType? = null,
    elementValues: Map<ExecutableElement, AnnotationValue>? = null
) = object : AnnotationMirror {
    override fun getAnnotationType(): DeclaredType = annotationType!!

    override fun getElementValues(): Map<ExecutableElement, AnnotationValue> = elementValues!!
}

internal fun annotationValue(value: Any? = null) = object : AnnotationValue {
    override fun <R : Any?, P : Any?> accept(p0: AnnotationValueVisitor<R, P>?, p1: P): R = wontDo()

    override fun getValue(): Any = value!!
}
