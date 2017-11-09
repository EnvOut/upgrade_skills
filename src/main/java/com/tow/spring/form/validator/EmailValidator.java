package com.tow.spring.form.validator;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.regex.Pattern;

@Component
public class EmailValidator {
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private Pattern pattern;

    @PostConstruct
    private void initial() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    public boolean valid(String email) {
        return pattern.matcher(email).matches();
    }
}
