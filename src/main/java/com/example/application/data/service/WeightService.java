package com.example.application.data.service;

import com.example.application.data.entity.Weight;
import com.example.application.data.repository.WeightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class WeightService {

    @Autowired
    private WeightRepository weightRepository;

    public void save(Weight weight) {
        weightRepository.save(weight);
    }
}
