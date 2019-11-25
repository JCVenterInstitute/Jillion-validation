package org.jcvi.jillion.validation.converters;

import org.jcvi.jillion.core.residue.nt.NucleotideSequence;

public enum NucleotideSequenceIdentityConverter implements SeqConverter<NucleotideSequence, NucleotideSequence> {

    INSTANCE;

    @Override
    public NucleotideSequence toSequence(NucleotideSequence from) {
        return from;
    }
}
