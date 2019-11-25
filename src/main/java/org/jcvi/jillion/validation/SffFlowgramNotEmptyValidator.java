package org.jcvi.jillion.validation;

import org.jcvi.jillion.core.Sequence;
import org.jcvi.jillion.trace.fastq.FastqRecord;
import org.jcvi.jillion.trace.sff.SffFlowgram;

public class SffFlowgramNotEmptyValidator extends AbstractSeqNotEmptyValidator<SffFlowgram> {
    protected Sequence toSequence(SffFlowgram obj) {
        return obj.getNucleotideSequence();
    }
}
