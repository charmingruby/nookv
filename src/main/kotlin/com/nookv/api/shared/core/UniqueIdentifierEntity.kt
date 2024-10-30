package com.nookv.api.shared.core

import java.util.*

class UniqueIdentifierEntity(id: String?) {
    private val id: String = id ?: UUID.randomUUID().toString()

    fun toValue(): String {
        return this.id
    }
}