# KTAP
Kotlin Extension for the Java Annotation Processor

### ElementKtx
#### Common extensions for Elements. Contains:
```kotlin
fun ExecutableElement.isOptional(): Boolean
fun VariableElement.isOptional(): Boolean
```

### ElementFilterKtx
#### Applies the `ElementFilter` functions to Iterables and Sets of Elements. Contains:
```kotlin
fun Iterable<Element>.getFields(): List<VariableElement>
fun Iterable<Element>.filterFields(fieldPredicate: (VariableElement) -> Boolean): List<VariableElement>
fun Set<Element>.getFields(): Set<VariableElement>
fun Set<Element>.filterFields(fieldPredicate: (VariableElement) -> Boolean): Set<VariableElement>
fun Iterable<Element>.getConstructors(): List<ExecutableElement>
fun Iterable<Element>.filterConstructors(constructorPredicate: (ExecutableElement) -> Boolean): List<ExecutableElement>
fun Set<Element>.getConstructors(): Set<ExecutableElement>: Set<ExecutableElement>
fun Set<Element>.filterConstructors(constructorPredicate: (ExecutableElement) -> Boolean): Set<ExecutableElement>
fun Iterable<Element>.getMethods(): List<ExecutableElement>
fun Iterable<Element>.filterMethods(methodPredicate: (ExecutableElement) -> Boolean): List<ExecutableElement>
fun Set<Element>.getMethods(): Set<ExecutableElement>
fun Set<Element>.filterMethods(methodPredicate: (ExecutableElement) -> Boolean): Set<ExecutableElement>
fun Iterable<Element>.getTypes(): List<TypeElement>
fun Iterable<Element>.filterTypes(typePredicate: (TypeElement) -> Boolean): List<TypeElement>
fun Set<Element>.getTypes(): Set<TypeElement>
fun Set<Element>.filterTypes(typePredicate: (TypeElement) -> Boolean): Set<TypeElement>
fun Iterable<Element>.getPackages(): List<PackageElement>
fun Iterable<Element>.filterPackages(packagePredicate: (PackageElement) -> Boolean): List<PackageElement>
fun Set<Element>.getPackages(): Set<PackageElement>
fun Set<Element>.filterPackages(packagePredicate: (PackageElement) -> Boolean): Set<PackageElement>
```

### MessagerKtx
#### Extensions for the Messager. Contains granular variations of the following:
```kotlin
fun Messager.error(error: CharSequence, element: Element, annotationMirror: AnnotationMirror, annotationValue: AnnotationValue)
fun Messager.warning(error: CharSequence, element: Element, annotationMirror: AnnotationMirror, annotationValue: AnnotationValue)
fun Messager.note(error: CharSequence, element: Element, annotationMirror: AnnotationMirror, annotationValue: AnnotationValue)
fun Messager.other(error: CharSequence, element: Element, annotationMirror: AnnotationMirror, annotationValue: AnnotationValue)
```

### PrintKtx
#### Extension to get a printable string for Elements, same as `toString` for data classes.
```kotlin
fun Element.toPrintable()
```

## Install
- Configure your project to consume GitHub packages
    - Generate an access token with `read packages` permission, more details here: [GitHub Help](https://help.github.com/en/packages/using-github-packages-with-your-projects-ecosystem/configuring-gradle-for-use-with-github-packages)
    - Add the maven repository to your `Project` dependencies; `username` is your user ID and
      `password` is the key generated previously
```groovy
allprojects {
    repositories {
        maven {
            url = uri("https://maven.pkg.github.com/iFanie/KTAP")
            credentials {
                username = ...
                password = ...
            }
        }
    }
}
```

- Add the dependency to your `Module`
```groovy
dependencies {
    implementation 'dev.fanie:ktap:0.0.5'
}
```
