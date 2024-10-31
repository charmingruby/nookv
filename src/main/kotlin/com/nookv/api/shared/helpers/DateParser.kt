package com.nookv.api.shared.helpers

import java.time.DateTimeException
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

class DateParser {
    fun stringToISO8601Format(date: String): Date? {
        return try {
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
            val localDate = LocalDate.parse(date, formatter)
            return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant())
        } catch (e: DateTimeException) {
            return null
        }
    }
}