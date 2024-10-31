package com.nookv.api.modules.identity.core.services

import com.nookv.api.modules.identity.core.dto.CreateUserDto
import com.nookv.api.modules.identity.core.models.UserModel
import com.nookv.api.modules.identity.core.models.UserModelProps
import com.nookv.api.shared.helpers.DateParser
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Date

@Service
class UserManagementService {
    fun createUser(dto: CreateUserDto): UserModel? {
        val parsedBirthDate = DateParser().stringToISO8601Format(dto.birthDate)

        parsedBirthDate?.let {
            val input = UserModelProps(
                firstName = dto.firstName,
                lastName = dto.lastName,
                email = dto.email,
                password = dto.password,
                birthDate = parsedBirthDate,
                profile = null,
            )

            val user = UserModel(input, null)

            return user
        }

        return null
    }
}