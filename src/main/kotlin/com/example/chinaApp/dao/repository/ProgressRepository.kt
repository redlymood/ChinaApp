package com.example.chinaApp.dao.repository

import com.example.chinaApp.dao.entity.ProgressEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ProgressRepository : JpaRepository<ProgressEntity?, UUID?>
