package com.example.esde.views.todolist;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;

import java.util.List;

public class ToDoList extends FormLayout {

    Grid<ToDoItem> grid;
    List<ToDoItem> todos;

    // TODO 1.1: Instantiate a list for the todos
    public ToDoList() {
        setSizeFull();
        grid = new Grid<>(ToDoItem.class, false);
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        grid.addColumn(ToDoItem::getToDoDescription).setHeader("Description");
        // TODO 1.2: Add the other columns for the fields of an ToDoItem and set an appropriate header

        // TODO 1.3: Set the items of the grid to be filled by
    }

    // TODO 2: Add the ToDoItem (item) from the parameter to the list of ToDoItems and set the items of the grid to show the list
    public void addToDoItem(ToDoItem item) {

        throw new UnsupportedOperationException("This function is not implemented yet :(");
    }

}
