package com.example.application.data.service;

import com.example.application.data.entity.Dashboard;
import com.example.application.data.entity.Weight;
import com.example.application.data.repository.WeightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;


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

    public List<Weight> getWeightList() {
        Iterable<Weight> all = weightRepository.findAll();
        return Streamable.of(all).toList();
    }

    public List<Dashboard> getDashboardList() {
        Dashboard dashboard = new Dashboard();
        dashboard.setDailyAverage(getDailyAverage());
        dashboard.setPercentage("17%");
        dashboard.setTimeLeft(57);
        return List.of(dashboard);
    }

    private String getDailyAverage() {
        List<Weight> weightList = getWeightList();
        if (weightList.isEmpty()) {
            return "0";
        }
        double maxWeight = weightList
                .stream()
                .min(Comparator.comparing(Weight::getDateTime))
                .map(weight -> Double.parseDouble(weight.getWeight()))
                .get();

        double minWeight = weightList
                .stream()
                .max(Comparator.comparing(Weight::getDateTime))
                .map(weight -> Double.parseDouble(weight.getWeight()))
                .get();

        double average = (maxWeight - minWeight) / weightList.size();
        return String.format("%.2f", average);
    }

}
