package com.example.demo.repositories;

import com.example.demo.models.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UsersEntity, Integer> {
    Optional<UsersEntity> findByFirstName(String firstName);

    @Override
    <S extends UsersEntity> S save(S entity);

    @Override
    void delete(UsersEntity entity);

    @Override
    void deleteById(Integer integer);
}
