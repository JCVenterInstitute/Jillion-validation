package org.jcvi.jillion.validation.seqNonEmpty;

import org.jcvi.jillion.core.Sequence;
import org.jcvi.jillion.trace.fastq.FastqRecord;

public class FastqNotEmptyValidator extends AbstractSeqNotEmptyValidator<FastqRecord> {
    protected Sequence toSequence(FastqRecord obj) {
        return obj.getNucleotideSequence();
    }
}
