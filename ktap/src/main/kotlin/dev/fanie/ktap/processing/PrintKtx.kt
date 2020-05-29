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

fun TypeMirror?.print() = this?.let { "TypeMirror(kind=${kind})" } ?: NUL

private fun List<TypeMirror>?.printTypeMirrors() = this?.let { list ->
    buildString {
        append('[')
        list.forEachIndexed { index, mirror ->
            append(mirror.print())
            if (index < list.size - 1) {
                append(", ")
            }
        }
        append(']')
    }
} ?: NUL

fun ElementKind?.print() = this?.toString() ?: NUL

fun Modifier?.print() = this?.toString() ?: NUL

private fun Set<Modifier>?.printModifiers() = this?.let { set ->
    buildString {
        append('[')
        set.forEachIndexed { index, modifier ->
            append(modifier.print())
            if (index < set.size - 1) {
                append(", ")
            }
        }
        append(']')
    }
} ?: NUL

fun Name?.print() = this?.toString() ?: NUL

fun DeclaredType?.print() = this?.let { type ->
    buildString {
        append("DeclaredType(")
        append("asElement=${type.asElement()?.findAndPrint()}, ")
        append("enclosingType=${type.enclosingType?.print()}, ")
        append("typeArguments=${typeArguments?.printTypeMirrors()}")
        append(")")
    }
} ?: NUL

fun AnnotationValue?.print() = this?.value?.toString() ?: NUL

private fun MutableMap<out ExecutableElement, out AnnotationValue>?.printElementWithValues() = this?.let { map ->
    buildString {
        append('[')
        var index = 0
        map.forEach { (element, value) ->
            append("(${element.print()} -> ${value.print()})")
            if (index < map.size - 1) {
                append(", ")
            }
            index++
        }
        append(']')
    }
} ?: NUL

fun AnnotationMirror?.print() = this?.let {
    buildString {
        append("AnnotationMirror(")
        append("annotationType=${annotationType?.print()}, ")
        append("annotationValues=${elementValues?.printElementWithValues()}")
        append(')')
    }
} ?: NUL

private fun List<AnnotationMirror>?.printAnnotationMirrors() = this?.let { list ->
    buildString {
        append('[')
        list.forEachIndexed { index, mirror ->
            append(mirror.print())
            if (index < list.size - 1) {
                append(", ")
            }
        }
        append(']')
    }
} ?: NUL

fun NestingKind?.print() = this?.toString() ?: NUL

fun TypeParameterElement?.print(): String {
    return this?.let {
        buildString {
            append("TypeParameterElement(")
            append("asType=${asType()?.print()}, ")
            append("kind=${kind?.print()}, ")
            append("modifiers=${modifiers?.printModifiers()}, ")
            append("simpleName=${simpleName?.print()}, ")
            append("enclosedElements=${enclosedElements?.findAndPrintElements()}, ")
            append("annotationMirrors=${annotationMirrors?.printAnnotationMirrors()}, ")
            append("genericElement=${genericElement?.findAndPrint()}, ")
            append("bounds=${bounds?.printTypeMirrors()}, ")
            append("enclosingElement=${enclosingElement?.findAndPrint()}")
            append(')')
        }
    } ?: NUL
}

private fun List<TypeParameterElement>?.printTypeParameterElements() = this?.let { list ->
    buildString {
        append('[')
        list.forEachIndexed { index, element ->
            append(element.print())
            if (index < list.size - 1) {
                append(", ")
            }
        }
        append(']')
    }
} ?: NUL

fun VariableElement?.print(): String {
    return this?.let {
        buildString {
            append("VariableElement(")
            append("asType=${asType()?.print()}, ")
            append("kind=${kind?.print()}, ")
            append("modifiers=${modifiers?.printModifiers()}, ")
            append("enclosedElements=${enclosedElements?.findAndPrintElements()}, ")
            append("annotationMirrors=${annotationMirrors?.printAnnotationMirrors()}, ")
            append("constantValue=$constantValue, ")
            append("simpleName=${simpleName?.print()}, ")
            append("enclosingElement=${enclosingElement?.findAndPrint()}")
            append(')')
        }
    } ?: NUL
}

private fun List<VariableElement>?.printVariableElements() = this?.let { list ->
    buildString {
        append('[')
        list.forEachIndexed { index, element ->
            append(element.print())
            if (index < list.size - 1) {
                append(", ")
            }
        }
        append(']')
    }
} ?: NUL

fun ExecutableElement?.print(): String {
    return this?.let {
        buildString {
            append("ExecutableElement(")
            append("asType=${asType()?.print()}, ")
            append("kind=${kind?.print()}, ")
            append("modifiers=${modifiers?.printModifiers()}, ")
            append("enclosingElement=${enclosingElement?.findAndPrint()}, ")
            append("enclosedElements=${enclosedElements?.findAndPrintElements()}, ")
            append("annotationMirrors=${annotationMirrors?.printAnnotationMirrors()}, ")
            append("typeParameters=${typeParameters?.printTypeParameterElements()}, ")
            append("returnType=${returnType?.print()}, ")
            append("parameters=${parameters?.printVariableElements()}, ")
            append("receiverType=${receiverType?.print()}")
            append("isVarArgs=$isVarArgs, ")
            append("isDefault=$isDefault, ")
            append("thrownTypes=${thrownTypes?.printTypeMirrors()}, ")
            append("defaultValue=${defaultValue?.print()}, ")
            append("simpleName=${simpleName?.print()}")
            append(')')
        }
    } ?: NUL
}

fun PackageElement?.print(): String {
    return this?.let {
        buildString {
            append("PackageElement(")
            append("asType=${asType()?.print()}, ")
            append("kind=${kind?.print()}, ")
            append("modifiers=${modifiers?.printModifiers()}, ")
            append("enclosingElement=${enclosingElement?.findAndPrint()}, ")
            append("enclosedElements=${enclosedElements?.findAndPrintElements()}, ")
            append("annotationMirrors=${annotationMirrors?.printAnnotationMirrors()}, ")
            append("qualifiedName=${qualifiedName?.print()}, ")
            append("simpleName=${simpleName?.print()}, ")
            append("enclosedElement=${enclosedElements?.findAndPrintElements()}, ")
            append("isUnnamed=$isUnnamed, ")
            append("enclosingElement=${enclosingElement?.findAndPrint()}")
            append(')')
        }
    } ?: NUL
}

fun TypeElement?.print(): String {
    return this?.let {
        buildString {
            append("PackageElement(")
            append("asType=${asType()?.print()}, ")
            append("kind=${kind?.print()}, ")
            append("modifiers=${modifiers?.printModifiers()}, ")
            append("enclosingElement=${enclosingElement?.findAndPrint()}, ")
            append("annotationMirrors=${annotationMirrors?.printAnnotationMirrors()}, ")
            append("enclosedElements=${enclosedElements?.findAndPrintElements()}, ")
            append("nestingKind=${nestingKind?.print()}, ")
            append("qualifiedName=${qualifiedName?.print()}, ")
            append("simpleName=${simpleName?.print()}, ")
            append("superclass=${superclass?.print()}, ")
            append("interfaces=${interfaces?.printTypeMirrors()}, ")
            append("typeParameters=${typeParameters?.printTypeParameterElements()}, ")
            append("enclosingElement=${enclosingElement?.findAndPrint()}")
            append(')')
        }
    } ?: NUL
}

private fun Element?.findAndPrint() = when (this) {
    null -> NUL
    is TypeParameterElement -> this.print()
    is VariableElement -> this.print()
    is ExecutableElement -> this.print()
    is PackageElement -> this.print()
    is TypeElement -> this.print()
    else -> throw NoSuchElementException()
}

private fun List<Element>?.findAndPrintElements() = this?.let { list ->
    buildString {
        append('[')
        list.forEachIndexed { index, element ->
            append(element.findAndPrint())
            if (index < list.size - 1) {
                append(", ")
            }
        }
        append(']')
    }
} ?: NUL
