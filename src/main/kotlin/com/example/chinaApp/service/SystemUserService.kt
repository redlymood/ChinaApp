package com.example.chinaApp.service

import org.apache.commons.lang3.ObjectUtils
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User

class SystemUserService {

    fun getCurrentUser(): String {
        val principal = SecurityContextHolder.getContext().authentication.principal
        val user: String
        if (principal is User) {
            user = (if (ObjectUtils.isEmpty(principal)) null else principal.username)!!
        } else if (principal is String) {
            user = (if (ObjectUtils.isEmpty(principal)) null else principal)!!
        } else {
            user = null.toString()
        }
        return user
    }
}