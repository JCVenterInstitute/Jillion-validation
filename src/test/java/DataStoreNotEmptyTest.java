import org.jcvi.jillion.core.datastore.DataStore;
import org.jcvi.jillion.core.datastore.DataStoreUtil;
import org.jcvi.jillion.trace.fastq.FastqDataStore;
import org.jcvi.jillion.validation.DataStoreNotEmpty;
import org.junit.Test;

import javax.validation.Validator;
import java.util.Collections;

public class DataStoreNotEmptyTest {

    private Validator validator = ValidatorUtil.createDefaultValidator();


    class Sut{
        @DataStoreNotEmpty
        DataStore dataStore;

        public Sut(DataStore dataStore) {
            this.dataStore = dataStore;
        }
    }

    class SubclassDatastore{
        @DataStoreNotEmpty
        FastqDataStore dataStore;

        public SubclassDatastore(DataStore dataStore) {
            this.dataStore = DataStoreUtil.adapt(FastqDataStore.class, dataStore);
        }
    }
    @Test
    public void emptyDataStore(){

        ValidatorUtil.assertHasViolations(new Sut(DataStoreUtil.adapt(Collections.emptyMap())), validator);
    }

    @Test
    public void notEmptyDataStore(){

        ValidatorUtil.assertNoViolations(new Sut(DataStoreUtil.adapt(Collections.singletonMap("id", "bar"))), validator);
    }

    @Test
    public void emptySubclassDataStore(){

        ValidatorUtil.assertHasViolations(new SubclassDatastore(DataStoreUtil.adapt(Collections.emptyMap())), validator);
    }

    @Test
    public void notEmptySubclassDataStore(){

        ValidatorUtil.assertNoViolations(new SubclassDatastore(DataStoreUtil.adapt(Collections.singletonMap("id", "bar"))), validator);
    }
}
