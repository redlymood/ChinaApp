package com.example.chinaApp.service

import com.example.chinaApp.dto.RegisterRequest
import com.example.chinaApp.dao.entity.UserEntity
import com.example.chinaApp.dao.service.UserDaoService
import com.example.chinaApp.dto.LoginRequest
import com.example.chinaApp.dto.User
import com.example.chinaApp.util.JwtTokenUtil
import com.example.chinaApp.util.ObjectConverter
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.password.PasswordEncoder

class UserService (private val userDaoService: UserDaoService,
                   private val objectConverter: ObjectConverter,
                   private val passwordEncoder: PasswordEncoder,
                   private val authenticationManager: AuthenticationManager,
                   private val jwtTokenUtil: JwtTokenUtil
) {

    fun getUserByEmail(email: String) : User {
        val userEntity = userDaoService.findByEmail(email)
        return objectConverter.run { userEntity!!.toDTO() }
    }

    fun createUser(request: RegisterRequest) {
        val userEntity = UserEntity(
            email = request.email,
            name = request.name,
            password = passwordEncoder.encode(request.password),
            role = request.role
        )
        userDaoService.save(userEntity)
    }

    fun login(request: LoginRequest): String {
        val authentication = authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(request.email, request.password)
        )
        val userDetails = authentication.principal as UserDetails

        return jwtTokenUtil.generateToken(userDetails.username)
    }
}