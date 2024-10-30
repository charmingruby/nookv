package com.nookv.api.shared.core

import java.util.*

open class BaseEntity<T>(protected var props: T, id: String?) {
    private val _id: UniqueIdentifierEntity = UniqueIdentifierEntity(id = id)
    private val _createdAt: Date = Date()
    private var _updatedAt: Date = Date()

    protected fun id(): String {
        return this._id.toValue()
    }

    protected fun createdAt(): Date {
        return this._createdAt
    }

    protected fun updatedAt(): Date {
        return this._updatedAt
    }
}
