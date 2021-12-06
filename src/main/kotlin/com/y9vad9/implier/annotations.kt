package com.y9vad9.implier


/**
 * Marks that object should be able to mutate.
 * Generates `toMutable()` function for creating mutable variant of object and
 * mutable variant of annotated interface.
 */
@Target(allowedTargets = [AnnotationTarget.CLASS])
annotation class MutableImpl

/**
 * Marks that object should be able to immutate.
 * Generates `toImmutable()` function for creating immutable variant of object and
 * mutable variant of annotated interface.
 */
@Target(allowedTargets = [AnnotationTarget.CLASS])
annotation class ImmutableImpl

/**
 * Marks that object should have factory-function with hidden realization.
 * To make it works, you should use at least one of mutable / immutable annotations.
 */
@Target(allowedTargets = [AnnotationTarget.CLASS])
annotation class FactoryFunctionImpl

/**
 * Marks that object should have Builder implementation.
 * To make it works, you should use at least one of mutable / immutable
 * annotations (type will be hidden behind interface / abstract class). Immutable preferred.
 *
 * @param type - methods generation type (with accessors set/get, or just `property(value)`)
 */
@Target(allowedTargets = [AnnotationTarget.CLASS])
annotation class BuilderImpl(val type: Type = Type.WITHOUT_ACCESSORS) {
    enum class Type {
        WITH_ACCESSORS, WITHOUT_ACCESSORS
    }
}