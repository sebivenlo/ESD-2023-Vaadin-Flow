package com.example.esde.views.task2;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ToDoItem extends VerticalLayout {

    String description;
    String dueDate;
    String priority;

    public ToDoItem(String description, String dueDate, String priority) {
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    // TODO 1: Setup the getter method
    public String getToDoDescription() {

        throw new UnsupportedOperationException("This function is not implemented yet :(");
    }

    // TODO 2: Setup the getter method
    public String getDueDate() {

        throw new UnsupportedOperationException("This function is not implemented yet :(");
    }

    // TODO 3: Setup the getter method
    public String getPriority() {

        throw new UnsupportedOperationException("This function is not implemented yet :(");
    }

}
