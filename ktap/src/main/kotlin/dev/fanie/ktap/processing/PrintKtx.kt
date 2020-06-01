package dev.fanie.ktap.processing

import javax.lang.model.element.AnnotationMirror
import javax.lang.model.element.AnnotationValue
import javax.lang.model.element.Element
import javax.lang.model.element.ElementKind
import javax.lang.model.element.ExecutableElement
import javax.lang.model.element.Modifier
import javax.lang.model.element.Name
import javax.lang.model.element.NestingKind
import javax.lang.model.element.PackageElement
import javax.lang.model.element.TypeElement
import javax.lang.model.element.TypeParameterElement
import javax.lang.model.element.VariableElement
import javax.lang.model.type.DeclaredType
import javax.lang.model.type.TypeMirror

private const val NUL = "null"

private fun TypeMirror?.forPrint() = this?.let { "TypeMirror(kind=${kind})" } ?: NUL

fun TypeMirror?.toPrintable() = forPrint()

private fun List<TypeMirror>?.printTypeMirrors() = this?.let { list ->
    buildString {
        append('[')
        list.forEachIndexed { index, mirror ->
            append(mirror.forPrint())
            if (index < list.size - 1) {
                append(", ")
            }
        }
        append(']')
    }
} ?: NUL

private fun ElementKind?.forPrint() = this?.toString() ?: NUL

fun ElementKind?.toPrintable() = forPrint()

private fun Modifier?.forPrint() = this?.toString() ?: NUL

fun Modifier?.toPrintable() = forPrint()

private fun Set<Modifier>?.printModifiers() = this?.let { set ->
    buildString {
        append('[')
        set.forEachIndexed { index, modifier ->
            append(modifier.forPrint())
            if (index < set.size - 1) {
                append(", ")
            }
        }
        append(']')
    }
} ?: NUL

private fun Name?.forPrint() = this?.toString() ?: NUL

fun Name?.toPrintable() = forPrint()

private fun DeclaredType?.forPrint(withEnclosing: Boolean) = this?.let { type ->
    buildString {
        append("DeclaredType(")
        append("asElement=${type.asElement()?.findAndPrint(withEnclosing, false)}, ")
        if (withEnclosing) {
            append("enclosingType=${type.enclosingType?.forPrint()}, ")
        }
        append("typeArguments=${typeArguments?.printTypeMirrors()}")
        append(")")
    }
} ?: NUL

fun DeclaredType?.toPrintable() = forPrint(withEnclosing = true)

private fun AnnotationValue?.forPrint() = this?.value?.toString() ?: NUL

fun AnnotationValue?.toPrintable() = forPrint()

private fun MutableMap<out ExecutableElement, out AnnotationValue>?.printElementWithValues(
    withEnclosing: Boolean,
    withEnclosed: Boolean
) = this?.let { map ->
    buildString {
        append('[')
        var index = 0
        map.forEach { (element, value) ->
            append("(${element.forPrint(withEnclosing, withEnclosed)} -> ${value.forPrint()})")
            if (index < map.size - 1) {
                append(", ")
            }
            index++
        }
        append(']')
    }
} ?: NUL

private fun AnnotationMirror?.forPrint() = this?.let {
    buildString {
        append("AnnotationMirror(")
        append("annotationType=${annotationType?.forPrint()}, ")
        append("annotationValues=${elementValues?.printElementWithValues(withEnclosing = false, withEnclosed = false)}")
        append(')')
    }
} ?: NUL

fun AnnotationMirror?.toPrintable() = forPrint()

private fun List<AnnotationMirror>?.printAnnotationMirrors() = this?.let { list ->
    buildString {
        append('[')
        list.forEachIndexed { index, mirror ->
            append(mirror.forPrint())
            if (index < list.size - 1) {
                append(", ")
            }
        }
        append(']')
    }
} ?: NUL

private fun NestingKind?.forPrint() = this?.toString() ?: NUL

fun NestingKind?.toPrintable() = forPrint()

private fun TypeParameterElement?.forPrint(withEnclosed: Boolean, withEnclosing: Boolean): String {
    return this?.let {
        buildString {
            append("TypeParameterElement(")
            append("asType=${asType()?.forPrint()}, ")
            append("kind=${kind?.forPrint()}, ")
            append("modifiers=${modifiers?.printModifiers()}, ")
            append("simpleName=${simpleName?.forPrint()}, ")
            if (withEnclosed) {
                append(
                    "enclosedElements=${enclosedElements?.findAndPrintElements(
                        withEnclosed = false,
                        withEnclosing = false
                    )}, "
                )
            }
            append("annotationMirrors=${annotationMirrors?.printAnnotationMirrors()}, ")
            append("genericElement=${genericElement?.findAndPrint(withEnclosing = false, withEnclosed = false)}, ")
            append("bounds=${bounds?.printTypeMirrors()}, ")
            if (withEnclosing) {
                append("enclosingElement=${enclosingElement?.findAndPrint(withEnclosed = false, withEnclosing = false)}")
            }
            append(')')
        }
    } ?: NUL
}

fun TypeParameterElement?.toPrintable() = forPrint(withEnclosed = true, withEnclosing = true)

private fun List<TypeParameterElement>?.printTypeParameterElements(
    withEnclosed: Boolean,
    withEnclosing: Boolean
) = this?.let { list ->
    buildString {
        append('[')
        list.forEachIndexed { index, element ->
            append(element.forPrint(withEnclosed, withEnclosing))
            if (index < list.size - 1) {
                append(", ")
            }
        }
        append(']')
    }
} ?: NUL

private fun VariableElement?.forPrint(withEnclosed: Boolean, withEnclosing: Boolean): String {
    return this?.let {
        buildString {
            append("VariableElement(")
            append("asType=${asType()?.forPrint()}, ")
            append("kind=${kind?.forPrint()}, ")
            append("modifiers=${modifiers?.printModifiers()}, ")
            if (withEnclosed) {
                append(
                    "enclosedElements=${enclosedElements?.findAndPrintElements(
                        withEnclosing = false,
                        withEnclosed = false
                    )}, "
                )
            }
            append("annotationMirrors=${annotationMirrors?.printAnnotationMirrors()}, ")
            append("constantValue=$constantValue, ")
            append("simpleName=${simpleName?.forPrint()}, ")
            if (withEnclosing) {
                append("enclosingElement=${enclosingElement?.findAndPrint(withEnclosing = false, withEnclosed = false)}")
            }
            append(')')
        }
    } ?: NUL
}

fun VariableElement?.toPrintable() = forPrint(withEnclosed = true, withEnclosing = true)

private fun List<VariableElement>?.printVariableElements(withEnclosed: Boolean, withEnclosing: Boolean) = this?.let { list ->
    buildString {
        append('[')
        list.forEachIndexed { index, element ->
            append(element.forPrint(withEnclosed, withEnclosing))
            if (index < list.size - 1) {
                append(", ")
            }
        }
        append(']')
    }
} ?: NUL

private fun ExecutableElement?.forPrint(withEnclosing: Boolean, withEnclosed: Boolean): String {
    return this?.let {
        buildString {
            append("ExecutableElement(")
            append("asType=${asType()?.forPrint()}, ")
            append("kind=${kind?.forPrint()}, ")
            append("modifiers=${modifiers?.printModifiers()}, ")
            if (withEnclosing) {
                append("enclosingElement=${enclosingElement?.findAndPrint(withEnclosing = false, withEnclosed = false)}, ")
            }
            if (withEnclosed) {
                append(
                    "enclosedElements=${enclosedElements?.findAndPrintElements(
                        withEnclosing = false,
                        withEnclosed = false
                    )}, "
                )
            }
            append("annotationMirrors=${annotationMirrors?.printAnnotationMirrors()}, ")
            append(
                "typeParameters=${typeParameters?.printTypeParameterElements(
                    withEnclosing = false,
                    withEnclosed = false
                )}, "
            )
            append("returnType=${returnType?.forPrint()}, ")
            append("parameters=${parameters?.printVariableElements(withEnclosing = false, withEnclosed = false)}, ")
            append("receiverType=${receiverType?.forPrint()}, ")
            append("isVarArgs=$isVarArgs, ")
            append("isDefault=$isDefault, ")
            append("thrownTypes=${thrownTypes?.printTypeMirrors()}, ")
            append("defaultValue=${defaultValue?.forPrint()}, ")
            append("simpleName=${simpleName?.forPrint()}")
            append(')')
        }
    } ?: NUL
}

fun ExecutableElement?.toPrintable() = forPrint(withEnclosing = true, withEnclosed = true)

private fun PackageElement?.forPrint(withEnclosing: Boolean, withEnclosed: Boolean): String {
    return this?.let {
        buildString {
            append("PackageElement(")
            append("asType=${asType()?.forPrint()}, ")
            append("kind=${kind?.forPrint()}, ")
            append("modifiers=${modifiers?.printModifiers()}, ")
            if (withEnclosed) {
                append(
                    "enclosedElements=${enclosedElements?.findAndPrintElements(
                        withEnclosing = false, withEnclosed = false
                    )}, "
                )
            }
            append("annotationMirrors=${annotationMirrors?.printAnnotationMirrors()}, ")
            append("qualifiedName=${qualifiedName?.forPrint()}, ")
            append("simpleName=${simpleName?.forPrint()}, ")
            append("enclosedElement=${enclosedElements?.findAndPrintElements(withEnclosing = false, withEnclosed = false)}, ")
            append("isUnnamed=$isUnnamed, ")
            if (withEnclosing) {
                append("enclosingElement=${enclosingElement?.findAndPrint(withEnclosing = false, withEnclosed = false)}, ")
            }
            append(')')
        }
    } ?: NUL
}

fun PackageElement?.toPrintable() = forPrint(withEnclosing = true, withEnclosed = true)

private fun TypeElement?.forPrint(withEnclosed: Boolean, withEnclosing: Boolean): String {
    return this?.let {
        buildString {
            append("TypeElement(")
            append("asType=${asType()?.forPrint()}, ")
            append("kind=${kind?.forPrint()}, ")
            append("modifiers=${modifiers?.printModifiers()}, ")
            append("annotationMirrors=${annotationMirrors?.printAnnotationMirrors()}, ")
            if (withEnclosed) {
                append(
                    "enclosedElements=${enclosedElements?.findAndPrintElements(
                        withEnclosing = false,
                        withEnclosed = false
                    )}, "
                )
            }
            append("nestingKind=${nestingKind?.forPrint()}, ")
            append("qualifiedName=${qualifiedName?.forPrint()}, ")
            append("simpleName=${simpleName?.forPrint()}, ")
            append("superclass=${superclass?.forPrint()}, ")
            append("interfaces=${interfaces?.printTypeMirrors()}, ")
            append(
                "typeParameters=${typeParameters?.printTypeParameterElements(
                    withEnclosing = false,
                    withEnclosed = false
                )}, "
            )
            if (withEnclosing) {
                append("enclosingElement=${enclosingElement?.findAndPrint(withEnclosing = false, withEnclosed = false)}, ")
            }
            append(')')
        }
    } ?: NUL
}

fun TypeElement?.toPrintable() = forPrint(withEnclosed = true, withEnclosing = true)

private fun Element?.findAndPrint(withEnclosing: Boolean, withEnclosed: Boolean) = when (this) {
    null -> NUL
    is TypeParameterElement -> this.forPrint(withEnclosed, withEnclosing)
    is VariableElement -> this.forPrint(withEnclosed, withEnclosing)
    is ExecutableElement -> this.forPrint(withEnclosing, withEnclosed)
    is PackageElement -> this.forPrint(withEnclosing, withEnclosed)
    is TypeElement -> this.forPrint(withEnclosed, withEnclosing)
    else -> NoSuchElementException()
}

private fun List<Element>?.findAndPrintElements(withEnclosing: Boolean, withEnclosed: Boolean) = this?.let { list ->
    buildString {
        append('[')
        list.forEachIndexed { index, element ->
            append(element.findAndPrint(withEnclosing, withEnclosed))
            if (index < list.size - 1) {
                append(", ")
            }
        }
        append(']')
    }
} ?: NUL
