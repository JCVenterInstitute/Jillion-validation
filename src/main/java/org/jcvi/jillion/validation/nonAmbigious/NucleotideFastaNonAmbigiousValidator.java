package org.jcvi.jillion.validation.nonAmbigious;

import org.jcvi.jillion.fasta.nt.NucleotideFastaRecord;
import org.jcvi.jillion.validation.converters.FastaNucleotideSeqConverter;

import javax.validation.ConstraintValidator;


public class NucleotideFastaNonAmbigiousValidator extends AbstractNonAmbigiousValidator<NucleotideFastaRecord> {
    public NucleotideFastaNonAmbigiousValidator() {
        super(FastaNucleotideSeqConverter.INSTANCE);
    }

}
