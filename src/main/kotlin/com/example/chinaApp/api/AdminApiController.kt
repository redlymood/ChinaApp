package com.example.chinaApp.api

import com.example.chinaApp.dto.Feedback
import com.example.chinaApp.dto.User
import com.example.chinaApp.service.AdminService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AdminApiController(val adminService: AdminService) {

    @GetMapping("/admin/feedbacks")
    fun getFeedbackList(): List<Feedback> {
        return adminService.getFeedbackList()
    }

    @GetMapping("/admin/users")
    fun getUserList(): List<User> {
        return adminService.getUserList()
    }
}