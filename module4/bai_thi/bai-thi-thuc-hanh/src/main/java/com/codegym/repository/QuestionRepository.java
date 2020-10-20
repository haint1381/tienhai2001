package com.codegym.repository;

import com.codegym.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long> {
    Page<Question> findQuestionsByTitleContains(String color, Pageable pageable);
    Page<Question> findQuestionsByQuestionType_NameQuestionTypeContains(String color, Pageable pageable);
    Page<Question> findQuestionsByQuestionType_NameQuestionTypeContainsOrTitleContains(String name,String color, Pageable pageable);
}
