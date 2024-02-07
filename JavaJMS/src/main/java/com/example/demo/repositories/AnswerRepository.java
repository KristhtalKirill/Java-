package com.example.demo.repositories;

import com.example.demo.models.entity.AnswersEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends CrudRepository<AnswersEntity, Integer> {
    long count();

    @Query("select a from AnswersEntity a where a.id_user = ?1")
    List<AnswersEntity> findById_user(int id_user);

    @Override
    void deleteById(Integer integer);

    @Override
    void delete(AnswersEntity entity);

    @Override
    <S extends AnswersEntity> S save(S entity);
}
