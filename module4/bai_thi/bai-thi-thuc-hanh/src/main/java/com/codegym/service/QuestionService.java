package com.codegym.service;

import com.codegym.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuestionService {
    Page<Question> getAll(Pageable pageable);
    Iterable<Question> findAll();
    Question findById(Long id);
    void save(Question question);
    void delete(Long id);

    Page<Question> findQuestionByTitleContains(String color, Pageable pageable);
    Page<Question> findQuestionByQuestionTypeContains(String color, Pageable pageable);
    Page<Question> findQuestionByQuestionTypeContainsOrTitleContains(String color, Pageable pageable);
}
