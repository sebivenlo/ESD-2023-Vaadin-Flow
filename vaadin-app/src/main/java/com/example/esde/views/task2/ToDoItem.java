package com.example.esde.views.task2;




public class ToDoItem {

    private String description;
    private String dueDate;
    private String priority;

    public ToDoItem(){

    }

    public String getToDoDescription() {
        return description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
