package com.po2024.zadanie3

import org.springframework.stereotype.Component

@Component
class SessionManager {

    private val activeSessions = mutableMapOf<String, Boolean>()

    fun login(username: String) {
        activeSessions[username] = true
    }

    fun logout(username: String) {
        activeSessions.remove(username)
    }

    fun isActive(username: String): Boolean {
        return activeSessions.containsKey(username)
    }

}