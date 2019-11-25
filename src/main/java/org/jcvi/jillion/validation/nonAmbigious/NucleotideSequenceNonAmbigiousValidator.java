package org.jcvi.jillion.validation.nonAmbigious;

import org.jcvi.jillion.core.residue.nt.NucleotideSequence;
import org.jcvi.jillion.validation.converters.NucleotideSequenceIdentityConverter;

public class NucleotideSequenceNonAmbigiousValidator extends AbstractNonAmbigiousValidator<NucleotideSequence> {

    public NucleotideSequenceNonAmbigiousValidator(){
        super(NucleotideSequenceIdentityConverter.INSTANCE);
    }
}
