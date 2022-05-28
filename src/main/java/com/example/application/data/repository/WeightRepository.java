package com.example.application.data.repository;

import com.example.application.data.entity.Weight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface WeightRepository extends CrudRepository<Weight, Long> {
}
