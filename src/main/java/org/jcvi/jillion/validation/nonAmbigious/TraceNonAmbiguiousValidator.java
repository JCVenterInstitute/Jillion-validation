package org.jcvi.jillion.validation.nonAmbigious;

import org.jcvi.jillion.trace.Trace;
import org.jcvi.jillion.validation.converters.TraceNucleotideSeqConverter;

public class TraceNonAmbiguiousValidator extends AbstractNonAmbigiousValidator<Trace> {
    public TraceNonAmbiguiousValidator() {
        super(TraceNucleotideSeqConverter.INSTANCE);
    }
}
