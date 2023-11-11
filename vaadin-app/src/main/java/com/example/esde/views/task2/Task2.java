package com.example.esde.views.task2;

import com.example.esde.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * In this task you will create a very simple To Do List,
 * the list itself being a separate component that you will have to edit as well
 */
@PageTitle("Task 2 - ESDE Vaadin Workshop")
@Route(value = "task2", layout = MainLayout.class)
public class Task2 extends HorizontalLayout {

    /**
     * HINT: Also look into the ToDoList and ToDoItem classes for open tasks!
     */

    ToDoList todoList;

    public Task2() {
        // TODO 1: Create a new ToDoList object for the todoList attribute and put it into the "add" function

        //setJustifyContentMode(JustifyContentMode.CENTER);
        add(createNewToDoForm());
    }

    private FormLayout createNewToDoForm() {
        FormLayout form = new FormLayout();

        TextField todoDescription = new TextField("Description");
        TextField todoDueDate = new TextField("Due Date");
        ComboBox<String> todoPriority = new ComboBox<>("Priority");
        todoPriority.setItems("Low", "Medium", "High");
        Button createButton = new Button("Create");
        createButton.addClickListener(event -> {
            // TODO 2: Create a new ToDoItem object, fill the values and add it to the todoList
        });

        form.add(todoDescription, todoDueDate, todoPriority, createButton);
        return form;
    }

}
