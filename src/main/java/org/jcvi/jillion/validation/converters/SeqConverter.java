package org.jcvi.jillion.validation.converters;

import org.jcvi.jillion.core.Sequence;
import org.jcvi.jillion.core.residue.aa.ProteinSequence;

public interface SeqConverter<T, R extends Sequence> {
    R toSequence(T from);
}
