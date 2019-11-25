package org.jcvi.jillion.validation.seqNonEmpty;

import org.jcvi.jillion.core.Sequence;
import org.jcvi.jillion.core.residue.nt.NucleotideSequence;

public class NucleotideSeqNotEmptyValidator extends AbstractSeqNotEmptyValidator<NucleotideSequence> {
    protected Sequence toSequence(NucleotideSequence obj) {
        return obj;
    }
}
