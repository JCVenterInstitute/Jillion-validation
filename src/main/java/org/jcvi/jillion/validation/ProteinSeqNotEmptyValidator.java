package org.jcvi.jillion.validation;

import org.jcvi.jillion.core.Sequence;
import org.jcvi.jillion.core.residue.aa.ProteinSequence;

public class ProteinSeqNotEmptyValidator extends AbstractSeqNotEmptyValidator<ProteinSequence> {
    protected Sequence toSequence(ProteinSequence obj) {
        return obj;
    }
}
