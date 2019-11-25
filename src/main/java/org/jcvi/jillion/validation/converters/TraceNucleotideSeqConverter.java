package org.jcvi.jillion.validation.converters;

import org.jcvi.jillion.core.residue.nt.NucleotideSequence;
import org.jcvi.jillion.trace.Trace;

public enum TraceNucleotideSeqConverter implements NucleotideSeqConverter<Trace>{
    INSTANCE;
    @Override
    public NucleotideSequence toSequence(Trace from) {
        return from.getNucleotideSequence();
    }
}
