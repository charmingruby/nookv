package com.nookv.api.modules.identity.core.models

import com.nookv.api.shared.core.BaseEntity
import java.util.*

data class UserModelProps(
    var firstName: String,
    var lastName: String,
    var email: String,
    var birthDate: Date,
    var password: String,
    var profile: ProfileModel?
)

class UserModel(props: UserModelProps, id: String?) : BaseEntity<UserModelProps>(props, id) {
    fun getId(): String {
        return this.id()
    }

    fun getFirstName(): String {
        return this.props.firstName
    }

    fun getLastName(): String {
        return this.props.lastName
    }

    fun getEmail(): String {
        return this.props.email
    }

    fun getBirthDate(): Date {
        return this.props.birthDate
    }

    fun getPassword(): String {
        return this.props.password
    }

    fun getProfile(): ProfileModel? {
        return this.props.profile
    }

    fun addProfile(profile: ProfileModel) {
        this.props.profile = profile
    }

    fun getCreatedAt(): Date {
        return this.createdAt()
    }

    fun getUpdatedAt(): Date {
        return this.updatedAt()
    }
}