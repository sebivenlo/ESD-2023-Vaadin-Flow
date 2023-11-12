package com.example.esde.views.task1;

import com.example.esde.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * This will be a very simple task, change some values, create some objects, and you'll be done!
 */
@PageTitle("Task 1 - ESDE Vaadin Workshop")
@Route(value = "task1", layout = MainLayout.class)
public class Task1 extends VerticalLayout {

    private H2 header;
    private TextField textfield;
    private Button button;

    public Task1() {
        header = createHeader();
        button = createButton();
        textfield = null;

        add(header, button);
    }

    /**
     * TODO 1: Change the header to whatever you would like it to show
     */
    private H2 createHeader() {
        H2 header = new H2("Replace me");

        return header;
    }

    /**
     * TODO 2.1: Create a TextField object and set the label to "Your Name" and return the TextField
     * TODO 2.2: Add this function into the constructor and put the object also in the "add(...)" function
     */
    private TextField createTextfield() {

        throw new UnsupportedOperationException("This function is not implemented yet :(");
    }

    /**
     * TODO 3: Add a click listener to the button that takes the value from the text field and update the header to greet the name (e.g. "Hello John!")
     */
    private Button createButton() {
        Button button = new Button();
        button.setText("Update header");

        return button;
    }

    /**
     * TODO 4.1: Add a method that returns a new green button (hint: change the property "background-color")
     * TODO 4.2: Clicking on the button should navigate to the next task (Task2)
     * (Dont forget to add the button to the layout)
     */

}
