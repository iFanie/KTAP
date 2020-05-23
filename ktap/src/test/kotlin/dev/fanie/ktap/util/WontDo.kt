package dev.fanie.ktap.util

internal fun wontDo(reason: String = "Not needed for tests"): Nothing =
    throw NotImplementedError("An operation is not implemented: $reason")
