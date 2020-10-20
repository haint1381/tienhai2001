package com.codegym.service.impl;

import com.codegym.model.Question;
import com.codegym.repository.QuestionRepository;
import com.codegym.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    @Override
    public Page<Question> getAll(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }

    @Override
    public Iterable<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question findById(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Question question) {
        questionRepository.save(question);
    }

    @Override
    public void delete(Long id) {
        questionRepository.deleteById(id);
    }

    @Override
    public Page<Question> findQuestionByTitleContains(String color, Pageable pageable) {
        return questionRepository.findQuestionsByTitleContains(color,pageable);
    }

    @Override
    public Page<Question> findQuestionByQuestionTypeContains(String color, Pageable pageable) {
        return questionRepository.findQuestionsByQuestionType_NameQuestionTypeContains(color, pageable);
    }

    @Override
    public Page<Question> findQuestionByQuestionTypeContainsOrTitleContains( String color, Pageable pageable) {
        return questionRepository.findQuestionsByQuestionType_NameQuestionTypeContainsOrTitleContains(color,color,pageable);
    }
}
