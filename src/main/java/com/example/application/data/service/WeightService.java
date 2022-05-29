package com.example.application.data.service;

import com.example.application.data.entity.Weight;
import com.example.application.data.repository.WeightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class WeightService {

    @Autowired
    private WeightRepository weightRepository;

    public void save(Weight weight) {
        //TODO удалить эту порнографию
        weight.setId(weightRepository.count() + 1);

        weight.setDateTime(LocalDate.now());
        weightRepository.save(weight);
    }

    public List<Weight> getWeightList() {
        Iterable<Weight> all = weightRepository.findAll();
        return Streamable.of(all).toList();
    }

}
