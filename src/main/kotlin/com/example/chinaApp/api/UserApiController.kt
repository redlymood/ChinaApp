package com.example.chinaApp.api;

import com.example.chinaApp.dto.LoginRequest
import com.example.chinaApp.dto.RegisterRequest
import com.example.chinaApp.exceptions.UserIsAlreadyExistException
import com.example.chinaApp.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserApiController (
    private val userService: UserService
){

    @PostMapping("/login")
    fun login( @RequestBody request: LoginRequest): ResponseEntity<*> {
        return try {
            val token = userService.login(request)
            ResponseEntity.ok().body(token)
        } catch (e: BadCredentialsException)   {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).build<Any>()
        }
    }

    @PostMapping("/register")
    fun register(@RequestBody request: RegisterRequest): ResponseEntity<*> {
        try {
            userService.createUser(request)
            return ResponseEntity.status(HttpStatus.CREATED).build<Any>()
        } catch (e: UserIsAlreadyExistException) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e)
        }
    }

    @GetMapping("/user/progress:")
    fun getProgress(): ResponseEntity<Long> {
        return ResponseEntity.ok().body(userService.getProgress())
    }
}
