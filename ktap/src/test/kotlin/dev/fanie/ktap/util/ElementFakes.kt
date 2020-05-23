package dev.fanie.ktap.util

import javax.lang.model.element.AnnotationMirror
import javax.lang.model.element.AnnotationValue
import javax.lang.model.element.Element
import javax.lang.model.element.ElementKind
import javax.lang.model.element.ElementVisitor
import javax.lang.model.element.ExecutableElement
import javax.lang.model.element.Modifier
import javax.lang.model.element.Name
import javax.lang.model.element.NestingKind
import javax.lang.model.element.PackageElement
import javax.lang.model.element.TypeElement
import javax.lang.model.element.TypeParameterElement
import javax.lang.model.element.VariableElement
import javax.lang.model.type.TypeMirror
import kotlin.reflect.KClass

internal fun element(
    modifiers: Set<Modifier>? = null,
    simpleName: Name? = null,
    kind: ElementKind? = null,
    asType: TypeMirror? = null,
    enclosingElement: Element? = null,
    annotations: List<KClass<out Annotation>>? = null,
    annotationMirrors: List<AnnotationMirror>? = null,
    enclosedElements: List<Element>? = null
) = object : Element {
    override fun getModifiers(): Set<Modifier> = modifiers!!

    override fun getSimpleName(): Name = simpleName!!

    override fun getKind(): ElementKind = kind!!

    override fun asType(): TypeMirror = asType!!

    override fun getEnclosingElement(): Element = enclosingElement!!

    override fun <R : Any?, P : Any?> accept(p0: ElementVisitor<R, P>?, p1: P): R = wontDo()

    override fun <A : Annotation> getAnnotationsByType(p0: Class<A>?): Array<A> = wontDo()

    override fun <A : Annotation> getAnnotation(p0: Class<A>): A? = tryToFind(p0, annotations!!)

    override fun getAnnotationMirrors(): List<AnnotationMirror> = annotationMirrors!!

    override fun getEnclosedElements(): List<Element> = enclosedElements!!
}

internal fun executableElement(
    annotationValue: AnnotationValue? = null,
    modifiers: Set<Modifier>? = null,
    simpleName: Name? = null,
    kind: ElementKind? = null,
    asType: TypeMirror? = null,
    returnType: TypeMirror? = null,
    receiverType: TypeMirror? = null,
    thrownTypes: List<TypeMirror>? = null,
    typeParameters: List<TypeParameterElement>? = null,
    enclosingElement: Element? = null,
    parameters: List<VariableElement>? = null,
    isVarArgs: Boolean? = null,
    isDefault: Boolean? = null,
    annotations: List<KClass<out Annotation>>? = null,
    annotationMirrors: List<AnnotationMirror>? = null,
    enclosedElements: List<Element>? = null
) = object : ExecutableElement {
    override fun getDefaultValue(): AnnotationValue = annotationValue!!

    override fun getModifiers(): Set<Modifier> = modifiers!!

    override fun getSimpleName(): Name = simpleName!!

    override fun getKind(): ElementKind = kind!!

    override fun asType(): TypeMirror = asType!!

    override fun getReturnType(): TypeMirror = returnType!!

    override fun getReceiverType(): TypeMirror = receiverType!!

    override fun getThrownTypes(): List<TypeMirror> = thrownTypes!!

    override fun getTypeParameters(): List<TypeParameterElement> = typeParameters!!

    override fun getEnclosingElement(): Element = enclosingElement!!

    override fun <R : Any?, P : Any?> accept(p0: ElementVisitor<R, P>?, p1: P): R = wontDo()

    override fun getParameters(): List<VariableElement> = parameters!!

    override fun isVarArgs(): Boolean = isVarArgs!!

    override fun <A : Annotation> getAnnotationsByType(p0: Class<A>): Array<A> = wontDo()

    override fun isDefault(): Boolean = isDefault!!

    override fun <A : Annotation> getAnnotation(p0: Class<A>): A? = tryToFind(p0, annotations!!)

    override fun getAnnotationMirrors(): List<AnnotationMirror> = annotationMirrors!!

    override fun getEnclosedElements(): List<Element> = enclosedElements!!
}

internal fun methodElement(
    annotationValue: AnnotationValue? = null,
    modifiers: Set<Modifier>? = null,
    simpleName: Name? = null,
    asType: TypeMirror? = null,
    returnType: TypeMirror? = null,
    receiverType: TypeMirror? = null,
    thrownTypes: List<TypeMirror>? = null,
    typeParameters: List<TypeParameterElement>? = null,
    enclosingElement: Element? = null,
    parameters: List<VariableElement>? = null,
    isVarArgs: Boolean? = null,
    isDefault: Boolean? = null,
    annotations: List<KClass<out Annotation>>? = null,
    annotationMirrors: List<AnnotationMirror>? = null,
    enclosedElements: List<Element>? = null
) = executableElement(
    annotationValue,
    modifiers,
    simpleName,
    ElementKind.METHOD,
    asType,
    returnType,
    receiverType,
    thrownTypes,
    typeParameters,
    enclosingElement,
    parameters,
    isVarArgs,
    isDefault,
    annotations,
    annotationMirrors,
    enclosedElements
)

internal fun constructorElement(
    annotationValue: AnnotationValue? = null,
    modifiers: Set<Modifier>? = null,
    simpleName: Name? = null,
    asType: TypeMirror? = null,
    returnType: TypeMirror? = null,
    receiverType: TypeMirror? = null,
    thrownTypes: List<TypeMirror>? = null,
    typeParameters: List<TypeParameterElement>? = null,
    enclosingElement: Element? = null,
    parameters: List<VariableElement>? = null,
    isVarArgs: Boolean? = null,
    isDefault: Boolean? = null,
    annotations: List<KClass<out Annotation>>? = null,
    annotationMirrors: List<AnnotationMirror>? = null,
    enclosedElements: List<Element>? = null
) = executableElement(
    annotationValue,
    modifiers,
    simpleName,
    ElementKind.CONSTRUCTOR,
    asType,
    returnType,
    receiverType,
    thrownTypes,
    typeParameters,
    enclosingElement,
    parameters,
    isVarArgs,
    isDefault,
    annotations,
    annotationMirrors,
    enclosedElements
)

internal fun variableElement(
    modifiers: Set<Modifier>? = null,
    simpleName: Name? = null,
    kind: ElementKind? = null,
    asType: TypeMirror? = null,
    enclosingElement: Element? = null,
    annotations: List<KClass<out Annotation>>? = null,
    constantValue: Any? = null,
    annotationMirrors: List<AnnotationMirror>? = null,
    enclosedElements: List<Element>? = null
) = object : VariableElement {
    override fun getModifiers(): Set<Modifier> = modifiers!!

    override fun getSimpleName(): Name = simpleName!!

    override fun getKind(): ElementKind = kind!!

    override fun asType(): TypeMirror = asType!!

    override fun getEnclosingElement(): Element = enclosingElement!!

    override fun <R : Any?, P : Any?> accept(p0: ElementVisitor<R, P>?, p1: P): R = wontDo()

    override fun <A : Annotation> getAnnotationsByType(p0: Class<A>?): Array<A> = wontDo()

    override fun <A : Annotation> getAnnotation(p0: Class<A>): A? = tryToFind(p0, annotations!!)

    override fun getConstantValue(): Any = constantValue!!

    override fun getAnnotationMirrors(): List<AnnotationMirror> = annotationMirrors!!

    override fun getEnclosedElements(): List<Element> = enclosedElements!!
}

internal fun fieldElement(
    modifiers: Set<Modifier>? = null,
    simpleName: Name? = null,
    asType: TypeMirror? = null,
    enclosingElement: Element? = null,
    annotations: List<KClass<out Annotation>>? = null,
    constantValue: Any? = null,
    annotationMirrors: List<AnnotationMirror>? = null,
    enclosedElements: List<Element>? = null
) = variableElement(
    modifiers,
    simpleName,
    ElementKind.FIELD,
    asType,
    enclosingElement,
    annotations,
    constantValue,
    annotationMirrors,
    enclosedElements
)

internal fun typeElement(
    modifiers: Set<Modifier>? = null,
    simpleName: Name? = null,
    kind: ElementKind? = null,
    asType: TypeMirror? = null,
    superclass: TypeMirror? = null,
    typeParameters: List<TypeParameterElement>? = null,
    qualifiedName: Name? = null,
    enclosingElement: Element? = null,
    interfaces: List<TypeMirror>? = null,
    annotations: List<KClass<out Annotation>>? = null,
    nestingKind: NestingKind? = null,
    annotationMirrors: List<AnnotationMirror>? = null,
    enclosedElements: List<Element>? = null
) = object : TypeElement {
    override fun getModifiers(): Set<Modifier> = modifiers!!

    override fun getSimpleName(): Name = simpleName!!

    override fun getKind(): ElementKind = kind!!

    override fun asType(): TypeMirror = asType!!

    override fun getSuperclass(): TypeMirror = superclass!!

    override fun getTypeParameters(): List<TypeParameterElement> = typeParameters!!

    override fun getQualifiedName(): Name = qualifiedName!!

    override fun getEnclosingElement(): Element = enclosingElement!!

    override fun getInterfaces(): List<TypeMirror> = interfaces!!

    override fun <R : Any?, P : Any?> accept(p0: ElementVisitor<R, P>?, p1: P): R = wontDo()

    override fun <A : Annotation> getAnnotationsByType(p0: Class<A>): Array<A> = wontDo()

    override fun <A : Annotation> getAnnotation(p0: Class<A>): A? = tryToFind(p0, annotations!!)

    override fun getNestingKind(): NestingKind = nestingKind!!

    override fun getAnnotationMirrors(): List<AnnotationMirror> = annotationMirrors!!

    override fun getEnclosedElements(): List<Element> = enclosedElements!!
}

internal fun packageElement(
    modifiers: Set<Modifier>? = null,
    simpleName: Name? = null,
    kind: ElementKind? = null,
    asType: TypeMirror? = null,
    isUnnamed: Boolean? = null,
    qualifiedName: Name? = null,
    enclosingElement: Element? = null,
    annotations: List<KClass<out Annotation>>? = null,
    annotationMirrors: List<AnnotationMirror>? = null,
    enclosedElements: List<Element>? = null
) = object : PackageElement {
    override fun getModifiers(): Set<Modifier> = modifiers!!

    override fun getSimpleName(): Name = simpleName!!

    override fun getKind(): ElementKind = kind!!

    override fun asType(): TypeMirror = asType!!

    override fun isUnnamed(): Boolean = isUnnamed!!

    override fun getQualifiedName(): Name = qualifiedName!!

    override fun getEnclosingElement(): Element = enclosingElement!!

    override fun <R : Any?, P : Any?> accept(p0: ElementVisitor<R, P>?, p1: P): R = wontDo()

    override fun <A : Annotation> getAnnotationsByType(p0: Class<A>): Array<A> = wontDo()

    override fun <A : Annotation> getAnnotation(p0: Class<A>): A? = tryToFind(p0, annotations!!)

    override fun getAnnotationMirrors(): List<AnnotationMirror> = annotationMirrors!!

    override fun getEnclosedElements(): List<Element> = enclosedElements!!
}

private fun <A : Annotation> tryToFind(needle: Class<A>, haystack: List<KClass<out Annotation>>): A? {
    for (possibleNeedle in haystack) {
        if (needle.isAssignableFrom(possibleNeedle.java)) {
            return annotation(needle.kotlin)
        }
    }
    return null
}
