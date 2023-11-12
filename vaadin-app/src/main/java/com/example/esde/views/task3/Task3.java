package com.example.esde.views.task3;

import com.example.esde.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * In this task you will create a simple view where you can manage courses and students and actually storing those
 * values in a database. In this example we use an in-memory database called H2, it is set up automatically.
 *
 * There is a form for creating a new course, one for creating a new student and a third one for adding
 * an existing student into a course. To simplify the task, you can assume that a student can only be registered to
 * a single course at a time.
 */
@PageTitle("Task 3 - ESDE Vaadin Workshop")
@Route(value = "task3", layout = MainLayout.class)
public class Task3 extends HorizontalLayout {

    SchoolService service;

    /** ComboBox for selecting a course in the grid */
    ComboBox<CourseEntity> courseSelection;

    /** ComboBoxes for adding a student to a course */
    ComboBox<StudentEntity> combineStudentSelection;
    ComboBox<CourseEntity> combineCourseSelection;

    public Task3(SchoolService service) {
        this.service = service;

        add(createStudentsGrid(), createHorizontalLayout());
    }

    /**
     * TODO: Update all combo boxes and fills them with values from repositories
     */
    private void updateComboBoxes() {

        throw new UnsupportedOperationException("This function is not implemented yet :(");
    }

    /**
     * Creates Vertical Layout for displaying the
     * @return VerticalLayout
     */
    private VerticalLayout createStudentsGrid() {
        VerticalLayout verticalLayout = new VerticalLayout();

        // Grid for listing all students in a course
        Grid<StudentEntity> grid = new Grid<>(StudentEntity.class, false);
        grid.setSizeFull();
        grid.addColumn(StudentEntity::getId).setHeader("Student number");
        grid.addColumn(StudentEntity::getFullName).setHeader("Full Student Name");

        // ComboBox for selecting a course
        this.courseSelection = new ComboBox<>("Select a course");
        this.courseSelection.setItemLabelGenerator(CourseEntity::getShortName);
        this.courseSelection.setItems(this.service.getAllCourses());

        this.courseSelection.addValueChangeListener(event -> {
            // TODO: When changing the value of the ComboBox, set the items of the grid to contain the students of the select course
            // Hint: You can get the selected course from the event!

        });

        verticalLayout.add(courseSelection, grid);
        return verticalLayout;
    }

    /**
     * Creates Horizontal Layout for displaying the three creation forms on the right side of the screen
     * @return HorizontalLayout
     */
    private HorizontalLayout createHorizontalLayout() {
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.add(createStudentForm(), createCourseForm(), createConnectionForm());

        return horizontalLayout;
    }

    /**
     * Creates form for creating a new Student object and adding it into the database
     * @return VerticalLayout
     */
    private VerticalLayout createStudentForm() {
        VerticalLayout form = new VerticalLayout();
        H2 header = new H2("Create Student");
        TextField idField = new TextField("Student number");
        TextField nameField = new TextField("Full Name");
        Button createButton = new Button("Create Student");
        createButton.addClickListener(clickevent -> {
            // TODO: Create a new StudentEntity with the values of the TextFields
            // TODO: Use the SchoolService to add the student to the database

            // TODO: Uncomment to following two lines when you have implemented the function
            // updateComboBoxes();
            // Notification.show("Created a new student!");

            // TODO (OPTIONAL): You might also want to clear the TextFields after creating the student
        });

        form.add(header, idField, nameField, createButton);
        return form;
    }

    /**
     * Creates form for creating a new Course object and adding it into the database
     * @return VerticalLayout
     */
    private VerticalLayout createCourseForm() {
        VerticalLayout form = new VerticalLayout();
        H2 header = new H2("Create Course");
        TextField shortField = new TextField("Shortname of Course");
        TextField fullnameField = new TextField("Fullname of Course");
        Button createButton = new Button("Create Course");
        createButton.addClickListener(clickevent -> {
            // TODO: Create a new CourseEntity with the values of the TextFields
            // TODO: Use the SchoolService to add the course to the database

            // TODO: Uncomment to following two lines when you have implemented the function
            // updateComboBoxes();
            // Notification.show("Created a new course!");

            // TODO (OPTIONAL): You might also want to clear the TextFields after creating the course
        });

        form.add(header, shortField, fullnameField, createButton);
        return form;
    }

    /**
     * Creates form for adding an existing student into an existing course and persisting the updated course in the database
     * @return VerticalLayout
     */
    private VerticalLayout createConnectionForm() {
        VerticalLayout form = new VerticalLayout();
        H2 header = new H2("Add student to a course");
        this.combineCourseSelection = new ComboBox<>("Select Course");
        this.combineCourseSelection.setItemLabelGenerator(CourseEntity::getShortName);

        this.combineStudentSelection = new ComboBox<>("Select Student");
        this.combineStudentSelection.setItemLabelGenerator(StudentEntity::getFullName);

        Button createButton = new Button("Add student to course");
        createButton.addClickListener(clickevent -> {
            // TODO: Get the selected values of the ComboBoxes for selecting a course and a student to combine them
            // TODO: Add the selected student to the course and update the course with the SchoolService

            // TODO: Uncomment to following two lines when you have implemented the function
            // updateComboBoxes();
            // Notification.show("Added student to course!");
        });

        form.add(header, this.combineCourseSelection, this.combineStudentSelection, createButton);
        return form;
    }

}
