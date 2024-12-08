package com.example.chinaApp.service

import com.example.chinaApp.dao.repository.UserRepository
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service


@Service
class JwtUserDetailsService(
    private val userRepository: UserRepository
): UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        val entity = userRepository.findByEmail(username!!)
        if (!entity.isPresent) {
            throw UsernameNotFoundException("User not found with username: $username")
        }
        val user = entity.get()
        return User.builder()
            .username(user.email)
            .password(user.password)
            .roles(user.role)
            .build()
    }


}