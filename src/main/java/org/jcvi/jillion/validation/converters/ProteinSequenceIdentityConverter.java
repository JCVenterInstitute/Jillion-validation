package org.jcvi.jillion.validation.converters;

import org.jcvi.jillion.core.residue.aa.ProteinSequence;

public enum ProteinSequenceIdentityConverter implements SeqConverter<ProteinSequence, ProteinSequence> {

    INSTANCE;

    @Override
    public ProteinSequence toSequence(ProteinSequence from) {
        return from;
    }
}
