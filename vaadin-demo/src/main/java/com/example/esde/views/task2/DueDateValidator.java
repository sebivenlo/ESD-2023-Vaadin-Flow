package com.example.esde.views.task2;

import com.vaadin.flow.data.binder.ValidationResult;
import com.vaadin.flow.data.binder.Validator;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.data.validator.AbstractValidator;
import com.vaadin.flow.data.validator.EmailValidator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This is a Custom DueDateValidator for Vaading. The Purpose of this Validator is to check, if the Date Format matches
 * the format provided to the Constructor, and to validate, that the selected Due Date is in the future.
 */
public class DueDateValidator extends AbstractValidator<String> {

    private final DateFormat dateParser;

    public DueDateValidator(String errorMsg, String dateFormat){
        //sets Message, that is displayed, when Validation fails.
        super(errorMsg);
        //parser for date format validation is instatiated
        dateParser = new SimpleDateFormat(dateFormat);
        dateParser.setLenient(false);
    }
    @Override
    public ValidationResult apply(String s, ValueContext valueContext) {
        return this.toResult(s, this.isValid(s));
    }

    private boolean isValid(String s) {
        try {
            //If parser can not parse the provided String, then a ParseException is thrown, and false is returned!
            Date parsedDate = dateParser.parse(s);
            //if the date was in correct format, it will be checked to be in the future.
            return parsedDate.after(new Date());
        } catch (ParseException e) {
            return false;
        }
    }
}
