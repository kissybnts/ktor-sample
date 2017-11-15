package com.kissybnts.schemas

import org.jetbrains.exposed.dao.IntIdTable

object UserTable : IntIdTable(name = "users") {
    val name = varchar("name", 255)
    val password = varchar("password", 255)
}