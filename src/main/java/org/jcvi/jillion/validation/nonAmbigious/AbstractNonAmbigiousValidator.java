package org.jcvi.jillion.validation.nonAmbigious;

import org.jcvi.jillion.core.residue.Residue;
import org.jcvi.jillion.core.residue.ResidueSequence;
import org.jcvi.jillion.validation.SeqNonAmbiguous;
import org.jcvi.jillion.validation.converters.SeqConverter;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Iterator;

public abstract class AbstractNonAmbigiousValidator<T>  implements ConstraintValidator<SeqNonAmbiguous, T> {

    private final SeqConverter<T, ? extends ResidueSequence> converter;

    public AbstractNonAmbigiousValidator(SeqConverter<T, ? extends ResidueSequence> converter) {
        this.converter = converter;
    }

    @Override
    public void initialize(SeqNonAmbiguous constraintAnnotation) {

    }

    @Override
    public boolean isValid(T t, ConstraintValidatorContext constraintValidatorContext) {
        ResidueSequence seq = converter.toSequence(t);
        Iterator<? extends Residue> iter = seq.ungappedIterator();
        while(iter.hasNext()){
            if(iter.next().isAmbiguity()){
                return false;
            }
        }
        return true;
    }
}
