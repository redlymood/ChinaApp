package com.example.chinaApp.api

import com.example.chinaApp.dto.Feedback
import com.example.chinaApp.dto.User
import com.example.chinaApp.dto.UserInfo
import com.example.chinaApp.service.AdminService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class AdminApiController(
    private val adminService: AdminService
) {

    @GetMapping("/admin/feedbacks")
    fun getFeedbackList(): ResponseEntity<List<Feedback>> {
        return ResponseEntity.ok().body(adminService.getFeedbackList())
    }

    @GetMapping("/admin/users")
    fun getUserList(): ResponseEntity<List<User>> {
        return ResponseEntity.ok().body(adminService.getUserList())
    }

    @GetMapping("/admin/user/{id}/details")
    fun getUserInfo(@PathVariable id: UUID): ResponseEntity<UserInfo> {
        return ResponseEntity.ok().body(adminService.getUserInfo(id))
    }
}