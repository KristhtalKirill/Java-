package com.example.demo.repositories;

import com.example.demo.models.jms.WatchDog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchDogRepository extends CrudRepository<WatchDog, Integer> {
}
