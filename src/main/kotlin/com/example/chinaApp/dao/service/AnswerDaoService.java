package com.example.chinaApp.dao.service;

import com.example.chinaApp.dao.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AnswerDaoService {

    private final AnswerRepository answerRepository;
}
