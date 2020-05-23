package dev.fanie.ktap

import dev.fanie.ktap.util.asName
import dev.fanie.ktap.util.constructorElement
import dev.fanie.ktap.util.fieldElement
import dev.fanie.ktap.util.methodElement
import dev.fanie.ktap.util.packageElement
import dev.fanie.ktap.util.typeElement
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import javax.lang.model.element.ElementKind
import javax.lang.model.element.Modifier

internal class ElementFilterKtxKtTest {
    @Test
    fun `when getting the fields from elements, then the result is the expected`() {
        val field1 = fieldElement()
        val field2 = fieldElement()

        val listResult = listOf(field1, methodElement(), methodElement(), field2, methodElement()).getFields()
        assertEquals(listOf(field1, field2), listResult)

        val setResult = setOf(field1, methodElement(), methodElement(), field2, methodElement()).getFields()
        assertEquals(setOf(field1, field2), setResult)
    }

    @Test
    fun `when filtering the fields from elements, then the result is the expected`() {
        val field1 = fieldElement(simpleName = "test 1".asName())
        val field2 = fieldElement(simpleName = "test 2".asName())

        val listResult =
            listOf(field1, methodElement(), methodElement(), field2, fieldElement(simpleName = "-".asName())).filterFields {
                it.simpleName.startsWith("test")
            }
        assertEquals(listOf(field1, field2), listResult)

        val setResult =
            setOf(field1, methodElement(), methodElement(), field2, fieldElement(simpleName = "-".asName())).filterFields {
                it.simpleName.startsWith("test")
            }

        assertEquals(setOf(field1, field2), setResult)
    }

    @Test
    fun `when getting the constructors from elements, then the result is the expected`() {
        val constructor1 = constructorElement()
        val constructor2 = constructorElement()

        val listResult =
            listOf(constructor1, methodElement(), methodElement(), constructor2, methodElement()).getConstructors()
        assertEquals(listOf(constructor1, constructor2), listResult)

        val setResult =
            setOf(constructor1, methodElement(), methodElement(), constructor2, methodElement()).getConstructors()
        assertEquals(setOf(constructor1, constructor2), setResult)
    }

    @Test
    fun `when filtering the constructors from elements, then the result is the expected`() {
        val constructor1 = constructorElement(modifiers = setOf(Modifier.PUBLIC))
        val constructor2 = constructorElement(modifiers = setOf(Modifier.PUBLIC))

        val listResult =
            listOf(
                constructor1,
                methodElement(),
                methodElement(),
                constructor2,
                constructorElement(modifiers = setOf(Modifier.PRIVATE))
            ).filterConstructors {
                !it.modifiers.contains(Modifier.PRIVATE)
            }
        assertEquals(listOf(constructor1, constructor2), listResult)

        val setResult =
            setOf(
                constructor1,
                methodElement(),
                methodElement(),
                constructor2,
                constructorElement(modifiers = setOf(Modifier.PRIVATE))
            ).filterConstructors {
                !it.modifiers.contains(Modifier.PRIVATE)
            }

        assertEquals(setOf(constructor1, constructor2), setResult)
    }

    @Test
    fun `when getting the methods from elements, then the result is the expected`() {
        val method1 = methodElement()
        val method2 = methodElement()

        val listResult =
            listOf(method1, constructorElement(), constructorElement(), method2, constructorElement()).getMethods()
        assertEquals(listOf(method1, method2), listResult)

        val setResult =
            setOf(method1, constructorElement(), constructorElement(), method2, constructorElement()).getMethods()
        assertEquals(setOf(method1, method2), setResult)
    }

    @Test
    fun `when filtering the methods from elements, then the result is the expected`() {
        val method1 = methodElement(simpleName = "test 1".asName())
        val method2 = methodElement(simpleName = "test 2".asName())

        val listResult =
            listOf(
                method1,
                constructorElement(),
                constructorElement(),
                method2,
                methodElement(simpleName = "-".asName())
            ).filterMethods {
                it.simpleName.startsWith("test")
            }
        assertEquals(listOf(method1, method2), listResult)

        val setResult =
            setOf(
                method1,
                constructorElement(),
                constructorElement(),
                method2,
                methodElement(simpleName = "-".asName())
            ).filterMethods {
                it.simpleName.startsWith("test")
            }

        assertEquals(setOf(method1, method2), setResult)
    }

    @Test
    fun `when getting the types from elements, then the result is the expected`() {
        val type1 = typeElement(kind = ElementKind.CLASS)
        val type2 = typeElement(kind = ElementKind.CLASS)

        val listResult =
            listOf(type1, constructorElement(), constructorElement(), type2, constructorElement()).getTypes()
        assertEquals(listOf(type1, type2), listResult)

        val setResult =
            setOf(type1, constructorElement(), constructorElement(), type2, constructorElement()).getTypes()
        assertEquals(setOf(type1, type2), setResult)
    }

    @Test
    fun `when filtering the types from elements, then the result is the expected`() {
        val type1 = typeElement(kind = ElementKind.CLASS, simpleName = "test 1".asName())
        val type2 = typeElement(kind = ElementKind.CLASS, simpleName = "test 2".asName())

        val listResult =
            listOf(
                type1,
                constructorElement(),
                constructorElement(),
                type2,
                typeElement(kind = ElementKind.CLASS, simpleName = "-".asName())
            ).filterTypes {
                it.simpleName.startsWith("test")
            }
        assertEquals(listOf(type1, type2), listResult)

        val setResult =
            setOf(
                type1,
                constructorElement(),
                constructorElement(),
                type2,
                typeElement(kind = ElementKind.CLASS, simpleName = "-".asName())
            ).filterTypes {
                it.simpleName.startsWith("test")
            }

        assertEquals(setOf(type1, type2), setResult)
    }

    @Test
    fun `when getting the packages from elements, then the result is the expected`() {
        val package1 = packageElement(kind = ElementKind.PACKAGE)
        val package2 = packageElement(kind = ElementKind.PACKAGE)

        val listResult =
            listOf(package1, constructorElement(), constructorElement(), package2, constructorElement()).getPackages()
        assertEquals(listOf(package1, package2), listResult)

        val setResult =
            setOf(package1, constructorElement(), constructorElement(), package2, constructorElement()).getPackages()
        assertEquals(setOf(package1, package2), setResult)
    }

    @Test
    fun `when filtering the packages from elements, then the result is the expected`() {
        val package1 = packageElement(kind = ElementKind.PACKAGE, simpleName = "test 1".asName())
        val package2 = packageElement(kind = ElementKind.PACKAGE, simpleName = "test 2".asName())

        val listResult =
            listOf(
                package1,
                constructorElement(),
                constructorElement(),
                package2,
                packageElement(kind = ElementKind.PACKAGE, simpleName = "-".asName())
            ).filterPackages {
                it.simpleName.startsWith("test")
            }
        assertEquals(listOf(package1, package2), listResult)

        val setResult =
            setOf(
                package1,
                constructorElement(),
                constructorElement(),
                package2,
                packageElement(kind = ElementKind.PACKAGE, simpleName = "-".asName())
            ).filterPackages {
                it.simpleName.startsWith("test")
            }

        assertEquals(setOf(package1, package2), setResult)
    }
}