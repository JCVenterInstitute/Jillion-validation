package org.jcvi.jillion.validation.nonAmbigious;

import org.jcvi.jillion.core.residue.aa.ProteinSequence;
import org.jcvi.jillion.validation.converters.ProteinSequenceIdentityConverter;

public class ProteinSequenceNonAmbigiousValidator extends AbstractNonAmbigiousValidator<ProteinSequence> {

    public ProteinSequenceNonAmbigiousValidator(){
        super(ProteinSequenceIdentityConverter.INSTANCE);
    }
}
