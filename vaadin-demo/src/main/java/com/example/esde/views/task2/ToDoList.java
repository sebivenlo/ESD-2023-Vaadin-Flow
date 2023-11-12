package com.example.esde.views.task2;

import com.example.esde.views.task2.ToDoItem;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;

import java.util.ArrayList;
import java.util.List;

public class ToDoList extends Grid<ToDoItem> {




    // TODO 1.1: Instantiate a list for the todos
    List<ToDoItem> todos = new ArrayList<>();

    public ToDoList() {
        super(ToDoItem.class, false);
        super.setSelectionMode(Grid.SelectionMode.MULTI);
        super.addColumn(ToDoItem::getToDoDescription).setHeader("Description");
        // TODO 1.2: Add the other columns for the fields of an ToDoItem and set an appropriate header
        super.addColumn(ToDoItem::getDueDate).setHeader("Due Date");
        super.addColumn(ToDoItem::getPriority).setHeader("Priority");

        // TODO 1.3: Set the items of the grid to be filled by the todos list
        super.setItems(todos);
    }

    // TODO 2: Add the ToDoItem (item) from the parameter to the list of ToDoItems and make the grid contain the new todo
    public void addToDoItem(ToDoItem item) {
        todos.add(item);
        super.setItems(todos);
        //throw new UnsupportedOperationException("This function is not implemented yet :(");
    }

}
