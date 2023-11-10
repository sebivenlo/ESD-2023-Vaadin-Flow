package com.example.esde.views.tasks;

import com.example.esde.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Task 2")
@Route(value = "task2", layout = MainLayout.class)
public class Task2 extends VerticalLayout {

    private H2 header;

    public Task2() {
        header = createHeader();

        add(header, createButton());
    }

    /**
     * TODO: Change the header to whatever you would like it to show
     */
    private H2 createHeader() {
        H2 header = new H2("Replace me");

        return header;
    }

    /**
     * TODO: Create a Button object, set the text to SOMETHING and give it add a click listener to it
     */
    private Button createButton() {
        Button button = new Button();
        button.setText("Sag hihi");
        button.addClickListener(event -> {
            Notification.show("Test");
        });

        return button;

       // throw new UnsupportedOperationException("This function is not implemented yet :(");
    }

}
