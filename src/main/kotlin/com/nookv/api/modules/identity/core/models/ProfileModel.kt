package com.nookv.api.modules.identity.core.models

import com.nookv.api.shared.core.BaseEntity
import java.util.Date

data class ProfileModelProps(
    var displayName: String,
    var currentVersion: String,
    var region: String,
    var firstTimePlayedAt: Date,
)

class ProfileModel(props: ProfileModelProps, id: String?) : BaseEntity<ProfileModelProps>(props, id) {
    fun getId(): String {
        return this.id()
    }

    fun getDisplayName(): String {
        return this.props.displayName
    }

    fun getCurrentVersion(): String {
        return this.props.currentVersion
    }

    fun getRegion(): String {
        return this.props.region
    }

    fun getFirstTimePlayedAt(): Date {
        return this.props.firstTimePlayedAt
    }

    fun getCreatedAt(): Date {
        return this.createdAt()
    }

    fun getUpdatedAt(): Date {
        return this.updatedAt()
    }
}