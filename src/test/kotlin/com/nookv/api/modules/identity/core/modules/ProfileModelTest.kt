package com.nookv.api.modules.identity.core.modules

import com.nookv.api.modules.identity.core.models.ProfileModel
import com.nookv.api.modules.identity.core.models.ProfileModelProps
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Date
import kotlin.math.abs

class ProfileModelTest {
    private val dummyId = "id"
    private val dummyDisplayName = "Ruby"
    private val dummyCurrentVersion = "New Horizon"
    private val dummyRegion = "South America"
    private val dummyFirstTimePlayed = Date.from(
        LocalDateTime.of(2024, 10, 15, 0, 0)
            .atZone(ZoneId.systemDefault())
            .toInstant()
    )

    @Test
    fun `it should be able to create a profile`() {
        val profile = ProfileModel(
            ProfileModelProps(
                displayName = dummyDisplayName,
                currentVersion = dummyCurrentVersion,
                region = dummyRegion,
                firstTimePlayedAt = dummyFirstTimePlayed
            ), dummyId
        )

        val now = Date()
        val tolerance = 1000

        assert(profile.getId() == dummyId)
        assert(profile.getDisplayName() == dummyDisplayName)
        assert(profile.getCurrentVersion() == dummyCurrentVersion)
        assert(profile.getRegion() == dummyRegion)
        assert(profile.getFirstTimePlayedAt().before(now))
        assertTrue(abs(now.time - profile.getCreatedAt().time) < tolerance)
        assertTrue(abs(now.time - profile.getUpdatedAt().time) < tolerance)
    }
}