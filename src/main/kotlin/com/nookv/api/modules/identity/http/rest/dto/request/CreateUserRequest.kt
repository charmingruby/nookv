package com.nookv.api.modules.identity.http.rest.dto.request

data class CreateUserRequest(
    var firstName: String,
    var lastName: String,
    var email: String,
    var birthDate: String,
    var password: String,
)