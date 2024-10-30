package com.nookv.api.shared.core

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.Date
import kotlin.math.abs


class BaseEntityTest {
    @Test
    fun `should be able to extends base entity`() {
        val dummyId: String = "test-id"
        val dummyTitle: String = "dummyTitle"

        val entity = TestEntity(TestEntityProps(title = dummyTitle), dummyId)
        val now = Date()
        val tolerance = 1000

        assert(entity.getId() == dummyId)
        assert(entity.getTitle() == dummyTitle)
        assertTrue(abs(now.time - entity.getCreatedAt().time) < tolerance)
        assertTrue(abs(now.time - entity.getUpdatedAt().time) < tolerance)
    }
}