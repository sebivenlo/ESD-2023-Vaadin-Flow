package com.example.esde.views.task3;

import com.example.esde.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.sql.SQLOutput;
import java.util.List;

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

        updateComboBoxes();
    }

    /**
     * Updates all combo boxes and fills them with values from repositories
     */
    private void updateComboBoxes() {
        this.courseSelection.setItems(this.service.getAllCourses());
        this.combineCourseSelection.setItems(this.service.getAllCourses());
        this.combineStudentSelection.setItems(this.service.getAllStudents());
    }

    /**
     * Creates Vertical Layout for displaying the
     * @return VerticalLayout
     */
    private VerticalLayout createStudentsGrid() {
        VerticalLayout verticalLayout = new VerticalLayout();

        Grid<StudentEntity> grid = new Grid<>(StudentEntity.class, false);
        grid.setSizeFull();
        grid.addColumn(StudentEntity::getId).setHeader("Studentnumber");
        grid.addColumn(StudentEntity::getFullName).setHeader("Full Student Name");

        this.courseSelection = new ComboBox<>("Select a course");
        this.courseSelection.setItemLabelGenerator(CourseEntity::getShortName);
        this.courseSelection.setItems(this.service.getAllCourses());
        this.courseSelection.addValueChangeListener(event -> {
            grid.setItems(event.getValue().getStudents());
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
     * Creates form for creating a new Student object and adding into the database
     * @return VerticalLayout
     */
    private VerticalLayout createStudentForm() {
        VerticalLayout form = new VerticalLayout();
        H2 header = new H2("Create Student");
        TextField idField = new TextField("Studentnumber");
        TextField nameField = new TextField("Full Name");
        Button createButton = new Button("Create Student");
        createButton.addClickListener(clickevent -> {
            StudentEntity student = new StudentEntity(
                    Long.parseLong(idField.getValue()),
                    nameField.getValue()
            );
            this.service.addStudent(student);
            updateComboBoxes();
            Notification.show("Created a new student!");

            idField.setValue("");
            nameField.setValue("");
        });

        form.add(header, idField, nameField, createButton);
        return form;
    }

    /**
     * Creates form for creating a new Course object and adding into the database
     * @return VerticalLayout
     */
    private VerticalLayout createCourseForm() {
        VerticalLayout form = new VerticalLayout();
        H2 header = new H2("Create Course");
        TextField shortField = new TextField("Shortname of Course");
        TextField fullnameField = new TextField("Fullname of Course");
        Button createButton = new Button("Create Course");
        createButton.addClickListener(clickevent -> {
            CourseEntity course = new CourseEntity(
                    shortField.getValue(),
                    fullnameField.getValue()
            );
            this.service.addCourse(course);
            updateComboBoxes();
            Notification.show("Created a new course!");

            shortField.setValue("");
            fullnameField.setValue("");
        });

        form.add(header, shortField, fullnameField, createButton);
        return form;
    }

    /**
     * Creates form for adding an existing student into an existing course
     * @return VerticalLayout
     */
    private VerticalLayout createConnectionForm() {
        VerticalLayout form = new VerticalLayout();
        H2 header = new H2("Add Student to Course");
        this.combineCourseSelection = new ComboBox<>("Select Course");
        this.combineCourseSelection.setItemLabelGenerator(CourseEntity::getShortName);

        this.combineStudentSelection = new ComboBox<>("Select Student");
        this.combineStudentSelection.setItemLabelGenerator(StudentEntity::getFullName);

        Button createButton = new Button("Add student to course");
        createButton.addClickListener(clickevent -> {
            CourseEntity course = this.combineCourseSelection.getValue();
            StudentEntity student = this.combineStudentSelection.getValue();
            course.addStudent(student);
            this.service.updateCourse(course);

            updateComboBoxes();
            Notification.show("Added student to course!");
        });

        form.add(header, this.combineCourseSelection, this.combineStudentSelection, createButton);
        return form;
    }

}
