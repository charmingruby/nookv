package com.nookv.api.support.factories

import com.nookv.api.modules.identity.core.models.ProfileModel
import com.nookv.api.modules.identity.core.models.ProfileModelProps
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

class ProfileModelFactory(
    private val props: ProfileModelProps = ProfileModelProps(
        displayName = "Ruby",
        currentVersion = "New Horizon",
        region = "South America",
        firstTimePlayedAt = Date.from(
            LocalDateTime.of(2024, 10, 15, 0, 0)
                .atZone(ZoneId.systemDefault())
                .toInstant()
        )
    ),
    private val id: String? = UUID.randomUUID().toString()
) {
    fun create(props: ProfileModelProps = this.props, id: String? = this.id): ProfileModel {
        return ProfileModel(props, id)
    }
}
