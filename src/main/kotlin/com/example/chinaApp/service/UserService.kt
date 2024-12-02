package com.example.chinaApp.service

import com.example.chinaApp.dto.RegisterRequest
import com.example.chinaApp.dao.entity.UserEntity
import com.example.chinaApp.dao.service.ProgressDaoService
import com.example.chinaApp.dao.service.UserDaoService
import com.example.chinaApp.dto.LoginRequest
import com.example.chinaApp.exceptions.UserIsAlreadyExistException
import com.example.chinaApp.exceptions.UserNotFoundException
import com.example.chinaApp.util.JwtTokenUtil
import org.apache.commons.lang3.ObjectUtils
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService (private val userDaoService: UserDaoService,
                   private val passwordEncoder: PasswordEncoder,
                   private val authenticationManager: AuthenticationManager,
                   private val jwtTokenUtil: JwtTokenUtil,
                   private val systemUserService: SystemUserService,
                   private val progressDaoService: ProgressDaoService
) {

    fun createUser(request: RegisterRequest) {
        val userEntity = userDaoService.findByEmail(request.email)
        if (!ObjectUtils.isEmpty(userEntity)) {
            throw UserIsAlreadyExistException("Пользователь уже зарегистрирован")
        }
        val newUser = UserEntity(
            email = request.email,
            name = request.name,
            password = passwordEncoder.encode(request.password),
            role = request.role
        )
        userDaoService.save(newUser)
    }

    fun login(request: LoginRequest): String {
        val authentication = authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(request.email, request.password)
        )
        val userDetails = authentication.principal as UserDetails

        return jwtTokenUtil.generateToken(userDetails.username)
    }

    fun getProgress(): Long {
        val email = systemUserService.getCurrentUser()
        val user = userDaoService.findByEmail(email)
        if (ObjectUtils.isEmpty(user)) {
            throw UserNotFoundException("Не удалось получить прогресс: пользователь не найден")
        }
        return progressDaoService.getNumberOfLessonsCompleted(user?.id)
    }
}