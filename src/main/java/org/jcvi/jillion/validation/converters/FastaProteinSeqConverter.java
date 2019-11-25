package org.jcvi.jillion.validation.converters;

import org.jcvi.jillion.core.residue.aa.ProteinSequence;
import org.jcvi.jillion.fasta.aa.ProteinFastaRecord;

public enum FastaProteinSeqConverter implements ProteinSeqConverter<ProteinFastaRecord> {
    INSTANCE;

    @Override
    public ProteinSequence toSequence(ProteinFastaRecord from) {
        return from.getSequence();
    }
}
