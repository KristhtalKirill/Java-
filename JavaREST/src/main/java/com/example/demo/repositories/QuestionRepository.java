package com.example.demo.repositories;

import com.example.demo.models.entity.AnswersEntity;
import com.example.demo.models.entity.QuestionEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface QuestionRepository extends CrudRepository<QuestionEntity, Integer> {

    @Query("select q from QuestionEntity q")
    @Override
    Iterable<QuestionEntity> findAll();

    long count();

    @Query("select q from QuestionEntity q where q.id not in (?1)")
    Iterable<QuestionEntity> findAllQuestionsThatNotAnsweredYet(List<Integer> ids);

}