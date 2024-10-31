package com.nookv.api.modules.identity.http.rest.controllers

import com.nookv.api.modules.identity.core.dto.CreateUserDto
import com.nookv.api.modules.identity.core.services.UserManagementService
import com.nookv.api.modules.identity.http.rest.dto.request.CreateUserRequest
import com.nookv.api.modules.identity.http.rest.dto.response.CreateUserResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserManagementController(
    val userManagementService: UserManagementService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createUser(@RequestBody body: CreateUserRequest): CreateUserResponse? {
        val res = this.userManagementService.createUser(
            CreateUserDto(
                firstName = body.firstName,
                lastName = body.lastName,
                email = body.email,
                password = body.password,
                birthDate = body.birthDate,
            )
        )

        if (res != null) {
            return CreateUserResponse(id = res.getId())
        }

        return null
    }
}