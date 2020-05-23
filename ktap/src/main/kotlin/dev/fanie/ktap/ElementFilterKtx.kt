package dev.fanie.ktap

import javax.lang.model.element.Element
import javax.lang.model.element.ExecutableElement
import javax.lang.model.element.PackageElement
import javax.lang.model.element.TypeElement
import javax.lang.model.element.VariableElement
import javax.lang.model.util.ElementFilter

fun Iterable<Element>.getFields(): List<VariableElement> = ElementFilter.fieldsIn(this)

inline fun Iterable<Element>.filterFields(crossinline fieldPredicate: (VariableElement) -> Boolean) =
    ElementFilter.fieldsIn(this).filter(fieldPredicate)

fun Set<Element>.getFields(): Set<VariableElement> = ElementFilter.fieldsIn(this)

inline fun Set<Element>.filterFields(crossinline fieldPredicate: (VariableElement) -> Boolean) =
    ElementFilter.fieldsIn(this).filter(fieldPredicate).toSet()

fun Iterable<Element>.getConstructors(): List<ExecutableElement> = ElementFilter.constructorsIn(this)

inline fun Iterable<Element>.filterConstructors(crossinline constructorPredicate: (ExecutableElement) -> Boolean) =
    ElementFilter.constructorsIn(this).filter(constructorPredicate)

fun Set<Element>.getConstructors(): Set<ExecutableElement> = ElementFilter.constructorsIn(this)

inline fun Set<Element>.filterConstructors(crossinline constructorPredicate: (ExecutableElement) -> Boolean) =
    ElementFilter.constructorsIn(this).filter(constructorPredicate).toSet()

fun Iterable<Element>.getMethods(): List<ExecutableElement> = ElementFilter.methodsIn(this)

inline fun Iterable<Element>.filterMethods(crossinline methodPredicate: (ExecutableElement) -> Boolean) =
    ElementFilter.methodsIn(this).filter(methodPredicate)

fun Set<Element>.getMethods(): Set<ExecutableElement> = ElementFilter.methodsIn(this)

inline fun Set<Element>.filterMethods(crossinline methodPredicate: (ExecutableElement) -> Boolean) =
    ElementFilter.methodsIn(this).filter(methodPredicate).toSet()

fun Iterable<Element>.getTypes(): List<TypeElement> = ElementFilter.typesIn(this)

inline fun Iterable<Element>.filterTypes(crossinline typePredicate: (TypeElement) -> Boolean) =
    ElementFilter.typesIn(this).filter(typePredicate)

fun Set<Element>.getTypes(): Set<TypeElement> = ElementFilter.typesIn(this)

inline fun Set<Element>.filterTypes(crossinline typePredicate: (TypeElement) -> Boolean) =
    ElementFilter.typesIn(this).filter(typePredicate).toSet()

fun Iterable<Element>.getPackages(): List<PackageElement> = ElementFilter.packagesIn(this)

inline fun Iterable<Element>.filterPackages(crossinline packagePredicate: (PackageElement) -> Boolean) =
    ElementFilter.packagesIn(this).filter(packagePredicate)

fun Set<Element>.getPackages(): Set<PackageElement> = ElementFilter.packagesIn(this)

inline fun Set<Element>.filterPackages(crossinline packagePredicate: (PackageElement) -> Boolean) =
    ElementFilter.packagesIn(this).filter(packagePredicate).toSet()
