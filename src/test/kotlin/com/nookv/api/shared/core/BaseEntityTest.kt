package com.nookv.api.shared.core

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.Date
import kotlin.math.abs


class BaseEntityTest {
    data class TestEntityProps(
        val title: String
    )

    class TestEntity(props: TestEntityProps, id: String?) : BaseEntity<TestEntityProps>(props, id) {
        fun getTitle(): String {
            return this.props.title
        }

        fun getId(): String {
            return this.id()
        }

        fun getCreatedAt(): Date {
            return this.createdAt()
        }

        fun getUpdatedAt(): Date {
            return this.updatedAt()
        }
    }

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