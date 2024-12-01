package com.example.chinaApp.dao.service;

import com.example.chinaApp.dao.repository.LessonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LessonDaoService {

    private final LessonRepository lessonRepository;
}
