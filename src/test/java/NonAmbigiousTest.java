import org.jcvi.jillion.core.qual.QualitySequence;
import org.jcvi.jillion.core.qual.QualitySequenceBuilder;
import org.jcvi.jillion.core.residue.nt.Nucleotide;
import org.jcvi.jillion.core.residue.nt.NucleotideSequence;
import org.jcvi.jillion.fasta.nt.NucleotideFastaRecord;
import org.jcvi.jillion.fasta.nt.NucleotideFastaRecordBuilder;
import org.jcvi.jillion.trace.fastq.FastqRecord;
import org.jcvi.jillion.trace.fastq.FastqRecordBuilder;
import org.jcvi.jillion.validation.NonAmbiguous;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.*;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class NonAmbigiousTest {

    private Validator validator;

    private String seq;
    private boolean isAmbigious;

    public NonAmbigiousTest(Validator validator, String seq, boolean isAmbigious) {
        this.validator = validator;
        this.seq = seq;
        this.isAmbigious = isAmbigious;
    }

    @Parameterized.Parameters(name = "{1}")
    public static Collection<Object[]> getData(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{validator, "", false});

        list.add(new Object[]{validator, "ACGT", false});
        list.add(new Object[]{validator, "ACGUACGU", false});
        list.add(new Object[]{validator, "AAAAAAAA", false});


        list.add(new Object[]{validator, "ACGN", true});
        list.add(new Object[]{validator, "AAAAACCCCGGGTTTNNNN", true});

        for(Nucleotide n : Nucleotide.ALL_VALUES){
            list.add(new Object[]{validator, n.toString(), n.isAmbiguity()});
        }

        return list;
    }

    public <T> void assertNoViolations(T obj){
        Set<ConstraintViolation<T>> violations = validator.validate(obj);
        assertTrue(violations.isEmpty());
    }

    public <T> void assertHasViolations(T obj){
        Set<ConstraintViolation<T>> violations = validator.validate(obj);
        System.out.println(violations);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void nucSequence(){
        assertValidationCorrect(new NucSequence(seq));
    }

    @Test
    public void nucFasta(){
        assertValidationCorrect(new NucFasta(seq));
    }
    @Test
    public void nucFastq(){
        assertValidationCorrect(new NucFastq(seq));
    }

    private void assertValidationCorrect(Object obj) {
        if(isAmbigious){
            assertHasViolations(obj);
        }else{
            assertNoViolations(obj);
        }
    }


    class NucSequence{
        @NonAmbiguous
        private NucleotideSequence seq;

        NucSequence(String s){
            this.seq = NucleotideSequence.of(s);
        }
    }

    class NucFasta{
        @NonAmbiguous
        private NucleotideFastaRecord seq;

        NucFasta(String s){
            this.seq = new NucleotideFastaRecordBuilder("id",s)
                                                            .build();
        }
    }

    class NucFastq{
        @NonAmbiguous
        private FastqRecord seq;

        NucFastq(String s){
            this.seq = FastqRecordBuilder.create("id", NucleotideSequence.of(s), genQuals(s))
                    .build();
        }

        private QualitySequence genQuals(String s ){
            byte[] q = new byte[s.length()];
            Arrays.fill(q, (byte)20);
            return new QualitySequenceBuilder(q).turnOffDataCompression(true).build();
        }
    }

}
