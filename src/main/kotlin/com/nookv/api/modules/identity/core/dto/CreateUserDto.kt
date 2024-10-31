package com.nookv.api.modules.identity.core.dto

data class CreateUserDto(
    var firstName: String,
    var lastName: String,
    var email: String,
    var birthDate: String,
    var password: String,
)