package com.aykan.validation;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Target({
        ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.FIELD
})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordConstraintValidator.class)
@Documented
public @interface ValidPassword {
}
