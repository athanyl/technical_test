package com.inside.user.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.inside.user.model.User;

public class AuthorizedValidator implements ConstraintValidator<Authorized, String> {
    private String authorized;
    @Override
    public void initialize(Authorized authorizedValue) {
        this.authorized = authorizedValue.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (authorized.equals("gender")) {
            if(value.equals("")){
                return true;
            }
            for (String gender : User.AUTHORIZEDGENDERS) {
                if (value.equals(gender)) {
                    return true;
                }
            }
        }
        if (authorized.equals("country")) {
            if(value.equals("")){
                return true;
            }
            for (String country : User.AUTHORIZEDCOUNTRIES) {
                if (value.equals(country)) {
                    return true;
                }
            }
        }
        return false;
    }
}
