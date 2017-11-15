package com.kissybnts.services

import com.kissybnts.entities.UserEntity
import org.jetbrains.exposed.sql.transactions.transaction

class UserService {
    fun findAll(): List<UserEntity> {
        return transaction {
            UserEntity.all().toList()
        }
    }
}