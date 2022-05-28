package com.example.application.views.main;

import com.example.application.data.entity.Weight;
import com.example.application.data.service.WeightService;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class SideForm extends VerticalLayout {

    @Autowired
    private WeightService weightService;

    Binder<Weight> binder = new Binder<>(Weight.class);

    @PostConstruct
    public void init() {
        Grid<Weight> grid = new Grid<>(Weight.class);
        grid.setColumns("weight", "dateTime");

        TextField weightField = new TextField("weight");

        binder.forField(weightField).bind(Weight::getWeight, Weight::setWeight);
        binder.setBean(new Weight());

        Button saveButton = new Button("Save");
        saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        saveButton.addClickShortcut(Key.ENTER);
        saveButton.addClickListener(event -> save());

        add(grid, weightField, saveButton);
    }

    private void save() {
        Weight weight = binder.getBean();
        weightService.save(weight);
    }



}