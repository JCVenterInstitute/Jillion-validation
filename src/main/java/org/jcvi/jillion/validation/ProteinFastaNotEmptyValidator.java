package org.jcvi.jillion.validation;

import org.jcvi.jillion.core.Sequence;
import org.jcvi.jillion.fasta.aa.ProteinFastaRecord;

public class ProteinFastaNotEmptyValidator extends AbstractSeqNotEmptyValidator<ProteinFastaRecord> {
    protected Sequence toSequence(ProteinFastaRecord obj) {
        return obj.getSequence();
    }
}
