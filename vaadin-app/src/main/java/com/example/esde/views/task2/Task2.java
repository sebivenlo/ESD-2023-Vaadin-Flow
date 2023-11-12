package com.example.esde.views.task2;

import com.example.esde.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
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
        // TODO 1: Create a new ToDoList object for the todoList attribute and add it to the Task2 View
        add(createNewToDoForm());
    }

    private FormLayout createNewToDoForm() {
        FormLayout form = new FormLayout();

        TextField todoDescription = new TextField("Description");
        TextField todoDueDate = new TextField("Due Date (HH:mm yyyy-MM-dd)");
        ComboBox<String> todoPriority = new ComboBox<>("Priority");
        todoPriority.setItems("Low", "Medium", "High");

        Binder<ToDoItem> binder = new Binder<>(ToDoItem.class);

        // TODO 2.1: add todoDescription to the binder. Optionally: make field Required, with message "Field is Required"


        // TODO 2.2: add todoDueDate to the binder. Optionally: Validate the Due Date. Hint: take a look at the provided
        // com.example.esde.task2.DueDateValidator and make use of it.


        // TODO 2.3: add todoPriority to the binder. Optionally: make field Required, with message "Field is Required"


        Button createButton = new Button("Create");
        createButton.addClickListener(event -> {
            // TODO 3: Create a new ToDoItem object and use the binder to write to this BEAN and add it to the todoList
            throw new UnsupportedOperationException("Not yet Implemented!");
        });



        form.add(todoDescription, todoDueDate, todoPriority, createButton);
        return form;
    }

}
