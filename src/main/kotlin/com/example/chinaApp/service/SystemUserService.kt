package com.example.chinaApp.service

import org.apache.commons.lang3.ObjectUtils
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User
import org.springframework.stereotype.Service

@Service
class SystemUserService {

    fun getCurrentUser(): String {
        val user: String? = when (val principal = SecurityContextHolder.getContext().authentication.principal) {
            is User -> {
                (if (ObjectUtils.isEmpty(principal)) null else principal.username)!!
            }

            is String -> {
                (if (ObjectUtils.isEmpty(principal)) null else principal)!!
            }

            else -> {
                null
            }
        }
        return user!!
    }
}