package com.nookv.api.modules.identity.core.modules

import com.nookv.api.modules.identity.core.models.UserModel
import com.nookv.api.modules.identity.core.models.UserModelProps
import com.nookv.api.support.factories.ProfileModelFactory
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*
import kotlin.math.abs

class UserModelTest {
    private val dummyId = "id"
    private val dummyFirstName = "dummyFirstName"
    private val dummyLastName = "dummyLastName"
    private val dummyEmail = "dummyEmail"
    private val dummyBirthDate = Date.from(
        LocalDateTime.of(2003, 5, 31, 0, 0)
            .atZone(ZoneId.systemDefault())
            .toInstant()
    )
    private val dummyPassword = "dummyPassword"

    @Test
    fun `it should be able to create a user model`() {
        val user = UserModel(
            UserModelProps(
                firstName = dummyFirstName,
                lastName = dummyLastName,
                email = dummyEmail,
                birthDate = dummyBirthDate,
                password = dummyPassword,
                profile = null
            ), dummyId
        )

        val now = Date()
        val tolerance = 1000

        assert(user.getId() == dummyId)
        assert(user.getFirstName() == dummyFirstName)
        assert(user.getLastName() == dummyLastName)
        assert(user.getEmail() == dummyEmail)
        assert(user.getBirthDate().before(now))
        assert(user.getPassword() == dummyPassword)
        assertNull(user.getProfile())
        assertTrue(abs(now.time - user.getCreatedAt().time) < tolerance)
        assertTrue(abs(now.time - user.getUpdatedAt().time) < tolerance)
    }

    @Test
    fun `it should be able to create a user model with profile`() {
        val profile = ProfileModelFactory().create(id = "profileId")

        val user = UserModel(
            UserModelProps(
                firstName = dummyFirstName,
                lastName = dummyLastName,
                email = dummyEmail,
                birthDate = dummyBirthDate,
                password = dummyPassword,
                profile = null
            ), dummyId
        )

        user.addProfile(profile)

        assert(user.getId() == dummyId)
        assert(user.getProfile()?.getId() == "profileId")
    }
}