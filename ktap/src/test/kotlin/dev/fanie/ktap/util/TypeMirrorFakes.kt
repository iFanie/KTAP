package dev.fanie.ktap.util

import javax.lang.model.element.AnnotationMirror
import javax.lang.model.type.TypeKind
import javax.lang.model.type.TypeMirror
import javax.lang.model.type.TypeVisitor
import kotlin.reflect.KClass

internal fun typeMirror(
    kind: TypeKind? = null,
    annotations: List<KClass<out Annotation>>? = null,
    annotationMirrors: List<AnnotationMirror>? = null,
    toString: String? = null
) = object : TypeMirror {
    override fun getKind(): TypeKind = kind!!

    override fun <R : Any?, P : Any?> accept(p0: TypeVisitor<R, P>?, p1: P): R = wontDo()

    override fun <A : Annotation> getAnnotationsByType(p0: Class<A>): Array<A> = wontDo()

    override fun <A : Annotation> getAnnotation(p0: Class<A>): A? = tryToFind(p0, annotations!!)

    override fun getAnnotationMirrors(): List<AnnotationMirror> = annotationMirrors!!

    override fun toString(): String = toString!!
}