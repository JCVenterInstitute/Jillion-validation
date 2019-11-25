package org.jcvi.jillion.validation;

import org.jcvi.jillion.core.datastore.DataStore;
import org.jcvi.jillion.core.datastore.DataStoreException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DataStoreNotEmptyValidator implements ConstraintValidator<DataStoreNotEmpty, DataStore> {

    public void initialize(DataStoreNotEmptyValidator constraintAnnotation) {

    }
    @Override
    public boolean isValid(DataStore dataStore, ConstraintValidatorContext constraintValidatorContext) {
        boolean notNullOrClosed= dataStore!=null && !dataStore.isClosed();
        if(notNullOrClosed){
            try{
                return dataStore.getNumberOfRecords()!=0L;
            }catch(DataStoreException e){
                return false;
            }
        }
        return false;
    }
}
