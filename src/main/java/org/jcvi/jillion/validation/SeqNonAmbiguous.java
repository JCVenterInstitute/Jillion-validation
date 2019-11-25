package org.jcvi.jillion.validation;

import org.jcvi.jillion.validation.nonAmbigious.*;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {NucleotideFastaNonAmbigiousValidator.class, ProteinFastaNonAmbigiousValidator.class,
        TraceNonAmbiguiousValidator.class,
        NucleotideSequenceNonAmbigiousValidator.class, ProteinSequenceNonAmbigiousValidator.class})
public @interface SeqNonAmbiguous {
    String message() default "Sequence can not contain ambiguous residues";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
