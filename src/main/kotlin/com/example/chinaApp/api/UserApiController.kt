package com.example.chinaApp.api;

import com.example.chinaApp.JwtTokenUtil
import com.example.chinaApp.dao.dto.LoginRequest
import com.example.chinaApp.dao.dto.RegisterRequest
import com.example.chinaApp.dao.service.UserDaoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserApiController (
    private val userService: UserDaoService,
    private val jwtTokenUtil: JwtTokenUtil,
    private val authenticationManager: AuthenticationManager
){

    @PostMapping("/login")
    fun login( @RequestBody request: LoginRequest): ResponseEntity<*> {
        return try {
            val authentication = authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(request.email, request.password)
            )
            val userDetails = authentication.principal as UserDetails

            val token = jwtTokenUtil.generateToken(userDetails.username)
            ResponseEntity.ok().body(token)
        } catch (e: BadCredentialsException)   {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).build<Any>()
        }


    }


    @PostMapping("/register")
    fun register(@RequestBody request: RegisterRequest): ResponseEntity<*> {
        val user = userService.findByEmail(request.email)
        return if (user != null) {
            ResponseEntity.status(HttpStatus.CONFLICT).build<Any>()
        } else {
            userService.create(request)
            ResponseEntity.status(HttpStatus.CREATED).build<Any>()
        }
    }
}
