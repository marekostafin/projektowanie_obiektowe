package com.po2024.zadanie3

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthenticationController {

    @Autowired
    lateinit var authenticationService: AuthenticationService

    @Autowired
    lateinit var sessionManager: SessionManager

    @GetMapping("/users")
    fun getUsers(@RequestHeader("Authentication") username: String): List<String> {
        if (sessionManager.isActive(username)) {
            return authenticationService.getUsers()
        } else {
            throw RuntimeException("Unauthorized access")
        }
    }

    @PostMapping("/auth")
    fun authenticate(@RequestBody request: AuthRequest): AuthResponse{
        val isAuthenticated = authenticationService.authenticate(request.username, request.password)
        if (isAuthenticated) {
            sessionManager.login(request.username)
        }
        return AuthResponse(isAuthenticated)
    }

    data class AuthRequest(val username: String, val password: String)
    data class AuthResponse(val isAuthenticated: Boolean)

}
