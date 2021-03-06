package org.jcvi.jillion.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DataStoreNotEmptyValidator.class)
public @interface DataStoreNotEmpty {
    String message() default "Datastore can not be empty";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
