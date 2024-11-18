package com.example.chinaApp.dao.service

import com.example.chinaApp.dao.dto.RegisterRequest
import com.example.chinaApp.dao.entity.UserEntity
import com.example.chinaApp.dao.repository.UserRepository
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.security.crypto.bcrypt.BCrypt
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull


@Service
@Slf4j
@RequiredArgsConstructor
class UserDaoService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    fun findByEmail(email: String): UserEntity? {
        return userRepository.findByEmail(email).getOrNull()
    }

    fun create(request: RegisterRequest): UserEntity {
        val user = UserEntity(
            email = request.email,
            name = request.name,
            password = passwordEncoder.encode(request.password),
            role = request.role
        )
        return userRepository.save(user)
    }
}