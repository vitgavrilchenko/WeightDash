package com.example.application.views.main;

import com.example.application.data.entity.Dashboard;
import com.example.application.data.entity.Weight;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Main")
@Route(value = "")
public class MainView extends HorizontalLayout {

    public MainView() {
        SideForm sideForm = new SideForm();
        Grid<Dashboard> dashboardGrid = new Grid<>(Dashboard.class);
        dashboardGrid.setColumns("percentage", "dailyAverage", "timeLeft");
        sideForm.setWidth("25em");
        dashboardGrid.setWidth("25em");
        add(sideForm, dashboardGrid);
    }


}