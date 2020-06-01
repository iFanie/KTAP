package dev.fanie.ktap.element

import dev.fanie.ktap.type.KTypeMirror
import org.jetbrains.annotations.NotNull
import javax.lang.model.element.ExecutableElement
import javax.lang.model.element.VariableElement

fun ExecutableElement.isOptional() = this.getAnnotation(NotNull::class.java) == null && !returnType.kind.isPrimitive

val ExecutableElement.returnKType: KTypeMirror
    get() = object : KTypeMirror(returnType) {
        override val isOptional: Boolean get() = this@returnKType.isOptional()
    }

fun VariableElement.isOptional() = this.getAnnotation(NotNull::class.java) == null && !asType().kind.isPrimitive

fun VariableElement.asKType(): KTypeMirror = object : KTypeMirror(asType()) {
    override val isOptional: Boolean get() = this@asKType.isOptional()
}
