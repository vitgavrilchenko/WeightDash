package com.example.application.views.main;

import com.example.application.data.entity.Dashboard;
import com.example.application.data.entity.Weight;
import com.example.application.data.service.WeightService;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@PageTitle("Main")
@Route(value = "")
@Component
public class MainView extends HorizontalLayout {

    @Autowired
    private WeightService weightService;

    Grid<Dashboard> dashboardGrid = new Grid<>(Dashboard.class);

    @PostConstruct
    public void init() {

        dashboardGrid.setColumns("percentage", "dailyAverage", "timeLeft");
        dashboardGrid.setItems(weightService.getDashboardList());

        VerticalLayout sideForm = getSideForm();
        sideForm.setWidth("25em");

        add(sideForm, dashboardGrid);
    }

    private VerticalLayout getSideForm() {
        VerticalLayout sideFormLayout = new VerticalLayout();
        Grid<Weight> grid = new Grid<>(Weight.class);
        grid.setColumns("dateTime", "weight");

        TextField weightField = new TextField("Введите свой вес");
        Binder<Weight> binder = new Binder<>(Weight.class);
        binder.forField(weightField).bind(Weight::getWeight, Weight::setWeight);
        binder.setBean(new Weight());

        Button saveButton = new Button("Сохранить");
        saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        saveButton.addClickShortcut(Key.ENTER);
        saveButton.addClickListener(event -> saveWeight(binder.getBean(), grid));

        sideFormLayout.add(weightField, saveButton, grid);
        return sideFormLayout;
    }

    private void saveWeight(Weight weight, Grid<Weight> grid) {
        weightService.saveWeight(weight);
        grid.setItems(weightService.getWeightList());
        dashboardGrid.setItems(weightService.getDashboardList());

    }
}