package org.jcvi.jillion.validation.seqNonEmpty;

import org.jcvi.jillion.core.Sequence;
import org.jcvi.jillion.fasta.nt.NucleotideFastaRecord;

public class NucleotideFastaNotEmptyValidator extends AbstractSeqNotEmptyValidator<NucleotideFastaRecord> {
    protected Sequence toSequence(NucleotideFastaRecord obj) {
        return obj.getSequence();
    }
}
