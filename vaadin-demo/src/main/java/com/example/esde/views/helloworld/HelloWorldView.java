package com.example.esde.views.helloworld;

import com.example.esde.views.MainLayout;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.charts.model.Label;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("ESDE Vaadin Workshop")
@Route(value = "", layout = MainLayout.class)
public class HelloWorldView extends VerticalLayout {

    /**
     * Don't touch this file!
     */

    private Button taskCta;

    public HelloWorldView() {
        H2 header = new H2("Welcome to our Vaadin Flow Workshop!");
        Paragraph text = new Paragraph(
                "With the help of the following tasks you will get to know a bit the basics of how Vaadin Flow works and how to use it!\n\n" +
                        "The first task is going to show you some very basic concepts, like using ready made components.\n" +
                        "The second task will guide through creating your own custom component.\n" +
                        "The third task will teach you how to make use of a database in Vaadin."
        );
        text.getStyle().set("white-space", "pre-line");
        taskCta = new Button("Go to first task");
        taskCta.addClickListener(e -> {
            getUI().ifPresent(ui -> ui.navigate("task1"));
            Notification.show("Good Luck!");
        });
        taskCta.addClickShortcut(Key.ENTER);

        setMargin(true);
        add(header, text, taskCta);
    }

}
