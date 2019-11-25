package org.jcvi.jillion.validation.converters;

import org.jcvi.jillion.core.residue.nt.NucleotideSequence;
import org.jcvi.jillion.trace.fastq.FastqRecord;

public enum FastqNucleotideSeqConverter implements NucleotideSeqConverter<FastqRecord> {
    INSTANCE;
    @Override
    public NucleotideSequence toSequence(FastqRecord from) {
        return from.getNucleotideSequence();
    }
}
