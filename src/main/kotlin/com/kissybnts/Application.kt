package com.kissybnts

import com.kissybnts.entities.UserEntity
import com.kissybnts.schemas.UserTable
import com.kissybnts.services.UserService
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.features.DefaultHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.get
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

fun Application.main() {
    Database.connect("jdbc:mysql://127.0.0.1/ktor_sample?useSSL=false", "com.mysql.cj.jdbc.Driver", "user", "user")
    install(DefaultHeaders)
    install(CallLogging)
    install(Routing) {
        get("/") {
            call.respond(HttpStatusCode.OK, "Hello world from Ktor!")
        }
        get("/users") {
            val names = UserService().findAll().joinToString(", ") { it.name }
            call.respond(HttpStatusCode.OK, names)
        }
    }
}