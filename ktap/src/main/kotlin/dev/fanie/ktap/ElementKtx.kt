package dev.fanie.ktap

import org.jetbrains.annotations.NotNull
import javax.lang.model.element.ExecutableElement
import javax.lang.model.element.VariableElement

fun ExecutableElement.isOptional() = this.getAnnotation(NotNull::class.java) == null

fun VariableElement.isOptional() = this.getAnnotation(NotNull::class.java) == null
