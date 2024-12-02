package com.example.chinaApp.dao.service

import com.example.chinaApp.dao.entity.UserEntity
import com.example.chinaApp.dao.repository.UserRepository
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Service
import java.util.*
import kotlin.jvm.optionals.getOrNull


@Service
@Slf4j
@RequiredArgsConstructor
class UserDaoService(
    private val userRepository: UserRepository
) {
    fun findByEmail(email: String): UserEntity? {
        return userRepository.findByEmail(email).getOrNull()
    }

    fun save(userEntity: UserEntity): UserEntity {
        return userRepository.save(userEntity)
    }

    fun findAll(): List<UserEntity> {
        return userRepository.findAll()
    }

    fun findById(id: UUID): Optional<UserEntity> {
        return userRepository.findById(id)
    }
}