package com.codegym.repository;

import com.codegym.model.UserQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserQuestionRepository extends JpaRepository<UserQuestion,Long> {
}
