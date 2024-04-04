package com.po2024.zadanie3

import org.springframework.stereotype.Service

@Service
object AuthenticationService {

    private var usersPasswords = mapOf("test" to "12345", "admin" to "adminadmin", "user" to "qwerty")

    fun getUsers(): List<String> {
        return usersPasswords.keys.toList()
    }

    fun authenticate(username: String, password: String): Boolean {
        val storedPassword = usersPasswords[username]
        return password == storedPassword
    }

}