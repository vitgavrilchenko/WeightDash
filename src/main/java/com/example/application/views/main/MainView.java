package com.example.application.views.main;

import com.example.application.data.entity.Dashboard;
import com.example.application.data.entity.Weight;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
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
    private SideForm sideForm;

    @PostConstruct
    public void init() {
        Grid<Dashboard> dashboardGrid = new Grid<>(Dashboard.class);
        dashboardGrid.setColumns("percentage", "dailyAverage", "timeLeft");
        sideForm.setWidth("25em");
        add(sideForm, dashboardGrid);
    }


}