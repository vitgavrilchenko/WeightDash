package com.example.application.data.service;

import com.example.application.data.entity.Weight;
import com.example.application.data.repository.WeightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class WeightService {

    @Autowired
    private WeightRepository weightRepository;

    public void save(Weight weight) {
        //TODO удалить эту порнографию
        weight.setId(weightRepository.count() + 1);

        weight.setDateTime(LocalDateTime.now());
        weightRepository.save(weight);
    }
}
