package org.jcvi.jillion.validation.converters;

import org.jcvi.jillion.core.residue.nt.NucleotideSequence;
import org.jcvi.jillion.fasta.nt.NucleotideFastaRecord;

public enum FastaNucleotideSeqConverter implements NucleotideSeqConverter<NucleotideFastaRecord> {
    INSTANCE;

    @Override
    public NucleotideSequence toSequence(NucleotideFastaRecord from) {
        return from.getSequence();
    }
}
