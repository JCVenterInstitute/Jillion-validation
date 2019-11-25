package org.jcvi.jillion.validation.seqNonEmpty;
import org.jcvi.jillion.core.Sequence;
import org.jcvi.jillion.validation.SeqNotEmpty;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public abstract class AbstractSeqNotEmptyValidator<T> implements ConstraintValidator<SeqNotEmpty, T> {

    public void initialize(SeqNotEmpty constraintAnnotation) {

    }

    public boolean isValid(T obj, ConstraintValidatorContext constraintValidatorContext) {
        return obj!=null && !toSequence(obj).isEmpty();
    }

    protected abstract Sequence toSequence(T obj);
}
