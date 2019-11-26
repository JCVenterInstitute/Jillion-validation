import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public final class ValidatorUtil {

    ValidatorUtil(){
        //can not instantiate
    }
    public static <T> void assertNoViolations(T obj, Validator validator){
        Set<ConstraintViolation<T>> violations = validator.validate(obj);
        assertTrue(violations.isEmpty());
    }

    public static <T> void assertHasViolations(T obj, Validator validator){
        Set<ConstraintViolation<T>> violations = validator.validate(obj);
        assertFalse(violations.isEmpty());
    }

    public static Validator createDefaultValidator(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        return factory.getValidator();
    }
}
