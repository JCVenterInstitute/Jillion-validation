import org.jcvi.jillion.core.residue.nt.NucleotideSequence;
import org.jcvi.jillion.validation.SeqNotEmpty;
import org.junit.Before;
import org.junit.Test;

import javax.validation.Validator;

public class SeqNotEmptyTest {

    private Validator validator;

    @Before
    public void setup(){
        validator = ValidatorUtil.createDefaultValidator();

    }

    @Test
    public void emptyNuc(){
        ValidatorUtil.assertHasViolations(new NucSeq(""), validator);
        ValidatorUtil.assertHasViolations(new NucSeq(null), validator);
    }

    @Test
    public void notEmptyNuc(){
        ValidatorUtil.assertNoViolations(new NucSeq("ACGT"), validator);
        ValidatorUtil.assertNoViolations(new NucSeq("---"), validator);
        ValidatorUtil.assertNoViolations(new NucSeq("AC-GT"), validator);

        ValidatorUtil.assertNoViolations(new NucSeq("NNNN"), validator);

        ValidatorUtil.assertNoViolations(new NucSeq("ACNGT"), validator);
    }

    class NucSeq{
        @SeqNotEmpty
        NucleotideSequence seq;

        public NucSeq(String seq) {
            this.seq = seq==null? null:NucleotideSequence.of(seq);
        }
    }
}
