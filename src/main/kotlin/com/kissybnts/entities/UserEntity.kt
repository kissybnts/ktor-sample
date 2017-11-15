package com.kissybnts.entities

import com.kissybnts.schemas.UserTable
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass

class UserEntity(id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<UserEntity>(UserTable)
    var name by UserTable.name
    var password by UserTable.password
}