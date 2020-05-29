package dev.fanie.ktap.type

import javax.lang.model.type.TypeKind
import javax.lang.model.type.TypeMirror

abstract class KTypeMirror(private val typeMirror: TypeMirror) : TypeMirror by typeMirror {
    abstract val isOptional: Boolean

    val stringValue: String
        get() = when (kind) {
            TypeKind.BOOLEAN -> Boolean::class.qualifiedName.toString()
            TypeKind.BYTE -> Byte::class.qualifiedName.toString()
            TypeKind.SHORT -> Short::class.qualifiedName.toString()
            TypeKind.INT -> Int::class.qualifiedName.toString()
            TypeKind.LONG -> Long::class.qualifiedName.toString()
            TypeKind.CHAR -> Char::class.qualifiedName.toString()
            TypeKind.FLOAT -> Float::class.qualifiedName.toString()
            TypeKind.DOUBLE -> Double::class.qualifiedName.toString()
            else -> typeMirror.toString() + if (isOptional) "?" else ""
        }
}
