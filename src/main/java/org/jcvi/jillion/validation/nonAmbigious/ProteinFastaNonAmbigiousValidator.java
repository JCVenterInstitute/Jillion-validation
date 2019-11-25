package org.jcvi.jillion.validation.nonAmbigious;

import org.jcvi.jillion.fasta.aa.ProteinFastaRecord;
import org.jcvi.jillion.validation.converters.FastaProteinSeqConverter;

public class ProteinFastaNonAmbigiousValidator extends AbstractNonAmbigiousValidator<ProteinFastaRecord> {
    public ProteinFastaNonAmbigiousValidator() {
        super(FastaProteinSeqConverter.INSTANCE);
    }
}
