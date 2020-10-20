package com.codegym.service.impl;

import com.codegym.model.UserQuestion;
import com.codegym.repository.QuestionTypeRepository;
import com.codegym.repository.UserQuestionRepository;
import com.codegym.service.UserQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserQuestionServiceImpl implements UserQuestionService {
    @Autowired
    UserQuestionRepository userQuestionRepository;

    @Override
    public Iterable<UserQuestion> findAll() {
        return userQuestionRepository.findAll();
    }
}
