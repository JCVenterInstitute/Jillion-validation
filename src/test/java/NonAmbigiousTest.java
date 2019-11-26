import org.jcvi.jillion.core.qual.QualitySequence;
import org.jcvi.jillion.core.qual.QualitySequenceBuilder;
import org.jcvi.jillion.core.residue.nt.Nucleotide;
import org.jcvi.jillion.core.residue.nt.NucleotideSequence;
import org.jcvi.jillion.fasta.nt.NucleotideFastaRecord;
import org.jcvi.jillion.fasta.nt.NucleotideFastaRecordBuilder;
import org.jcvi.jillion.trace.chromat.Chromatogram;
import org.jcvi.jillion.trace.fastq.FastqRecord;
import org.jcvi.jillion.trace.fastq.FastqRecordBuilder;
import org.jcvi.jillion.validation.SeqNonAmbiguous;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

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
        Validator validator = ValidatorUtil.createDefaultValidator();

        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{validator, "", false});
        list.add(new Object[]{validator, "---", false});
        list.add(new Object[]{validator, "ACGT", false});
        list.add(new Object[]{validator, "AC-GT", false});
        list.add(new Object[]{validator, "ACGUACGU", false});
        list.add(new Object[]{validator, "AAAAAAAA", false});


        list.add(new Object[]{validator, "ACGN", true});
        list.add(new Object[]{validator, "AC-GN", true});
        list.add(new Object[]{validator, "AAAAACCCCGGGTTTNNNN", true});

        for(Nucleotide n : Nucleotide.ALL_VALUES){
            list.add(new Object[]{validator, n.toString(), n.isAmbiguity()});
        }

        return list;
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

    @Test
    public void nucChromatogram(){
        assertValidationCorrect(new ChromatogramSeq(seq));
    }

    private void assertValidationCorrect(Object obj) {
        if(isAmbigious){
            ValidatorUtil.assertHasViolations(obj, validator);
        }else{
            ValidatorUtil.assertNoViolations(obj, validator);
        }
    }


    class NucSequence{
        @SeqNonAmbiguous
        private NucleotideSequence seq;

        NucSequence(String s){
            this.seq = NucleotideSequence.of(s);
        }
    }

    class NucFasta{
        @SeqNonAmbiguous
        private NucleotideFastaRecord seq;

        NucFasta(String s){
            this.seq = new NucleotideFastaRecordBuilder("id",s)
                                                            .build();
        }
    }

    class NucFastq{
        @SeqNonAmbiguous
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

    class ChromatogramSeq{
        @SeqNonAmbiguous
        private Chromatogram seq;

        ChromatogramSeq(String s){
            this.seq = mock(Chromatogram.class);
            when(seq.getNucleotideSequence()).thenReturn(NucleotideSequence.of(s));
        }


    }

}
