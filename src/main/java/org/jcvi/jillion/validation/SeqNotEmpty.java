package org.jcvi.jillion.validation;

import org.jcvi.jillion.validation.seqNonEmpty.*;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The annotated sequence must not be empty (have length 0).
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {NucleotideSeqNotEmptyValidator.class, ProteinSeqNotEmptyValidator.class,
                            NucleotideFastaNotEmptyValidator.class, ProteinFastaNotEmptyValidator.class,
                            FastqNotEmptyValidator.class,
                            SffFlowgramNotEmptyValidator.class})
public @interface SeqNotEmpty {
    String message() default "Sequence can not be empty";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
